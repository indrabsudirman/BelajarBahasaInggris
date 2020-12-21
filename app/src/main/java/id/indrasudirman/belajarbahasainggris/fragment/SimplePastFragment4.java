package id.indrasudirman.belajarbahasainggris.fragment;

import android.content.ClipData;
import android.content.ClipDescription;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import id.indrasudirman.belajarbahasainggris.R;


public class SimplePastFragment4 extends Fragment implements View.OnDragListener, View.OnLongClickListener {

    private View view;

    private TextInputEditText answerSimplePastDrop1;
    private TextInputEditText answerSimplePastDrop2;
    private TextInputEditText answerSimplePastDrop3;
    private AppCompatTextView optionOne;
    private AppCompatTextView optionTwo;
    private AppCompatTextView optionThree;
    private static final String SIMPLE_PAST_DROP_ONE = "Simple Past Drop One";
    private static final String SIMPLE_PAST_DROP_TWO = "Simple Past Drop Two";
    private static final String SIMPLE_PAST_DROP_THREE = "Simple Past Drop Three";
    private static final String TEXT_VIEW_OPTION_ONE = "Were";
    private static final String TEXT_VIEW_OPTION_TWO = "Was";
    private static final String TEXT_VIEW_OPTION_THREE = "Did not";


    public SimplePastFragment4() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_simple_past4, container, false);

        findView();
        implementEvent();






        return view;
    }

    //Find all views and set Tag to all draggable views
    private void findView() {
        answerSimplePastDrop1 = view.findViewById(R.id.dropSimplePastOne);
        answerSimplePastDrop1.setTag(SIMPLE_PAST_DROP_ONE);
        disableEditText(answerSimplePastDrop1);
        answerSimplePastDrop2 = view.findViewById(R.id.dropSimplePastTwo);
        answerSimplePastDrop2.setTag(SIMPLE_PAST_DROP_TWO);
        disableEditText(answerSimplePastDrop2);
        answerSimplePastDrop3 = view.findViewById(R.id.dropSimplePastThree);
        answerSimplePastDrop3.setTag(SIMPLE_PAST_DROP_THREE);
        disableEditText(answerSimplePastDrop3);

        optionOne = view.findViewById(R.id.optionOne);
        optionOne.setTag(TEXT_VIEW_OPTION_ONE);
        optionTwo = view.findViewById(R.id.optionTwo);
        optionTwo.setTag(TEXT_VIEW_OPTION_TWO);
        optionThree = view.findViewById(R.id.optionThree);
        optionThree.setTag(TEXT_VIEW_OPTION_THREE);
    }

    //Implement long click and drag listener
    private void implementEvent() {
        //add or remove any view that you don't want to be dragged
        optionOne.setOnLongClickListener(this);
        optionTwo.setOnLongClickListener(this);
        optionThree.setOnLongClickListener(this);

        //add or remove any view that you don't want to accept dragged view
        answerSimplePastDrop1.setOnDragListener(this);
        answerSimplePastDrop2.setOnDragListener(this);
        answerSimplePastDrop3.setOnDragListener(this);

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

                view.getBackground().setColorFilter(Color.YELLOW, PorterDuff.Mode.SRC_IN);

                // Invalidate the view to force a redraw in the new tint
                view.invalidate();

                return true;
            case DragEvent.ACTION_DRAG_LOCATION:
                // Ignore the event
                return true;
            case DragEvent.ACTION_DRAG_EXITED:
                // Re-sets the color tint to blue, if you had set the BLUE color or any color in ACTION_DRAG_STARTED. Returns true; the return value is ignored.

                //  view.getBackground().setColorFilter(Color.BLUE, PorterDuff.Mode.SRC_IN);

                //If u had not provided any color in ACTION_DRAG_STARTED then clear color filter.
                view.getBackground().clearColorFilter();
                // Invalidate the view to force a redraw in the new tint
                view.invalidate();

                return true;
            case DragEvent.ACTION_DROP:
                // Gets the item containing the dragged data
                ClipData.Item item = event.getClipData().getItemAt(0);

                // Gets the text data from the item.
                String dragData = item.getText().toString();

                // Displays a message containing the dragged data.
                Toast.makeText(getActivity(), "Dragged data is " + dragData, Toast.LENGTH_SHORT).show();

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
            case DragEvent.ACTION_DRAG_ENDED:
                // Turns off any color tinting
                view.getBackground().clearColorFilter();

                // Invalidates the view to force a redraw
                view.invalidate();


                // Does a getResult(), and displays what happened.
                if (event.getResult())
                    Toast.makeText(getActivity(), "The drop was handled.", Toast.LENGTH_SHORT).show();

                else {
//                    Toast.makeText(getActivity(), "The drop didn't work.", Toast.LENGTH_SHORT).show();
                    view.post(new Runnable() {
                        @Override
                        public void run() {
                            dragView.setVisibility(View.VISIBLE);
                        }
                    });
                    break;
                }


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

    private void disableEditText(EditText editText) {
//        editText.setFocusable(false);
//        editText
        editText.setCursorVisible(false);
        editText.setKeyListener(null);
//        editText.setBackgroundColor(Color.TRANSPARENT);
     }

}