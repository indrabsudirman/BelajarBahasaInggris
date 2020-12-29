package id.indrasudirman.belajarbahasainggris.presentcontinuous;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import id.indrasudirman.belajarbahasainggris.R;

public class PresentContinuousFragment1 extends Fragment {

    private View view;


    public PresentContinuousFragment1() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_present_continuous1, container, false);

        return view;
    }
}