package id.indrasudirman.belajarbahasainggris.futurecontinuous;

import android.content.ClipData;
import android.content.ClipDescription;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.graphics.BlendModeColorFilterCompat;
import androidx.core.graphics.BlendModeCompat;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.github.amlcurran.showcaseview.ShowcaseView;
import com.github.amlcurran.showcaseview.targets.ViewTarget;
import com.google.android.material.textfield.TextInputEditText;

import id.indrasudirman.belajarbahasainggris.R;
import id.indrasudirman.belajarbahasainggris.utils.MyScrollView;


public class FutureContinuousFragment4 extends Fragment implements View.OnDragListener, View.OnLongClickListener {

    private View view;
    private TextInputEditText dropFutureContinuousOne;
    private TextInputEditText dropFutureContinuousTwoOne;
    private TextInputEditText dropFutureContinuousTwoTwo;
    private TextInputEditText dropFutureContinuousThreeOne;
    private TextInputEditText dropFutureContinuousThreeTwo;
    private TextInputEditText dropFutureContinuousFourOne;
    private TextInputEditText dropFutureContinuousFourTwo;
    private TextInputEditText dropFutureContinuousFiveOne;
    private TextInputEditText dropFutureContinuousFiveTwo;
    private AppCompatTextView optionOne;
    private AppCompatTextView optionTwo;
    private AppCompatTextView optionThree;
    private AppCompatTextView optionFour;
    private AppCompatTextView optionFive;
    private AppCompatTextView optionSix;
    private AppCompatTextView optionSeven;
    private AppCompatTextView optionEight;
    private AppCompatTextView optionNine;
    private AppCompatButton tooltipsDropFutureContinuousOne;
    private AppCompatButton tooltipsDropFutureContinuousTwo;
    private AppCompatButton tooltipsDropFutureContinuousThree;
    private AppCompatButton tooltipsDropFutureContinuousFour;
    private AppCompatButton tooltipsDropFutureContinuousFive;
    private static final String TEXT_VIEW_OPTION_ONE = "shall";
    private static final String TEXT_VIEW_OPTION_TWO = "be frying";
    private static final String TEXT_VIEW_OPTION_THREE = "be climbing";
    private static final String TEXT_VIEW_OPTION_FOUR = "will";
    private static final String TEXT_VIEW_OPTION_FIVE = "be waiting";
    private static final String TEXT_VIEW_OPTION_SIX = "will";
    private static final String TEXT_VIEW_OPTION_SEVEN = "be teacher";
    private static final String TEXT_VIEW_OPTION_EIGHT = "will";
    private static final String TEXT_VIEW_OPTION_NINE = "be studying";

    private AppCompatImageView imageInfo;

    private LinearLayout mainLayout;

    private ShowcaseView showcaseView;

    private int mScrollDistance;
    private MyScrollView scrollViewFutureContinuous4;


    public FutureContinuousFragment4() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_future_continuous4, container, false);

        findView();
        implementEvent();
        implementEventTooltips();
        //SCROLLVIEW
        scrollViewFutureContinuous4.setOnScrollViewListener(new MyScrollView.OnScrollViewListener() {
            @Override
            public void onScrollChanged1(MyScrollView.OnScrollViewListener listener) {
                mScrollDistance = scrollViewFutureContinuous4.getScrollY();
            }
        });

        return view;
    }

    private void findView() {
        dropFutureContinuousOne = view.findViewById(R.id.dropFutureContinuousOne);
        disableEditText(dropFutureContinuousOne);
        dropFutureContinuousTwoOne = view.findViewById(R.id.dropFutureContinuousTwoOne);
        disableEditText(dropFutureContinuousTwoOne);
        dropFutureContinuousTwoTwo = view.findViewById(R.id.dropFutureContinuousTwoTwo);
        disableEditText(dropFutureContinuousTwoTwo);
        dropFutureContinuousThreeOne = view.findViewById(R.id.dropFutureContinuousThreeOne);
        disableEditText(dropFutureContinuousThreeOne);
        dropFutureContinuousThreeTwo = view.findViewById(R.id.dropFutureContinuousThreeTwo);
        disableEditText(dropFutureContinuousThreeTwo);
        dropFutureContinuousFourOne = view.findViewById(R.id.dropFutureContinuousFourOne);
        disableEditText(dropFutureContinuousFourOne);
        dropFutureContinuousFourTwo = view.findViewById(R.id.dropFutureContinuousFourTwo);
        disableEditText(dropFutureContinuousFourTwo);
        dropFutureContinuousFiveOne = view.findViewById(R.id.dropFutureContinuousFiveOne);
        disableEditText(dropFutureContinuousFiveOne);
        dropFutureContinuousFiveTwo = view.findViewById(R.id.dropFutureContinuousFiveTwo);
        disableEditText(dropFutureContinuousFiveTwo);

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

        tooltipsDropFutureContinuousOne = view.findViewById(R.id.tooltipsDropFutureContinuousOne);
        tooltipsDropFutureContinuousTwo = view.findViewById(R.id.tooltipsDropFutureContinuousTwo);
        tooltipsDropFutureContinuousThree = view.findViewById(R.id.tooltipsDropFutureContinuousThree);
        tooltipsDropFutureContinuousFour = view.findViewById(R.id.tooltipsDropFutureContinuousFour);
        tooltipsDropFutureContinuousFive = view.findViewById(R.id.tooltipsDropFutureContinuousFive);

        imageInfo = view.findViewById(R.id.imageInfo);

        scrollViewFutureContinuous4 = view.findViewById(R.id.scrollViewFutureContinuous4);

        mainLayout = view.findViewById(R.id.mainLayout);
    }

    private void disableEditText(TextInputEditText inputEditText) {
        inputEditText.setCursorVisible(false);
        inputEditText.setKeyListener(null);
    }

    private void implementEventTooltips() {
        tooltipsDropFutureContinuousOne.setOnClickListener(clickListenerToolTips);
        tooltipsDropFutureContinuousTwo.setOnClickListener(clickListenerToolTips);
        tooltipsDropFutureContinuousThree.setOnClickListener(clickListenerToolTips);
        tooltipsDropFutureContinuousFour.setOnClickListener(clickListenerToolTips);
        tooltipsDropFutureContinuousFive.setOnClickListener(clickListenerToolTips);
        imageInfo.setOnClickListener(clickListenerToolTips);
    }


    private final View.OnClickListener clickListenerToolTips = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (view.getId() == R.id.tooltipsDropFutureContinuousOne) {
                ViewTarget target = new ViewTarget(R.id.dropFutureContinuousOne, getActivity());
                showcaseView = new ShowcaseView.Builder(getActivity())
                        .setTarget(target)
                        .setContentTitle("Tips")
                        .setContentText("Drop jawabanmu di sini")
                        .setStyle(R.style.CustomShowcaseTheme2)
                        .build();
            }
            if (view.getId() == R.id.tooltipsDropFutureContinuousTwo) {
                ViewTarget target = new ViewTarget(R.id.dropFutureContinuousTwoOne, getActivity());
                showcaseView = new ShowcaseView.Builder(getActivity())
                        .setTarget(target)
                        .setContentTitle("Tips")
                        .setContentText("Drop jawabanmu di sini")
                        .setStyle(R.style.CustomShowcaseTheme2)
                        .build();
            }
            if (view.getId() == R.id.tooltipsDropFutureContinuousThree) {
                ViewTarget target = new ViewTarget(R.id.dropFutureContinuousThreeOne, getActivity());
                showcaseView = new ShowcaseView.Builder(getActivity())
                        .setTarget(target)
                        .setContentTitle("Tips")
                        .setContentText("Drop jawabanmu di sini")
                        .setStyle(R.style.CustomShowcaseTheme2)
                        .build();
            }
            if (view.getId() == R.id.tooltipsDropFutureContinuousFour) {
                ViewTarget target = new ViewTarget(R.id.dropFutureContinuousFourOne, getActivity());
                showcaseView = new ShowcaseView.Builder(getActivity())
                        .setTarget(target)
                        .setContentTitle("Tips")
                        .setContentText("Drop jawabanmu di sini")
                        .setStyle(R.style.CustomShowcaseTheme2)
                        .build();
            }
            if (view.getId() == R.id.tooltipsDropFutureContinuousFive) {
                ViewTarget target = new ViewTarget(R.id.dropFutureContinuousFiveOne, getActivity());
                showcaseView = new ShowcaseView.Builder(getActivity())
                        .setTarget(target)
                        .setContentTitle("Tips")
                        .setContentText("Drop jawabanmu di sini")
                        .setStyle(R.style.CustomShowcaseTheme2)
                        .build();
            }
            if (view.getId() == R.id.imageInfo) {
                ViewTarget target = new ViewTarget(R.id.layoutOptionDrag, getActivity());
                showcaseView = new ShowcaseView.Builder(getActivity())
                        .setTarget(target)
                        .setContentTitle("Tips")
                        .setContentText("Drag jawaban ini")
                        .setStyle(R.style.CustomShowcaseTheme2)
                        .build();
            }
        }
    };

    //    Implement long click and drag listener
    private void implementEvent() {
        //add or remove any view that you don't want to be dragged
        optionOne.setOnLongClickListener(this);
        optionTwo.setOnLongClickListener(this);
        optionThree.setOnLongClickListener(this);
        optionFour.setOnLongClickListener(this);
        optionFive.setOnLongClickListener(this);
        optionSix.setOnLongClickListener(this);
        optionSeven.setOnLongClickListener(this);
        optionEight.setOnLongClickListener(this);
        optionNine.setOnLongClickListener(this);

        //add or remove any view that you don't want to accept dragged view
        dropFutureContinuousOne.setOnDragListener(this);
        dropFutureContinuousTwoOne.setOnDragListener(this);
        dropFutureContinuousTwoTwo.setOnDragListener(this);
        dropFutureContinuousThreeOne.setOnDragListener(this);
        dropFutureContinuousThreeTwo.setOnDragListener(this);
        dropFutureContinuousFourOne.setOnDragListener(this);
        dropFutureContinuousFourTwo.setOnDragListener(this);
        dropFutureContinuousFiveOne.setOnDragListener(this);
        dropFutureContinuousFiveTwo.setOnDragListener(this);

        mainLayout.setOnDragListener(this);

    }

    // This is the method that the system calls when it dispatches a drag event to the
    // listener.
    @Override
    public boolean onDrag(View view, DragEvent event) {
        final View dragView = (View) event.getLocalState();
        // Defines a variable to store the action type for the incoming event
        int action = event.getAction();
        // Handles each of the expected events
        switch (action) {
            case DragEvent.ACTION_DRAG_STARTED:
                // Determines if this View can accept the dragged data
                if (event.getClipDescription().hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)) {
                    // if you want to apply color when drag started to your view you can uncomment below lines
                    // to give any color tint to the View to indicate that it can accept
                    // data.

                    //  view.getBackground().setColorFilter(Color.BLUE, PorterDuff.Mode.SRC_IN);//set background color to your view

                    // Invalidate the view to force a redraw in the new tint
                    //  view.invalidate();

                    // returns true to indicate that the View can accept the dragged data.
                    return true;

                }

                // Returns false. During the current drag and drop operation, this View will
                // not receive events again until ACTION_DRAG_ENDED is sent.
                return false;

            case DragEvent.ACTION_DRAG_ENTERED:
                // Applies a YELLOW or any color tint to the View, when the dragged view entered into drag acceptable view
                // Return true; the return value is ignored.
                if (view.getId() == R.id.mainLayout) {
                    return false;
                } else {

                    view.getBackground().setColorFilter(BlendModeColorFilterCompat.createBlendModeColorFilterCompat(Color.RED, BlendModeCompat.SRC_ATOP));

                    // Invalidate the view to force a redraw in the new tint
                    view.invalidate();

                    return true;
                }
            case DragEvent.ACTION_DRAG_LOCATION:
                // Enable ScrollView while dragging
                int y = Math.round(view.getY())+Math.round(event.getY());
                int translatedY = y - mScrollDistance;
                Log.i("translated",""+translatedY+" "+ mScrollDistance+" "+y);
                int threshold =50 ;
                // make a scrolling up due the y has passed the threshold
                if (translatedY < 200) {
                    // make a scroll up by 30 px
                    scrollViewFutureContinuous4.smoothScrollBy(0, -5);
                }
                // make a autoscrolling down due y has passed the 500 px border
                if (translatedY + threshold > 500) {
                    // make a scroll down by 30 px
                    scrollViewFutureContinuous4.smoothScrollBy(0, 5);
                }

                break;

            case DragEvent.ACTION_DRAG_EXITED:
                // Re-sets the color tint to blue, if you had set the BLUE color or any color in ACTION_DRAG_STARTED. Returns true; the return value is ignored.

                //  view.getBackground().setColorFilter(Color.BLUE, PorterDuff.Mode.SRC_IN);

                //If u had not provided any color in ACTION_DRAG_STARTED then clear color filter.
                if (view.getId() == R.id.mainLayout) {
                    return false;
                } else {
                    view.getBackground().clearColorFilter();
                    // Invalidate the view to force a redraw in the new tint
                    view.invalidate();

                    return true;
                }
            case DragEvent.ACTION_DROP:

                if (view.getId() == R.id.mainLayout) {
                    return false;
                } else {
                    // Gets the item containing the dragged data
                    ClipData.Item item = event.getClipData().getItemAt(0);

                    // Gets the text data from the item.
                    String dragData = item.getText().toString();

                    // Displays a message containing the dragged data.
                    Toast.makeText(getActivity(), "Anda memilih " + dragData, Toast.LENGTH_SHORT).show();

                    // Turns off any color tints
                    view.getBackground().clearColorFilter();

                    // Invalidates the view to force a redraw
                    view.invalidate();

                    View v = (View) event.getLocalState();
                    ViewGroup owner = (ViewGroup) v.getParent();
                    owner.removeView(v);//remove the dragged view
                    TextInputEditText container = (TextInputEditText) view;//caste the view into LinearLayout as our drag acceptable layout is LinearLayout
                    container.setFocusableInTouchMode(true);
                    container.setText(dragData);
//                container.addView(v);//Add the dragged view
                    v.setVisibility(View.VISIBLE);//finally set Visibility to VISIBLE

                    // Returns true. DragEvent.getResult() will return true.
                    return true;
                }
            case DragEvent.ACTION_DRAG_ENDED:
                // Turns off any color tinting
                view.getBackground().clearColorFilter();

                // Invalidates the view to force a redraw
                view.invalidate();


                // View back to the first place, when drag doesn't correct target.
                view.post(new Runnable() {
                    @Override
                    public void run() {
                        dragView.setVisibility(View.VISIBLE);
                    }
                });


                // returns true; the value is ignored.
                return true;

            // An unknown action type was received.
            default:
                Log.e("DragDrop Example", "Unknown action type received by OnDragListener.");
                break;
        }
        return false;

    }

    @Override
    public boolean onLongClick(View view) {
        // Create a new ClipData.
        // This is done in two steps to provide clarity. The convenience method
        // ClipData.newPlainText() can create a plain text ClipData in one step.

        // Create a new ClipData.Item from the ImageView object's tag
        ClipData.Item item = new ClipData.Item((CharSequence) view.getTag());

        // Create a new ClipData using the tag as a label, the plain text MIME type, and
        // the already-created item. This will create a new ClipDescription object within the
        // ClipData, and set its MIME type entry to "text/plain"
        String [] mimeTypes = {ClipDescription.MIMETYPE_TEXT_PLAIN};

        ClipData data = new ClipData(view.getTag().toString(), mimeTypes, item);

        // Instantiates the drag shadow builder.
        View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);

        // Starts the drag
        view.startDrag(data//data to be dragged
                , shadowBuilder //drag shadow
                , view//local data about the drag and drop operation
                , 0//no needed flags
        );

        //Set view visibility to INVISIBLE as we are going to drag the view
        view.setVisibility(View.INVISIBLE);
        return true;
    }
}