package id.indrasudirman.belajarbahasainggris.simplepastfuture;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.github.chrisbanes.photoview.PhotoView;

import id.indrasudirman.belajarbahasainggris.R;


public class SimplePastFutureFragment1 extends Fragment {

    private View view;
    private PhotoView simplePastFutureImage;


    public SimplePastFutureFragment1() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_simple_past_future1, container, false);
        simplePastFutureImage = view.findViewById(R.id.simplePastFutureImage);
        simplePastFutureImage.setImageResource(R.drawable.simple_past_future_tense_master);

        simplePastFutureImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Anda memilih " + simplePastFutureImage, Toast.LENGTH_SHORT).show();
//                Intent fullScreenIntent = new Intent(getActivity(), FullScreenImage.class);
////                fullScreenIntent.set(simplePastFutureImage);
//                startActivity(fullScreenIntent);
//                Intent intent
            }
        });




        return view;
    }
}