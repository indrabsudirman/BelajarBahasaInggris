package id.indrasudirman.belajarbahasainggris.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import id.indrasudirman.belajarbahasainggris.simplefuture.SimpleFutureFragment1;
import id.indrasudirman.belajarbahasainggris.simplefuture.SimpleFutureFragment2;
import id.indrasudirman.belajarbahasainggris.simplefuture.SimpleFutureFragment3;
import id.indrasudirman.belajarbahasainggris.simplefuture.SimpleFutureFragment4;
import id.indrasudirman.belajarbahasainggris.simplefuture.SimpleFutureFragment5;
import id.indrasudirman.belajarbahasainggris.simplefuture.SimpleFutureFragment6;

public class SimpleFutureAdapter extends FragmentStateAdapter {

    public SimpleFutureAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 1:
                return new SimpleFutureFragment2();
            case 2:
                return new SimpleFutureFragment3();
            case 3:
                return new SimpleFutureFragment4();
            case 4:
                return new SimpleFutureFragment5();
            case 5:
                return new SimpleFutureFragment6();
            default:
                return new SimpleFutureFragment1();
        }

    }

    @Override
    public int getItemCount() {
        return 6;
    }
}