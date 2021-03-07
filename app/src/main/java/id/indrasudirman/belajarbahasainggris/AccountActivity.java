package id.indrasudirman.belajarbahasainggris;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
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
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import id.indrasudirman.belajarbahasainggris.utils.BottomSheetEditAccount;

public class AccountActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_STORAGE_PERMISSION = 1;
    private static final int REQUEST_CODE_SELECT_IMAGE = 2;

    private BottomNavigationView bottomNavigationView;
    private AppCompatImageView editAccount;
    private CircularImageView imageViewUser;
    private CircularImageView changeImage;
//    private AppCompatTextView simplePastTense;
//    private FloatingActionButton fabChangeImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_test);
        ButterKnife.bind(this);



        //Initialize and assign variable
        bottomNavigationView = findViewById(R.id.bottomNav);
        editAccount = findViewById(R.id.editAccount);
        imageViewUser = findViewById(R.id.imageViewUser);
        changeImage = findViewById(R.id.changeImage);
//        simplePastTense = findViewById(R.id.simplePastTense);
//        fabChangeImage = findViewById(R.id.fabChangeImage);
//
        changeImage.setOnClickListener(view -> {
            Toast.makeText(getApplicationContext(), "Anda ingin ganti foto", Toast.LENGTH_SHORT).show();
            onProfileImageClick();
        });





        //Set Recycler View Learn English as default
        bottomNavigationView.setSelectedItemId(R.id.user_account);



        //Perform item selectListener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
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
        changeImage.setVisibility(View.INVISIBLE);
        //Show icon change image account, when image icon clicked
        imageViewUser.setOnClickListener(view -> {
            changeImage.setVisibility(View.VISIBLE);
            changeImage.postDelayed(() -> changeImage.setVisibility(View.INVISIBLE), 2000);

        });
//
//        //Set checklist green, is tense has passed
//        simplePastTense.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_round_check_success,0);


    }

    @OnClick({R.id.changeImage})
    void onProfileImageClick() {
        Dexter.withActivity(this)
                .withPermissions(Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .withListener(new MultiplePermissionsListener() {
                    @Override
                    public void onPermissionsChecked(MultiplePermissionsReport report) {
                        if (report.areAllPermissionsGranted()) {
                            showImagePickerOption();
                        }

                        if (report.isAnyPermissionPermanentlyDenied()) {
//                            showSettingsDialog();
                        }
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
                        token.continuePermissionRequest();
                    }
                }).check();
    }

    private void showImagePickerOption() {
        Toast.makeText(getApplicationContext(), "Show image picker ", Toast.LENGTH_SHORT).show();
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