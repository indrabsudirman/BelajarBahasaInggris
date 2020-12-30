package id.indrasudirman.belajarbahasainggris.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import id.indrasudirman.belajarbahasainggris.pastfuturecontinuous.PastFutureContinuousFragment1;
import id.indrasudirman.belajarbahasainggris.pastfuturecontinuous.PastFutureContinuousFragment2;
import id.indrasudirman.belajarbahasainggris.pastfuturecontinuous.PastFutureContinuousFragment3;

public class PastFutureContinuousAdapter extends FragmentStateAdapter {

    public PastFutureContinuousAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 1:
                return new PastFutureContinuousFragment2();
            case 2:
                return new PastFutureContinuousFragment3();
            default:
                return new PastFutureContinuousFragment1();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
