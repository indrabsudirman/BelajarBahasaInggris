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

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

import id.indrasudirman.belajarbahasainggris.adapter.PresentPerfectAdapter;
import id.indrasudirman.belajarbahasainggris.adapter.PresentPerfectContinuousAdapter;
import id.indrasudirman.belajarbahasainggris.model.User;
import id.indrasudirman.belajarbahasainggris.sqlite.SQLiteHelper;
import id.indrasudirman.belajarbahasainggris.utils.PasswordMD5WithSalt;

public class PresentPerfectContinuousActivity extends AppCompatActivity {

    int[] colorIntArray = {R.color.colorPrimary, R.color.colorPrimary, R.color.colorPrimary, R.color.colorPrimary, R.color.colorPrimary};
    int[] iconIntArray = {R.drawable.ic_next_white, R.drawable.ic_check, R.drawable.ic_next_white, R.drawable.ic_check, R.drawable.ic_check};
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_present_perfect_continuous);

        viewPager2 = findViewById(R.id.viewPager);
        viewPager2.setAdapter(new PresentPerfectContinuousAdapter(this));
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
                            , MainMenu.class));
                    overridePendingTransition(0, 0);
                    return true;
                case R.id.user_account:
                    startActivity(new Intent(getApplicationContext()
                            , AccountActivity.class));
                    overridePendingTransition(0, 0);
                    return true;
            }
            return false;
        });

        //Perform TabLayout mediator for Viewpager2
        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(tabLayout,
                viewPager2, (tab, position) -> {
                    switch (position) {
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
                    checkAnswerTest1();
                    break;
                case 2:
                    viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);
                    user.setScore(3);
                    score = user.getScore();
                    System.out.println("Score : " + score);
                    break;
                case 3:
                    checkAnswerTest2();
                    break;
                case 4:
                    finishOnTheLastPage();
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

    private void checkAnswerTest1() {

        ArrayList<String> incorrectAnswerList = new ArrayList<>();

        int numberOfQuestionCorrect = 0;

        if (checkQuestionTestOne1()) {
            numberOfQuestionCorrect++;
        } else {
            incorrectAnswerList.add("Soal No 1");
        }

        if (checkQuestionTestOne2()) {
            numberOfQuestionCorrect++;
        } else {
            incorrectAnswerList.add("Soal No 2");
        }

        StringBuilder sb = new StringBuilder();
        for (String s : incorrectAnswerList) {
            sb.append(s);
            sb.append("\n");
        }

        if (numberOfQuestionCorrect == 2) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(PresentPerfectContinuousActivity.this);
            alertDialogBuilder
                    .setTitle("Selamat!")
                    .setMessage("Anda berhasil, nilai Anda : " + numberOfQuestionCorrect + "/2\nIni Sempurna. Anda dapat melanjutkan ke pelajaran berikutnya.")
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
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(PresentPerfectContinuousActivity.this);
            alertDialogBuilder
                    .setTitle("Gagal!")
                    .setMessage("Anda gagal, Nilai Anda adalah : " + numberOfQuestionCorrect + "/2\nAnda belum dapat melanjutkan pelajaran berikutnya.\n\n" + "Perbaiki jawaban Anda : \n\n" + sb.toString())
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

    private boolean checkQuestionTestOne1() {
        TextInputEditText editTextQuestion = findViewById(R.id.dropAnswerOne);

        String key = "08f51e50e2d91171b80fee86ee247ac9";

        PasswordMD5WithSalt p = new PasswordMD5WithSalt();

        return p.passKey(editTextQuestion.getText().toString().toLowerCase().trim()).equalsIgnoreCase(key);
    }

    private boolean checkQuestionTestOne2() {
        TextInputEditText editTextQuestion = findViewById(R.id.dropAnswerTwo);

        String key = "303415c0805cbf9dab045f7156fffa64";

        PasswordMD5WithSalt p = new PasswordMD5WithSalt();

        return p.passKey(editTextQuestion.getText().toString().toLowerCase().trim()).equalsIgnoreCase(key);
    }

    // checkAnswerTest2
    private void checkAnswerTest2() {

        ArrayList<String> incorrectAnswerList = new ArrayList<>();

        int numberOfQuestionCorrect = 0;

        if (checkQuestionTestTwo1()) {
            numberOfQuestionCorrect++;
        } else {
            incorrectAnswerList.add("Soal No 1 (1)");
        }

        if (checkQuestionTestTwo2()) {
            numberOfQuestionCorrect++;
        } else {
            incorrectAnswerList.add("Soal No 1 (2)");
        }

        if (checkQuestionTestTwo3()) {
            numberOfQuestionCorrect++;
        } else {
            incorrectAnswerList.add("Soal No 2 (1)");
        }

        if (checkQuestionTestTwo4()) {
            numberOfQuestionCorrect++;
        } else {
            incorrectAnswerList.add("Soal No 2 (2)");
        }

        if (checkQuestionTestTwo5()) {
            numberOfQuestionCorrect++;
        } else {
            incorrectAnswerList.add("Soal No 3 (1)");
        }

        if (checkQuestionTestTwo6()) {
            numberOfQuestionCorrect++;
        } else {
            incorrectAnswerList.add("Soal No 3 (2)");
        }

        if (checkQuestionTestTwo7()) {
            numberOfQuestionCorrect++;
        } else {
            incorrectAnswerList.add("Soal No 4 (1)");
        }

        if (checkQuestionTestTwo8()) {
            numberOfQuestionCorrect++;
        } else {
            incorrectAnswerList.add("Soal No 4 (2)");
        }

        if (checkQuestionTestTwo9()) {
            numberOfQuestionCorrect++;
        } else {
            incorrectAnswerList.add("Soal No 5 (1)");
        }

        if (checkQuestionTestTwo10()) {
            numberOfQuestionCorrect++;
        } else {
            incorrectAnswerList.add("Soal No 5 (2)");
        }
        StringBuilder sb = new StringBuilder();
        for (String s : incorrectAnswerList) {
            sb.append(s);
            sb.append("\n");
        }

        if (numberOfQuestionCorrect == 10) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(PresentPerfectContinuousActivity.this);
            alertDialogBuilder
                    .setTitle("Selamat!")
                    .setMessage("Anda berhasil, nilai Anda : " + numberOfQuestionCorrect + "/10\nIni Sempurna. Anda dapat melanjutkan ke pelajaran berikutnya.")
                    .setCancelable(false)
                    .setPositiveButton("Halaman berikutnya",
                            (dialogInterface, i) -> {
                                //Set Score user to 1
                                score = 4;
                                user.setScore(score);
                                score = user.getScore();
                                System.out.println("Score : " + score);
                                viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);

                            });

            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();

        } else {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(PresentPerfectContinuousActivity.this);
            alertDialogBuilder
                    .setTitle("Gagal!")
                    .setMessage("Anda gagal, Nilai Anda adalah : " + numberOfQuestionCorrect + "/10\nAnda belum dapat melanjutkan pelajaran berikutnya.\n\n" + "Perbaiki jawaban Anda : \n\n" + sb.toString())
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

    private boolean checkQuestionTestTwo1() {
        TextInputEditText editTextQuestion = findViewById(R.id.dropAnswerOneOne);

        String key = "8c00c19e66a7ba9d80bded9460cb1b41";

        PasswordMD5WithSalt p = new PasswordMD5WithSalt();

        return p.passKey(editTextQuestion.getText().toString().toLowerCase().trim()).equalsIgnoreCase(key);
    }

    private boolean checkQuestionTestTwo2() {
        TextInputEditText editTextQuestion = findViewById(R.id.dropAnswerOneTwo);

        String key = "3f4cede61a59db6832b07ea4f3bd3de1";

        PasswordMD5WithSalt p = new PasswordMD5WithSalt();

        return p.passKey(editTextQuestion.getText().toString().toLowerCase().trim()).equalsIgnoreCase(key);
    }

    private boolean checkQuestionTestTwo3() {
        TextInputEditText editTextQuestion = findViewById(R.id.dropAnswerTwoOne);

        String key = "01a3d05917850faba0102b81375a387e";

        PasswordMD5WithSalt p = new PasswordMD5WithSalt();

        return p.passKey(editTextQuestion.getText().toString().toLowerCase().trim()).equalsIgnoreCase(key);
    }

    private boolean checkQuestionTestTwo4() {
        TextInputEditText editTextQuestion = findViewById(R.id.dropAnswerTwoTwo);

        String key = "562a5db52b15793e732b0773a71522c1";

        PasswordMD5WithSalt p = new PasswordMD5WithSalt();

        return p.passKey(editTextQuestion.getText().toString().toLowerCase().trim()).equalsIgnoreCase(key);
    }

    private boolean checkQuestionTestTwo5() {
        TextInputEditText editTextQuestion = findViewById(R.id.dropAnswerThreeOne);

        String key = "b42dad5453b2128a32f6612b13ea5d9f";

        PasswordMD5WithSalt p = new PasswordMD5WithSalt();

        return p.passKey(editTextQuestion.getText().toString().toLowerCase().trim()).equalsIgnoreCase(key);
    }

    private boolean checkQuestionTestTwo6() {
        TextInputEditText editTextQuestion = findViewById(R.id.dropAnswerThreeTwo);

        String key = "8644ef7e5f3f604fc864b6ee4870e40a";

        PasswordMD5WithSalt p = new PasswordMD5WithSalt();

        return p.passKey(editTextQuestion.getText().toString().toLowerCase().trim()).equalsIgnoreCase(key);
    }

    private boolean checkQuestionTestTwo7() {
        TextInputEditText editTextQuestion = findViewById(R.id.dropAnswerFourOne);

        String key = "14be6fffc6426434191c04a2473e5f62";

        PasswordMD5WithSalt p = new PasswordMD5WithSalt();

        return p.passKey(editTextQuestion.getText().toString().toLowerCase().trim()).equalsIgnoreCase(key);
    }

    private boolean checkQuestionTestTwo8() {
        TextInputEditText editTextQuestion = findViewById(R.id.dropAnswerFourTwo);

        String key = "25a9ac406aceb47a0c6cade972bc26fa";

        PasswordMD5WithSalt p = new PasswordMD5WithSalt();

        return p.passKey(editTextQuestion.getText().toString().toLowerCase().trim()).equalsIgnoreCase(key);
    }

    private boolean checkQuestionTestTwo9() {
        TextInputEditText editTextQuestion = findViewById(R.id.dropAnswerFiveOne);

        String key = "14be6fffc6426434191c04a2473e5f62";

        PasswordMD5WithSalt p = new PasswordMD5WithSalt();

        return p.passKey(editTextQuestion.getText().toString().toLowerCase().trim()).equalsIgnoreCase(key);
    }

    private boolean checkQuestionTestTwo10() {
        TextInputEditText editTextQuestion = findViewById(R.id.dropAnswerFiveTwo);

        String key = "ed8c35a1ac48075e6d39385ae0362958";

        PasswordMD5WithSalt p = new PasswordMD5WithSalt();

        return p.passKey(editTextQuestion.getText().toString().toLowerCase().trim()).equalsIgnoreCase(key);
    }

    private void finishOnTheLastPage() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(PresentPerfectContinuousActivity.this);
        alertDialogBuilder
                .setTitle("Selamat!")
                .setMessage("Pembelajaran Present Perfect Continuous Tense sudah selesai. Anda dapat melanjutkan ke pelajaran berikutnya Future Perfect Continuous Tense.")
                .setCancelable(false)
                .setPositiveButton("Future Perfect Continuous Tense",
                        (dialogInterface, i) -> {
                            //Set Score user to 5
                            score = 5;
                            user.setScore(score);
                            score = user.getScore();
                            //Set Score to DB
                            String userEmail = (sharedPreferences.getString(KEY_EMAIL, "").trim());
                            sqLiteHelper.updateUserScore(userEmail, "14");
                            startActivity(new Intent(getApplicationContext()
                                    ,MainMenu.class));
                            overridePendingTransition(0, 0);
                        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}