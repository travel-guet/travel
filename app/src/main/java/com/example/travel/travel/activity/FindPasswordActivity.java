package com.example.travel.travel.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.travel.travel.R;

/**
 * Created by a on 2016/10/9.
 * 找回密码
 */
public class FindPasswordActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView find_password_back_image;
    private LinearLayout find_password_title;
    private EditText phone_text;
    private EditText find_password_ver;
    private Button find_password_ver_btn;
    private EditText find_password_new;
    private EditText find_password_confirm;
    private Button find_password__btn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_password);
        this.getSupportActionBar().hide();      //隐藏头部的actionbar

        initView();
    }

    private void initView() {
        find_password_back_image = (ImageView) findViewById(R.id.find_password_back_iv);
        phone_text = (EditText) findViewById(R.id.phone_et);
        find_password_ver = (EditText) findViewById(R.id.find_password_ver_et);
        find_password_ver_btn = (Button) findViewById(R.id.find_password_verify_btn);
        find_password_new = (EditText) findViewById(R.id.find_password_new_et);
        find_password_confirm = (EditText) findViewById(R.id.find_password_confirm_et);
        find_password__btn = (Button) findViewById(R.id.find_password_btn);

        find_password_back_image.setOnClickListener(this);
        find_password_ver_btn.setOnClickListener(this);
        find_password__btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.find_password_back_iv:
                this.finish();         //结束本界面，回到登录界面。
                break;
            case R.id.find_password_verify_btn:

                break;
            case R.id.find_password_btn:
                //找回密码

                this.finish();         //结束本界面，回到登录界面。
                break;
        }
    }

    private void submit() {
        // validate
        String text = phone_text.getText().toString().trim();
        if (TextUtils.isEmpty(text)) {
            Toast.makeText(this, "请输入手机号", Toast.LENGTH_SHORT).show();
            return;
        }

        String ver = find_password_ver.getText().toString().trim();
        if (TextUtils.isEmpty(ver)) {
            Toast.makeText(this, "输入验证码", Toast.LENGTH_SHORT).show();
            return;
        }

        String newp = find_password_new.getText().toString().trim();
        if (TextUtils.isEmpty(newp)) {
            Toast.makeText(this, "请输入新密码", Toast.LENGTH_SHORT).show();
            return;
        }

        String confirm = find_password_confirm.getText().toString().trim();
        if (TextUtils.isEmpty(confirm)) {
            Toast.makeText(this, "确认新密码", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something


    }
}
