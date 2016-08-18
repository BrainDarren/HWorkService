package com.zdpractice.hworkservice.ui.person;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.zdpractice.hworkservice.R;

/**
 * Created by 15813 on 2016/8/15.
 */
public class PersonBaseFragment extends Fragment {

    public static PersonBaseFragment newInstance() {
        Bundle args = new Bundle();
        PersonBaseFragment fragment = new PersonBaseFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View  view=inflater.inflate(R.layout.lay_person, container, false);
        Button btninfo = (Button)view.findViewById(R.id.btninfo);
        Button btnpopu = (Button)view.findViewById(R.id.btnpopu);
        Button btnwallet = (Button)view.findViewById(R.id.btnwallet);
        Button btnabout = (Button)view.findViewById(R.id.btnabout);
        Button btnnotice = (Button)view.findViewById(R.id.btnnotice);
        Button btnsetting = (Button)view.findViewById(R.id.btnsetting);
        btninfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),InfoActivity.class);
                startActivity(intent);
            }
        });

        btnpopu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),PupolartityAcivity.class);
                startActivity(intent);
            }
        });
        btnwallet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),WalletActivity.class);
                startActivity(intent);
            }
        });
        btnabout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),AboutActivity.class);
                startActivity(intent);
            }
        });
        btnnotice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),NoticeActivity.class);
                startActivity(intent);
            }
        });
        btnsetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),InfoActivity.class);
                startActivity(intent);
            }
        });
        return view;

    }
}
