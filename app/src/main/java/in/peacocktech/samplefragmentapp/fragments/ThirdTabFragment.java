package in.peacocktech.samplefragmentapp.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Random;

import in.peacocktech.samplefragmentapp.ChangeCurrentFragment;
import in.peacocktech.samplefragmentapp.MainActivity;
import in.peacocktech.samplefragmentapp.R;

public class ThirdTabFragment extends Fragment implements ChangeCurrentFragment {


    private String title;
    private int page;

    // newInstance constructor for creating fragment with arguments
    public static ThirdTabFragment newInstance(int page, String title) {
        ThirdTabFragment fragmentFirst = new ThirdTabFragment();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        fragmentFirst.setArguments(args);
        return fragmentFirst;
    }

    // Store instance variables based on arguments passed
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*page = getArguments().getInt("someInt", 0);
        title = getArguments().getString("someTitle");*/
    }

    // Inflate the view for the fragment based on layout XML
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.f_3, container, false);

        manageFragment(new FFragment(),"1");
        return view;
    }



    @Override
    public void onFragmentChangeListener(Fragment fragment, String tag) {
        manageFragment(fragment,tag);
    }

    public void manageFragment(Fragment fragment,String tag)
    {
        FragmentManager fragmentManager=getChildFragmentManager();
        //    String f_name=fragment.getClass().getName();
        if(!fragmentManager.popBackStackImmediate(tag,0))
        {
            FragmentTransaction ft=fragmentManager.beginTransaction();
            ft.add(R.id.frame_container, fragment, tag);
            ft.addToBackStack(tag);
            ft.commit();

        }
    }

}
