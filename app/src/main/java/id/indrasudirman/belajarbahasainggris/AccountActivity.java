package id.indrasudirman.belajarbahasainggris;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.Settings;
import android.text.Html;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.io.IOException;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;
import id.indrasudirman.belajarbahasainggris.utils.BottomSheetEditAccount;

public class AccountActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    public static final int REQUEST_IMAGE = 100;

    private BottomNavigationView bottomNavigationView;
    private AppCompatImageView editAccount;
    private CircularImageView imageViewUser;
    private CircularImageView changeImage;


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
            changeImageClicked();
        });

        loadProfileDefault();

        // Clearing older images from cache directory
        // don't call this line if you want to choose multiple images in the same activity
        // call this once the bitmap(s) usage is over
        ChangeImageProfileActivity.clearCache(this);

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

    private void loadProfile(String url) {
        Log.d(TAG, " image cache path :" + url);

        Glide.with(this).load(url)
                .into(imageViewUser);
        imageViewUser.setColorFilter(ContextCompat.getColor(this, android.R.color.transparent));
    }

    private void loadProfileDefault() {
        Glide.with(this).load(R.drawable.gl_pro)
                .into(imageViewUser);
        imageViewUser.setColorFilter(ContextCompat.getColor(this, android.R.color.transparent));
    }

    @OnClick({R.id.changeImage})
    void changeImageClicked() {
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
        ChangeImageProfileActivity.showImagePickerOption(this, new ChangeImageProfileActivity.PickerOptionListener() {
            @Override
            public void onTakeCameraSelected() {
                launchCameraIntent();
            }

            @Override
            public void onChooseGallerySelected() {
                launchGalleryIntent();
            }
        });

    }

    private void launchCameraIntent() {
        Intent intent = new Intent(AccountActivity.this, ChangeImageProfileActivity.class);
        intent.putExtra(ChangeImageProfileActivity.INTENT_IMAGE_PICKER_OPTION, ChangeImageProfileActivity.REQUEST_IMAGE_CAPTURE);

        //Setting aspect ratio
        intent.putExtra(ChangeImageProfileActivity.INTENT_LOCK_ASPECT_RATIO, true);
        intent.putExtra(ChangeImageProfileActivity.INTENT_ASPECT_RATIO_X, 1); //16x9, 1x1,3:4, 3:2
        intent.putExtra(ChangeImageProfileActivity.INTENT_ASPECT_RATIO_Y, 1);

        //setting maximum bitmap width and height
        intent.putExtra(ChangeImageProfileActivity.INTENT_SET_BITMAP_MAX_WIDTH_HEIGHT, true);
        intent.putExtra(ChangeImageProfileActivity.INTENT_BITMAP_MAX_WIDTH, 1000);
        intent.putExtra(ChangeImageProfileActivity.INTENT_BITMAP_MAX_HEIGHT, 1000);

        startActivityForResult(intent, REQUEST_IMAGE);
    }

    private void launchGalleryIntent() {
        Intent intent = new Intent(AccountActivity.this, ChangeImageProfileActivity.class);
        intent.putExtra(ChangeImageProfileActivity.INTENT_IMAGE_PICKER_OPTION, ChangeImageProfileActivity.REQUEST_GALLERY_IMAGE);

        //setting aspect ratio
        intent.putExtra(ChangeImageProfileActivity.INTENT_LOCK_ASPECT_RATIO, true);
        intent.putExtra(ChangeImageProfileActivity.INTENT_ASPECT_RATIO_X, 1); //16x9, 1x1, 3:4, 3:2
        intent.putExtra(ChangeImageProfileActivity.INTENT_ASPECT_RATIO_Y, 1);
        startActivityForResult(intent, REQUEST_IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE) {
            if (resultCode == Activity.RESULT_OK) {
                Uri uri = data.getParcelableExtra("path");
                try {
                    //you can update this bitmap to your server
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), uri);

                    //loading profile image from local cache
                    loadProfile(uri.toString());

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Showing Alert Dialog with settings option
     * Navigates user to app settings
     * NOTE: Keep proper title and message depending on your app
     */
    private void showSettingDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(AccountActivity.this);
        builder.setTitle(getString(R.string.dialog_permission_title));
        builder.setMessage(getString(R.string.dialog_permission_message));
        builder.setPositiveButton(getString(R.string.go_to_settings), (dialog, which) ->{
            dialog.cancel();
            openSettings();
        });
        builder.setNegativeButton(getString(android.R.string.cancel), (dialog, which) -> dialog.cancel());
            builder.show();

    }

    //navigation user to app settings
    private void openSettings() {
        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        Uri uri = Uri.fromParts("package", getPackageName(), null);
        intent.setData(uri);
        startActivityForResult(intent, 101);
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