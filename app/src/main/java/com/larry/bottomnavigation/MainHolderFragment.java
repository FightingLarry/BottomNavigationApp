package com.larry.bottomnavigation;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.larry.light.LightFragment;

/**
 * Created by Larry on 2017/7/19.
 */

public class MainHolderFragment extends LightFragment {

    private ViewPager mViewPager;
    private PagerAdapter mAdapter;
    private BottomNavigationView mBbottomNavigationView;

    private HomeFragment mHomeFragment;
    private DashBoardFragment mDashBoardFragment;
    private NotificationsFragment mNotificationsFragment;

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_main;
    }

    @Override
    public int getTitle() {
        return 0;
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {

                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.navigation_home:
                            mViewPager.setCurrentItem(0);
                            return true;
                        case R.id.navigation_dashboard:
                            mViewPager.setCurrentItem(1);
                            return true;
                        case R.id.navigation_notifications:
                            mViewPager.setCurrentItem(2);
                            return true;
                    }
                    return false;
                }
            };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);

        mViewPager = (ViewPager) view.findViewById(R.id.viewpager);
        mViewPager.setAdapter(getAdapter());

        mBbottomNavigationView = (BottomNavigationView) view.findViewById(R.id.navigation);
        mBbottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        mBbottomNavigationView.setSelectedItemId(R.id.navigation_home);
                        break;
                    case 1:
                        mBbottomNavigationView.setSelectedItemId(R.id.navigation_dashboard);
                        break;
                    case 2:
                        mBbottomNavigationView.setSelectedItemId(R.id.navigation_notifications);
                        break;
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        mViewPager.setCurrentItem(0);
        return view;
    }


    private PagerAdapter getAdapter() {
        if (mAdapter == null) {
            mAdapter = new FragmentPagerAdapter(getChildFragmentManager()) {

                @Override
                public int getCount() {
                    return 3;
                }

                @Override
                public Fragment getItem(int position) {
                    if (position == 0) {
                        return getHomeFragment();
                    } else if (position == 1) {
                        return getDashBoardFragment();
                    }
                    return getNotificationsFragment();
                }
            };
        }
        return mAdapter;
    }

    public HomeFragment getHomeFragment() {
        if (mHomeFragment == null) {
            mHomeFragment = new HomeFragment();
        }
        return mHomeFragment;
    }

    public DashBoardFragment getDashBoardFragment() {
        if (mDashBoardFragment == null) {
            mDashBoardFragment = new DashBoardFragment();
        }
        return mDashBoardFragment;
    }

    public NotificationsFragment getNotificationsFragment() {
        if (mNotificationsFragment == null) {
            mNotificationsFragment = new NotificationsFragment();
        }
        return mNotificationsFragment;
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        getHomeFragment().onActivityResult(requestCode, resultCode, data);
        getDashBoardFragment().onActivityResult(requestCode, resultCode, data);
        getNotificationsFragment().onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        getHomeFragment().onRequestPermissionsResult(requestCode, permissions, grantResults);
        getDashBoardFragment().onRequestPermissionsResult(requestCode, permissions, grantResults);
        getNotificationsFragment().onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

}
