package in.peacocktech.samplefragmentapp.fragments;


import android.os.Bundle;

import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import in.peacocktech.samplefragmentapp.MainActivity;
import in.peacocktech.samplefragmentapp.R;
import in.peacocktech.samplefragmentapp.TabActivity;


public class SFragment extends BaseFragment {


    public SFragment() {
        // Required empty public constructor
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_s, container, false);
        view.findViewById(R.id.next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ((ThirdTabFragment) getBaseActivity()).onFragmentChangeListener(new TFragment(),"3");
            }
        });
        return view;
    }

}
