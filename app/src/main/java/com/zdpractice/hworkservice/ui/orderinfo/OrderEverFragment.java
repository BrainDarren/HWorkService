package com.zdpractice.hworkservice.ui.orderinfo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zdpractice.hworkservice.R;

/**
 * Created by 15813 on 2016/8/18.
 */
public class OrderEverFragment extends Fragment {

    private View view;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.orderinfo_ever,container,false);
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
