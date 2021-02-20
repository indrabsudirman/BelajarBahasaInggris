package id.indrasudirman.belajarbahasainggris.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import id.indrasudirman.belajarbahasainggris.futureperfectcontinuous.FuturePerfectContinuousFragment1;
import id.indrasudirman.belajarbahasainggris.futureperfectcontinuous.FuturePerfectContinuousFragment2;
import id.indrasudirman.belajarbahasainggris.futureperfectcontinuous.FuturePerfectContinuousFragment3;
import id.indrasudirman.belajarbahasainggris.futureperfectcontinuous.FuturePerfectContinuousFragment4;
import id.indrasudirman.belajarbahasainggris.futureperfectcontinuous.FuturePerfectContinuousFragment5;

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
            case 3:
                return new FuturePerfectContinuousFragment4();
            case 4:
                return new FuturePerfectContinuousFragment5();
            default:
                return new FuturePerfectContinuousFragment1();
        }
    }

    @Override
    public int getItemCount() {
        return 5;
    }
}
