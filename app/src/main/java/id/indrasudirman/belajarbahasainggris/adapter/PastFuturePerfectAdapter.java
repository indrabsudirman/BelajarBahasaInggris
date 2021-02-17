package id.indrasudirman.belajarbahasainggris.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import id.indrasudirman.belajarbahasainggris.pastfutureperfect.PastFuturePerfectFragment1;
import id.indrasudirman.belajarbahasainggris.pastfutureperfect.PastFuturePerfectFragment2;
import id.indrasudirman.belajarbahasainggris.pastfutureperfect.PastFuturePerfectFragment3;
import id.indrasudirman.belajarbahasainggris.pastfutureperfect.PastFuturePerfectFragment4;
import id.indrasudirman.belajarbahasainggris.pastfutureperfect.PastFuturePerfectFragment5;

public class PastFuturePerfectAdapter extends FragmentStateAdapter {

    public PastFuturePerfectAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 1:
                return new PastFuturePerfectFragment2();
            case 2:
                return new PastFuturePerfectFragment3();
            case 3:
                return new PastFuturePerfectFragment4();
            case 4:
                return new PastFuturePerfectFragment5();
            default:
                return new PastFuturePerfectFragment1();
        }
    }

    @Override
    public int getItemCount() {
        return 5;
    }
}
