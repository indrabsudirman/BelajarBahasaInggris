package id.indrasudirman.belajarbahasainggris.futureperfect;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import id.indrasudirman.belajarbahasainggris.R;


public class FuturePerfectFragment3 extends Fragment {

    private View view;


    public FuturePerfectFragment3() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_future_perfect3, container, false);

        return view;
    }
}