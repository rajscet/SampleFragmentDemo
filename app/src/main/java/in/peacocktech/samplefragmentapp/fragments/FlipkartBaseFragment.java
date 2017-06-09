package in.peacocktech.samplefragmentapp.fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;

import in.peacocktech.MainFlipkartActivity;
import in.peacocktech.samplefragmentapp.ChangeCurrentFragment;
import in.peacocktech.samplefragmentapp.MainAmazonActivity;


/**
 * Created by peacock on 24/1/17.
 */

public class FlipkartBaseFragment extends Fragment {

    private MainFlipkartActivity activity;

    private ChangeCurrentFragment changeCurrentFragment;



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activity = (MainFlipkartActivity) getActivity();

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

    public MainFlipkartActivity getBaseActivity() {

        return activity;

    }


    public ActionBar getBaseSupportActionBar() {

        return activity.getSupportActionBar();

    }

    public Toolbar getBaseToolBar() {

        return activity.getToolbar();

    }

}
