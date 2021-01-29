package id.indrasudirman.belajarbahasainggris.presentcontinuous;

import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.github.amlcurran.showcaseview.ShowcaseView;
import com.google.android.material.textfield.TextInputEditText;

import id.indrasudirman.belajarbahasainggris.R;
import id.indrasudirman.belajarbahasainggris.utils.MyScrollView;


public class PresentContinuousFragment4 extends Fragment {

    private View view;
    private TextInputEditText dropPresentContinuousOne;
    private TextInputEditText dropPresentContinuousTwoOne;
    private TextInputEditText dropPresentContinuousThree;
    private TextInputEditText dropPresentContinuousFourOne;
    private TextInputEditText dropPresentContinuousFourTwo;
    private TextInputEditText dropPresentContinuousFive;
    private AppCompatTextView optionOne;
    private AppCompatTextView optionTwo;
    private AppCompatTextView optionThree;
    private AppCompatTextView optionFour;
    private AppCompatTextView optionFive;
    private AppCompatTextView optionSix;
    private AppCompatTextView optionSeven;
    private AppCompatTextView optionEight;
    private AppCompatTextView optionNine;
    private AppCompatButton tooltipsDropPresentContinuousOne;
    private AppCompatButton tooltipsDropPresentContinuousTwo;
    private AppCompatButton tooltipsDropPresentContinuousThree;
    private AppCompatButton tooltipsDropPresentContinuousFour;
    private AppCompatButton tooltipsDropPresentContinuousFive;
    private static final String TEXT_VIEW_OPTION_ONE = "wasn't preparing";
    private static final String TEXT_VIEW_OPTION_TWO = "did";
    private static final String TEXT_VIEW_OPTION_THREE = "called";
    private static final String TEXT_VIEW_OPTION_FOUR = "was washing";
    private static final String TEXT_VIEW_OPTION_FIVE = "was";
    private static final String TEXT_VIEW_OPTION_SIX = "doing";
    private static final String TEXT_VIEW_OPTION_SEVEN = "were";
    private static final String TEXT_VIEW_OPTION_EIGHT = "was";
    private static final String TEXT_VIEW_OPTION_NINE = "was always studying";

    private AppCompatImageView imageInfo;

    private LinearLayout mainLayout;

    private ShowcaseView showcaseView;

    private int mScrollDistance;
    private MyScrollView scrollViewPresentContinuous4;


    public PresentContinuousFragment4() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_present_continuous4, container, false);


        return view;
    }
}