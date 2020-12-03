package id.indrasudirman.belajarbahasainggris.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import id.indrasudirman.belajarbahasainggris.fragment.SimplePastFragment1;
import id.indrasudirman.belajarbahasainggris.fragment.SimplePastFragment2;

public class SimplePastAdapter extends FragmentStateAdapter {

    public SimplePastAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new SimplePastFragment1();
            default:
                return new SimplePastFragment2();
        }

    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
