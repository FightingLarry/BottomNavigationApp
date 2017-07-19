package com.larry.bottomnavigation;

import com.larry.light.LightFragment;

/**
 * Created by Larry on 2017/7/19.
 */

public class DashBoardFragment extends LightFragment {

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_dashboard;
    }

    @Override
    public int getTitle() {
        return R.string.title_dashboard;
    }

}
