package in.peacocktech.samplefragmentapp.fragments;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import in.peacocktech.MainFlipkartActivity;
import in.peacocktech.samplefragmentapp.MainAmazonActivity;
import in.peacocktech.samplefragmentapp.R;


public class TwoFKTFragment extends FlipkartBaseFragment {

    Activity activity;

    public TwoFKTFragment() {
        // Required empty public constructor
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        activity=getBaseActivity();
        View view = inflater.inflate(R.layout.fragment_s, container, false);
        view.findViewById(R.id.next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ((MainFlipkartActivity) getBaseActivity()).onFragmentChangeListener(new ThirdFKTFragment(),"3");
            }
        });
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();



/*        getBaseSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getBaseToolBar().setNavigationOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                ((MainFlipkartActivity) activity).getSupportFragmentManager().popBackStackImmediate();

            }
        });*/
        ((MainFlipkartActivity) getBaseActivity()).enableViews(true);
    }

}
