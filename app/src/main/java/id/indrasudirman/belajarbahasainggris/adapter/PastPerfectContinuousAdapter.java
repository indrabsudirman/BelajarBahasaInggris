package id.indrasudirman.belajarbahasainggris.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import id.indrasudirman.belajarbahasainggris.pastperfectcontinuous.PastPerfectContinuousFragment1;
import id.indrasudirman.belajarbahasainggris.pastperfectcontinuous.PastPerfectContinuousFragment2;
import id.indrasudirman.belajarbahasainggris.pastperfectcontinuous.PastPerfectContinuousFragment3;
import id.indrasudirman.belajarbahasainggris.pastperfectcontinuous.PastPerfectContinuousFragment4;
import id.indrasudirman.belajarbahasainggris.pastperfectcontinuous.PastPerfectContinuousFragment5;

public class PastPerfectContinuousAdapter extends FragmentStateAdapter {

    public PastPerfectContinuousAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 1:
                return new PastPerfectContinuousFragment2();
            case 2:
                return new PastPerfectContinuousFragment3();
            case 3:
                return new PastPerfectContinuousFragment4();
            case 4:
                return new PastPerfectContinuousFragment5();
            default:
                return new PastPerfectContinuousFragment1();
        }
    }

    @Override
    public int getItemCount() {
        return 5;
    }
}
