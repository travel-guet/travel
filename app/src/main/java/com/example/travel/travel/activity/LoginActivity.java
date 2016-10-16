package com.example.travel.travel.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.travel.travel.R;

/**
 * 登录
 * */
public class LoginActivity extends AppCompatActivity implements View.OnClickListener {


    private ImageView login_back_image;
    private LinearLayout login_title;
    private EditText login_username;
    private View lpc_1;
    private EditText login_password;
    private View lpc_2;
    private Button btn_login;
    private TextView login_forget_text;
    private TextView login_register_text;
    private LinearLayout login_question;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        this.getSupportActionBar().hide();      //隐藏头部的actionbar
        initView();

    }


    private void initView() {
        login_back_image = (ImageView) findViewById(R.id.login_back_iv);
        login_username = (EditText) findViewById(R.id.login_username_et);
        lpc_1 = (View) findViewById(R.id.lpc_1);
        login_password = (EditText) findViewById(R.id.login_password);
        lpc_2 = (View) findViewById(R.id.lpc_2);
        btn_login = (Button) findViewById(R.id.login_btn);
        login_forget_text = (TextView) findViewById(R.id.login_forget_tv);
        login_register_text = (TextView) findViewById(R.id.login_register_tv);
        login_question = (LinearLayout) findViewById(R.id.login_question);

        login_back_image.setOnClickListener(this);
        btn_login.setOnClickListener(this);
        login_forget_text.setOnClickListener(this);
        login_register_text.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_back_iv:

                break;
            case R.id.login_btn:


                break;
            case R.id.login_forget_tv:
                Intent findpassword = new Intent(LoginActivity.this , FindPasswordActivity.class);
                startActivity( findpassword);
                break;
            case R.id.login_register_tv:
                Intent register = new Intent(LoginActivity.this , RegisterActivity.class);
                startActivity( register);
                break;
        }
    }

    private void submit() {
        // validate
        String username = login_username.getText().toString().trim();
        if (TextUtils.isEmpty(username)) {
            Toast.makeText(this, "请输入账号", Toast.LENGTH_SHORT).show();
            return;
        }

        String password = login_password.getText().toString().trim();
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something


    }
}
