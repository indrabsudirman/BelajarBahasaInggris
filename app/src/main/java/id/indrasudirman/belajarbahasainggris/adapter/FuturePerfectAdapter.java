package id.indrasudirman.belajarbahasainggris.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import id.indrasudirman.belajarbahasainggris.futureperfect.FuturePerfectFragment1;
import id.indrasudirman.belajarbahasainggris.futureperfect.FuturePerfectFragment2;
import id.indrasudirman.belajarbahasainggris.futureperfect.FuturePerfectFragment3;
import id.indrasudirman.belajarbahasainggris.futureperfect.FuturePerfectFragment4;
import id.indrasudirman.belajarbahasainggris.futureperfect.FuturePerfectFragment5;
import id.indrasudirman.belajarbahasainggris.pastcontinuous.PastContinuousFragment1;
import id.indrasudirman.belajarbahasainggris.pastcontinuous.PastContinuousFragment2;
import id.indrasudirman.belajarbahasainggris.pastcontinuous.PastContinuousFragment3;

public class FuturePerfectAdapter extends FragmentStateAdapter {

    public FuturePerfectAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 1:
                return new FuturePerfectFragment2();
            case 2:
                return new FuturePerfectFragment3();
            case 3:
                return new FuturePerfectFragment4();
            case 4:
                return new FuturePerfectFragment5();
            default:
                return new FuturePerfectFragment1();
        }
    }

    @Override
    public int getItemCount() {
        return 5;
    }
}
