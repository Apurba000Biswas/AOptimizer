package apurba.a_optimizer;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.Map;

public class AFP_adapter extends FragmentPagerAdapter {

    private Map<Integer, A_Fragment> mFragmentMap;

    public AFP_adapter(FragmentManager fm, Map<Integer
            , A_Fragment> fragmentMap) {
        super(fm);
        mFragmentMap = fragmentMap;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentMap.get(position);
    }


    @Override
    public int getCount() {
        return mFragmentMap.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String tittle = mFragmentMap.get(position).getTittle();
        return (tittle == null) ? "No tittle" : tittle;
    }
}
