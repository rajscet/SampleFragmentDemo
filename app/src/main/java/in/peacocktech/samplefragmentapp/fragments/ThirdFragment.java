package in.peacocktech.samplefragmentapp.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import in.peacocktech.samplefragmentapp.R;


public class ThirdFragment extends BaseFragment {


    public ThirdFragment() {
        // Required empty public constructor
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_t, container, false);

        return view;
    }

}
