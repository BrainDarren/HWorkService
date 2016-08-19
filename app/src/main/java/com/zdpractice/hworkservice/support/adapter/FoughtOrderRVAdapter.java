package com.zdpractice.hworkservice.support.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.zdpractice.hworkservice.R;

/**
 * Created by 15813 on 2016/8/19.
 */
public class FoughtOrderRVAdapter extends RecyclerView.Adapter<FoughtOrderRVAdapter.MyViewHolder> {

    private Context context;

    public FoughtOrderRVAdapter(Context context){
        this.context=context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(this.context).inflate(R.layout.competeorder_fought_rv_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {


        public MyViewHolder(View itemView) {
            super(itemView);

        }
    }
}
