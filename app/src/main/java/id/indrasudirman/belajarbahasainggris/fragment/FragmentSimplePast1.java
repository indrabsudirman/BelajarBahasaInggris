package id.indrasudirman.belajarbahasainggris.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;

import id.indrasudirman.belajarbahasainggris.R;


public class FragmentSimplePast1 extends Fragment {

    private View view;

    public FragmentSimplePast1() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_simple_past1, container, false);


        return view;
    }
}