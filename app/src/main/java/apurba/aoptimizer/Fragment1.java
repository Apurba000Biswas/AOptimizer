package apurba.aoptimizer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import apurba.a_optimizer.A_Fragment;

public class Fragment1 extends A_Fragment {

    public Fragment1() {
        // Required empty public constructor
    }

    public String getTittle(){
        return "Fragment 1";
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment1, container, false);
    }
}
