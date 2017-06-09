package in.peacocktech.samplefragmentapp.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Random;

import in.peacocktech.samplefragmentapp.MainAmazonActivity;
import in.peacocktech.samplefragmentapp.R;

public class OFragment extends MYBaseFragment {


    public OFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_f, container, false);


        view.findViewById(R.id.next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ((MainAmazonActivity) getBaseActivity()).onFragmentChangeListener(new TwoFragment(),"1"+new Random().nextInt());
        
            }
        });
        return view;
    }




}
