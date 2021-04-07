package id.indrasudirman.belajarbahasainggris.utils;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Objects;

import id.indrasudirman.belajarbahasainggris.R;
import id.indrasudirman.belajarbahasainggris.model.User;
import id.indrasudirman.belajarbahasainggris.sqlite.SQLiteHelper;

import static android.content.Context.MODE_PRIVATE;
import static id.indrasudirman.belajarbahasainggris.utils.PasswordMD5WithSalt.byteArrayToHexString;
import static id.indrasudirman.belajarbahasainggris.utils.PasswordMD5WithSalt.digest;
import static id.indrasudirman.belajarbahasainggris.utils.PasswordMD5WithSalt.getSalt;

public class BottomSheetEditAccount extends BottomSheetDialogFragment {

    private LinearLayout bottomSheetLinearLayout;
    private AppCompatButton saveEditUserAccount;
    private TextInputLayout newUserNameLayout;
    private TextInputEditText newUserNameEditText;
    private TextInputLayout newUserEmailLayout;
    private TextInputEditText newUserEmailEditText;
    private TextInputLayout newUserPasswordLayout;
    private TextInputEditText newUserPasswordEditText;
    private TextInputLayout newUserPasswordConfirmLayout;
    private TextInputEditText newUserPasswordConfirmEditText;

    private SQLiteHelper sqLiteHelper;
    private User user;

    private SharedPreferences sharedPreferences;

    private String userName, userEmail;
    private String saltPwdDB, pwdSaltedDB;
    private Boolean allFieldValid = false;

    private static final String SHARED_PREF_NAME = "sharedPrefLogin";
    private static final String KEY_EMAIL = "email";

    public BottomSheetEditAccount() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottom_sheet_layout, container, false);
        bottomSheetLinearLayout = view.findViewById(R.id.bottomSheetLinearLayout);
        bottomSheetLinearLayout.setBackgroundResource(R.drawable.bottom_sheet_background); //Not working

        saveEditUserAccount = view.findViewById(R.id.saveEditUserAccount);
        newUserNameLayout = view.findViewById(R.id.newUserNameLayout);
        newUserNameEditText = view.findViewById(R.id.newUserNameEditText);
        newUserEmailLayout = view.findViewById(R.id.newUserEmailLayout);
        newUserEmailEditText = view.findViewById(R.id.newUserEmailEditText);
        newUserPasswordLayout = view.findViewById(R.id.newUserPasswordLayout);
        newUserPasswordEditText = view.findViewById(R.id.newUserPasswordEditText);
        newUserPasswordConfirmLayout = view.findViewById(R.id.newUserPasswordConfirmLayout);
        newUserPasswordConfirmEditText = view.findViewById(R.id.newUserPasswordConfirmEditText);

        sqLiteHelper = new SQLiteHelper(getActivity());
        user = new User();

        getDetailAccountFromDatabase();

        saveEditUserAccount.setOnClickListener( view1 -> {
            saveEditAccount();
            });


        return view;
    }

    private void getDetailAccountFromDatabase() {
        sharedPreferences = getActivity().getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
        String userEmail = (sharedPreferences.getString(KEY_EMAIL, "").trim());

        String userName = sqLiteHelper.getUserName(userEmail);
        newUserNameEditText.setText(userName);
        newUserEmailEditText.setText(userEmail);
    }

    private void saveEditAccount() {
        try {
            checkFieldToEdit();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        if (allFieldValid) {

            if (!sqLiteHelper.checkUser(newUserEmailEditText.getText().toString().trim())) {
                user.setName(newUserNameEditText.getText().toString().trim());
                user.setEmail(newUserEmailEditText.getText().toString().trim());
                user.setSalt(getSaltPwdDB());
                System.out.println("Salt mau input = " + getSaltPwdDB());
                user.setPassword(getPwdSaltedDB());
                System.out.println("Password dan Salt mau input = " + getPwdSaltedDB());

                sqLiteHelper.addUser(user);

                newUserNameEditText.setText("");
                newUserEmailEditText.setText("");
                newUserPasswordEditText.setText("");
                newUserPasswordConfirmEditText.setText("");



                //Toast to show success message that record saved successfully
                Toast.makeText(getActivity(), "Registration Successful", Toast.LENGTH_SHORT).show();
//                Snackbar.make(nestedScrollView, "Registration Successful", Snackbar.LENGTH_LONG).show();
                allFieldValid = false;

            } else {
                //Toast to show error message that record already exists
                Toast.makeText(getActivity(), "Email Already Exists", Toast.LENGTH_SHORT).show();
//                Snackbar.make(nestedScrollView, "Email Already Exists", Snackbar.LENGTH_LONG).show();
                allFieldValid = false;
            }
            allFieldValid = false;

        }
    }

    public void checkFieldToEdit() throws NoSuchAlgorithmException {
        int length = newUserPasswordEditText.length();
        int lengthPass = newUserPasswordConfirmEditText.length();
        char [] passwordUserChar = new char[length];
        char [] passwordUserCharConfirm = new char[lengthPass];

        userName = newUserNameEditText.getText().toString().trim();
        userEmail = newUserEmailEditText.getText().toString().trim();
        //Getting value from all EditText and storing into variables

        Objects.requireNonNull(newUserPasswordEditText.getText()).getChars(0, length, passwordUserChar,0);
        Objects.requireNonNull(newUserPasswordConfirmEditText.getText()).getChars(0, lengthPass, passwordUserCharConfirm, 0);

        if (userName.isEmpty()){
            newUserNameLayout.setError("Nama tidak boleh kosong!");
        } else if (userName.isEmpty() && newUserPasswordEditText.length() == 0 && newUserPasswordConfirmEditText.length()== 0) {
            newUserNameLayout.setError(null);
            newUserEmailLayout.setError("Email tidak boleh kosong!");
            newUserPasswordLayout.setError("Password tidak boleh kosong!");
            newUserPasswordConfirmLayout.setError("Konfirmasi Password tidak boleh kosong!");
        } else if (validateUserName()){
            newUserNameLayout.setError(null);
            newUserEmailLayout.setError(null);
            if (Arrays.equals(passwordUserChar, passwordUserCharConfirm)) {
                if (passwordUserChar.length <= 5 && passwordUserCharConfirm.length <= 5) {
                    newUserPasswordEditText.setError("Password terlalu pendek!");
                    newUserPasswordConfirmEditText.setError("Password terlalu pendek!");
                } else {
                    newUserPasswordEditText.setError(null);
                    newUserPasswordConfirmEditText.setError(null);
                    byte [] salt = getSalt();
                    System.out.println("Salt number "+Arrays.toString(salt));
                    String saltPwd = byteArrayToHexString(salt);
                    String pwdSalted = digest(passwordUserChar, salt);
//                    System.out.println("Salt baru dibuat " + saltPwd);
//                    System.out.println("Password dan Salt menjadi " + pwdSalted);

                    setSaltPwdDB(saltPwd);
                    setPwdSaltedDB(pwdSalted);
//                    System.out.println("Salt dari setter menjadi " + getSaltPwdDB());

                    //Change char to 0
                    Arrays.fill(passwordUserChar, '0');
                    Arrays.fill(passwordUserCharConfirm, '0');
                    allFieldValid = true;

                }
            } else {
                newUserPasswordEditText.setError("Password tidak sama!");
                newUserPasswordConfirmEditText.setError("Password tidak sama!");
            }
        }
//        System.out.println("Pass sebelum dibuat 0 = "+ Arrays.toString(passwordUserChar));
//        System.out.println("Pass "+ Arrays.toString(passwordUserChar));



    }
    private boolean validateUserName() {
        if (!checkUserNameValid(newUserEmailEditText)) {
            newUserEmailLayout.setError("Isi email valid!");
            return false;
        } else {
            return true;
        }

    }

    private boolean checkUserNameValid(TextInputEditText textInputEditTextUsername) {
        CharSequence charSequence = textInputEditTextUsername.getText().toString().trim();
        return (!TextUtils.isEmpty(charSequence) && Patterns.EMAIL_ADDRESS.matcher(charSequence).matches());
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
}
