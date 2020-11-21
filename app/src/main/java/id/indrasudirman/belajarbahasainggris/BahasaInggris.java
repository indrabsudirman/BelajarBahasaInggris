package id.indrasudirman.belajarbahasainggris;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class BahasaInggris extends AppCompatActivity {

    private LoginActivity loginActivity;

    @Override
    protected void onCreate (Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        loginActivity = new LoginActivity();
    }
}
