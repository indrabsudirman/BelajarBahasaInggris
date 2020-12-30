package id.indrasudirman.belajarbahasainggris.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import id.indrasudirman.belajarbahasainggris.futurecontinuous.FutureContinuousFragment1;
import id.indrasudirman.belajarbahasainggris.futurecontinuous.FutureContinuousFragment2;
import id.indrasudirman.belajarbahasainggris.futurecontinuous.FutureContinuousFragment3;

public class FutureContinuousAdapter extends FragmentStateAdapter {

    public FutureContinuousAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 1:
                return new FutureContinuousFragment2();
            case 2:
                return new FutureContinuousFragment3();
            default:
                return new FutureContinuousFragment1();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
