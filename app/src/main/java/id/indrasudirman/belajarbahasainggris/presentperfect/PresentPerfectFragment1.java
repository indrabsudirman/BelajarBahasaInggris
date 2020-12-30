package id.indrasudirman.belajarbahasainggris.presentperfect;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import id.indrasudirman.belajarbahasainggris.R;


public class PresentPerfectFragment1 extends Fragment {

    private View view;


    public PresentPerfectFragment1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_present_perfect1, container, false);


        return view;
    }
}