package id.indrasudirman.belajarbahasainggris.utils;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
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

import id.indrasudirman.belajarbahasainggris.AccountActivity;
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

    private static final String TAG = BottomSheetDialogFragment.class.getSimpleName();

    private SendDataInterface mSendDataInterface;

    public BottomSheetEditAccount(SendDataInterface sendDataInterface) {
        this.mSendDataInterface = sendDataInterface;
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

            sharedPreferences = getActivity().getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
            String userEmail = (sharedPreferences.getString(KEY_EMAIL, "").trim());

            user.setName(newUserNameEditText.getText().toString().trim());
            Log.d(TAG, "User name is " + user.getName());
            user.setEmail(newUserEmailEditText.getText().toString().trim());
            Log.d(TAG, "User email is " + user.getEmail());
            user.setSalt(getSaltPwdDB());
            Log.d(TAG, "User salt is " + user.getSalt());
            user.setPassword(getPwdSaltedDB());
            Log.d(TAG, "User password is " + user.getPassword());
            sqLiteHelper.updateUser(userEmail, user.getName(), user.getEmail(), user.getSalt(), user.getPassword());
            //Toast to show success message that record saved successfully
            Toast.makeText(getActivity(), "Update Successful", Toast.LENGTH_SHORT).show();

            newUserNameEditText.setText("");
            newUserEmailEditText.setText("");
            newUserPasswordEditText.setText("");
            newUserPasswordConfirmEditText.setText("");

            mSendDataInterface.userName(user.getName(), user.getEmail());

            SharedPreferences.Editor editor = sharedPreferences.edit();

            editor.putString(KEY_EMAIL, user.getEmail()).apply();


            }
            allFieldValid = false;
            allFieldValid = false;

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
                    newUserPasswordLayout.setError("Password terlalu pendek!");
                    newUserPasswordConfirmLayout.setError("Password terlalu pendek!");
                } else {
                    newUserPasswordLayout.setError(null);
                    newUserPasswordConfirmLayout.setError(null);
                    byte [] salt = getSalt();
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
                newUserPasswordLayout.setError("Password tidak sama!");
                newUserPasswordConfirmLayout.setError("Password tidak sama!");
            }
        }



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

    public interface SendDataInterface{
        void userName(String userName, String userEmail);
//        void userEmail(String userEmail);
    }
}
