package com.larry.bottomnavigation;

import com.larry.light.LightFragment;

/**
 * Created by Larry on 2017/7/19.
 */

public class NotificationsFragment extends LightFragment {

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_natifications;
    }

    @Override
    public int getTitle() {
        return R.string.title_notifications;
    }

}
