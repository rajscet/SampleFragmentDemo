package in.peacocktech.samplefragmentapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.util.LogWriter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

import in.peacocktech.samplefragmentapp.fragments.FirstTabFragment;
import in.peacocktech.samplefragmentapp.fragments.SecondTabFragment;
import in.peacocktech.samplefragmentapp.fragments.ThirdTabFragment;

public class TabActivity extends AppCompatActivity {
    ViewPager vpPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);
        vpPager = (ViewPager) findViewById(R.id.vpPager);
        MyPagerAdapter adapterViewPager = new MyPagerAdapter(getSupportFragmentManager());
        vpPager.setAdapter(adapterViewPager);
        vpPager.setOffscreenPageLimit(3);
    }

    @Override
    public void onBackPressed() {
        if (!returnBackStackImmediate(getSupportFragmentManager())) {
            super.onBackPressed();
         /*   if (vpPager.getCurrentItem() == 0) {
                super.onBackPressed();
            } else
                vpPager.setCurrentItem(0);*/

        }
    }

    // HACK: propagate back button press to child fragments.
    // This might not work properly when you have multiple fragments adding multiple children to the backstack.
    // (in our case, only one child fragments adds fragments to the backstack, so we're fine with this)
    private boolean returnBackStackImmediate(FragmentManager fm) {
        Fragment fragment = getSupportFragmentManager().findFragmentByTag("android:switcher:" + R.id.vpPager + ":" + vpPager.getCurrentItem());
        // List<Fragment> fragments = fm.getFragments();

        // if (fragments != null && fragments.size() > 0) {
        //   for (Fragment fragment : fragments) {
        if (fragment.getChildFragmentManager().getBackStackEntryCount() > 1) {
            if (fragment.getChildFragmentManager().popBackStackImmediate()) {
                return true;
            } else {
                return returnBackStackImmediate(fragment.getChildFragmentManager());
            }

            //   }
        }
        return false;
    }

    public static class MyPagerAdapter extends FragmentPagerAdapter {
        private static int NUM_ITEMS = 3;

        public MyPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        // Returns total number of pages
        @Override
        public int getCount() {
            return NUM_ITEMS;
        }

        // Returns the fragment to display for that page
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0: // Fragment # 0 - This will show FirstFragment
                    return ThirdTabFragment.newInstance(0, "Page # 1");
                case 1: // Fragment # 0 - This will show FirstFragment different title
                    return ThirdTabFragment.newInstance(1, "Page # 2");
                case 2: // Fragment # 1 - This will show SecondFragment
                    return ThirdTabFragment.newInstance(2, "Page # 3");
                default:
                    return null;
            }
        }

        // Returns the page title for the top indicator
        @Override
        public CharSequence getPageTitle(int position) {
            return "Page " + position;
        }

    }

}
