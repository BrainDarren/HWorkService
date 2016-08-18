package com.zdpractice.hworkservice.support.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by 15813 on 2016/8/18.
 */
public class OrderInfoVPAdapter extends FragmentPagerAdapter {

    String[] title={"生效订单","历史纪录"};
    private ArrayList<Fragment> fragmentArrayList;



    public OrderInfoVPAdapter(FragmentManager fm,ArrayList<Fragment> fragmentArrayList) {
        super(fm);
        this.fragmentArrayList=fragmentArrayList;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentArrayList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentArrayList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }
}
