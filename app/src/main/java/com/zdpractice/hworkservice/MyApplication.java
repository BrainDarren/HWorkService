package com.zdpractice.hworkservice;

import android.app.Application;

import org.xutils.x;

/**
 * Created by 15813 on 2016/8/16.
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
    }
}
