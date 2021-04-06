package id.indrasudirman.belajarbahasainggris.utils;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import id.indrasudirman.belajarbahasainggris.R;
import id.indrasudirman.belajarbahasainggris.sqlite.SQLiteHelper;

import static android.content.Context.MODE_PRIVATE;

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

    private SharedPreferences sharedPreferences;

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

        getDetailAccountFromDatabase();

        saveEditUserAccount.setOnClickListener( view1 ->
                Toast.makeText(getContext(), "Simpan clicked", Toast.LENGTH_SHORT).show()

        );


        return view;
    }

    private void getDetailAccountFromDatabase() {
        sharedPreferences = getActivity().getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
        String userEmail = (sharedPreferences.getString(KEY_EMAIL, "").trim());

        String userName = sqLiteHelper.getUserName(userEmail);
        newUserNameEditText.setText(userName);
        newUserEmailEditText.setText(userEmail);
    }
}
