package com.zdpractice.hworkservice.ui.competeorder;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.zdpractice.hworkservice.R;
import com.zdpractice.hworkservice.support.adapter.HomeVPAdapter;
import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;

public class HomeFragment extends Fragment implements View.OnClickListener{


    private ViewPager viewPager;
    private CompeteFragment competeFragment;
    private FoughtFragment foughtFragment;
    private TextView tvShowOrder;
    private TextView tvShowFought;
    private ArrayList<Fragment> fragmentArrayList;
    private View view;
    private static HomeFragment homeFragment;


    public static HomeFragment newInstance(){
        if (homeFragment==null){
            homeFragment=new HomeFragment();
        }
        return homeFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.home_base,container,false);
        tvShowFought= (TextView) view.findViewById(R.id.tvShowFought);
        tvShowOrder= (TextView) view.findViewById(R.id.tvShowOrder);
        viewPager= (ViewPager) view.findViewById(R.id.vp_home);

        //把fragment添加入数组
        competeFragment =new CompeteFragment();
        foughtFragment=new FoughtFragment();
        fragmentArrayList=new ArrayList<Fragment>();
        fragmentArrayList.add(competeFragment);
        fragmentArrayList.add(foughtFragment);

        viewPager.setAdapter(new HomeVPAdapter(getChildFragmentManager(),fragmentArrayList));
        viewPager.setCurrentItem(0,false);
        tvShowFought.setOnClickListener(this);
        tvShowOrder.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tvShowFought:
                viewPager.setCurrentItem(1,false);
                break;
            case R.id.tvShowOrder:
                viewPager.setCurrentItem(0,false);
                break;
        }
    }
}
