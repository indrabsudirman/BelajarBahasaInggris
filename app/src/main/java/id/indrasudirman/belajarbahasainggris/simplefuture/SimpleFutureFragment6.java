package id.indrasudirman.belajarbahasainggris.simplefuture;

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


public class SimpleFutureFragment6 extends Fragment {

    private View view;
    private TextInputEditText dropSimpleFutureOne;
    private TextInputEditText dropSimpleFutureOneTwo;
    private TextInputEditText dropSimpleFutureTwo;
    private TextInputEditText dropSimpleFutureTwoTwo;
    private TextInputEditText dropSimpleFutureThree;
    private TextInputEditText dropSimpleFutureThreeTwo;
    private TextInputEditText dropSimpleFutureFour;
    private TextInputEditText dropSimpleFutureFourTwo;
    private TextInputEditText dropSimpleFutureFive;
    private AppCompatTextView optionOne;
    private AppCompatTextView optionTwo;
    private AppCompatTextView optionThree;
    private AppCompatTextView optionFour;
    private AppCompatTextView optionFive;
    private AppCompatTextView optionSix;
    private AppCompatTextView optionSeven;
    private AppCompatTextView optionEight;
    private AppCompatTextView optionNine;

    private static final String TEXT_VIEW_OPTION_ONE = "menyatakan rencana yang sudah pasti";
    private static final String TEXT_VIEW_OPTION_TWO = "menyatakan prediksi";
    private static final String TEXT_VIEW_OPTION_THREE = "you're going to";
    private static final String TEXT_VIEW_OPTION_FOUR = "am going to";
    private static final String TEXT_VIEW_OPTION_FIVE = "next time";
    private static final String TEXT_VIEW_OPTION_SIX = "menyatakan keinginan";
    private static final String TEXT_VIEW_OPTION_SEVEN = "will";
    private static final String TEXT_VIEW_OPTION_EIGHT = "will be";
    private static final String TEXT_VIEW_OPTION_NINE = "menyatakan prediksi";

    private AppCompatButton tooltipsDropSimpleFutureOne;
    private AppCompatButton tooltipsDropSimpleFutureTwo;
    private AppCompatButton tooltipsDropSimpleFutureThree;
    private AppCompatButton tooltipsDropSimpleFutureFour;
    private AppCompatButton tooltipsDropSimpleFutureFive;

    private AppCompatImageView imageInfo;

    private LinearLayout mainLayout;

    private ShowcaseView showcaseView;

    private int mScrollDistance;
    private MyScrollView scrollViewSimpleFuture6;


    public SimpleFutureFragment6() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_simple_future6, container, false);
        findView();


        return view;
    }

    private void findView() {
        dropSimpleFutureOne = view.findViewById(R.id.dropSimpleFutureOne);
        disableEditText(dropSimpleFutureOne);
        dropSimpleFutureOneTwo = view.findViewById(R.id.dropSimpleFutureOneTwo);
        disableEditText(dropSimpleFutureOneTwo);
        dropSimpleFutureTwo = view.findViewById(R.id.dropSimpleFutureTwo);
        disableEditText(dropSimpleFutureTwo);
        dropSimpleFutureTwoTwo = view.findViewById(R.id.dropSimpleFutureTwoTwo);
        disableEditText(dropSimpleFutureTwoTwo);
        dropSimpleFutureThree = view.findViewById(R.id.dropSimpleFutureThree);
        disableEditText(dropSimpleFutureThree);
        dropSimpleFutureThreeTwo = view.findViewById(R.id.dropSimpleFutureThreeTwo);
        disableEditText(dropSimpleFutureThreeTwo);
        dropSimpleFutureFour = view.findViewById(R.id.dropSimpleFutureFour);
        disableEditText(dropSimpleFutureFour);
        dropSimpleFutureFourTwo = view.findViewById(R.id.dropSimpleFutureFourTwo);
        disableEditText(dropSimpleFutureFourTwo);
        dropSimpleFutureFive = view.findViewById(R.id.dropSimpleFutureFive);
        disableEditText(dropSimpleFutureFive);

        optionOne = view.findViewById(R.id.optionOne);
        optionOne.setTag(TEXT_VIEW_OPTION_ONE);
        optionTwo = view.findViewById(R.id.optionTwo);
        optionTwo.setTag(TEXT_VIEW_OPTION_TWO);
        optionThree = view.findViewById(R.id.optionThree);
        optionThree.setTag(TEXT_VIEW_OPTION_THREE);
        optionFour = view.findViewById(R.id.optionFour);
        optionFour.setTag(TEXT_VIEW_OPTION_FOUR);
        optionFive = view.findViewById(R.id.optionFive);
        optionFive.setTag(TEXT_VIEW_OPTION_FIVE);
        optionSix = view.findViewById(R.id.optionSix);
        optionSix.setTag(TEXT_VIEW_OPTION_SIX);
        optionSeven = view.findViewById(R.id.optionSeven);
        optionSeven.setTag(TEXT_VIEW_OPTION_SEVEN);
        optionEight = view.findViewById(R.id.optionEight);
        optionEight.setTag(TEXT_VIEW_OPTION_EIGHT);
        optionNine = view.findViewById(R.id.optionNine);
        optionNine.setTag(TEXT_VIEW_OPTION_NINE);

        tooltipsDropSimpleFutureOne = view.findViewById(R.id.tooltipsDropSimplePresentOne);
        tooltipsDropSimpleFutureTwo = view.findViewById(R.id.tooltipsDropSimplePresentTwo);
        tooltipsDropSimpleFutureThree = view.findViewById(R.id.tooltipsDropSimplePresentThree);
        tooltipsDropSimpleFutureFour = view.findViewById(R.id.tooltipsDropSimplePresentFour);
        tooltipsDropSimpleFutureFive = view.findViewById(R.id.tooltipsDropSimplePresentFive);

        imageInfo = view.findViewById(R.id.imageInfo);

        scrollViewSimpleFuture6 = view.findViewById(R.id.scrollViewSimpleFuture6);

        mainLayout = view.findViewById(R.id.mainLayout);
    }
    private void disableEditText(TextInputEditText inputEditText) {
        inputEditText.setCursorVisible(false);
        inputEditText.setKeyListener(null);
    }
}