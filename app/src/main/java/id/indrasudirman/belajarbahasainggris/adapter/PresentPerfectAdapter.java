package id.indrasudirman.belajarbahasainggris.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import id.indrasudirman.belajarbahasainggris.pastcontinuous.PastContinuousFragment1;
import id.indrasudirman.belajarbahasainggris.pastcontinuous.PastContinuousFragment2;
import id.indrasudirman.belajarbahasainggris.pastcontinuous.PastContinuousFragment3;
import id.indrasudirman.belajarbahasainggris.presentperfect.PresentPerfectFragment1;
import id.indrasudirman.belajarbahasainggris.presentperfect.PresentPerfectFragment2;
import id.indrasudirman.belajarbahasainggris.presentperfect.PresentPerfectFragment3;

public class PresentPerfectAdapter extends FragmentStateAdapter {

    public PresentPerfectAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 1:
                return new PresentPerfectFragment2();
            case 2:
                return new PresentPerfectFragment3();
            default:
                return new PresentPerfectFragment1();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
