package id.indrasudirman.belajarbahasainggris.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import id.indrasudirman.belajarbahasainggris.presentcontinuous.PresentContinuousFragment1;
import id.indrasudirman.belajarbahasainggris.presentcontinuous.PresentContinuousFragment2;
import id.indrasudirman.belajarbahasainggris.presentcontinuous.PresentContinuousFragment3;
import id.indrasudirman.belajarbahasainggris.presentcontinuous.PresentContinuousFragment4;
import id.indrasudirman.belajarbahasainggris.presentcontinuous.PresentContinuousFragment5;
import id.indrasudirman.belajarbahasainggris.presentcontinuous.PresentContinuousFragment6;

public class PresentContinuousAdapter extends FragmentStateAdapter {

    public PresentContinuousAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 1:
                return new PresentContinuousFragment2();
            case 2:
                return new PresentContinuousFragment3();
            case 3:
                return new PresentContinuousFragment4();
            case 4:
                return new PresentContinuousFragment5();
            case 5:
                return new PresentContinuousFragment6();
            default:
                return new PresentContinuousFragment1();
        }
    }

    @Override
    public int getItemCount() {
        return 6;
    }
}
