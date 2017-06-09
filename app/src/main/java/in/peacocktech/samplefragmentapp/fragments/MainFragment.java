package in.peacocktech.samplefragmentapp.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import in.peacocktech.samplefragmentapp.ChangeCurrentFragment;
import in.peacocktech.samplefragmentapp.R;


public class MainFragment extends Fragment implements ChangeCurrentFragment {


    MainFragment activity;
    private String title;

    // newInstance constructor for creating fragment with arguments
    public static MainFragment newInstance(int page, String title) {
        MainFragment fragmentFirst = new MainFragment();
        Bundle args = new Bundle();
        args.putString("someTitle", title);
        fragmentFirst.setArguments(args);
        return fragmentFirst;
    }

    public MainFragment getBaseActivity() {

        return activity;

    }

    // Store instance variables based on arguments passed
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //   title = getArguments().getString("someTitle");
        activity = (MainFragment) getParentFragment();
    }

    // Inflate the view for the fragment based on layout XML
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_fragment, container, false);
        if (savedInstanceState == null) {

            if (null != getArguments()) {
                int index = getArguments().getInt("index");
                switch (index) {
                    case 0:
                        manageFragment(new ThirdTabFragment(), index + "");
                        break;
                    case 1:
                        manageFragment(new GalleryFragment(), index + "");
                        break;
                    case 2:
                        manageFragment(new SildeShowFragment(), index + "");
                        break;
                    case 4:
                        manageFragment(new ToolsFragment(), index + "");
                        break;
                    case 5:
                        manageFragment(new ShareFragment(), index + "");
                        break;
                    case 6:
                        manageFragment(new SendFragment(), index + "");
                        break;
                }
            }
        }
        return view;
    }


    @Override
    public void onFragmentChangeListener(Fragment fragment, String tag) {
        manageFragment(fragment, tag);
    }

    public void manageFragment(Fragment fragment, String tag) {
        FragmentManager fragmentManager = getChildFragmentManager();
        //    String f_name=fragment.getClass().getName();
        if (!fragmentManager.popBackStackImmediate(tag, 0)) {
            FragmentTransaction ft = fragmentManager.beginTransaction();
            ft.add(R.id.frame_container, fragment, tag);
            ft.addToBackStack(tag);
            ft.commit();

        }
    }


}
