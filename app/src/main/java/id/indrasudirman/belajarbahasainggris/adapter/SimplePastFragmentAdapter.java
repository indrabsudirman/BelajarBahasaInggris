package id.indrasudirman.belajarbahasainggris.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class SimplePastFragmentAdapter extends FragmentPagerAdapter {

    private final ArrayList<Fragment> fragmentArrayList;
    private final ArrayList<String> mFragmentTitleList;

    public SimplePastFragmentAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        fragmentArrayList = new ArrayList<>();
        mFragmentTitleList = new ArrayList<>();
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {

        return null;

    }

    @Override
    public int getCount() {
        return fragmentArrayList.size();
    }

    /**
     * This Method is precaution for androidX, while tabs text not displaying in android 9+
     * @param fragment
     * @param title
     */

    public void addFragment (Fragment fragment, String title) {
        fragmentArrayList.add(fragment);
        mFragmentTitleList.add(title);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle (int position) {
        return mFragmentTitleList.get(position);
    }
}
