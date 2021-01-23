package id.indrasudirman.belajarbahasainggris.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import id.indrasudirman.belajarbahasainggris.pastcontinuous.PastContinuousFragment1;
import id.indrasudirman.belajarbahasainggris.pastcontinuous.PastContinuousFragment2;
import id.indrasudirman.belajarbahasainggris.pastcontinuous.PastContinuousFragment3;
import id.indrasudirman.belajarbahasainggris.pastcontinuous.PastContinuousFragment4;
import id.indrasudirman.belajarbahasainggris.pastcontinuous.PastContinuousFragment5;

public class PastContinuousAdapter extends FragmentStateAdapter {

    public PastContinuousAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 1:
                return new PastContinuousFragment2();
            case 2:
                return new PastContinuousFragment3();
            case 3:
                return new PastContinuousFragment4();
            case 4:
                return new PastContinuousFragment5();
            default:
                return new PastContinuousFragment1();
        }
    }

    @Override
    public int getItemCount() {
        return 5;
    }
}
