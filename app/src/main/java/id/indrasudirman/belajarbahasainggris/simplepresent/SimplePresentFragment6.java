package id.indrasudirman.belajarbahasainggris.simplepresent;

import android.content.ClipData;
import android.content.ClipDescription;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.github.amlcurran.showcaseview.ShowcaseView;
import com.github.amlcurran.showcaseview.targets.ViewTarget;
import com.google.android.material.textfield.TextInputEditText;

import id.indrasudirman.belajarbahasainggris.R;
import id.indrasudirman.belajarbahasainggris.utils.MyScrollView;


public class SimplePresentFragment6 extends Fragment implements View.OnDragListener, View.OnLongClickListener {

    private View view;
    private TextInputEditText dropSimplePresentOne;
    private TextInputEditText dropSimplePresentTwo;
    private TextInputEditText dropSimplePresentThree;
    private TextInputEditText dropSimplePresentFour;
    private TextInputEditText dropSimplePresentFive;
    private TextInputEditText dropSimplePresentSix;
    private TextInputEditText dropSimplePresentSeven;
    private AppCompatTextView optionTwo;
    private AppCompatTextView optionOne;
    private AppCompatTextView optionThree;
    private AppCompatTextView optionFour;
    private AppCompatTextView optionFive;
    private AppCompatTextView optionSix;
    private AppCompatTextView optionSeven;
    private AppCompatTextView optionEight;

    private static final String TEXT_VIEW_OPTION_ONE = "never forgets";
    private static final String TEXT_VIEW_OPTION_TWO = "is";
    private static final String TEXT_VIEW_OPTION_THREE = "does";
    private static final String TEXT_VIEW_OPTION_FOUR = "rarely exercises";
    private static final String TEXT_VIEW_OPTION_FIVE = "twice a year";
    private static final String TEXT_VIEW_OPTION_SIX = "every time";
    private static final String TEXT_VIEW_OPTION_SEVEN = "always reads";
    private static final String TEXT_VIEW_OPTION_EIGHT = "every day";

    private AppCompatButton tooltipsDropSimplePresentOne;
    private AppCompatButton tooltipsDropSimplePresentTwo;
    private AppCompatButton tooltipsDropSimplePresentThree;
    private AppCompatButton tooltipsDropSimplePresentFour;
    private AppCompatButton tooltipsDropSimplePresentFive;

    private AppCompatImageView imageInfo;

    private LinearLayout mainLayout;

    private ShowcaseView showcaseView;

    private int mScrollDistance;
    private MyScrollView scrollViewSimplePresent6;

    public SimplePresentFragment6() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_simple_present6, container, false);

        findView();
        implementEvent();
        implementEventTooltips();

        scrollViewSimplePresent6.setOnScrollViewListener(new MyScrollView.OnScrollViewListener() {
            @Override
            public void onScrollChanged1(MyScrollView.OnScrollViewListener listener) {
                mScrollDistance = scrollViewSimplePresent6.getScrollY();
            }
        });

        return view;
    }

    private void findView() {
        dropSimplePresentOne = view.findViewById(R.id.dropSimplePresentOne);
        disableEditText(dropSimplePresentOne);
        dropSimplePresentTwo = view.findViewById(R.id.dropSimplePresentTwo);
        disableEditText(dropSimplePresentTwo);
        dropSimplePresentThree = view.findViewById(R.id.dropSimplePresentThree);
        disableEditText(dropSimplePresentThree);
        dropSimplePresentFour = view.findViewById(R.id.dropSimplePresentFour);
        disableEditText(dropSimplePresentFour);
        dropSimplePresentFive = view.findViewById(R.id.dropSimplePresentFive);
        disableEditText(dropSimplePresentFive);
        dropSimplePresentSix = view.findViewById(R.id.dropSimplePresentSix);
        disableEditText(dropSimplePresentSix);
        dropSimplePresentSeven = view.findViewById(R.id.dropSimplePresentSeven);
        disableEditText(dropSimplePresentSeven);

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

        tooltipsDropSimplePresentOne = view.findViewById(R.id.tooltipsDropSimplePresentOne);
        tooltipsDropSimplePresentTwo = view.findViewById(R.id.tooltipsDropSimplePresentTwo);
        tooltipsDropSimplePresentThree = view.findViewById(R.id.tooltipsDropSimplePresentThree);
        tooltipsDropSimplePresentFour = view.findViewById(R.id.tooltipsDropSimplePresentFour);
        tooltipsDropSimplePresentFive = view.findViewById(R.id.tooltipsDropSimplePresentFive);

        imageInfo = view.findViewById(R.id.imageInfo);

        scrollViewSimplePresent6 = view.findViewById(R.id.scrollViewSimplePresent6);

        mainLayout = view.findViewById(R.id.mainLayout);
    }

    private void disableEditText(TextInputEditText inputEditText) {
        inputEditText.setCursorVisible(false);
        inputEditText.setKeyListener(null);
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
        dropSimplePresentOne.setOnDragListener(this);
        dropSimplePresentTwo.setOnDragListener(this);
        dropSimplePresentThree.setOnDragListener(this);
        dropSimplePresentFour.setOnDragListener(this);
        dropSimplePresentFive.setOnDragListener(this);
        dropSimplePresentSix.setOnDragListener(this);
        dropSimplePresentSeven.setOnDragListener(this);

        mainLayout.setOnDragListener(this);
    }

    private void implementEventTooltips() {
        tooltipsDropSimplePresentOne.setOnClickListener(clickListenerToolTips);
        tooltipsDropSimplePresentTwo.setOnClickListener(clickListenerToolTips);
        tooltipsDropSimplePresentThree.setOnClickListener(clickListenerToolTips);
        tooltipsDropSimplePresentFour.setOnClickListener(clickListenerToolTips);
        tooltipsDropSimplePresentFive.setOnClickListener(clickListenerToolTips);
        imageInfo.setOnClickListener(clickListenerToolTips);
    }

    private final View.OnClickListener clickListenerToolTips = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (view.getId() == R.id.tooltipsDropSimplePresentOne) {
                ViewTarget target = new ViewTarget(R.id.dropSimplePresentOne, getActivity());
                showcaseView = new ShowcaseView.Builder(getActivity())
                        .setTarget(target)
                        .setContentTitle("Tips")
                        .setContentText("Drop jawabanmu di sini")
                        .setStyle(R.style.CustomShowcaseTheme2)
                        .build();
            }
            if (view.getId() == R.id.tooltipsDropSimplePresentTwo) {
                ViewTarget target = new ViewTarget(R.id.dropSimplePresentThree, getActivity());
                showcaseView = new ShowcaseView.Builder(getActivity())
                        .setTarget(target)
                        .setContentTitle("Tips")
                        .setContentText("Drop jawabanmu di sini")
                        .setStyle(R.style.CustomShowcaseTheme2)
                        .build();
            }
            if (view.getId() == R.id.tooltipsDropSimplePresentThree) {
                ViewTarget target = new ViewTarget(R.id.dropSimplePresentFour, getActivity());
                showcaseView = new ShowcaseView.Builder(getActivity())
                        .setTarget(target)
                        .setContentTitle("Tips")
                        .setContentText("Drop jawabanmu di sini")
                        .setStyle(R.style.CustomShowcaseTheme2)
                        .build();
            }
            if (view.getId() == R.id.tooltipsDropSimplePresentFour) {
                ViewTarget target = new ViewTarget(R.id.dropSimplePresentFive, getActivity());
                showcaseView = new ShowcaseView.Builder(getActivity())
                        .setTarget(target)
                        .setContentTitle("Tips")
                        .setContentText("Drop jawabanmu di sini")
                        .setStyle(R.style.CustomShowcaseTheme2)
                        .build();
            }
            if (view.getId() == R.id.tooltipsDropSimplePresentFive) {
                ViewTarget target = new ViewTarget(R.id.dropSimplePresentSeven, getActivity());
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

                    view.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.SRC_IN);

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
                    scrollViewSimplePresent6.smoothScrollBy(0, -5);
                }
                // make a autoscrolling down due y has passed the 500 px border
                if (translatedY + threshold > 500) {
                    // make a scroll down by 30 px
                    scrollViewSimplePresent6.smoothScrollBy(0, 5);
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