package id.indrasudirman.belajarbahasainggris;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import id.indrasudirman.belajarbahasainggris.adapter.SimplePastAdapter;

public class SimplePastActivity extends AppCompatActivity {
    private ViewPager2 viewPager2;
    private int score = 0;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_past);

        viewPager2 = findViewById(R.id.viewPager);
        viewPager2.setAdapter(new SimplePastAdapter(this));
        viewPager2.setUserInputEnabled(false);

        TabLayout tabLayout = findViewById(R.id.tabLayout);
//        tabLayout.clearOnTabSelectedListeners();

        //Initialize and assign variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation);

        //Set Recycler View Learn English as default
        bottomNavigationView.setSelectedItemId(R.id.main_learn);

        //Perform item selectListener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.main_learn:
                        startActivity(new Intent(getApplicationContext()
                                ,MainMenu.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.user_account:
                        startActivity(new Intent(getApplicationContext()
                                ,AccountActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });
        //Perform TabLayout mediator for Viewpager2
        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(tabLayout,
                viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position){
                    case 0: {
                        tab.setText("Hal 1");
                        tab.setIcon(R.drawable.ic_baseline_menu_book_24);

                        break;
                    }
                    case 1: {
                        tab.setText("Test");
                        tab.setIcon(R.drawable.test);
                        tab.view.setClickable(false);
                        if (score==1) {
                            tab.view.setClickable(true);
                        }
                        break;
                    }

                }

            }
        });
        tabLayoutMediator.attach();
    }

}