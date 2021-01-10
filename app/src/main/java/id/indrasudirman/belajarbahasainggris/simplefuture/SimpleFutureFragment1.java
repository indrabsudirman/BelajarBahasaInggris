package id.indrasudirman.belajarbahasainggris.simplefuture;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.uncopt.android.widget.text.justify.JustifiedTextView;

import id.indrasudirman.belajarbahasainggris.R;


public class SimpleFutureFragment1 extends Fragment {

    private View view;
    private JustifiedTextView simpleFutureExplain;
    private JustifiedTextView simpleFutureExample1;
    private JustifiedTextView simpleFutureExample2;


    public SimpleFutureFragment1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_simple_future1, container, false);

        initView();
        mSpannableString();

        return view;
    }

    private void initView() {

        simpleFutureExplain = view.findViewById(R.id.simpleFutureExplain);
        simpleFutureExample1 = view.findViewById(R.id.simpleFutureExample1);
        simpleFutureExample2 = view.findViewById(R.id.simpleFutureExample2);
    }

    private void mSpannableString() {
        SpannableString[] spannableString = new SpannableString[]{
                new SpannableString((getActivity().getResources().getString(R.string.simple_future_explain))),
                new SpannableString((getActivity().getResources().getString(R.string.second_bullet_simple_future))),
                new SpannableString((getActivity().getResources().getString(R.string.third_bullet_simple_future)))};
    }
}