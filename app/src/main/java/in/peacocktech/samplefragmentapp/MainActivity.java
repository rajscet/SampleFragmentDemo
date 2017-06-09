package in.peacocktech.samplefragmentapp;


import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import in.peacocktech.samplefragmentapp.fragments.FFragment;

public class MainActivity extends AppCompatActivity implements FragmentManager.OnBackStackChangedListener,ChangeCurrentFragment{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manageFragment(new FFragment(),"1");
        getSupportFragmentManager().addOnBackStackChangedListener(this);
    }


    public void manageFragment(Fragment fragment,String tag)
    {
        FragmentManager fragmentManager=getSupportFragmentManager();
    //    String f_name=fragment.getClass().getName();
        if(!fragmentManager.popBackStackImmediate(tag,0))
        {
            FragmentTransaction ft=fragmentManager.beginTransaction();
            ft.add(R.id.frame_container, fragment, tag);
            ft.addToBackStack(tag);
            ft.commit();

        }
    }




    @Override
    public void onFragmentChangeListener(android.support.v4.app.Fragment fragment, String tag) {
        manageFragment(fragment,tag);
    }

    @Override
    public void onBackPressed() {

        if (getSupportFragmentManager().getBackStackEntryCount() == 1) {

            finish();
            manageFragment(new FFragment(),"1");

        } else {

            super.onBackPressed();

        }
    }


    @Override
    public void onBackStackChanged() {
        FragmentManager fragmentManager=getSupportFragmentManager();
        Fragment fr = fragmentManager.findFragmentById(R.id.frame_container);
        if(fr!=null){
            fr.onResume();
        }
    }
}
