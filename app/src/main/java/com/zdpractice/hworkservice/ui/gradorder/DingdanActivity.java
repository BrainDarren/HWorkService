package com.zdpractice.hworkservice.ui.gradorder;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.zdpractice.hworkservice.R;
import com.zdpractice.hworkservice.support.adapter.DingdanAdapter;

/**
 * Created by syz on 2016/8/17.
 */

public class DingdanActivity extends AppCompatActivity {
    private TabLayout tlDD;
    private ViewPager vpDD;
    private DingdanAdapter dingdanAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dingdan_main);
        tlDD= (TabLayout) findViewById(R.id.tlDD);
        vpDD= (ViewPager) findViewById(R.id.vpDD);
        dingdanAdapter = new DingdanAdapter(getSupportFragmentManager(), this);
        vpDD.setAdapter(dingdanAdapter);
        tlDD.setupWithViewPager(vpDD);
        tlDD.setTabMode(TabLayout.MODE_SCROLLABLE);
    }
}
