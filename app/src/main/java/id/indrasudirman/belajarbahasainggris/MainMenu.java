package id.indrasudirman.belajarbahasainggris;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.Html;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
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
import id.indrasudirman.belajarbahasainggris.utils.RecyclerItemClickListener;

public class MainMenu extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MainMenuAdapter adapter;
    private List<EnglishList> english;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        androidx.appcompat.widget.Toolbar toolbar = (androidx.appcompat.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //Initialize and assign variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNav);

        //Set Recycler View Learn English as default
        bottomNavigationView.setSelectedItemId(R.id.main_learn);

        //Perform item selectListener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
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
            }
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
                    startActivity(new Intent(getApplicationContext()
                            ,SimplePresentActivity.class));
                    overridePendingTransition(0, 0);
                } if (position == 2) { //3
                    startActivity(new Intent(getApplicationContext()
                            ,SimpleFutureActivity.class));
                    overridePendingTransition(0, 0);
                } if (position == 3) { //4
                    Toast.makeText(MainMenu.this, "Anda klik Simple Past Future Tense", Toast.LENGTH_LONG).show();

                } if (position == 4) { //5
                    Toast.makeText(MainMenu.this, "Anda klik Past Continuous Tense", Toast.LENGTH_LONG).show();

                } if (position == 5) { //6
                    Toast.makeText(MainMenu.this, "Anda klik Present Continuous Tense", Toast.LENGTH_LONG).show();

                } if (position == 6) { //7
                    Toast.makeText(MainMenu.this, "Anda klik Future Continuous Tense", Toast.LENGTH_LONG).show();

                } if (position == 7) { //8
                    Toast.makeText(MainMenu.this, "Anda klik Past Future Continuous Tense", Toast.LENGTH_LONG).show();

                } if (position == 8) { //9
                    Toast.makeText(MainMenu.this, "Anda klik Past Perfect Tense", Toast.LENGTH_LONG).show();

                } if (position == 9) { //10
                    Toast.makeText(MainMenu.this, "Anda klik Present Perfect Tense", Toast.LENGTH_LONG).show();

                } if (position == 10) { //11
                    Toast.makeText(MainMenu.this, "Anda klik Future Perfect Tense", Toast.LENGTH_LONG).show();

                } if (position == 11) { //12
                    Toast.makeText(MainMenu.this, "Anda klik Past Future Perfect Tense", Toast.LENGTH_LONG).show();

                } if (position == 12) { //13
                    Toast.makeText(MainMenu.this, "Anda klik Past Perfect Continuous Tense", Toast.LENGTH_LONG).show();

                } if (position == 13) { //14
                    Toast.makeText(MainMenu.this, "Anda klik Present Perfect Continuous Tense", Toast.LENGTH_LONG).show();

                } if (position == 14) { //15
                    Toast.makeText(MainMenu.this, "Anda klik Future Perfect Continuous Tense", Toast.LENGTH_LONG).show();

                } if (position == 15) { //16
                    Toast.makeText(MainMenu.this, "Anda klik Past Future Perfect Continuous Tense", Toast.LENGTH_LONG).show();

                }



            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        prepareCovers();

        try {
            Glide.with(this).load(R.drawable.top_cover).into((ImageView) findViewById(R.id.backdrop));
        } catch (Exception e) {
            e.printStackTrace();
        }
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
                    collapsingToolbar.setTitle(Html.fromHtml("<font color='#008577'>"+getString(R.string.app_name)+"</font>"));
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
                R.drawable.bookopen,
                R.drawable.bookopen,
                R.drawable.bookopen,
                R.drawable.bookopen,
                R.drawable.bookopen,
                R.drawable.bookopen,
                R.drawable.bookopen,
                R.drawable.bookopen,
                R.drawable.bookopen,
                R.drawable.bookopen,
                R.drawable.bookopen};

        EnglishList a = new EnglishList("Simple Past Tense", 5, covers[0]); //1
        english.add(a);

        a = new EnglishList("Simple Present Tense", 5, covers[1]); //2
        english.add(a);

        a = new EnglishList("Simple Future Tense", 5, covers[2]); //3
        english.add(a);

        a = new EnglishList("Simple Past Future Tense", 5, covers[3]); //4
        english.add(a);

        a = new EnglishList("Past Continuous Tense", 5, covers[4]); //5
        english.add(a);

        a = new EnglishList("Present Continuous Tense", 5, covers[5]); //6
        english.add(a);

        a = new EnglishList("Future Continuous Tense", 5, covers[6]); //7
        english.add(a);

        a = new EnglishList("Past Future Continuous Tense", 5, covers[7]); //8
        english.add(a);

        a = new EnglishList("Past Perfect Tense", 5, covers[8]); //9
        english.add(a);

        a = new EnglishList("Present Perfect Tense", 5, covers[9]); //10
        english.add(a);

        a = new EnglishList("Future Perfect Tense", 5, covers[9]); //11
        english.add(a);

        a = new EnglishList("Past Future Perfect Tense", 5, covers[9]); //12
        english.add(a);

        a = new EnglishList("Past Perfect Continuous Tense", 5, covers[9]); //13
        english.add(a);

        a = new EnglishList("Present Perfect Continuous Tense", 5, covers[9]); //14
        english.add(a);

        a = new EnglishList("Future Perfect Continuous Tense", 5, covers[9]); //15
        english.add(a);

        a = new EnglishList("Past Future Perfect Continuous Tense", 5, covers[9]); //16
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