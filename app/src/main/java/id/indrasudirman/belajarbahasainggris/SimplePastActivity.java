package id.indrasudirman.belajarbahasainggris;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

import id.indrasudirman.belajarbahasainggris.adapter.SimplePastAdapter;
import id.indrasudirman.belajarbahasainggris.utils.PasswordMD5WithSalt;

public class SimplePastActivity extends AppCompatActivity {
    private ViewPager2 viewPager2;
    private FloatingActionButton floatingActionButton;
    private int score = 0;

    int[] colorIntArray = {R.color.colorPrimary, R.color.colorPrimary, R.color.colorPrimary, R.color.colorPrimary};
    int[] iconIntArray = {R.drawable.ic_next_white, R.drawable.ic_check, R.drawable.ic_next_white, R.drawable.ic_check};





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_past);

        viewPager2 = findViewById(R.id.viewPager);
        viewPager2.setAdapter(new SimplePastAdapter(this));
        viewPager2.setUserInputEnabled(false);

        floatingActionButton = findViewById(R.id.fab);
        floatingActionButton.setBackgroundColor(Color.parseColor("#FF009650"));

        final TabLayout tabLayout = findViewById(R.id.tabLayout);
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
                    case 2: {
                        tab.setText("Hal 3");
                        tab.setIcon(R.drawable.ic_baseline_menu_book_24);
                        tab.view.setClickable(false);
                        break;
                    }
                    case 3: {
                        tab.setText("Test");
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
                    case 2:
                        viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);
                        break;
                    case 1:
                        checkAnswer(view);
                        break;
                    case 3:
                        Snackbar.make(view, "Pakulonan, Serpong Utara, Tangsel", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                        break;
                }
            }
        });

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
                if (tab.getPosition() ==2) {
                    viewPager2.setOnTouchListener(new View.OnTouchListener() {
                        @Override
                        public boolean onTouch(View v, MotionEvent event) {

                            return false;
                        }
                    });
                }
                animateFab(tab.getPosition());
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

    private boolean checkQuestion1() {
        TextInputEditText editTextQuestion = findViewById(R.id.answer_simple_past_test1);

        String key = "1f0cec14e2c5effcbff50f2feb9495f6";

        PasswordMD5WithSalt p = new PasswordMD5WithSalt();

        return p.passKey(editTextQuestion.getText().toString().toLowerCase()).equalsIgnoreCase(key);
    }

    private boolean checkQuestion2() {
        TextInputEditText editTextQuestion = findViewById(R.id.answer_simple_past_test2);

        String key = "07715e6d0e0223bf2bd3ded1ff74184c";

        PasswordMD5WithSalt p = new PasswordMD5WithSalt();

        return p.passKey(editTextQuestion.getText().toString().toLowerCase()).equalsIgnoreCase(key);
    }

    private boolean checkQuestion3() {
        TextInputEditText editTextQuestion = findViewById(R.id.answer_simple_past_test3);

        String key = "e22864336bd8b265bcd2d0435462e1f4";

        PasswordMD5WithSalt p = new PasswordMD5WithSalt();

        return p.passKey(editTextQuestion.getText().toString().toLowerCase()).equalsIgnoreCase(key);
    }

    private void checkAnswer(View view) {
        ArrayList<String> incorrectAnswerList = new ArrayList<>();

        int numberOfQuestionCorrect = 0;

        if (checkQuestion1()) {
            numberOfQuestionCorrect++;
        } else {
            incorrectAnswerList.add("Soal No 1");
        }

        if (checkQuestion2()) {
            numberOfQuestionCorrect++;
        } else {
            incorrectAnswerList.add("Soal No 2");
        }

        if (checkQuestion3()) {
            numberOfQuestionCorrect++;
        } else {
            incorrectAnswerList.add("Soal No 3");
        }

        StringBuilder sb = new StringBuilder();
        for (String s : incorrectAnswerList) {
            sb.append(s);
            sb.append("\n");
        }

        if (numberOfQuestionCorrect == 3) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(SimplePastActivity.this);
            alertDialogBuilder
                    .setTitle("Selamat!")
                    .setMessage("Anda berhasil, nilai Anda : " + numberOfQuestionCorrect + "/3\nIni Sempurna. Anda dapat melanjutkan ke pelajaran berikutnya.")
                    .setCancelable(false)
                    .setPositiveButton("Simple Past Tense 2",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);


                                }
                            });

            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        } else {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(SimplePastActivity.this);
            alertDialogBuilder
                    .setTitle("Gagal!")
                    .setMessage("Anda gagal, Nilai Anda adalah : " + numberOfQuestionCorrect + "/3\nAnda belum dapat melanjutkan pelajaran berikutnya.\n\n" + "Perbaiki jawaban Anda : \n\n" + sb.toString())
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


}