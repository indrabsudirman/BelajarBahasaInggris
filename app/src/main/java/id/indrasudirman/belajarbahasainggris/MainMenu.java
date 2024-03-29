package id.indrasudirman.belajarbahasainggris;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Html;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

import id.indrasudirman.belajarbahasainggris.adapter.MainMenuAdapter;
import id.indrasudirman.belajarbahasainggris.model.EnglishList;
import id.indrasudirman.belajarbahasainggris.sqlite.SQLiteHelper;
import id.indrasudirman.belajarbahasainggris.utils.RecyclerItemClickListener;

public class MainMenu extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MainMenuAdapter adapter;
    private List<EnglishList> english;
    private String scoreDatabase;

    private SQLiteHelper sqLiteHelper;
    private SharedPreferences sharedPreferences;

    private static final String SHARED_PREF_NAME = "sharedPrefLogin";
    private static final String KEY_EMAIL = "email";

    private boolean doubleBackToExitPressedOnce = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        sqLiteHelper = new SQLiteHelper(this);
        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);


        //Initialize and assign variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNav);

        //Set Recycler View Learn English as default
        bottomNavigationView.setSelectedItemId(R.id.main_learn);

        //Perform item selectListener
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.main_learn:
                    return true;
                case R.id.user_account:
                    startActivity(new Intent(getApplicationContext()
                            , AccountActivity.class));
                    overridePendingTransition(0, 0);
                    return true;
            }
            return false;
        });

        initCollapsingToolbar();

        recyclerView = findViewById(R.id.recycler_view);

        english = new ArrayList<>();
        adapter = new MainMenuAdapter(this, english);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        //Row click listener
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getApplicationContext(), recyclerView, new RecyclerItemClickListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                if (position == 0) { //1
                    startActivity(new Intent(getApplicationContext()
                            ,SimplePastActivity.class));
                    overridePendingTransition(0, 0);

                } if (position == 1) { //2
                    scoreDatabase = sqLiteHelper.getUserScore(sharedPreferences.getString(KEY_EMAIL, "").trim());

                        int score = Integer.parseInt(scoreDatabase);
                        if (score >= position) {
                            startActivity(new Intent(getApplicationContext()
                                    ,SimplePresentActivity.class));
                            overridePendingTransition(0, 0);
                        } else {
                            Toast.makeText(getApplicationContext(), "Anda harus menyelesaikan pembelajaran sebelumnya, score anda = " + score, Toast.LENGTH_SHORT).show();
                        }


                } if (position == 2) { //3
                    scoreDatabase = sqLiteHelper.getUserScore(sharedPreferences.getString(KEY_EMAIL, "").trim());

                        int score = Integer.parseInt(scoreDatabase);
                        if (score >= position) {
                            startActivity(new Intent(getApplicationContext()
                                    ,SimpleFutureActivity.class));
                            overridePendingTransition(0, 0);
                        } else {
                            Toast.makeText(getApplicationContext(), "Anda harus menyelesaikan pembelajaran sebelumnya, score anda = " + score, Toast.LENGTH_SHORT).show();
                        }

                } if (position == 3) { //4 SimplePastFutureActivity
                    scoreDatabase = sqLiteHelper.getUserScore(sharedPreferences.getString(KEY_EMAIL, "").trim());

                    int score = Integer.parseInt(scoreDatabase);
                    if (score >= position) {
                        startActivity(new Intent(getApplicationContext()
                                ,SimplePastFutureActivity.class));
                        overridePendingTransition(0, 0);
                    } else {
                        Toast.makeText(getApplicationContext(), "Anda harus menyelesaikan pembelajaran sebelumnya, score anda = " + score, Toast.LENGTH_SHORT).show();
                    }

                } if (position == 4) { //5 PastContinuousActivity
                    scoreDatabase = sqLiteHelper.getUserScore(sharedPreferences.getString(KEY_EMAIL, "").trim());

                    int score = Integer.parseInt(scoreDatabase);
                    if (score >= position) {
                        startActivity(new Intent(getApplicationContext()
                                ,PastContinuousActivity.class));
                        overridePendingTransition(0, 0);
                    } else {
                        Toast.makeText(getApplicationContext(), "Anda harus menyelesaikan pembelajaran sebelumnya, score anda = " + score, Toast.LENGTH_SHORT).show();
                    }

                } if (position == 5) { //6 PresentContinuousActivity
                    scoreDatabase = sqLiteHelper.getUserScore(sharedPreferences.getString(KEY_EMAIL, "").trim());

                    int score = Integer.parseInt(scoreDatabase);
                    if (score >= position) {
                        startActivity(new Intent(getApplicationContext()
                                ,PresentContinuousActivity.class));
                        overridePendingTransition(0, 0);
                    } else {
                        Toast.makeText(getApplicationContext(), "Anda harus menyelesaikan pembelajaran sebelumnya, score anda = " + score, Toast.LENGTH_SHORT).show();
                    }

                } if (position == 6) { //7 FutureContinuousActivity
                    scoreDatabase = sqLiteHelper.getUserScore(sharedPreferences.getString(KEY_EMAIL, "").trim());

                    int score = Integer.parseInt(scoreDatabase);
                    if (score >= position) {
                        startActivity(new Intent(getApplicationContext()
                                ,FutureContinuousActivity.class));
                        overridePendingTransition(0, 0);
                    } else {
                        Toast.makeText(getApplicationContext(), "Anda harus menyelesaikan pembelajaran sebelumnya, score anda = " + score, Toast.LENGTH_SHORT).show();
                    }

                } if (position == 7) { //8 PastFutureContinuousActivity
                    scoreDatabase = sqLiteHelper.getUserScore(sharedPreferences.getString(KEY_EMAIL, "").trim());

                    int score = Integer.parseInt(scoreDatabase);
                    if (score >= position) {
                        startActivity(new Intent(getApplicationContext()
                                ,PastFutureContinuousActivity.class));
                        overridePendingTransition(0, 0);
                    } else {
                        Toast.makeText(getApplicationContext(), "Anda harus menyelesaikan pembelajaran sebelumnya, score anda = " + score, Toast.LENGTH_SHORT).show();
                    }

                } if (position == 8) { //9 PastPerfectActivity
                    scoreDatabase = sqLiteHelper.getUserScore(sharedPreferences.getString(KEY_EMAIL, "").trim());

                    int score = Integer.parseInt(scoreDatabase);
                    if (score >= position) {
                        startActivity(new Intent(getApplicationContext()
                                ,PastPerfectActivity.class));
                        overridePendingTransition(0, 0);
                    } else {
                        Toast.makeText(getApplicationContext(), "Anda harus menyelesaikan pembelajaran sebelumnya, score anda = " + score, Toast.LENGTH_SHORT).show();
                    }

                } if (position == 9) { //10 PresentPerfectActivity
                    scoreDatabase = sqLiteHelper.getUserScore(sharedPreferences.getString(KEY_EMAIL, "").trim());

                    int score = Integer.parseInt(scoreDatabase);
                    if (score >= position) {
                        startActivity(new Intent(getApplicationContext()
                                ,PresentPerfectActivity.class));
                        overridePendingTransition(0, 0);
                    } else {
                        Toast.makeText(getApplicationContext(), "Anda harus menyelesaikan pembelajaran sebelumnya, score anda = " + score, Toast.LENGTH_SHORT).show();
                    }

                } if (position == 10) { //11 FuturePerfectActivity
                    scoreDatabase = sqLiteHelper.getUserScore(sharedPreferences.getString(KEY_EMAIL, "").trim());

                    int score = Integer.parseInt(scoreDatabase);
                    if (score >= position) {
                        startActivity(new Intent(getApplicationContext()
                                ,FuturePerfectActivity.class));
                        overridePendingTransition(0, 0);
                    } else {
                        Toast.makeText(getApplicationContext(), "Anda harus menyelesaikan pembelajaran sebelumnya, score anda = " + score, Toast.LENGTH_SHORT).show();
                    }

                } if (position == 11) { //12 PastFuturePerfectActivity
                    scoreDatabase = sqLiteHelper.getUserScore(sharedPreferences.getString(KEY_EMAIL, "").trim());

                    int score = Integer.parseInt(scoreDatabase);
                    if (score >= position) {
                        startActivity(new Intent(getApplicationContext()
                                ,PastFuturePerfectActivity.class));
                        overridePendingTransition(0, 0);
                    } else {
                        Toast.makeText(getApplicationContext(), "Anda harus menyelesaikan pembelajaran sebelumnya, score anda = " + score, Toast.LENGTH_SHORT).show();
                    }

                } if (position == 12) { //13 PastPerfectContinuousActivity
                    scoreDatabase = sqLiteHelper.getUserScore(sharedPreferences.getString(KEY_EMAIL, "").trim());

                    int score = Integer.parseInt(scoreDatabase);
                    if (score >= position) {
                        startActivity(new Intent(getApplicationContext()
                                ,PastPerfectContinuousActivity.class));
                        overridePendingTransition(0, 0);
                    } else {
                        Toast.makeText(getApplicationContext(), "Anda harus menyelesaikan pembelajaran sebelumnya, score anda = " + score, Toast.LENGTH_SHORT).show();
                    }

                } if (position == 13) { //14 PresentPerfectContinuousActivity
                    scoreDatabase = sqLiteHelper.getUserScore(sharedPreferences.getString(KEY_EMAIL, "").trim());

                    int score = Integer.parseInt(scoreDatabase);
                    if (score >= position) {
                        startActivity(new Intent(getApplicationContext()
                                ,PresentPerfectContinuousActivity.class));
                        overridePendingTransition(0, 0);
                    } else {
                        Toast.makeText(getApplicationContext(), "Anda harus menyelesaikan pembelajaran sebelumnya, score anda = " + score, Toast.LENGTH_SHORT).show();
                    }

                } if (position == 14) { //15 FuturePerfectContinuousActivity
                    scoreDatabase = sqLiteHelper.getUserScore(sharedPreferences.getString(KEY_EMAIL, "").trim());

                    int score = Integer.parseInt(scoreDatabase);
                    if (score >= position) {
                        startActivity(new Intent(getApplicationContext()
                                ,FuturePerfectContinuousActivity.class));
                        overridePendingTransition(0, 0);
                    } else {
                        Toast.makeText(getApplicationContext(), "Anda harus menyelesaikan pembelajaran sebelumnya, score anda = " + score, Toast.LENGTH_SHORT).show();
                    }

                } if (position == 15) { //16 PastFuturePerfectContinuousActivity
                    scoreDatabase = sqLiteHelper.getUserScore(sharedPreferences.getString(KEY_EMAIL, "").trim());

                    int score = Integer.parseInt(scoreDatabase);
                    if (score >= position) {
                        startActivity(new Intent(getApplicationContext()
                                ,PastFuturePerfectContinuousActivity.class));
                        overridePendingTransition(0, 0);
                    } else {
                        Toast.makeText(getApplicationContext(), "Anda harus menyelesaikan pembelajaran sebelumnya, score anda = " + score, Toast.LENGTH_SHORT).show();
                    }
                }



            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        prepareCovers();

        try {
            Glide.with(this).load(R.drawable.top_cover_main_menu).into((ImageView) findViewById(R.id.backdrop));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            Intent homeIntent = new Intent(Intent.ACTION_MAIN);
            homeIntent.addCategory( Intent.CATEGORY_HOME );
            homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(homeIntent);
            return;
        }
        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(getApplicationContext(), "Tekan sekali lagi untuk keluar", Toast.LENGTH_SHORT).show();

        new Handler(Looper.getMainLooper()).postDelayed(() -> doubleBackToExitPressedOnce=false, 2000);
    }

    /**
     * Initializing collapsing toolbar
     * Will show and hide the toolbar title on scroll
     */
    @SuppressLint("ResourceAsColor")
    private void initCollapsingToolbar() {
        final CollapsingToolbarLayout collapsingToolbar =
                findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(" ");
        AppBarLayout appBarLayout = findViewById(R.id.appbar);
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
                    collapsingToolbar.setTitle(Html.fromHtml("<font color='#009650'>"+getString(R.string.app_name)+"</font>"));
                    isShow = true;
                } else if (isShow) {
                    collapsingToolbar.setTitle(" ");
                    isShow = false;
                }
            }
        });
    }

    /**
     * Adding few cover for testing
     */
    private void prepareCovers() {
        int[] covers = new int[]{
                R.drawable.simple_past_icon,
                R.drawable.simple_present_icon,
                R.drawable.simple_future_icon,
                R.drawable.simple_past_future_icon,
                R.drawable.past_continuous_tense_icon,
                R.drawable.present_continuous_tense_icon,
                R.drawable.future_continuous_tense_icon,
                R.drawable.past_future_continuous_tense_icon,
                R.drawable.past_perfect_tense_icon,
                R.drawable.present_perfect_tense_icon,
                R.drawable.future_perfect_tense_icon,
                R.drawable.past_future_perfect_tense_icon,
                R.drawable.past_perfect_continuous_tense_icon,
                R.drawable.present_perfect_continuous_tense_icon,
                R.drawable.future_perfect_continuous_tense_icon,
                R.drawable.past_future_perfect_continuous_tense_icon};

        EnglishList a = new EnglishList("Simple Past Tense", 5, covers[0]); //1
        english.add(a);

        a = new EnglishList("Simple Present Tense", 6, covers[1]); //2
        english.add(a);

        a = new EnglishList("Simple Future Tense", 6, covers[2]); //3
        english.add(a);

        a = new EnglishList("Simple Past Future Tense", 5, covers[3]); //4
        english.add(a);

        a = new EnglishList("Past Continuous Tense", 5, covers[4]); //5
        english.add(a);

        a = new EnglishList("Present Continuous Tense", 6, covers[5]); //6
        english.add(a);

        a = new EnglishList("Future Continuous Tense", 5, covers[6]); //7
        english.add(a);

        a = new EnglishList("Past Future Continuous Tense", 5, covers[7]); //8
        english.add(a);

        a = new EnglishList("Past Perfect Tense", 5, covers[8]); //9
        english.add(a);

        a = new EnglishList("Present Perfect Tense", 5, covers[9]); //10
        english.add(a);

        a = new EnglishList("Future Perfect Tense", 5, covers[10]); //11
        english.add(a);

        a = new EnglishList("Past Future Perfect Tense", 5, covers[11]); //12
        english.add(a);

        a = new EnglishList("Past Perfect Continuous Tense", 5, covers[12]); //13
        english.add(a);

        a = new EnglishList("Present Perfect Continuous Tense", 5, covers[13]); //14
        english.add(a);

        a = new EnglishList("Future Perfect Continuous Tense", 5, covers[14]); //15
        english.add(a);

        a = new EnglishList("Past Future Perfect Continuous Tense", 5, covers[15]); //16
        english.add(a);

        adapter.notifyDataSetChanged();
    }

    /**
     * RecyclerView item decoration - give equal margin around grid item
     */
    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }
}