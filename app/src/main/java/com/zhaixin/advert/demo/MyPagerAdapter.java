package com.zhaixin.advert.demo;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

/*
 *  项目名:   ZhaiXinAdvert
 *  包名:     com.zhaixin.advert.demo
 *  文件名:   MyPagerAdapter
 *  创建时间:  2025/8/22
 *  创建者:   Hao
 *  描述:
 */
public class MyPagerAdapter extends FragmentStateAdapter {
    private static final int TAB_COUNT = 2;
    private static final String[] TAB_TITLES = new String[]{"Tab 1", "Tab 2"};

    public MyPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new Banner1();
            case 1:
                return new Banner2();
            default:
                return new Banner1();
        }
    }

    @Override
    public int getItemCount() {
        return TAB_COUNT;
    }

    public String getTabTitle(int position) {
        return TAB_TITLES[position];
    }
}
