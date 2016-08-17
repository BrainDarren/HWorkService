package com.zdpractice.hworkservice.ui.login;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.zdpractice.hworkservice.R;

/**
 * Created by 15813 on 2016/8/15.
 */

/*
* 未完成记住密码，连服务器查询，文本框清除等功能
* */
public class loginActivity extends AppCompatActivity implements TextWatcher, View.OnClickListener {
    private EditText username;
    private EditText userpwd;
    private CheckBox cb_remember;
    private Button btn_login;
    private ImageView name_clear,pwd_clear;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.lay_login);
        init();
    }

    public void init(){
        username= (EditText) findViewById(R.id.username);
        userpwd= (EditText) findViewById(R.id.userpwd);
        cb_remember= (CheckBox) findViewById(R.id.cb_remember);
        btn_login= (Button) findViewById(R.id.btn_login);
        name_clear= (ImageView) findViewById(R.id.name_clear);
        pwd_clear= (ImageView) findViewById(R.id.mima_clear);
        userpwd.addTextChangedListener(this);
        btn_login.setOnClickListener(this);


    }
/**
 * 根据密码框内有无内容，判定按钮是否可按
 * */
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
            btn_login.setBackground(getResources().getDrawable(R.drawable.login_btn_selector));
        }else{
            btn_login.setEnabled(false);
            btn_login.setBackground(getResources().getDrawable(R.drawable.login_btn_click_before));
        }
    }

    @Override
    public void onClick(View view) {
        String name=username.getText().toString();
        String pwd=userpwd.getText().toString();
        if(name.matches("1\\d{10}")){
            if(pwd.matches("\\\\w{6,10}")){
                //联网判定用户是否否在
            }else{
                Toast.makeText(loginActivity.this,"密码必须为6至10为的数字、字母、下划线组合",Toast.LENGTH_SHORT).show();
                userpwd.setText("");
            }
        }else{
            Toast.makeText(loginActivity.this,"用户名必须为手机号",Toast.LENGTH_SHORT).show();
            username.setText("");
            userpwd.setText("");
        }
    }
}


//http://192.168.0.158:8080/exj/removte
//用户名或手机号：15932698423 密码：698423