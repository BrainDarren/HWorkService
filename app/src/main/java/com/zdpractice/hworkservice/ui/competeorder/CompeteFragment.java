package com.zdpractice.hworkservice.ui.competeorder;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.zdpractice.hworkservice.R;

/**
 * Created by 15813 on 2016/8/17.
 */
public class CompeteFragment extends Fragment{
    private View view;
//    private @ViewInject(R.id.rvCompeteOrder) RecyclerView rvCompeteOrder;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.competeorder_show,container,false);
//        rvCompeteOrder.setAdapter();
        return view;
    }
}
