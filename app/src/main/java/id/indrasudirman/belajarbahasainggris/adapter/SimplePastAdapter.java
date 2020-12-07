package id.indrasudirman.belajarbahasainggris.adapter;

import android.widget.Toast;

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
            case 1:
//                Toast.makeText("Set method belum berhasil :(", Toast.LENGTH_SHORT).show();
                return new SimplePastFragment2();
            default:
                return new SimplePastFragment1();
        }

    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
