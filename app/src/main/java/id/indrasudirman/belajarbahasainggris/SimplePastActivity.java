package id.indrasudirman.belajarbahasainggris;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import id.indrasudirman.belajarbahasainggris.fragment.FragmentSimplePast1;
import id.indrasudirman.belajarbahasainggris.fragment.FragmentSimplePast2;

public class SimplePastActivity extends AppCompatActivity {

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_past);

        FragmentSimplePast1 fragmentSimplePast1 = new FragmentSimplePast1();
        FragmentManager fragmentManager = getSupportFragmentManager();

        fragmentManager.beginTransaction().add(R.id.frameLayout, fragmentSimplePast1).commit();


    }
}