package com.zdpractice.hworkservice.ui.competeorder;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.zdpractice.hworkservice.R;
import com.zdpractice.hworkservice.support.adapter.HomeRVAdapter;

/**
 * Created by 15813 on 2016/8/17.
 */
public class CompeteFragment extends Fragment{

    //显示订单信息的Fragment

    private View view;
    //查看订单信息的RecycleView
    private RecyclerView rvCompeteOrder;
    private SwipeRefreshLayout sflCompeteOrder;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.competeorder_show,container,false);
        rvCompeteOrder= (RecyclerView) view.findViewById(R.id.rvCompeteOrder);
        rvCompeteOrder.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayout.VERTICAL, false));
        //TODO SwipeRefreshLayout
        sflCompeteOrder= (SwipeRefreshLayout) view.findViewById(R.id.sflCompeteOrder);
        //TODO 要把联网获取的订单数据传递到适配器
        rvCompeteOrder.setAdapter(new HomeRVAdapter(getActivity()));
        return view;
    }
}
