package com.zdpractice.hworkservice.ui.orderinfo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zdpractice.hworkservice.R;
import com.zdpractice.hworkservice.support.adapter.OrderInfoVPAdapter;

import java.util.ArrayList;

/**
 * Created by 15813 on 2016/8/18.
 */
public class OrderBaseFragment extends Fragment {

    private View view;
    private TabLayout tl_Orderinfo;
    private ViewPager vp_Orderinfo;
    private static OrderBaseFragment orderBaseFragment;
    private OrderSuccessFragment orderSuccessFragment;
    private OrderEverFragment orderEverFragment;
    private ArrayList<Fragment> fragmentArrayList;

    public static OrderBaseFragment newInstance(){
        if (orderBaseFragment==null){
            orderBaseFragment=new OrderBaseFragment();

        }
        return orderBaseFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.orderinfo_base,container,false);
        Log.v("OrderBaseFragment","orderbasefragment");
        tl_Orderinfo= (TabLayout) view.findViewById(R.id.tl_Orderinfo);
        vp_Orderinfo= (ViewPager) view.findViewById(R.id.vp_Orderinfo);

        orderEverFragment=new OrderEverFragment();
        orderSuccessFragment=new OrderSuccessFragment();
        fragmentArrayList=new ArrayList<Fragment>();
        fragmentArrayList.add(orderSuccessFragment);
        fragmentArrayList.add(orderEverFragment);

        vp_Orderinfo.setAdapter(new OrderInfoVPAdapter(getActivity().getSupportFragmentManager(),fragmentArrayList));
        tl_Orderinfo.setupWithViewPager(vp_Orderinfo);
        tl_Orderinfo.setTabMode(TabLayout.MODE_SCROLLABLE);
        return view;
    }



}
