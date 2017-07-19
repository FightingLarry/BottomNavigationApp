package com.larry.bottomnavigation;

import com.larry.light.LightFragmentActivity;

public class MainActivity extends LightFragmentActivity {

    @Override
    protected void initializeStartingFragment() {
        loadFragment(new MainHolderFragment(), null);
    }


}
