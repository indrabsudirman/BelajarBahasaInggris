package id.indrasudirman.belajarbahasainggris.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import id.indrasudirman.belajarbahasainggris.presentcontinuous.PresentContinuousFragment1;
import id.indrasudirman.belajarbahasainggris.presentcontinuous.PresentContinuousFragment2;
import id.indrasudirman.belajarbahasainggris.presentcontinuous.PresentContinuousFragment3;

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
            default:
                return new PresentContinuousFragment1();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
