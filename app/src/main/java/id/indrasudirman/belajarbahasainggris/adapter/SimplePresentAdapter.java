package id.indrasudirman.belajarbahasainggris.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;


import id.indrasudirman.belajarbahasainggris.simplepresent.SimplePresentFragment1;
import id.indrasudirman.belajarbahasainggris.simplepresent.SimplePresentFragment2;
import id.indrasudirman.belajarbahasainggris.simplepresent.SimplePresentFragment3;

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
            default:
                return new SimplePresentFragment1();
        }

    }

    @Override
    public int getItemCount() {
        return 3;
    }
}