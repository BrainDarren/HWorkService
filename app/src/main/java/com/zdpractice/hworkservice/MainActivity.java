package com.zdpractice.hworkservice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.zdpractice.hworkservice.ui.competeorder.HomeFragment;
import com.zdpractice.hworkservice.ui.orderinfo.OrderBaseFragment;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageView ivHome,ivOrder,ivPersonal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        ivHome.setOnClickListener(this);
        ivOrder.setOnClickListener(this);
        ivPersonal.setOnClickListener(this);
    }

    public void init(){
        ivHome= (ImageView) this.findViewById(R.id.ivHome);
        ivOrder= (ImageView) this.findViewById(R.id.ivOrder);
        ivPersonal= (ImageView) this.findViewById(R.id.ivPersonal);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ivHome:
                getSupportFragmentManager().beginTransaction().replace(R.id.lay_base, HomeFragment.newInstance()).commit();
                break;
            case R.id.ivOrder:
                getSupportFragmentManager().beginTransaction().replace(R.id.lay_base, OrderBaseFragment.newInstance()).commit();
                break;
            case R.id.ivPersonal:
                break;
        }
    }
}
