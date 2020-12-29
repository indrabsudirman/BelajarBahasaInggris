package id.indrasudirman.belajarbahasainggris.simplepastfuture;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import id.indrasudirman.belajarbahasainggris.R;


public class SimplePastFutureFragment2 extends Fragment {

    private View view;


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