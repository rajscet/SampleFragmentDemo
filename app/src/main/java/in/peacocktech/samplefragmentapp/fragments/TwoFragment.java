package in.peacocktech.samplefragmentapp.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import in.peacocktech.samplefragmentapp.MainAmazonActivity;
import in.peacocktech.samplefragmentapp.R;


public class TwoFragment extends MYBaseFragment {


    public TwoFragment() {
        // Required empty public constructor
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_s, container, false);
        view.findViewById(R.id.next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ((MainAmazonActivity) getBaseActivity()).onFragmentChangeListener(new ThirdFragment(),"3");
            }
        });
        return view;
    }

}
