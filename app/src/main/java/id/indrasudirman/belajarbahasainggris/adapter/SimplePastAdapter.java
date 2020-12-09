package id.indrasudirman.belajarbahasainggris.adapter;

import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import id.indrasudirman.belajarbahasainggris.fragment.SimplePastFragment1;
import id.indrasudirman.belajarbahasainggris.fragment.SimplePastFragment2;
import id.indrasudirman.belajarbahasainggris.fragment.SimplePastFragment3;
import id.indrasudirman.belajarbahasainggris.fragment.SimplePastFragment4;

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
            default:
                return new SimplePastFragment1();
        }

    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
