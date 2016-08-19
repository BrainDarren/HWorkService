package com.zdpractice.hworkservice.ui.login;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.zdpractice.hworkservice.MainActivity;
import com.zdpractice.hworkservice.MyApplication;
import com.zdpractice.hworkservice.R;
import com.zdpractice.hworkservice.model.UserParentBean;
import com.zdpractice.hworkservice.support.networktool.AES;
import com.zdpractice.hworkservice.support.networktool.NetWorkTools;

/**
 * Created by 15813 on 2016/8/15.
 */

/*
* 连服务器查询 bug不能退回到登陆界面
* */
public class loginActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText username;
    private EditText userpwd;
    private CheckBox cb_remember;
    private Button btn_login;
    private  NetWorkTools netWorkTools;
    private ImageView name_clear,pwd_clear;
    private SharedPreferences pregerences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.lay_login);
        pregerences =getSharedPreferences("AllData", Context.MODE_PRIVATE);
        init();
    }
    public void init(){
        username= (EditText) findViewById(R.id.username);
        userpwd= (EditText) findViewById(R.id.userpwd);
        cb_remember= (CheckBox) findViewById(R.id.cb_remember);

        btn_login= (Button) findViewById(R.id.btn_login);
        name_clear= (ImageView) findViewById(R.id.name_clear);
        pwd_clear= (ImageView) findViewById(R.id.mima_clear);
        Is_cb_remember_Checked();

        if(pregerences.getBoolean("记住密码",false)){
            cb_remember.setChecked(true);
            String ppwd=AES.decode(pregerences.getString("密码",""));
            username.setText(pregerences.getString("用户名",""));
            userpwd.setText(ppwd);

        }

        String pwd=userpwd.getText().toString();
        if(pwd.length()>0){
            btn_login.setEnabled(true);
            pwd_clear.setVisibility(View.VISIBLE);
            btn_login.setBackground(getResources().getDrawable(R.drawable.login_btn_selector));
        }

        userpwd.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }
             @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }
             @Override
            public void afterTextChanged(Editable editable) {
                String l=editable.toString();
                if(l.length()>0){
                    btn_login.setEnabled(true);
                    pwd_clear.setVisibility(View.VISIBLE);
                    btn_login.setBackground(getResources().getDrawable(R.drawable.login_btn_selector));
                }else{
                    pwd_clear.setVisibility(View.GONE);
                    btn_login.setEnabled(false);
                    btn_login.setBackground(getResources().getDrawable(R.drawable.login_btn_click_before));
                }
            }
        });
        username.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
            String l=editable.toString();
                if(l.length()>0){
                    name_clear.setVisibility(View.VISIBLE);
                }else{
                    name_clear.setVisibility(View.GONE);
                }
            }
        });

        btn_login.setOnClickListener(this);

        name_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                username.setText("");
            }
        });
        pwd_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userpwd.setText("");
            }
        });


     }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                    String name = username.getText().toString();
                    String pwd = userpwd.getText().toString();
                    if (name.matches("1\\d{10}")) {
                        if (pwd.matches("\\w{6,10}")) {
                            netWorkTools=new NetWorkTools();
                            String  pwd1 = AES.encode(pwd);
                            UserParentBean bean=netWorkTools.requestLog(name,pwd1);

                            if(bean.getMessage()==null){
                                if(cb_remember.isChecked()) {
                                    SharedPreferences.Editor editor = pregerences.edit();
                                    editor.putString("用户名", name);
                                    editor.putString("密码", pwd);
                                    editor.commit();
                                    }
                            Intent intent=new Intent(loginActivity.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                            }else{
                                Toast.makeText(loginActivity.this,bean.getMessage().toString(),Toast.LENGTH_SHORT).show();
                       }

                        } else {
                            Toast.makeText(loginActivity.this, "密码必须为6至10为的数字、字母、下划线组合", Toast.LENGTH_SHORT).show();
                            userpwd.setText("");
                        }
                    } else {
                        Toast.makeText(loginActivity.this, "用户名必须为手机号", Toast.LENGTH_SHORT).show();
                        username.setText("");
                        userpwd.setText("");
                            }
                break;

            }

    }
    /*
    * 监听记住密码的事件
    * */
    public void Is_cb_remember_Checked(){
        cb_remember.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(cb_remember.isChecked()){
                    pregerences.edit().putBoolean("记住密码",true).commit();

                }else{
                    pregerences.edit().putBoolean("记住密码",false).commit();
                }
            }
        });
    }


}
//http://192.168.0.158:8080/exj/removte
//用户名或手机号：15932698423 密码：698423