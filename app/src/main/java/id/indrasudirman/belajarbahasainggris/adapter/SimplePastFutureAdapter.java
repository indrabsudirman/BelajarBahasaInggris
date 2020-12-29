package id.indrasudirman.belajarbahasainggris.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;


import id.indrasudirman.belajarbahasainggris.simplepastfuture.SimplePastFutureFragment1;
import id.indrasudirman.belajarbahasainggris.simplepastfuture.SimplePastFutureFragment2;
import id.indrasudirman.belajarbahasainggris.simplepastfuture.SimplePastFutureFragment3;

public class SimplePastFutureAdapter extends FragmentStateAdapter {

    public SimplePastFutureAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 1:
                return new SimplePastFutureFragment2();
            case 2:
                return new SimplePastFutureFragment3();
            default:
                return new SimplePastFutureFragment1();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
