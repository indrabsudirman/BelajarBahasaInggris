package id.indrasudirman.belajarbahasainggris.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;


import id.indrasudirman.belajarbahasainggris.simplepresent.SimplePresentFragment1;
import id.indrasudirman.belajarbahasainggris.simplepresent.SimplePresentFragment2;
import id.indrasudirman.belajarbahasainggris.simplepresent.SimplePresentFragment3;
import id.indrasudirman.belajarbahasainggris.simplepresent.SimplePresentFragment4;
import id.indrasudirman.belajarbahasainggris.simplepresent.SimplePresentFragment5;
import id.indrasudirman.belajarbahasainggris.simplepresent.SimplePresentFragment6;

public class SimplePresentAdapter extends FragmentStateAdapter {

    public SimplePresentAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 1:
                return new SimplePresentFragment2();
            case 2:
                return new SimplePresentFragment3();
            case 3:
                return new SimplePresentFragment4();
            case 4:
                return new SimplePresentFragment5();
            case 5:
                return new SimplePresentFragment6();
            default:
                return new SimplePresentFragment1();
        }

    }

    @Override
    public int getItemCount() {
        return 6;
    }
}