package com.zdpractice.hworkservice;

import android.app.Application;

import com.zdpractice.hworkservice.model.UserBean;

import org.xutils.x;

/**
 * Created by 15813 on 2016/8/16.
 */
public class MyApplication extends Application {

    /**
     * 此应用的token，在登陆页面赋值
     */
    public static String token;
    public static UserBean userBean;
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
    }
}
