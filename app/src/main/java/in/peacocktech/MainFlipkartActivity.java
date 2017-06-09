package in.peacocktech;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import in.peacocktech.samplefragmentapp.ChangeCurrentFragment;
import in.peacocktech.samplefragmentapp.R;
import in.peacocktech.samplefragmentapp.fragments.GalleryFragment;
import in.peacocktech.samplefragmentapp.fragments.OFKTFragment;
import in.peacocktech.samplefragmentapp.fragments.OFragment;
import in.peacocktech.samplefragmentapp.fragments.SendFragment;
import in.peacocktech.samplefragmentapp.fragments.ShareFragment;
import in.peacocktech.samplefragmentapp.fragments.SildeShowFragment;
import in.peacocktech.samplefragmentapp.fragments.ToolsFragment;

public class MainFlipkartActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,FragmentManager.OnBackStackChangedListener,ChangeCurrentFragment {


    private Toolbar toolbar = null;
    private boolean mToolBarNavigationListenerIsRegistered = false;

    ActionBarDrawerToggle mDrawerToggle;
    public Toolbar getToolbar() {

        return toolbar;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
         toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        getSupportFragmentManager().addOnBackStackChangedListener(this);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
         mDrawerToggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        OFKTFragment cameraImportFragment = new OFKTFragment();
        manageFragment(cameraImportFragment,"camera");

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
        if (getSupportFragmentManager().getBackStackEntryCount() == 1) {

            finish();


        } else {

            super.onBackPressed();

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {

            OFKTFragment  cameraImportFragment = new OFKTFragment();
            manageFragment(cameraImportFragment,"camera");

        } else if (id == R.id.nav_gallery) {

            GalleryFragment galleryFragment = new GalleryFragment();

            manageFragment(galleryFragment,"gallery");
        } else if (id == R.id.nav_slideshow) {

            SildeShowFragment slideShowFragment = new SildeShowFragment();

            manageFragment(slideShowFragment,"slide");

        } else if (id == R.id.nav_manage) {

            ToolsFragment toolsFragment = new ToolsFragment();
            manageFragment(toolsFragment,"manage");

        } else if (id == R.id.nav_share) {

            ShareFragment sendFragment = new ShareFragment();
            manageFragment(sendFragment,"share");

        } else if (id == R.id.nav_send) {


            SendFragment sendFragment = new SendFragment();
            manageFragment(sendFragment,"send");

        }

        item.setChecked(true);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    public void manageFragment(Fragment fragment, String tag)
    {
        FragmentManager fragmentManager=getSupportFragmentManager();
        //    String f_name=fragment.getClass().getName();
        if(!fragmentManager.popBackStackImmediate(tag,0))
        {
            FragmentTransaction ft=fragmentManager.beginTransaction();
            ft.replace(R.id.content_frame, fragment, tag);
            ft.addToBackStack(tag);
            ft.commit();

        }
    }




    @Override
    public void onFragmentChangeListener(Fragment fragment, String tag) {
        manageFragment(fragment,tag);
    }




    @Override
    public void onBackStackChanged() {
        FragmentManager fragmentManager=getSupportFragmentManager();
        Fragment fr = fragmentManager.findFragmentById(R.id.frame_container);
        if(fr!=null){
            fr.onResume();
        }
    }

    public void enableViews(boolean enable) {

        // To keep states of ActionBar and ActionBarDrawerToggle synchronized,
        // when you enable on one, you disable on the other.
        // And as you may notice, the order for this operation is disable first, then enable - VERY VERY IMPORTANT.
        if(enable) {
            // Remove hamburger
            mDrawerToggle.setDrawerIndicatorEnabled(false);
            // Show back button
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            // when DrawerToggle is disabled i.e. setDrawerIndicatorEnabled(false), navigation icon
            // clicks are disabled i.e. the UP button will not work.
            // We need to add a listener, as in below, so DrawerToggle will forward
            // click events to this listener.
            if(!mToolBarNavigationListenerIsRegistered) {
                mDrawerToggle.setToolbarNavigationClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Doesn't have to be onBackPressed
                        onBackPressed();
                    }
                });

                mToolBarNavigationListenerIsRegistered = true;
            }

        } else {
            // Remove back button
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            // Show hamburger
            mDrawerToggle.setDrawerIndicatorEnabled(true);
            // Remove the/any drawer toggle listener
            mDrawerToggle.setToolbarNavigationClickListener(null);
            mToolBarNavigationListenerIsRegistered = false;
        }


    }
}




  