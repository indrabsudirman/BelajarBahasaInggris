package id.indrasudirman.belajarbahasainggris.simplepast;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.github.amlcurran.showcaseview.ShowcaseView;
import com.github.amlcurran.showcaseview.targets.ViewTarget;

import id.indrasudirman.belajarbahasainggris.R;


public class SimplePastFragment2 extends Fragment {
    private View view;
    private ShowcaseView showcaseView;
    private Button buttonTips1;
    private Button buttonTips2;
    private Button buttonTips3;




    public SimplePastFragment2() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_simple_past2, container, false);

        buttonTips1 = view.findViewById(R.id.tooltip_simple_past_test1);
        buttonTips2 = view.findViewById(R.id.tooltip_simple_past_test2);
        buttonTips3 = view.findViewById(R.id.tooltip_simple_past_test3);

        buttonTips1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ViewTarget target = new ViewTarget(R.id.answer_simple_past_test1, getActivity());
                showcaseView = new ShowcaseView.Builder(getActivity())
                        .setTarget(target)
                        .setContentTitle("Tips")
                        .setContentText("Isi dengan bentuk Irregular verbs")
                        .setStyle(R.style.CustomShowcaseTheme2)
                        .build();

            }
        });

        buttonTips2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ViewTarget target = new ViewTarget(R.id.answer_simple_past_test2, getActivity());
                showcaseView = new ShowcaseView.Builder(getActivity())
                        .setTarget(target)
                        .setContentTitle("Tips")
                        .setContentText("Isi dengan bentuk Regular verbs")
                        .setStyle(R.style.CustomShowcaseTheme2)
                        .build();

            }
        });

        buttonTips3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ViewTarget target = new ViewTarget(R.id.answer_simple_past_test3, getActivity());
                showcaseView = new ShowcaseView.Builder(getActivity())
                        .setTarget(target)
                        .setContentTitle("Tips")
                        .setContentText("Isi dengan bentuk Regular verbs")
                        .setStyle(R.style.CustomShowcaseTheme2)
                        .build();

            }
        });

        return view;
    }

}