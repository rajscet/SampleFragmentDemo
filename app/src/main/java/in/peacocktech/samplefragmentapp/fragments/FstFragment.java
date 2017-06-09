package in.peacocktech.samplefragmentapp.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Random;

import in.peacocktech.samplefragmentapp.R;

public class FstFragment extends BaseFragment {


    public FstFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_f, container, false);

        view.findViewById(R.id.next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ((ThirdTabFragment) getBaseActivity()).onFragmentChangeListener(new SFragment(),"1"+new Random().nextInt());
            }
        });
        return view;
    }




}
