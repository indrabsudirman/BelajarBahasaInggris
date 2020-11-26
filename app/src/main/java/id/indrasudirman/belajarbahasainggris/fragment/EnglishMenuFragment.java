package id.indrasudirman.belajarbahasainggris.fragment;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Html;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

import id.indrasudirman.belajarbahasainggris.R;
import id.indrasudirman.belajarbahasainggris.RecyclerViewActivity;
import id.indrasudirman.belajarbahasainggris.SimplePastFragment;
import id.indrasudirman.belajarbahasainggris.SimplePastTense;
import id.indrasudirman.belajarbahasainggris.adapter.EnglishListAdapter;
import id.indrasudirman.belajarbahasainggris.model.EnglishList;
import id.indrasudirman.belajarbahasainggris.utils.RecyclerItemClickListener;


public class EnglishMenuFragment extends Fragment {

    private static final String TAG = EnglishMenuFragment.class.getSimpleName();

    private RecyclerView recyclerView;
    private List<EnglishList> englishLists;
    private EnglishListAdapter englishListAdapter;
    private RecyclerViewActivity recyclerViewActivity;
    private ImageView imageView;
    private View view;
    private BottomNavigationView bottomNavigationView;


    public EnglishMenuFragment() {
        // Required empty public constructor
    }

    public EnglishMenuFragment(FragmentActivity activity, List<EnglishList> englishLists) {
    }


    public static EnglishMenuFragment newInstance(String param1, String param2) {
        EnglishMenuFragment fragment = new EnglishMenuFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_english_menu, container, false);

        Toolbar toolbar = view.findViewById(R.id.toolbar);
        initCollapsingToolbar();



        bottomNavigationView = getActivity().findViewById(R.id.bottom_navigation);
        recyclerView = view.findViewById(R.id.recycler_view);
        englishLists = new ArrayList<>();
        englishListAdapter = new EnglishListAdapter(getActivity(), englishLists);
        recyclerViewActivity = new RecyclerViewActivity();
        imageView = view.findViewById(R.id.backdrop);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(8), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(englishListAdapter);

        //Row click listener
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getContext().getApplicationContext(), recyclerView, new RecyclerItemClickListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
//                Fragment fragment =new Fragment();
                if (position == 0) {
                    FragmentManager fragmentManager = getParentFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    SimplePastFragment simplePastTense = new SimplePastFragment();
                    fragmentTransaction.replace(R.id.frame_container, simplePastTense);
                    fragmentTransaction.commit();
                } else if (position == 1) {
                    Intent intent = new Intent(getContext().getApplicationContext(), SimplePastTense.class);
                    startActivity(intent);
                }

            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        //Will hide bottom navigation while row scroll up
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                if (dy > 0 && bottomNavigationView.isShown()) {
                    bottomNavigationView.setVisibility(View.GONE);
                } else if (dy < 0 ) {
                    bottomNavigationView.setVisibility(View.VISIBLE);

                }
            }
        });

        prepareLearnCover();

        try {
            Glide.with(getActivity()).load(R.drawable.top_cover).into(imageView);

        } catch (Exception e) {
            Log.e(TAG, "Error Glide: " + e.getMessage());
        }
        
        return view;
    }

    private void prepareLearnCover() {

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

            EnglishList englishList = new EnglishList("Simple Past Tense", 13, covers[0]);
            englishLists.add(englishList);

            englishList = new EnglishList("Simple Present Tense", 8, covers[1]);
            englishLists.add(englishList);

            englishList = new EnglishList("Simple Future Tense", 11, covers[2]);
            englishLists.add(englishList);

            englishList = new EnglishList("Past Continuous Tense", 12, covers[3]);
            englishLists.add(englishList);

            englishList = new EnglishList("Present Continuous Tense", 14, covers[4]);
            englishLists.add(englishList);

            englishList = new EnglishList("Future Continuous Tense", 1, covers[5]);
            englishLists.add(englishList);

            englishList = new EnglishList("Past Perfect Tense", 11, covers[6]);
            englishLists.add(englishList);

            englishList = new EnglishList("Present Perfect Tense", 14, covers[7]);
            englishLists.add(englishList);

            englishList = new EnglishList("Future Perfect Tense", 11, covers[8]);
            englishLists.add(englishList);

            englishList = new EnglishList("Past Perfect Continuous Tense", 17, covers[9]);
            englishLists.add(englishList);

            englishListAdapter.notifyDataSetChanged();


    }

    /**
     * Initializing collapsing toolbar
     * Will show and hide the toolbar title on scroll
     */

    private void initCollapsingToolbar() {
        final CollapsingToolbarLayout collapsingToolbarLayout = view.findViewById(R.id.collapsing_toolbar);
        collapsingToolbarLayout.setTitle(" ");
        AppBarLayout appBarLayout = view.findViewById(R.id.appbar);
        appBarLayout.setExpanded(true);

        //hiding & showing the title when toolbar expanded & collapsed
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {

            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {

                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbarLayout.setTitle(Html.fromHtml("<font color='#008577'>"+getString(R.string.app_name)+"</font>"));;

                    isShow = true;
                }
                else if (isShow) {
                    collapsingToolbarLayout.setTitle(" ");
                    isShow = false;
                }

            }
        });
    }

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