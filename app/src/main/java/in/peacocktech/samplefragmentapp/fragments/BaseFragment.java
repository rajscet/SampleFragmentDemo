package in.peacocktech.samplefragmentapp.fragments;

import android.app.Activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.TaskStackBuilder;


import in.peacocktech.samplefragmentapp.ChangeCurrentFragment;
import in.peacocktech.samplefragmentapp.MainActivity;
import in.peacocktech.samplefragmentapp.R;
import in.peacocktech.samplefragmentapp.TabActivity;


/**
 * Created by peacock on 24/1/17.
 */

public class BaseFragment extends Fragment {

    private ThirdTabFragment activity;

    private ChangeCurrentFragment changeCurrentFragment;



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activity = (ThirdTabFragment) getParentFragment();

    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof ChangeCurrentFragment)
        changeCurrentFragment = (ChangeCurrentFragment) context;

    }

    @Override
    public void onDetach() {
        super.onDetach();
        changeCurrentFragment=null;

    }

    public ChangeCurrentFragment onChangeCurrentFragment(){

        return changeCurrentFragment;

    }

    public ThirdTabFragment getBaseActivity() {

        return activity;

    }


}
