package id.indrasudirman.belajarbahasainggris.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import id.indrasudirman.belajarbahasainggris.pastfutureperfectcontinuous.PastFuturePerfectContinuousFragment1;
import id.indrasudirman.belajarbahasainggris.pastfutureperfectcontinuous.PastFuturePerfectContinuousFragment2;
import id.indrasudirman.belajarbahasainggris.pastfutureperfectcontinuous.PastFuturePerfectContinuousFragment3;
import id.indrasudirman.belajarbahasainggris.pastperfect.PastPerfectFragment1;
import id.indrasudirman.belajarbahasainggris.pastperfect.PastPerfectFragment2;
import id.indrasudirman.belajarbahasainggris.pastperfect.PastPerfectFragment3;

public class PastFuturePerfectContinuousAdapter extends FragmentStateAdapter {

    public PastFuturePerfectContinuousAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 1:
                return new PastFuturePerfectContinuousFragment2();
            case 2:
                return new PastFuturePerfectContinuousFragment3();
            default:
                return new PastFuturePerfectContinuousFragment1();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
