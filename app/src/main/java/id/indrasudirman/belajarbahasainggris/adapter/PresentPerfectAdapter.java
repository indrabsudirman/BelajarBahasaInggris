package id.indrasudirman.belajarbahasainggris.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import id.indrasudirman.belajarbahasainggris.presentperfect.PresentPerfectFragment1;
import id.indrasudirman.belajarbahasainggris.presentperfect.PresentPerfectFragment2;
import id.indrasudirman.belajarbahasainggris.presentperfect.PresentPerfectFragment3;
import id.indrasudirman.belajarbahasainggris.presentperfect.PresentPerfectFragment4;
import id.indrasudirman.belajarbahasainggris.presentperfect.PresentPerfectFragment5;

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
            case 3:
                return new PresentPerfectFragment4();
            case 4:
                return new PresentPerfectFragment5();
            default:
                return new PresentPerfectFragment1();
        }
    }

    @Override
    public int getItemCount() {
        return 5;
    }
}
