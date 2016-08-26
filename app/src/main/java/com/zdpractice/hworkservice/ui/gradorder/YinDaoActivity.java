package com.zdpractice.hworkservice.ui.gradorder;

import android.app.Activity;
import android.os.Bundle;

import com.zdpractice.hworkservice.R;

/**
 * Created by syz on 2016/8/24.
 */

public class YinDaoActivity extends Activity {
    YinDaoSharedHelper yinDaoSharedHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        yinDaoSharedHelper =new YinDaoSharedHelper(getApplicationContext());

        String cishu=yinDaoSharedHelper.read();
        if(cishu==null){
            setContentView(R.layout.grad_yindao);
            yinDaoSharedHelper.save("123");
        }else if(cishu!=null){
            setContentView(R.layout.activity_main);
        }
    }
}
