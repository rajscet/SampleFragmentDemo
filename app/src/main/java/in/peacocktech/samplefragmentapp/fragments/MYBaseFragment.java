package in.peacocktech.samplefragmentapp.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import in.peacocktech.samplefragmentapp.ChangeCurrentFragment;
import in.peacocktech.samplefragmentapp.MainAmazonActivity;


/**
 * Created by peacock on 24/1/17.
 */

public class MYBaseFragment extends Fragment {

    private MainAmazonActivity activity;

    private ChangeCurrentFragment changeCurrentFragment;



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activity = (MainAmazonActivity) getActivity();

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

    public MainAmazonActivity getBaseActivity() {

        return activity;

    }


}
