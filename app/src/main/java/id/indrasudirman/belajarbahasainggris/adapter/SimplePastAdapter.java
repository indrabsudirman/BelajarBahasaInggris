package id.indrasudirman.belajarbahasainggris.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import id.indrasudirman.belajarbahasainggris.simplepast.SimplePastFragment5;
import id.indrasudirman.belajarbahasainggris.simplepast.SimplePastFragment1;
import id.indrasudirman.belajarbahasainggris.simplepast.SimplePastFragment2;
import id.indrasudirman.belajarbahasainggris.simplepast.SimplePastFragment3;
import id.indrasudirman.belajarbahasainggris.simplepast.SimplePastFragment4;

public class SimplePastAdapter extends FragmentStateAdapter {

    public SimplePastAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 1:
                return new SimplePastFragment2();
            case 2:
                return new SimplePastFragment3();
            case 3:
                return new SimplePastFragment4();
            case 4:
                return new SimplePastFragment5();
            default:
                return new SimplePastFragment1();
        }

    }

    @Override
    public int getItemCount() {
        return 5;
    }
}
