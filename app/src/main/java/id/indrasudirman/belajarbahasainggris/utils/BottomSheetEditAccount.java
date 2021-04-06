package id.indrasudirman.belajarbahasainggris.utils;

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

public class BottomSheetEditAccount extends BottomSheetDialogFragment {

    private LinearLayout bottomSheetLinearLayout;
    private AppCompatButton saveEditUserAccount;
    private TextInputLayout newUserNameLayout;
    private TextInputEditText newUserNameEditText;

    public BottomSheetEditAccount() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottom_sheet_layout, container, false);
        bottomSheetLinearLayout = view.findViewById(R.id.bottomSheetLinearLayout);
        bottomSheetLinearLayout.setBackgroundResource(R.drawable.bottom_sheet_background); //Not working

        saveEditUserAccount = view.findViewById(R.id.saveEditUserAccount);
        saveEditUserAccount.setOnClickListener( view1 ->
                Toast.makeText(getContext(), "Simpan clicked", Toast.LENGTH_SHORT).show()

        );


        return view;
    }
}
