package id.indrasudirman.belajarbahasainggris;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.widget.NestedScrollView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Objects;

import id.indrasudirman.belajarbahasainggris.model.User;
import id.indrasudirman.belajarbahasainggris.sqlite.SQLiteHelper;

import static id.indrasudirman.belajarbahasainggris.utils.PasswordMD5WithSalt.byteArrayToHexString;
import static id.indrasudirman.belajarbahasainggris.utils.PasswordMD5WithSalt.digest;
import static id.indrasudirman.belajarbahasainggris.utils.PasswordMD5WithSalt.getSalt;

public class SignUp extends AppCompatActivity {

    private Button signUpButton;
    private TextInputEditText textInputEditTextName;
    private TextInputEditText textInputEditTextUsername;
    private TextInputEditText textInputEditTextPassword;
    private TextInputEditText textInputEditTextPasswordConfirm;
    private TextInputLayout textInputLayoutName;
    private TextInputLayout inputLayoutUsername;
    private TextInputLayout inputLayoutPassword;
    private TextInputLayout inputLayoutConfirmPassword;
    private AppCompatTextView appCompatTextViewLoginLink;
    private NestedScrollView nestedScrollView;
    private String name, userName;
    private String saltPwdDB, pwdSaltedDB;
    private Boolean allFieldValid = false;

    private User user;
    private SQLiteHelper sqLiteHelper;

    private SharedPreferences sharedPreferences;

    private static final String TAG = SignUp.class.getSimpleName();

    private static final String SHARED_PREF_NAME = "sharedPrefLogin";
    private static final String KEY_EMAIL = "email";

    private boolean doubleBackToExitPressedOnce = false;

    public SignUp() {
        //Default constructor

    }

    public String getSaltPwdDB() {
        return saltPwdDB;
    }

    public void setSaltPwdDB(String saltPwdDB) {
        this.saltPwdDB = saltPwdDB;
    }

    public String getPwdSaltedDB() {
        return pwdSaltedDB;
    }

    public void setPwdSaltedDB(String pwdSaltedDB) {
        this.pwdSaltedDB = pwdSaltedDB;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        signUpButton = findViewById(R.id.appCompatButtonRegister);
        textInputEditTextName = findViewById(R.id.textInputEditTextName);
        textInputEditTextUsername = findViewById(R.id.textInputEditTextEmail);
        textInputEditTextPassword = findViewById(R.id.textInputEditTextPassword);
        textInputEditTextPasswordConfirm = findViewById(R.id.textInputEditTextConfirmPassword);
        textInputLayoutName = findViewById(R.id.textInputLayoutName);
        inputLayoutUsername = findViewById(R.id.textInputLayoutEmail);
        inputLayoutPassword = findViewById(R.id.textInputLayoutPassword);
        inputLayoutConfirmPassword = findViewById(R.id.textInputLayoutConfirmPassword);
        appCompatTextViewLoginLink = findViewById(R.id.appCompatTextViewLoginLink);

        nestedScrollView = findViewById(R.id.nestedScrollView);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);

        sqLiteHelper = new SQLiteHelper(this);
        user = new User();


        //Adding Sign Up click listener
        signUpButton.setOnClickListener(view -> {

            try {
                checkFieldSignUp();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            if (allFieldValid) {

                if (!sqLiteHelper.checkUser(Objects.requireNonNull(textInputEditTextUsername.getText()).toString().trim())) {
                    user.setName(Objects.requireNonNull(textInputEditTextName.getText()).toString().trim());
                    user.setEmail(textInputEditTextUsername.getText().toString().trim());
                    user.setSalt(getSaltPwdDB());
                    Log.d(TAG, "Salt mau input = " + getSaltPwdDB());
                    user.setPassword(getPwdSaltedDB());
                    Log.d(TAG, "Salt mau input = " + getPwdSaltedDB());

                    sqLiteHelper.addUser(user);

                    textInputEditTextName.setText("");
                    textInputEditTextUsername.setText("");
                    textInputEditTextPassword.setText("");
                    textInputEditTextPasswordConfirm.setText("");

                    //Snack Bar to show success message that record saved successfully
                    Snackbar.make(nestedScrollView, "Registration Successful, please login", Snackbar.LENGTH_LONG).show();

                } else {
                    //Snack Bar to show error message that record already exists
                    Snackbar.make(nestedScrollView, "Email Already Exists", Snackbar.LENGTH_LONG).show();
                }
                allFieldValid = false;
                allFieldValid = false;

            }


        });

        SpannableString spannableString = new SpannableString("Already a member? Login!");
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                overridePendingTransition(0,0);
            }
        };
        spannableString.setSpan(clickableSpan,18,24,0);
        appCompatTextViewLoginLink.setMovementMethod(LinkMovementMethod.getInstance());
        appCompatTextViewLoginLink.setText(spannableString);
    }



    public void checkFieldSignUp() throws NoSuchAlgorithmException {
        int length = textInputEditTextPassword.length();
        int lengthPass = textInputEditTextPasswordConfirm.length();
        char [] passwordUserChar = new char[length];
        char [] passwordUserCharConfirm = new char[lengthPass];

        name = textInputEditTextName.getText().toString().trim();
        userName = textInputEditTextUsername.getText().toString().trim();
        //Getting value from all EditText and storing into variables

        Objects.requireNonNull(textInputEditTextPassword.getText()).getChars(0, length, passwordUserChar,0);
        Objects.requireNonNull(textInputEditTextPasswordConfirm.getText()).getChars(0, lengthPass, passwordUserCharConfirm, 0);

        if (name.isEmpty()){
            textInputLayoutName.setError("Nama tidak boleh kosong!");
        } else if (userName.isEmpty() && textInputEditTextPassword.length() == 0 && textInputEditTextPasswordConfirm.length()== 0) {
            textInputLayoutName.setError(null);
            inputLayoutUsername.setError("Email tidak boleh kosong!");
            inputLayoutPassword.setError("Password tidak boleh kosong!");
            inputLayoutConfirmPassword.setError("Konfirmasi Password tidak boleh kosong!");
        } else if (validateUserName()){
            textInputLayoutName.setError(null);
            inputLayoutUsername.setError(null);
            if (Arrays.equals(passwordUserChar, passwordUserCharConfirm)) {
                if (passwordUserChar.length <= 5 && passwordUserCharConfirm.length <= 5) {
                    inputLayoutPassword.setError("Password terlalu pendek!");
                    inputLayoutConfirmPassword.setError("Password terlalu pendek!");
                } else {
                    inputLayoutPassword.setError(null);
                    inputLayoutConfirmPassword.setError(null);
                    byte [] salt = getSalt();
                    Log.d(TAG, "Salt number "+Arrays.toString(salt));
                    String saltPwd = byteArrayToHexString(salt);
                    String pwdSalted = digest(passwordUserChar, salt);

                    setSaltPwdDB(saltPwd);
                    setPwdSaltedDB(pwdSalted);

                    //Change char to 0
                    Arrays.fill(passwordUserChar, '0');
                    Arrays.fill(passwordUserCharConfirm, '0');
                    allFieldValid = true;

                }
            } else {
                inputLayoutPassword.setError("Password tidak sama!");
                inputLayoutConfirmPassword.setError("Password tidak sama!");
            }
        }

    }

    private boolean validateUserName() {
        if (!checkUserNameValid(textInputEditTextUsername)) {
            inputLayoutUsername.setError("Isi email valid!");
            return false;
        } else {
            return true;
        }

    }

    private boolean checkUserNameValid(TextInputEditText textInputEditTextUsername) {
        CharSequence charSequence = textInputEditTextUsername.getText().toString().trim();
        return (!TextUtils.isEmpty(charSequence) && Patterns.EMAIL_ADDRESS.matcher(charSequence).matches());
    }

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            Intent homeIntent = new Intent(Intent.ACTION_MAIN);
            homeIntent.addCategory( Intent.CATEGORY_HOME );
            homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(homeIntent);
            return;
        }
        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(getApplicationContext(), "Tekan sekali lagi untuk keluar", Toast.LENGTH_SHORT).show();

        new Handler(Looper.getMainLooper()).postDelayed(() -> doubleBackToExitPressedOnce=false, 2000);
    }
}
