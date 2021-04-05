package id.indrasudirman.belajarbahasainggris;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.provider.Settings;
import android.text.Html;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;
import id.indrasudirman.belajarbahasainggris.model.User;
import id.indrasudirman.belajarbahasainggris.sqlite.SQLiteHelper;
import id.indrasudirman.belajarbahasainggris.utils.BottomSheetEditAccount;

public class AccountActivity extends AppCompatActivity {

    public static final int REQUEST_IMAGE = 100;
    private static final String TAG = MainActivity.class.getSimpleName();
    private BottomNavigationView bottomNavigationView;
    private AppCompatImageView editAccount, logOutAccount;
    private CircularImageView imageViewUser;
    private CircularImageView changeImage;
    private AppCompatTextView simplePastTense;
    private String pathImage;
    private AppCompatTextView profileEmail, profileUserName, userScore;

    private User user;
    private SQLiteHelper sqLiteHelper;

    private SharedPreferences sharedPreferences;

    private static final String SHARED_PREF_NAME = "sharedPrefLogin";
    private static final String KEY_EMAIL = "email";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        ButterKnife.bind(this);

        //Initialize and assign variable
        user = new User();
        sqLiteHelper = new SQLiteHelper(this);
        bottomNavigationView = findViewById(R.id.bottomNav);
        editAccount = findViewById(R.id.editAccount);
        imageViewUser = findViewById(R.id.imageViewUser);
        changeImage = findViewById(R.id.changeImage);
        logOutAccount = findViewById(R.id.logOutAccount);
        simplePastTense = findViewById(R.id.simplePastTense);
        profileEmail = findViewById(R.id.profileEmail);
        profileUserName = findViewById(R.id.profileUserName);
        userScore = findViewById(R.id.userScore);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
        String userEmail = (sharedPreferences.getString(KEY_EMAIL, "").trim());

        String userName = sqLiteHelper.getUserName(userEmail);
        profileUserName.setText(userName);
        profileEmail.setText(userEmail);

        //get User Score from Database
        String userScoreDB = sqLiteHelper.getUserScore(userEmail);
        userScore.setText(userScoreDB);






        changeImage.setOnClickListener(view -> {

            changeImageClicked();
        });

        //Load image from database if exist, or load image default is not exist in database
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
                                , MainMenu.class));
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

        logOutAccount.setOnClickListener(view ->{
            logOutConfirmation();
        });

        //Set checklist green, is tense has passed
        simplePastTense.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_round_check_success, 0);

    }

    private void logOutConfirmation() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(AccountActivity.this);
        alertDialogBuilder
                .setTitle("Yakin Keluar!")
                .setIcon(R.mipmap.ic_question)
                .setMessage("Anda yakin akan keluar akun ?")
                .setCancelable(false)
                .setPositiveButton("Batal keluar",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(getApplicationContext(), "Anda batal keluar", Toast.LENGTH_SHORT).show();

                            }
                        })

                .setNegativeButton("Keluar",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                // Delete SharedPreferences save
                                sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, 0);
                                SharedPreferences.Editor editor = sharedPreferences.edit();
                                editor.clear();
                                editor.apply();
                                startActivity(new Intent(getApplicationContext()
                                        ,MainActivity.class));
                                overridePendingTransition(0, 0);
                            }
                        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    private void loadProfile(String url) {
        Log.d(TAG, " image cache path :" + url);

        Glide.with(this).load(url)
                .into(imageViewUser);
        imageViewUser.setColorFilter(ContextCompat.getColor(this, android.R.color.transparent));
    }

    private void loadProfileDefault() {
        String profileEmailS = (String) profileEmail.getText();


        if (sqLiteHelper.imagePathAlready(profileEmailS) != null) {
            String filename = sqLiteHelper.imagePathAlready(profileEmailS);
            Log.d(TAG, "Image name dari database, adalah : " + filename);

//            File file = new File(Environment.getExternalStorageDirectory().toString() + '/' + getString(R.string.app_name) + '/' + filename);
            if (Build.VERSION.SDK_INT >= 29) {
                File file = new File("/storage/emulated/0/" + Environment.DIRECTORY_PICTURES + File.separator + getString(R.string.app_name) + File.separator + filename);
                Uri imageUri = Uri.fromFile(file);

                Glide.with(this).load(imageUri)
                        .into(imageViewUser);
            } else {
                File file = new File("/storage/emulated/0/" + getString(R.string.app_name) + File.separator + filename);
                Uri imageUri = Uri.fromFile(file);

                Glide.with(this).load(imageUri)
                        .into(imageViewUser);
            }

        } else {
            Glide.with(this).load(R.drawable.gl_pro)
                    .into(imageViewUser);
        }
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
                            showSettingDialog();
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
//            switch (requestCode) {
//                case REQU
//            }
            if (resultCode == Activity.RESULT_OK) {
                Uri uri = data.getParcelableExtra("path");
                try {
                    //you can update this bitmap to your server
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), uri);
                    //save image to local Gallery
                    saveImageToGallery(bitmap);

                    //loading profile image from local cache
                    loadProfile(uri.toString());
                    //save image path to database

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            String s = this.pathImage;
            Log.d(TAG, "User photo path in onActivityResult " + s); //null
            String profileEmailS = (String) profileEmail.getText();
            user.setEmail(profileEmailS);
            Log.d(TAG, "Email user in onActivityResult " + user.getEmail());
            //Update image path to database
            sqLiteHelper.updateUserImage(profileEmailS, s);
        }
    }

    private void saveImageToGallery(Bitmap bitmap) {


        if (Build.VERSION.SDK_INT >= 29) {
            Log.d(AccountActivity.class.getName(), "OS Android adalah " + Build.VERSION.SDK_INT);
            @SuppressLint("SimpleDateFormat") String title = "profile" + new SimpleDateFormat("yyyyMMddHHmmss'.png'").format(new Date());
            ContentValues values = contentValues();
            values.put(MediaStore.Images.Media.RELATIVE_PATH, "Pictures/" + getString(R.string.app_name));
            values.put(MediaStore.Images.Media.IS_PENDING, true);
            values.put(MediaStore.Images.Media.DISPLAY_NAME, title); //set name image
            this.pathImage = title;
            user.setImageName(title);
            Log.d(AccountActivity.class.getName(), "Image profile name from getImageName is " + user.getImageName());
            Log.d(AccountActivity.class.getName(), "Image profile name from title is " + title);

            Uri uri = this.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
            if (uri != null) {
                try {
                    saveImageToStream(bitmap, this.getContentResolver().openOutputStream(uri));
                    values.put(MediaStore.Images.Media.IS_PENDING, false);
                    this.getContentResolver().update(uri, values, null, null);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        } else {
            Log.d(AccountActivity.class.getName(), "OS Android adalah " + Build.VERSION.SDK_INT);
            File directory = new File(Environment.getExternalStorageDirectory().toString() + '/' + getString(R.string.app_name));
//            File directory = new File(getBaseContext().getExternalFilesDir(n) + '/' + getString(R.string.app_name));
            if (!directory.exists()) {
                directory.mkdirs();
            }

            @SuppressLint("SimpleDateFormat")
            String fileName = "profile" + new SimpleDateFormat("yyyyMMddHHmmss'.png'").format(new Date());
            File file = new File(directory, fileName);

            try {
                saveImageToStream(bitmap, new FileOutputStream(file));
                ContentValues values = new ContentValues();
                values.put(MediaStore.Images.Media.DATA, file.getAbsolutePath());
                this.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);


            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            this.pathImage = fileName;
            Log.d(TAG, "Image name now at : " + fileName); //bisa tambahkan method lagi buat parameter pathImage

            user.setImageName(fileName);
            String photo = user.getImageName();
            Log.d(TAG, "Image name now at setImageName : " + photo);

            String name = user.getName(); //Null
            Log.d(TAG, "name now at getName : " + name);

        }

    }

    private ContentValues contentValues() {
        ContentValues values = new ContentValues();
        values.put(MediaStore.Images.Media.MIME_TYPE, "image/png");
        values.put(MediaStore.Images.Media.DATE_ADDED, System.currentTimeMillis() / 1000);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            values.put(MediaStore.Images.Media.DATE_TAKEN, System.currentTimeMillis());
        }
        return values;
    }

    private void saveImageToStream(Bitmap bitmap, OutputStream outputStream) {
        if (outputStream != null) {
            try {
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream);
                outputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
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
        builder.setPositiveButton(getString(R.string.go_to_settings), (dialog, which) -> {
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
                    collapsingToolbar.setTitle(Html.fromHtml("<font color='#FFFFFF'>" + " User details" + "</font>"));
                    isShow = true;
                } else if (isShow) {
                    collapsingToolbar.setTitle(" ");
                    isShow = false;
                }
            }
        });
    }
}