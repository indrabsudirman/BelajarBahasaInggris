package id.indrasudirman.belajarbahasainggris;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import id.indrasudirman.belajarbahasainggris.utils.BottomSheetEditAccount;

public class AccountActivity extends AppCompatActivity {

    private AppCompatImageView editAccount;
    private AppCompatImageView imageViewUser;
    private AppCompatTextView simplePastTense;
    private FloatingActionButton fabChangeImage;
    private NestedScrollView nestedScrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);



        //Initialize and assign variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNav);
        editAccount = findViewById(R.id.editAccount);
        imageViewUser = findViewById(R.id.imageViewUser);
        simplePastTense = findViewById(R.id.simplePastTense);
        fabChangeImage = findViewById(R.id.fabChangeImage);
        nestedScrollView = findViewById(R.id.nestedScrollView);

        //Set Recycler View Learn English as default
        bottomNavigationView.setSelectedItemId(R.id.user_account);



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
                        return true;
                }
                return false;
            }
        });

        //Show bottom sheet, to edit user account
        editAccount.setOnClickListener((View.OnClickListener) view -> {
            BottomSheetEditAccount bottomSheetEditAccount = new BottomSheetEditAccount();
            bottomSheetEditAccount.show(getSupportFragmentManager(), "TAG");
        });

        //Default hide icon change image account
        fabChangeImage.setVisibility(View.INVISIBLE);
        //Show icon change image account, when image icon clicked
        imageViewUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fabChangeImage.setVisibility(View.VISIBLE);
                fabChangeImage.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        fabChangeImage.setVisibility(View.INVISIBLE);
                    }
                }, 2000);

            }
        });

        //Set checklist green, is tense has passed
        simplePastTense.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_round_check_success,0);

//        nestedScrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
//            @Override
//            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
//                //the delay of the extension of the FAB is set for 12 items
//                if (scrollY > oldScrollY + 12 && fabChangeImage.isShown()) {
//                    fabChangeImage.hide();
//                }
//
//                //the delay of the extension of the FAB is set for 12 items
//                if (scrollY < oldScrollY - 12 && !fabChangeImage.isShown()) {
//                    fabChangeImage.hide();
//                }
//                //if the nestedScrollView is at the first item of the list then the floating action button should be in show state
//                if (scrollY == 0) {
//                    fabChangeImage.show();
//                }
//            }
//        });


    }




    public void setToolbar(@Nullable String title) {
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        CollapsingToolbarLayout collapsingToolbar = findViewById(R.id.collapsingToolbarLayout);
        collapsingToolbar.setTitle(title);
    }

    private void initCollapsingToolbar() {
        final CollapsingToolbarLayout collapsingToolbar =
                findViewById(R.id.collapsingToolbarLayout);
        collapsingToolbar.setTitle(" ");
        AppBarLayout appBarLayout = findViewById(R.id.appBarLayout);
        appBarLayout.setExpanded(true);

        // hiding & showing the title when toolbar expanded & collapsed
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbar.setTitle(Html.fromHtml("<font color='#FFFFFF'>"+" User details"+"</font>"));
                    isShow = true;
                } else if (isShow) {
                    collapsingToolbar.setTitle(" ");
                    isShow = false;
                }
            }
        });
    }
}