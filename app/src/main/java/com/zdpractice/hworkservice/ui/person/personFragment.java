package com.zdpractice.hworkservice.ui.person;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.zdpractice.hworkservice.R;

/**
 * Created by 15813 on 2016/8/15.
 */
public class personFragment extends Fragment{
    public personFragment() {
    }

    public static personFragment newInstance(String param) {

        Bundle args = new Bundle();

        personFragment fragment = new personFragment();
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
                           }
        });

        btnpopu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),PupolartityAcivity.class);

            }
        });
        btnwallet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),WalletActivity.class);

            }
        });
        btnabout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),AboutActivity.class);

            }
        });
        btnnotice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),NoticeActivity.class);

            }
        });
        btnsetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),InfoActivity.class);

            }
        });
        return super.onCreateView(inflater, container, savedInstanceState);

    }
}
