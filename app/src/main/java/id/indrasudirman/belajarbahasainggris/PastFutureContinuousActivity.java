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

import id.indrasudirman.belajarbahasainggris.adapter.PastFutureContinuousAdapter;
import id.indrasudirman.belajarbahasainggris.model.User;
import id.indrasudirman.belajarbahasainggris.sqlite.SQLiteHelper;
import id.indrasudirman.belajarbahasainggris.utils.PasswordMD5WithSalt;

public class PastFutureContinuousActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_past_future_continuous);

        viewPager2 = findViewById(R.id.viewPager);
        viewPager2.setAdapter(new PastFutureContinuousAdapter(this));
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
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
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
            }
        });

        //Perform TabLayout mediator for Viewpager2
        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(tabLayout,
                viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
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

            }
        });
        tabLayoutMediator.attach();

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = tabLayout.getSelectedTabPosition();
                switch (position) {
                    case 0:
                        viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);
                        user.setScore(1);
                        score = user.getScore();
                        System.out.println("Score : " + score);
                        break;
                    case 1:
                        checkAnswerPastFutureContinuous1();
                        break;
                    case 2:
                        viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);
                        user.setScore(3);
                        score = user.getScore();
                        System.out.println("Score : " + score);
                        break;
                    case 3:
                        checkAnswerPastFutureContinuous2();
                        break;
                    case 4:
                        finishOnPastFutureContinuous();
                        break;
                }
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

    // checkAnswerFutureContinuous1
    private void checkAnswerPastFutureContinuous1() {

        ArrayList<String> incorrectAnswerList = new ArrayList<>();

        int numberOfQuestionCorrect = 0;

        if (checkQuestionPastFutureContinuousTestOne1()) {
            numberOfQuestionCorrect++;
        } else {
            incorrectAnswerList.add("Soal No 1");
        }

        if (checkQuestionPastFutureContinuousTestOne2()) {
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
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(PastFutureContinuousActivity.this);
            alertDialogBuilder
                    .setTitle("Selamat!")
                    .setMessage("Anda berhasil, nilai Anda : " + numberOfQuestionCorrect + "/2\nIni Sempurna. Anda dapat melanjutkan ke pelajaran berikutnya.")
                    .setCancelable(false)
                    .setPositiveButton("Halaman berikutnya",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    //Set Score user to 1
                                    score = 2;
                                    user.setScore(score);
                                    score = user.getScore();
                                    System.out.println("Score : " + score);
                                    viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);

                                }
                            });

            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();

        } else {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(PastFutureContinuousActivity.this);
            alertDialogBuilder
                    .setTitle("Gagal!")
                    .setMessage("Anda gagal, Nilai Anda adalah : " + numberOfQuestionCorrect + "/2\nAnda belum dapat melanjutkan pelajaran berikutnya.\n\n" + "Perbaiki jawaban Anda : \n\n" + sb.toString())
                    .setCancelable(false)
                    .setPositiveButton("Mulai test lagi",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    viewPager2.setCurrentItem(viewPager2.getCurrentItem());

                                }
                            })

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
    private boolean checkQuestionPastFutureContinuousTestOne1() {
        TextInputEditText editTextQuestion = findViewById(R.id.dropPastFutureContinuousOne);

        String key = "58d71d44584db8d5bfb426c799467dfb";

        PasswordMD5WithSalt p = new PasswordMD5WithSalt();

        return p.passKey(editTextQuestion.getText().toString().toLowerCase().trim()).equalsIgnoreCase(key);
    }

    private boolean checkQuestionPastFutureContinuousTestOne2() {
        TextInputEditText editTextQuestion = findViewById(R.id.dropPastFutureContinuousTwo);

        String key = "d3e2f4936f2cb2ba53fd15844d589e0c";

        PasswordMD5WithSalt p = new PasswordMD5WithSalt();

        return p.passKey(editTextQuestion.getText().toString().toLowerCase().trim()).equalsIgnoreCase(key);
    }

    // checkAnswerFutureContinuous2
    private void checkAnswerPastFutureContinuous2() {

        ArrayList<String> incorrectAnswerList = new ArrayList<>();

        int numberOfQuestionCorrect = 0;

        if (checkQuestionPastFutureContinuousTestTwo1()) {
            numberOfQuestionCorrect++;
        } else {
            incorrectAnswerList.add("Soal No 1 (1)");
        }

        if (checkQuestionPastFutureContinuousTestTwo2()) {
            numberOfQuestionCorrect++;
        } else {
            incorrectAnswerList.add("Soal No 1 (2)");
        }

        if (checkQuestionPastFutureContinuousTestTwo3()) {
            numberOfQuestionCorrect++;
        } else {
            incorrectAnswerList.add("Soal No 2 (1)");
        }

        if (checkQuestionPastFutureContinuousTestTwo4()) {
            numberOfQuestionCorrect++;
        } else {
            incorrectAnswerList.add("Soal No 2 (2)");
        }

        if (checkQuestionPastFutureContinuousTestTwo5()) {
            numberOfQuestionCorrect++;
        } else {
            incorrectAnswerList.add("Soal No 3 (1)");
        }

        if (checkQuestionPastFutureContinuousTestTwo6()) {
            numberOfQuestionCorrect++;
        } else {
            incorrectAnswerList.add("Soal No 3 (2)");
        }

        if (checkQuestionPastFutureContinuousTestTwo7()) {
            numberOfQuestionCorrect++;
        } else {
            incorrectAnswerList.add("Soal No 4 (1)");
        }

        if (checkQuestionPastFutureContinuousTestTwo8()) {
            numberOfQuestionCorrect++;
        } else {
            incorrectAnswerList.add("Soal No 4 (2)");
        }

        if (checkQuestionPastFutureContinuousTestTwo9()) {
            numberOfQuestionCorrect++;
        } else {
            incorrectAnswerList.add("Soal No 5 (1)");
        }

        if (checkQuestionPastFutureContinuousTestTwo10()) {
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
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(PastFutureContinuousActivity.this);
            alertDialogBuilder
                    .setTitle("Selamat!")
                    .setMessage("Anda berhasil, nilai Anda : " + numberOfQuestionCorrect + "/10\nIni Sempurna. Anda dapat melanjutkan ke pelajaran berikutnya.")
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
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(PastFutureContinuousActivity.this);
            alertDialogBuilder
                    .setTitle("Gagal!")
                    .setMessage("Anda gagal, Nilai Anda adalah : " + numberOfQuestionCorrect + "/10\nAnda belum dapat melanjutkan pelajaran berikutnya.\n\n" + "Perbaiki jawaban Anda : \n\n" + sb.toString())
                    .setCancelable(false)
                    .setPositiveButton("Mulai test lagi",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    viewPager2.setCurrentItem(viewPager2.getCurrentItem());

                                }
                            })

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

    private boolean checkQuestionPastFutureContinuousTestTwo1() {
        TextInputEditText editTextQuestion = findViewById(R.id.dropAnswerOneOne);

        String key = "97bb1d0dbba34051a9040d11a6f58e4f";

        PasswordMD5WithSalt p = new PasswordMD5WithSalt();

        return p.passKey(editTextQuestion.getText().toString().toLowerCase().trim()).equalsIgnoreCase(key);
    }

    private boolean checkQuestionPastFutureContinuousTestTwo2() {
        TextInputEditText editTextQuestion = findViewById(R.id.dropAnswerOneTwo);

        String key = "98bd1c45684cf587ac2347a92dd7bb51";

        PasswordMD5WithSalt p = new PasswordMD5WithSalt();

        return p.passKey(editTextQuestion.getText().toString().toLowerCase().trim()).equalsIgnoreCase(key);
    }

    private boolean checkQuestionPastFutureContinuousTestTwo3() {
        TextInputEditText editTextQuestion = findViewById(R.id.dropAnswerTwoOne);

        String key = "55f195813a158d82e2934cfac569575d";

        PasswordMD5WithSalt p = new PasswordMD5WithSalt();

        return p.passKey(editTextQuestion.getText().toString().toLowerCase().trim()).equalsIgnoreCase(key);
    }

    private boolean checkQuestionPastFutureContinuousTestTwo4() {
        TextInputEditText editTextQuestion = findViewById(R.id.dropAnswerTwoTwo);

        String key = "1c536d97ecd0f821b24b17f71008a8a3";

        PasswordMD5WithSalt p = new PasswordMD5WithSalt();

        return p.passKey(editTextQuestion.getText().toString().toLowerCase().trim()).equalsIgnoreCase(key);
    }

    private boolean checkQuestionPastFutureContinuousTestTwo5() {
        TextInputEditText editTextQuestion = findViewById(R.id.dropAnswerThreeOne);

        String key = "e680afd37e4511a8cb3ce9f63168862a";

        PasswordMD5WithSalt p = new PasswordMD5WithSalt();

        return p.passKey(editTextQuestion.getText().toString().toLowerCase().trim()).equalsIgnoreCase(key);
    }

    private boolean checkQuestionPastFutureContinuousTestTwo6() {
        TextInputEditText editTextQuestion = findViewById(R.id.dropAnswerThreeTwo);

        String key = "cd63569e38fc446c2cba58366cf588ee";

        PasswordMD5WithSalt p = new PasswordMD5WithSalt();

        return p.passKey(editTextQuestion.getText().toString().toLowerCase().trim()).equalsIgnoreCase(key);
    }

    private boolean checkQuestionPastFutureContinuousTestTwo7() {
        TextInputEditText editTextQuestion = findViewById(R.id.dropAnswerFourOne);

        String key = "e680afd37e4511a8cb3ce9f63168862a";

        PasswordMD5WithSalt p = new PasswordMD5WithSalt();

        return p.passKey(editTextQuestion.getText().toString().toLowerCase().trim()).equalsIgnoreCase(key);
    }

    private boolean checkQuestionPastFutureContinuousTestTwo8() {
        TextInputEditText editTextQuestion = findViewById(R.id.dropAnswerFourTwo);

        String key = "6e1bcf42422a2e4c4dfd623a1dea79f3";

        PasswordMD5WithSalt p = new PasswordMD5WithSalt();

        return p.passKey(editTextQuestion.getText().toString().toLowerCase().trim()).equalsIgnoreCase(key);
    }

    private boolean checkQuestionPastFutureContinuousTestTwo9() {
        TextInputEditText editTextQuestion = findViewById(R.id.dropAnswerFiveOne);

        String key = "e680afd37e4511a8cb3ce9f63168862a";

        PasswordMD5WithSalt p = new PasswordMD5WithSalt();

        return p.passKey(editTextQuestion.getText().toString().toLowerCase().trim()).equalsIgnoreCase(key);
    }

    private boolean checkQuestionPastFutureContinuousTestTwo10() {
        TextInputEditText editTextQuestion = findViewById(R.id.dropAnswerFiveTwo);

        String key = "df3340f8dd84752cacbae55fb54855fd";

        PasswordMD5WithSalt p = new PasswordMD5WithSalt();

        return p.passKey(editTextQuestion.getText().toString().toLowerCase().trim()).equalsIgnoreCase(key);
    }

    private void finishOnPastFutureContinuous() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(PastFutureContinuousActivity.this);
        alertDialogBuilder
                .setTitle("Selamat!")
                .setMessage("Pembelajaran Past Future Continuous Tense sudah selesai. Anda dapat melanjutkan ke pelajaran berikutnya Past Perfect Tense.")
                .setCancelable(false)
                .setPositiveButton("Past Perfect Tense",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                //Set Score user to 5
                                score = 5;
                                user.setScore(score);
                                score = user.getScore();
                                //Set Score to DB
                                String userEmail = (sharedPreferences.getString(KEY_EMAIL, "").trim());
                                sqLiteHelper.updateUserScore(userEmail, "8");
                                startActivity(new Intent(getApplicationContext()
                                        ,MainMenu.class));
                                overridePendingTransition(0, 0);
                            }
                        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}