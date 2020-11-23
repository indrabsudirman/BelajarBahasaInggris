package id.indrasudirman.belajarbahasainggris;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.ImageViewCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.Resource;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import java.util.ArrayList;
import java.util.List;

import id.indrasudirman.belajarbahasainggris.adapter.EnglishListAdapter;
import id.indrasudirman.belajarbahasainggris.model.EnglishList;
import id.indrasudirman.belajarbahasainggris.utils.RecyclerItemClickListener;

public class RecyclerViewActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private EnglishListAdapter englishListAdapter;
    private List <EnglishList> englishLists;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initCollapsingToolbar();

        recyclerView = findViewById(R.id.recycler_view);
        englishLists = new ArrayList<>();
        englishListAdapter = new EnglishListAdapter(this, englishLists);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration (2, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(englishListAdapter);

        //Row Click Listener
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getApplicationContext(), recyclerView, new RecyclerItemClickListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent intent;

                if (position == 0) {
                    intent = new Intent(getApplicationContext(), SimplePast.class);
                    startActivity(intent);
                } else if (position == 1) {
                    intent = new Intent(getApplicationContext(), SimplePast.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        preparedRecyclerViewCovers();

        try {
            Glide.with(this).load(R.drawable.top_cover).into((ImageView) findViewById(R.id.backdrop));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initCollapsingToolbar() {
        final CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsing_toolbar);
        collapsingToolbarLayout.setTitle(" ");
        AppBarLayout appBarLayout = findViewById(R.id.appbar);
        appBarLayout.setExpanded(true);

        //Hiding & showing the title when toolbar expanded & collapsed
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                } if (scrollRange + verticalOffset == 0) {
                    collapsingToolbarLayout.setTitle(getString(R.string.app_name));
                    isShow = true;
                } else if (isShow) {
                    collapsingToolbarLayout.setTitle(" ");
                    isShow = false;
                }
            }
        });
    }

    /**
     * Adding few images for recycler view cover
     */

    private void preparedRecyclerViewCovers() {
        int [] cover = new int[] {
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

        EnglishList englishList = new EnglishList("Simple Past Tense", 11, cover[0]);
        englishLists.add(englishList);

        englishList = new EnglishList("Simple Present Tense", 7, cover[1]);
        englishLists.add(englishList);

        englishList = new EnglishList("Simple Future Tense", 7, cover[2]);
        englishLists.add(englishList);

        englishList = new EnglishList("Past Continuous Tense", 7, cover[3]);
        englishLists.add(englishList);

        englishList = new EnglishList("Present Continuous Tense", 7, cover[4]);
        englishLists.add(englishList);

        englishList = new EnglishList("Future Continuous Tense", 7, cover[5]);
        englishLists.add(englishList);

        englishList = new EnglishList("Past Perfect Tense", 7, cover[6]);
        englishLists.add(englishList);

        englishList = new EnglishList("Present Perfect Tense", 7, cover[7]);
        englishLists.add(englishList);

        englishList = new EnglishList("Future Perfect Tense", 7, cover[8]);
        englishLists.add(englishList);

        englishList = new EnglishList("Past Perfect Continuous Tense", 7, cover[9]);
        englishLists.add(englishList);

        englishListAdapter.notifyDataSetChanged();

    }
    /**
     *RecyclerView item Decoration - give equal margin around grid item
     */

    private class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {
        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.includeEdge = includeEdge;
            this.spacing = spacing;

        }

        @Override
        public void getItemOffsets (Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); //Item position
            int column = position % spanCount; //Item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; //spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { //top edge
                    outRect.top = spacing;
                } outRect.bottom = spacing; //item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; //spacing - (column + 1) * ((1f / spanCount) + spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; //Item top
                }
            }
        }
    }

    /**
     * Convert dp to pixel
     * @param dp
     * @return
     */
    private int dpToPx (int dp) {
        Resources resources = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, ((Resources) resources).getDisplayMetrics()));
    }
}