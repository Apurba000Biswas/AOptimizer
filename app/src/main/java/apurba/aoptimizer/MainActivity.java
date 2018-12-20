package apurba.aoptimizer;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.HashMap;
import java.util.Map;

import apurba.a_optimizer.AFP_adapter;
import apurba.a_optimizer.FragmentHolder;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ViewPager viewPager = findViewById(R.id.viewpager);
        Map<Integer, FragmentHolder> fragmentMap = new HashMap<Integer, FragmentHolder>();
        fragmentMap.put(0, new fHolder("Fragment 1", new Fragment1()));
        fragmentMap.put(1, new fHolder("Fragment 1", new Fragment2()));
        AFP_adapter adapter =
                new AFP_adapter(getSupportFragmentManager(), fragmentMap);
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }
}

class fHolder implements FragmentHolder{

    private Fragment mFragment;
    private String mTittle;

    public fHolder(String tittle, Fragment fragment){
        mTittle = tittle;
        mFragment = fragment;
    }

    @Override
    public Fragment getFragment() {
        return mFragment;
    }

    @Override
    public CharSequence getTittle() {
        return mTittle;
    }
}
