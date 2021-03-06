package id.indrasudirman.belajarbahasainggris;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.widget.NestedScrollView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

import static id.indrasudirman.belajarbahasainggris.utils.PasswordMD5WithSalt.digest;
import static id.indrasudirman.belajarbahasainggris.utils.PasswordMD5WithSalt.hexStringToByteArray;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Objects;

import id.indrasudirman.belajarbahasainggris.sqlite.SQLiteHelper;

public class MainActivity extends AppCompatActivity {

    private AppCompatButton loginButton;
    private TextInputLayout layoutUsername;
    private TextInputLayout layoutPassword;
    private TextInputEditText username;
    private TextInputEditText password;
    private AppCompatTextView register;
    private NestedScrollView nestedScrollView;
    private String userName, pwdUsr;
    private Boolean allFieldValid = false;

    private SharedPreferences sharedPreferences;

    private SQLiteHelper sqLiteHelper;
    private int length;
    private char[] pwd;

    private static final String SHARED_PREF_NAME = "sharedPrefLogin";
    private static final String KEY_EMAIL = "email";

    private boolean doubleBackToExitPressedOnce = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_login);

        loginButton = findViewById(R.id.appCompatButtonLogin);
        layoutUsername = findViewById(R.id.textInputLayoutEmail);
        layoutPassword = findViewById(R.id.textInputLayoutPassword);
        username = findViewById(R.id.textInputEditTextEmail);
        password = findViewById(R.id.textInputEditTextPassword);
        register = findViewById(R.id.appCompatTextViewRegisterLink);
        nestedScrollView = findViewById(R.id.nestedScrollView);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);

        sqLiteHelper = new SQLiteHelper(MainActivity.this);

        //Check if sharedPreferences data available
        String emailSharedPref = sharedPreferences.getString(KEY_EMAIL, null);
        // if sharedPreferences available so directly to MainMenu.class
        if (emailSharedPref != null) {
            Intent intent = new Intent(getApplicationContext(), MainMenu.class);
            startActivity(intent);
        }




        //Adding Login click listener
        loginButton.setOnClickListener(view -> {
            //Call method to check all field valid
            checkFieldLogin();
            length = password.length();
            pwd = new char[length];
            Objects.requireNonNull(password.getText()).getChars(0, length, pwd, 0);
            System.out.println("Pass user sebelum dibuat 0 " + Arrays.toString(pwd));
            if (allFieldValid) {

                //Get salt from database
                String salt = sqLiteHelper.getSalt(Objects.requireNonNull(username.getText()).toString().trim());
                if (salt != null) {
                    //convert salt to byte
                    byte[] saltByte = hexStringToByteArray(salt);
                    System.out.println("Salt number dari db "+Arrays.toString(saltByte));
                    try {

                        pwdUsr = digest(pwd, saltByte);
                        System.out.println("Pass User "+pwdUsr);
                    } catch (NoSuchAlgorithmException e) {
                        e.printStackTrace();
                    }
                    if (pwdUsr.equals(sqLiteHelper.getPwdSalt(username.getText().toString().trim()))) {
                        //Save to sharedPreferences
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString(KEY_EMAIL, username.getText().toString().trim());
                        editor.apply();
                        username.setText("");
                        password.setText("");
                        allFieldValid = false;
                        Intent intent = new Intent(getApplicationContext(), MainMenu.class);
                        startActivity(intent);
                    } else {

                        Snackbar.make(nestedScrollView, "Password salah", Snackbar.LENGTH_LONG).show();
                    }

                } else {
                    Snackbar.make(nestedScrollView, "Login failed, email not found", Snackbar.LENGTH_LONG).show();
                    username.setText("");
                    password.setText("");
                    allFieldValid = false;
                }

            }
            Arrays.fill(pwd, '0');
            System.out.println("Pass setelah dibuat 0 " + Arrays.toString(pwd));

        });

        SpannableString spannableString = new SpannableString("Don't have account! Register here!");
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                Intent intent = new Intent(getApplicationContext(), SignUp.class);
                startActivity(intent);
                overridePendingTransition(0,0);
            }
        };
        spannableString.setSpan(clickableSpan, 20, 34, 0);
        register.setMovementMethod(LinkMovementMethod.getInstance());
        register.setText(spannableString);
    }

    private void checkFieldLogin() {
        userName = Objects.requireNonNull(username.getText()).toString();
        int length = password.length();
        char[] passwordUserChar = new char[length];

        Objects.requireNonNull(password.getText()).getChars(0, length, passwordUserChar, 0);

        if (userName.isEmpty() && password.length() == 0) {
            layoutUsername.setError("Username tidak boleh kosong!");
            layoutPassword.setError("Password tidak boleh kosong!");
        } else if (validateUserName()) {
            layoutUsername.setError(null);
            if (password.length() == 0) {
                layoutPassword.setError("Password tidak boleh kosong!");
            } else {
                layoutPassword.setError(null);
                allFieldValid = true;
                Arrays.fill(passwordUserChar, '0');
                System.out.println("Pass " + Arrays.toString(passwordUserChar));
            }
        }
    }

    private boolean validateUserName() {
        userName = username.getText().toString();
        if (userName.isEmpty()) {
            username.setError("Username tidak boleh kosong!");
            return false;
        } else if (!checkUserNameValid(username)) {
            layoutUsername.setError("Username diisi email valid!");
            return false;
        } else {
            return true;
        }

    }

    private boolean checkUserNameValid(TextInputEditText username) {
        CharSequence charSequence = username.getText().toString().trim();
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
