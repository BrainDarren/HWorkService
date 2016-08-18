package com.zdpractice.hworkservice.ui.gradorder;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.zdpractice.hworkservice.R;

public class DingDFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";

    private int mParam1;


    public DingDFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment DingDFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DingDFragment newInstance(int param1) {
        DingDFragment fragment = new DingDFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getInt(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_ding_dan, container, false);
        TextView tvDD= (TextView) view.findViewById(R.id.tvDD);
        ImageView ivDD= (ImageView) view.findViewById(R.id.imDD);
        if(mParam1==1){
            tvDD.setText("已抢订单");
            ivDD.setImageResource(R.mipmap.ic_home);
        }else if(mParam1==2){
            tvDD.setText("历史订单");
            ivDD.setImageResource(R.mipmap.ic_about);
        }
        return view;
    }
}
