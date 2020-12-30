package id.indrasudirman.belajarbahasainggris.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import id.indrasudirman.belajarbahasainggris.pastperfect.PastPerfectFragment1;
import id.indrasudirman.belajarbahasainggris.pastperfect.PastPerfectFragment2;
import id.indrasudirman.belajarbahasainggris.pastperfect.PastPerfectFragment3;

public class PastPerfectAdapter extends FragmentStateAdapter {

    public PastPerfectAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 1:
                return new PastPerfectFragment2();
            case 2:
                return new PastPerfectFragment3();
            default:
                return new PastPerfectFragment1();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
