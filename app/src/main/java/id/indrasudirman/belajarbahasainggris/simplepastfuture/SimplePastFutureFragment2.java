package id.indrasudirman.belajarbahasainggris.simplepastfuture;

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


public class SimplePastFutureFragment2 extends Fragment {

    private View view;
    private TextInputEditText dropSimplePastFutureOne;
    private TextInputEditText dropSimplePastFutureTwo;
    private TextInputEditText dropSimplePastFutureThree;
    private TextInputEditText dropSimplePastFutureFour;
    private AppCompatTextView optionTwo;
    private AppCompatTextView optionOne;
    private AppCompatTextView optionThree;
    private AppCompatTextView optionFour;
    private AppCompatTextView optionFive;
    private AppCompatTextView optionSix;

    private static final String TEXT_VIEW_OPTION_ONE = "will stay";
    private static final String TEXT_VIEW_OPTION_TWO = "will go";
    private static final String TEXT_VIEW_OPTION_THREE = "conditional sentence type satu";
    private static final String TEXT_VIEW_OPTION_FOUR = "will goes";
    private static final String TEXT_VIEW_OPTION_FIVE = "kejadian yang akan dilakukan di masa depan";
    private static final String TEXT_VIEW_OPTION_SIX = "will stays";

    private AppCompatButton tooltipsDropSimplePastFutureOne;
    private AppCompatButton tooltipsDropSimplePastFutureTwo;

    private AppCompatImageView imageInfo;

    private LinearLayout mainLayout;

    private ShowcaseView showcaseView;

    private int mScrollDistance;
    private MyScrollView scrollViewSimplePastFuture2;


    public SimplePastFutureFragment2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_simple_past_future2, container, false);


        return view;
    }
}