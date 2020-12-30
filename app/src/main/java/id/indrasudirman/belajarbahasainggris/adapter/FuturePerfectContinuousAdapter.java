package id.indrasudirman.belajarbahasainggris.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import id.indrasudirman.belajarbahasainggris.futureperfectcontinuous.FuturePerfectContinuousFragment1;
import id.indrasudirman.belajarbahasainggris.futureperfectcontinuous.FuturePerfectContinuousFragment2;
import id.indrasudirman.belajarbahasainggris.futureperfectcontinuous.FuturePerfectContinuousFragment3;

public class FuturePerfectContinuousAdapter extends FragmentStateAdapter {

    public FuturePerfectContinuousAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 1:
                return new FuturePerfectContinuousFragment2();
            case 2:
                return new FuturePerfectContinuousFragment3();
            default:
                return new FuturePerfectContinuousFragment1();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
