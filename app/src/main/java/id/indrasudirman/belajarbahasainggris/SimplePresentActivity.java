package id.indrasudirman.belajarbahasainggris;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.google.android.material.textfield.TextInputEditText;


import java.util.ArrayList;

import id.indrasudirman.belajarbahasainggris.adapter.SimplePresentAdapter;
import id.indrasudirman.belajarbahasainggris.model.User;
import id.indrasudirman.belajarbahasainggris.sqlite.SQLiteHelper;
import id.indrasudirman.belajarbahasainggris.utils.PasswordMD5WithSalt;

public class SimplePresentActivity extends AppCompatActivity {

    private ViewPager2 viewPager2;
    private FloatingActionButton floatingActionButton;
    private int score = 0;
    private User user;
    private TabLayout tabLayout;

    private SQLiteHelper sqLiteHelper;
    private SharedPreferences sharedPreferences;

    private static final String TAG = SimplePastActivity.class.getSimpleName();
    private static final String SHARED_PREF_NAME = "sharedPrefLogin";
    private static final String KEY_EMAIL = "email";

    int[] colorIntArray = {R.color.colorPrimary, R.color.colorPrimary, R.color.colorPrimary, R.color.colorPrimary, R.color.colorPrimary, R.color.colorPrimary};
    int[] iconIntArray = {R.drawable.ic_next_white, R.drawable.ic_check, R.drawable.ic_next_white, R.drawable.ic_check, R.drawable.ic_next_white, R.drawable.ic_check};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_present);

        viewPager2 = findViewById(R.id.viewPager);
        viewPager2.setAdapter(new SimplePresentAdapter(this));
        viewPager2.setUserInputEnabled(false);

        sqLiteHelper = new SQLiteHelper(this);
        user = new User();
        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);

        floatingActionButton = findViewById(R.id.fab);
        floatingActionButton.setBackgroundColor(Color.parseColor("#FF009650"));

        tabLayout = findViewById(R.id.tabLayout);
//        tabLayout.clearOnTabSelectedListeners();

        //Initialize and assign variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation);

        //Set Recycler View Learn English as default
        bottomNavigationView.setSelectedItemId(R.id.main_learn);

        //Perform item selectListener
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
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
        });

        //Perform TabLayout mediator for Viewpager2
        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(tabLayout,
                viewPager2, (tab, position) -> {
                    switch (position){
                        case 0: {
                            tab.setText("Hal 1");
                            tab.setIcon(R.drawable.ic_baseline_menu_book_24);
                            break;
                        }
                        case 1: {
                            tab.setText("Hal 2");
                            tab.setIcon(R.drawable.test);
                            tab.view.setClickable(false);
                            break;
                        }
                        case 2: {
                            tab.setText("Hal 3");
                            tab.setIcon(R.drawable.ic_baseline_menu_book_24);
                            tab.view.setClickable(false);
                            break;
                        }
                        case 3: {
                            tab.setText("Hal 4");
                            tab.setIcon(R.drawable.test);
                            tab.view.setClickable(false);
                            break;
                        }
                        case 4: {
                            tab.setText("Hal 5");
                            tab.setIcon(R.drawable.ic_baseline_menu_book_24);
                            tab.view.setClickable(false);
                            break;
                        }
                        case 5: {
                            tab.setText("Hal 6");
                            tab.setIcon(R.drawable.test);
                            tab.view.setClickable(false);
                            break;
                        }
                    }

                });
        tabLayoutMediator.attach();

        floatingActionButton.setOnClickListener(view -> {
            int position = tabLayout.getSelectedTabPosition();
            switch (position) {
                case 0:
                    viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);
                    user.setScore(1);
                    score = user.getScore();
                    System.out.println("Score : " + score);
                    break;
                case 1:
                    checkAnswerSimplePresent1();
                    break;
                case 2:
                    viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);
                    user.setScore(3);
                    score = user.getScore();
                    System.out.println("Score : " + score);
                    break;
                case 3:
                    checkAnswerSimplePresent2();
                    break;
                case 4:
                    viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);
                    user.setScore(5);
                    score = user.getScore();
                    System.out.println("Score : " + score);
                    break;
                case 5:
                    checkAnswerSimplePresent3();
                    break;
            }
        });

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
                animateFab(tab.getPosition());
                switch (tab.getPosition()) {
                    case 0:
                        tab.view.setClickable(true);
                        break;
                    case 1:
                        tab.view.setClickable(score >= 1);
                        break;
                    case 2:
                        tab.view.setClickable(score >= 2);
                        break;
                    case 3:
                        tab.view.setClickable(score >= 3);
                        break;
                    case 4:
                        tab.view.setClickable(score >= 4);
                        break;
                    case 5:
                        tab.view.setClickable(score >= 5);
                        break;
                }


            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    protected void animateFab(final int position) {
        final FloatingActionButton fab = findViewById(R.id.fab);
        fab.clearAnimation();

        // Scale down animation
        ScaleAnimation shrink = new ScaleAnimation(1f, 0.1f, 1f, 0.1f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        shrink.setDuration(100);     // animation duration in milliseconds
        shrink.setInterpolator(new AccelerateInterpolator());
        shrink.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                // Change FAB color and icon
                fab.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(), colorIntArray[position]));
                fab.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), iconIntArray[position]));

                // Rotate Animation
                Animation rotate = new RotateAnimation(60.0f, 0.0f,
                        Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
                        0.5f);
                rotate.setDuration(150);
                rotate.setInterpolator(new DecelerateInterpolator());

                // Scale up animation
                ScaleAnimation expand = new ScaleAnimation(0.1f, 1f, 0.1f, 1f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                expand.setDuration(150);     // animation duration in milliseconds
                expand.setInterpolator(new DecelerateInterpolator());

                // Add both animations to animation state
                AnimationSet s = new AnimationSet(false); //false means don't share interpolators
                s.addAnimation(rotate);
                s.addAnimation(expand);
                fab.startAnimation(s);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        fab.startAnimation(shrink);

    }

    //Check Simple Present Test 1
    private void checkAnswerSimplePresent1() {
        ArrayList<String> incorrectAnswerList = new ArrayList<>();

        int numberOfQuestionCorrect = 0;

        if (checkQuestion1()) {
            numberOfQuestionCorrect++;
        } else {
            incorrectAnswerList.add("Soal No 1 (1)");
        }

        if (checkQuestion2()) {
            numberOfQuestionCorrect++;
        } else {
            incorrectAnswerList.add("Soal No 1 (2)");
        }

        if (checkQuestion3()) {
            numberOfQuestionCorrect++;
        } else {
            incorrectAnswerList.add("Soal No 2 (1)");
        }

        if (checkQuestion4()) {
            numberOfQuestionCorrect++;
        } else {
            incorrectAnswerList.add("Soal No 2 (2)");
        }

        StringBuilder sb = new StringBuilder();
        for (String s : incorrectAnswerList) {
            sb.append(s);
            sb.append("\n");
        }

        if (numberOfQuestionCorrect == 4) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(SimplePresentActivity.this);
            alertDialogBuilder
                    .setTitle("Selamat!")
                    .setMessage("Anda berhasil, nilai Anda : " + numberOfQuestionCorrect + "/4\nIni Sempurna. Anda dapat melanjutkan ke pelajaran berikutnya.")
                    .setCancelable(false)
                    .setPositiveButton("Halaman berikutnya",
                            (dialogInterface, i) -> {
                                //Set Score user to 1
                                score = 2;
                                user.setScore(score);
                                score = user.getScore();
                                System.out.println("Score : " + score);
                                viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);

                            });

            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();

        } else {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(SimplePresentActivity.this);
            alertDialogBuilder
                    .setTitle("Gagal!")
                    .setMessage("Anda gagal, Nilai Anda adalah : " + numberOfQuestionCorrect + "/4\nAnda belum dapat melanjutkan pelajaran berikutnya.\n\n" + "Perbaiki jawaban Anda : \n\n" + sb.toString())
                    .setCancelable(false)
                    .setPositiveButton("Mulai test lagi",
                            (dialogInterface, i) -> viewPager2.setCurrentItem(viewPager2.getCurrentItem()))

                    .setNegativeButton("Keluar aplikasi",
                            (dialogInterface, i) -> {
                                moveTaskToBack(true);
                                finish();
                            });

            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }

    }


    private boolean checkQuestion1() {
        TextInputEditText editTextQuestion = findViewById(R.id.dropSimplePresentOne);

        String key = "2d6b6aad43dffa9125ef8420faefca18";

        PasswordMD5WithSalt p = new PasswordMD5WithSalt();

        return p.passKey(editTextQuestion.getText().toString().toLowerCase().trim()).equalsIgnoreCase(key);
    }

    private boolean checkQuestion2() {
        TextInputEditText editTextQuestion = findViewById(R.id.dropSimplePresentTwo);

        String key = "6456fd664bdf27c7dbab1acdfd44f78f";

        PasswordMD5WithSalt p = new PasswordMD5WithSalt();

        return p.passKey(editTextQuestion.getText().toString().toLowerCase().trim()).equalsIgnoreCase(key);
    }

    private boolean checkQuestion3() {
        TextInputEditText editTextQuestion = findViewById(R.id.dropSimplePresentThree);

        String key = "2d3f28b714c3e6767dab1c82bf293685";

        PasswordMD5WithSalt p = new PasswordMD5WithSalt();

        return p.passKey(editTextQuestion.getText().toString().toLowerCase().trim()).equalsIgnoreCase(key);
    }

    private boolean checkQuestion4() {
        TextInputEditText editTextQuestion = findViewById(R.id.dropSimplePresentFour);

        String key = "fce663ae73dc87a727148bc3b94d1ffa";

        PasswordMD5WithSalt p = new PasswordMD5WithSalt();

        return p.passKey(editTextQuestion.getText().toString().toLowerCase().trim()).equalsIgnoreCase(key);
    }


    //Check Simple Present Test 2
    private void checkAnswerSimplePresent2() {
        ArrayList<String> incorrectAnswerList = new ArrayList<>();

        int numberOfQuestionCorrect = 0;

        if (checkQuestionSimplePresentTestSecond1()) {
            numberOfQuestionCorrect++;
        } else {
            incorrectAnswerList.add("Soal No 1");
        }

        if (checkQuestionSimplePresentTestSecond2()) {
            numberOfQuestionCorrect++;
        } else {
            incorrectAnswerList.add("Soal No 2");
        }

        if (checkQuestionSimplePresentTestSecond3()) {
            numberOfQuestionCorrect++;
        } else {
            incorrectAnswerList.add("Soal No 3");
        }

        if (checkQuestionSimplePresentTestSecond4()) {
            numberOfQuestionCorrect++;
        } else {
            incorrectAnswerList.add("Soal No 4");
        }

        if (checkQuestionSimplePresentTestSecond5()) {
            numberOfQuestionCorrect++;
        } else {
            incorrectAnswerList.add("Soal No 5");
        }

        StringBuilder sb = new StringBuilder();
        for (String s : incorrectAnswerList) {
            sb.append(s);
            sb.append("\n");
        }

        if (numberOfQuestionCorrect == 5) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(SimplePresentActivity.this);
            alertDialogBuilder
                    .setTitle("Selamat!")
                    .setMessage("Anda berhasil, nilai Anda : " + numberOfQuestionCorrect + "/5\nIni Sempurna. Anda dapat melanjutkan ke pelajaran berikutnya.")
                    .setCancelable(false)
                    .setPositiveButton("Halaman berikutnya",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    //Set Score user to 1
                                    score = 4;
                                    user.setScore(score);
                                    score = user.getScore();
                                    System.out.println("Score : " + score);
                                    viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);

                                }
                            });

            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();

        } else {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(SimplePresentActivity.this);
            alertDialogBuilder
                    .setTitle("Gagal!")
                    .setMessage("Anda gagal, Nilai Anda adalah : " + numberOfQuestionCorrect + "/5\nAnda belum dapat melanjutkan pelajaran berikutnya.\n\n" + "Perbaiki jawaban Anda : \n\n" + sb.toString())
                    .setCancelable(false)
                    .setPositiveButton("Mulai test lagi",
                            (dialogInterface, i) -> viewPager2.setCurrentItem(viewPager2.getCurrentItem()))

                    .setNegativeButton("Keluar aplikasi",
                            (dialogInterface, i) -> {
                                moveTaskToBack(true);
                                finish();
                            });

            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }
    }

    private boolean checkQuestionSimplePresentTestSecond1() {
        TextInputEditText editTextQuestion = findViewById(R.id.dropSimplePresentOne);

        String key = "5440e70c43cc02aba90d879c888e6e09";

        PasswordMD5WithSalt p = new PasswordMD5WithSalt();

        return p.passKey(editTextQuestion.getText().toString().toLowerCase().trim()).equalsIgnoreCase(key);
    }

    private boolean checkQuestionSimplePresentTestSecond2() {
        TextInputEditText editTextQuestion = findViewById(R.id.dropSimplePresentTwo);

        String key = "b5d3dda86dd6b7b4e4b794d9c46be86c";

        PasswordMD5WithSalt p = new PasswordMD5WithSalt();

        return p.passKey(editTextQuestion.getText().toString().toLowerCase().trim()).equalsIgnoreCase(key);
    }

    private boolean checkQuestionSimplePresentTestSecond3() {
        TextInputEditText editTextQuestion = findViewById(R.id.dropSimplePresentThree);

        String key = "deee62ef7c62eb45a76c47b0f6d8d182";

        PasswordMD5WithSalt p = new PasswordMD5WithSalt();

        return p.passKey(editTextQuestion.getText().toString().toLowerCase().trim()).equalsIgnoreCase(key);
    }

    private boolean checkQuestionSimplePresentTestSecond4() {
        TextInputEditText editTextQuestion = findViewById(R.id.dropSimplePresentFour);

        String key = "a2a551a6458a8de22446cc76d639a9e9";

        PasswordMD5WithSalt p = new PasswordMD5WithSalt();

        return p.passKey(editTextQuestion.getText().toString().toLowerCase().trim()).equalsIgnoreCase(key);
    }

    private boolean checkQuestionSimplePresentTestSecond5() {
        TextInputEditText editTextQuestion = findViewById(R.id.dropSimplePresentFive);

        String key = "4015e9ce43edfb0668ddaa973ebc7e87";

        PasswordMD5WithSalt p = new PasswordMD5WithSalt();

        return p.passKey(editTextQuestion.getText().toString().toLowerCase().trim()).equalsIgnoreCase(key);
    }

    private void checkAnswerSimplePresent3() {

        ArrayList<String> incorrectAnswerList = new ArrayList<>();

        int numberOfQuestionCorrect = 0;

        if (checkQuestionSimplePresentTestThird1()) {
            numberOfQuestionCorrect++;
        } else {
            incorrectAnswerList.add("Soal No 1 (1)");
        }

        if (checkQuestionSimplePresentTestThird2()) {
            numberOfQuestionCorrect++;
        } else {
            incorrectAnswerList.add("Soal No 1 (2)");
        }

        if (checkQuestionSimplePresentTestThird3()) {
            numberOfQuestionCorrect++;
        } else {
            incorrectAnswerList.add("Soal No 2");
        }

        if (checkQuestionSimplePresentTestThird4()) {
            numberOfQuestionCorrect++;
        } else {
            incorrectAnswerList.add("Soal No 3");
        }

        if (checkQuestionSimplePresentTestThird5()) {
            numberOfQuestionCorrect++;
        } else {
            incorrectAnswerList.add("Soal No 4 (1)");
        }

        if (checkQuestionSimplePresentTestThird6()) {
            numberOfQuestionCorrect++;
        } else {
            incorrectAnswerList.add("Soal No 4 (2)");
        }

        if (checkQuestionSimplePresentTestThird7()) {
            numberOfQuestionCorrect++;
        } else {
            incorrectAnswerList.add("Soal No 5");
        }

        StringBuilder sb = new StringBuilder();
        for (String s : incorrectAnswerList) {
            sb.append(s);
            sb.append("\n");
        }

        if (numberOfQuestionCorrect == 7) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(SimplePresentActivity.this);
            alertDialogBuilder
                    .setTitle("Selamat!")
                    .setMessage("Anda berhasil, nilai Anda : " + numberOfQuestionCorrect + "/7\nIni Sempurna. Anda dapat melanjutkan ke pelajaran berikutnya Simple Future Tense.")
                    .setCancelable(false)
                    .setPositiveButton("Simple Future Tense",
                            (dialogInterface, i) -> {
                                //Set Score user to 1
                                score = 4;
                                user.setScore(score);
                                score = user.getScore();
                                //Set Score to DB
                                String userEmail = (sharedPreferences.getString(KEY_EMAIL, "").trim());
                                sqLiteHelper.updateUserScore(userEmail, "2");
                                startActivity(new Intent(getApplicationContext()
                                        ,MainMenu.class));
                                overridePendingTransition(0, 0);
                            });

            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();

        } else {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(SimplePresentActivity.this);
            alertDialogBuilder
                    .setTitle("Gagal!")
                    .setMessage("Anda gagal, Nilai Anda adalah : " + numberOfQuestionCorrect + "/7\nAnda belum dapat melanjutkan pelajaran berikutnya.\n\n" + "Perbaiki jawaban Anda : \n\n" + sb.toString())
                    .setCancelable(false)
                    .setPositiveButton("Mulai test lagi",
                            (dialogInterface, i) -> viewPager2.setCurrentItem(viewPager2.getCurrentItem()))

                    .setNegativeButton("Keluar aplikasi",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    moveTaskToBack(true);
                                    finish();
                                }
                            });

            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }

    }

    private boolean checkQuestionSimplePresentTestThird1() {
        TextInputEditText editTextQuestion = findViewById(R.id.dropSimplePresentOne);

        String key = "86e9db1c12cbf5038e1833849bcf2899";

        PasswordMD5WithSalt p = new PasswordMD5WithSalt();

        return p.passKey(editTextQuestion.getText().toString().toLowerCase().trim()).equalsIgnoreCase(key);
    }

    private boolean checkQuestionSimplePresentTestThird2() {
        TextInputEditText editTextQuestion = findViewById(R.id.dropSimplePresentTwo);

        String key = "f7e78e04cba74c610354e91e622cc105";

        PasswordMD5WithSalt p = new PasswordMD5WithSalt();

        return p.passKey(editTextQuestion.getText().toString().toLowerCase().trim()).equalsIgnoreCase(key);
    }

    private boolean checkQuestionSimplePresentTestThird3() {
        TextInputEditText editTextQuestion = findViewById(R.id.dropSimplePresentThree);

        String key = "009b2a76c10b3a6f0f9d7a5b1f8aa701";

        PasswordMD5WithSalt p = new PasswordMD5WithSalt();

        return p.passKey(editTextQuestion.getText().toString().toLowerCase().trim()).equalsIgnoreCase(key);
    }

    private boolean checkQuestionSimplePresentTestThird4() {
        TextInputEditText editTextQuestion = findViewById(R.id.dropSimplePresentFour);

        String key = "18e6e150c819b0e433515f7ab5354f67";

        PasswordMD5WithSalt p = new PasswordMD5WithSalt();

        return p.passKey(editTextQuestion.getText().toString().toLowerCase().trim()).equalsIgnoreCase(key);
    }

    private boolean checkQuestionSimplePresentTestThird5() {
        TextInputEditText editTextQuestion = findViewById(R.id.dropSimplePresentFive);

        String key = "5440e70c43cc02aba90d879c888e6e09";

        PasswordMD5WithSalt p = new PasswordMD5WithSalt();

        return p.passKey(editTextQuestion.getText().toString().toLowerCase().trim()).equalsIgnoreCase(key);
    }

    private boolean checkQuestionSimplePresentTestThird6() {
        TextInputEditText editTextQuestion = findViewById(R.id.dropSimplePresentSix);

        String key = "83737189a94ae28f1a1c43cfeef8d87f";

        PasswordMD5WithSalt p = new PasswordMD5WithSalt();

        return p.passKey(editTextQuestion.getText().toString().toLowerCase().trim()).equalsIgnoreCase(key);
    }

    private boolean checkQuestionSimplePresentTestThird7() {
        TextInputEditText editTextQuestion = findViewById(R.id.dropSimplePresentSeven);

        String key = "21af0be5413d3aff369ff9a9e66df01a";

        PasswordMD5WithSalt p = new PasswordMD5WithSalt();

        return p.passKey(editTextQuestion.getText().toString().toLowerCase().trim()).equalsIgnoreCase(key);
    }
}