package id.indrasudirman.belajarbahasainggris.simplefuture;

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


public class SimpleFutureFragment4 extends Fragment implements View.OnDragListener, View.OnLongClickListener {

    private View view;
    private TextInputEditText dropSimpleFutureOne;
    private TextInputEditText dropSimpleFutureTwoOne;
    private TextInputEditText dropSimpleFutureTwoTwo;
    private TextInputEditText dropSimpleFutureThree;
    private TextInputEditText dropSimpleFutureFourOne;
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
    private AppCompatButton tooltipsDropSimpleFutureOne;
    private AppCompatButton tooltipsDropSimpleFutureTwo;
    private AppCompatButton tooltipsDropSimpleFutureThree;
    private AppCompatButton tooltipsDropSimpleFutureFour;
    private AppCompatButton tooltipsDropSimpleFutureFive;
    private static final String TEXT_VIEW_OPTION_TWO = "will not/won't";
    private static final String TEXT_VIEW_OPTION_ONE = "are";
    private static final String TEXT_VIEW_OPTION_THREE = "will not/won'";
    private static final String TEXT_VIEW_OPTION_FOUR = "going to";
    private static final String TEXT_VIEW_OPTION_FIVE = "will";
    private static final String TEXT_VIEW_OPTION_SIX = "am going";
    private static final String TEXT_VIEW_OPTION_SEVEN = "tonight";
    private static final String TEXT_VIEW_OPTION_EIGHT = "will study";

    private AppCompatImageView imageInfo;

    private LinearLayout mainLayout;

    private ShowcaseView showcaseView;

    private int mScrollDistance;
    private MyScrollView scrollViewSimpleFuture4;


    public SimpleFutureFragment4() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_simple_future4, container, false);

        findView();
        implementEvent();
        implementEventTooltips();


        //SCROLLVIEW
        scrollViewSimpleFuture4.setOnScrollViewListener(new MyScrollView.OnScrollViewListener() {
            @Override
            public void onScrollChanged1(MyScrollView.OnScrollViewListener listener) {
                mScrollDistance = scrollViewSimpleFuture4.getScrollY();
            }
        });

        return view;
    }

    private void findView() {
        dropSimpleFutureOne = view.findViewById(R.id.dropSimpleFutureOne);
        disableEditText(dropSimpleFutureOne);
        dropSimpleFutureTwoOne = view.findViewById(R.id.dropSimpleFutureTwoOne);
        disableEditText(dropSimpleFutureTwoOne);
        dropSimpleFutureTwoTwo = view.findViewById(R.id.dropSimpleFutureTwoTwo);
        disableEditText(dropSimpleFutureTwoTwo);
        dropSimpleFutureThree = view.findViewById(R.id.dropSimpleFutureThree);
        disableEditText(dropSimpleFutureThree);
        dropSimpleFutureFourOne = view.findViewById(R.id.dropSimpleFutureFourOne);
        disableEditText(dropSimpleFutureFourOne);
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

        tooltipsDropSimpleFutureOne = view.findViewById(R.id.tooltipsDropSimpleFutureOne);
        tooltipsDropSimpleFutureTwo = view.findViewById(R.id.tooltipsDropSimpleFutureTwo);
        tooltipsDropSimpleFutureThree = view.findViewById(R.id.tooltipsDropSimpleFutureThree);
        tooltipsDropSimpleFutureFour = view.findViewById(R.id.tooltipsDropSimpleFutureFour);
        tooltipsDropSimpleFutureFive = view.findViewById(R.id.tooltipsDropSimpleFutureFive);

        imageInfo = view.findViewById(R.id.imageInfo);

        scrollViewSimpleFuture4 = view.findViewById(R.id.scrollViewSimpleFuture4);

        mainLayout = view.findViewById(R.id.mainLayout);
    }

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

        //add or remove any view that you don't want to accept dragged view
        dropSimpleFutureOne.setOnDragListener(this);
        dropSimpleFutureTwoOne.setOnDragListener(this);
        dropSimpleFutureTwoTwo.setOnDragListener(this);
        dropSimpleFutureThree.setOnDragListener(this);
        dropSimpleFutureFourOne.setOnDragListener(this);
        dropSimpleFutureFourTwo.setOnDragListener(this);
        dropSimpleFutureFive.setOnDragListener(this);

        mainLayout.setOnDragListener(this);


    }


    private void implementEventTooltips() {
        tooltipsDropSimpleFutureOne.setOnClickListener(clickListenerToolTips);
        tooltipsDropSimpleFutureTwo.setOnClickListener(clickListenerToolTips);
        tooltipsDropSimpleFutureThree.setOnClickListener(clickListenerToolTips);
        tooltipsDropSimpleFutureFour.setOnClickListener(clickListenerToolTips);
        tooltipsDropSimpleFutureFive.setOnClickListener(clickListenerToolTips);
        imageInfo.setOnClickListener(clickListenerToolTips);
    }


    private final View.OnClickListener clickListenerToolTips = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (view.getId() == R.id.tooltipsDropSimpleFutureOne) {
                ViewTarget target = new ViewTarget(R.id.dropSimpleFutureOne, getActivity());
                showcaseView = new ShowcaseView.Builder(getActivity())
                        .setTarget(target)
                        .setContentTitle("Tips")
                        .setContentText("Drop jawabanmu di sini")
                        .setStyle(R.style.CustomShowcaseTheme2)
                        .build();
            }
            if (view.getId() == R.id.tooltipsDropSimpleFutureTwo) {
                ViewTarget target = new ViewTarget(R.id.dropSimpleFutureTwoOne, getActivity());
                showcaseView = new ShowcaseView.Builder(getActivity())
                        .setTarget(target)
                        .setContentTitle("Tips")
                        .setContentText("Drop jawabanmu di sini")
                        .setStyle(R.style.CustomShowcaseTheme2)
                        .build();
            }
            if (view.getId() == R.id.tooltipsDropSimpleFutureThree) {
                ViewTarget target = new ViewTarget(R.id.dropSimpleFutureThree, getActivity());
                showcaseView = new ShowcaseView.Builder(getActivity())
                        .setTarget(target)
                        .setContentTitle("Tips")
                        .setContentText("Drop jawabanmu di sini")
                        .setStyle(R.style.CustomShowcaseTheme2)
                        .build();
            }
            if (view.getId() == R.id.tooltipsDropSimpleFutureFour) {
                ViewTarget target = new ViewTarget(R.id.dropSimpleFutureFourOne, getActivity());
                showcaseView = new ShowcaseView.Builder(getActivity())
                        .setTarget(target)
                        .setContentTitle("Tips")
                        .setContentText("Drop jawabanmu di sini")
                        .setStyle(R.style.CustomShowcaseTheme2)
                        .build();
            }
            if (view.getId() == R.id.tooltipsDropSimpleFutureFive) {
                ViewTarget target = new ViewTarget(R.id.dropSimpleFutureFive, getActivity());
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

    private void disableEditText(TextInputEditText inputEditText) {
        inputEditText.setCursorVisible(false);
        inputEditText.setKeyListener(null);
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
                    scrollViewSimpleFuture4.smoothScrollBy(0, -5);
                }
                // make a autoscrolling down due y has passed the 500 px border
                if (translatedY + threshold > 500) {
                    // make a scroll down by 30 px
                    scrollViewSimpleFuture4.smoothScrollBy(0, 5);
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