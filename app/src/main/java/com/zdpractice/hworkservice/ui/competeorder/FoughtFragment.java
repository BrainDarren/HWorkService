package com.zdpractice.hworkservice.ui.competeorder;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zdpractice.hworkservice.R;
import com.zdpractice.hworkservice.support.adapter.FoughtOrderRVAdapter;

/**
 * Created by 15813 on 2016/8/17.
 */
public class FoughtFragment extends Fragment {

    private View view;
    //处于竞单中状态的订单列表的RecycleView
    private RecyclerView rvFoughtOrder;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.competeorder_fought,container,false);
        rvFoughtOrder= (RecyclerView) view.findViewById(R.id.rvFoughtOrder);
        rvFoughtOrder.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        rvFoughtOrder.setAdapter(new FoughtOrderRVAdapter(getActivity()));
        return view;

    }


}
