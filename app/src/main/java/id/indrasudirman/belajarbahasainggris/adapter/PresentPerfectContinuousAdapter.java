package id.indrasudirman.belajarbahasainggris.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import id.indrasudirman.belajarbahasainggris.presentperfectcontinuous.PresentPerfectContinuousFragment1;
import id.indrasudirman.belajarbahasainggris.presentperfectcontinuous.PresentPerfectContinuousFragment2;
import id.indrasudirman.belajarbahasainggris.presentperfectcontinuous.PresentPerfectContinuousFragment3;

public class PresentPerfectContinuousAdapter extends FragmentStateAdapter {

    public PresentPerfectContinuousAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 1:
                return new PresentPerfectContinuousFragment2();
            case 2:
                return new PresentPerfectContinuousFragment3();
            default:
                return new PresentPerfectContinuousFragment1();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
