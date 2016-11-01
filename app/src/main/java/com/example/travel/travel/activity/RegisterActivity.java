package com.example.travel.travel.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.travel.travel.R;
import com.example.travel.travel.utils.BoatHttpClient;
import com.example.travel.travel.utils.GlobalConstantUtil;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

/**
 * Created by a on 2016/10/9.
 * 注册
 */
public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView register_back_image;
    private LinearLayout register_title;
    private EditText register_username;
    private View rpc_1;
    private EditText register_password;
    private View rpc_2;
    private EditText register_password_confirm;
    private View rpc_3;
    private EditText register_phone;
    private View rpc_4;
    private EditText register_veri_num_text;
    private Button veri_btn;
    private View rpc_5;
    private LinearLayout register_verification;
    private Button btn_register;
    private EditText register_name;

    private String username;
    private String password;
    private String confirm;
    private String phone;
    private String name;


    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            try {
                if (msg.what == 1) {
                    JSONObject json = new JSONObject(msg.obj.toString());
                    if (json.getBoolean("state"))
                        Toast.makeText(getApplicationContext(), "注册成功"+json.toString(), Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(getApplicationContext(), "注册失败"+json.toString(), Toast.LENGTH_LONG).show();

                }else if (msg.what == 0) {
                    Toast.makeText(getApplicationContext(), "请检查网络", Toast.LENGTH_LONG).show();
                }
            } catch (Exception e) {

            }
            return;
        }
    };
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        this.getSupportActionBar().hide();      //隐藏头部的actionbar
        initView();
    }

    private void initView() {
        register_back_image = (ImageView) findViewById(R.id.register_back_iv);
        register_title = (LinearLayout) findViewById(R.id.register_title);
        register_username = (EditText) findViewById(R.id.register_username_et);
        rpc_1 = (View) findViewById(R.id.rpc_1);
        register_password = (EditText) findViewById(R.id.register_password_et);
        rpc_2 = (View) findViewById(R.id.rpc_2);
        register_password_confirm = (EditText) findViewById(R.id.register_password_confirm_et);
        rpc_3 = (View) findViewById(R.id.rpc_3);
        register_phone = (EditText) findViewById(R.id.register_phone_et);
        rpc_4 = (View) findViewById(R.id.rpc_4);
        register_name=(EditText)findViewById(R.id.register_name);
//        register_veri_num_text = (EditText) findViewById(R.id.register_verify_num_et);
//        veri_btn = (Button) findViewById(R.id.veri_btn);
//        rpc_5 = (View) findViewById(R.id.rpc_5);
//        register_verification = (LinearLayout) findViewById(R.id.register_verification);
        btn_register = (Button) findViewById(R.id.btn_register);

        register_back_image.setOnClickListener(this);
        veri_btn.setOnClickListener(this);
        btn_register.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.register_back_iv:
                this.finish();      //结束本界面，回到登录界面。
                break;
            case R.id.btn_register:
                //注册代码
                submit();
                SharedPreferences sharedPreferences=getSharedPreferences("userid", Context.MODE_ENABLE_WRITE_AHEAD_LOGGING);
//                Toast.makeText(this, sharedPreferences.getString("userid",null), Toast.LENGTH_SHORT).show();
                //this.finish();      //结束本界面，回到登录界面。
                break;
        }
    }

    private void submit() {
        // validate
        username = register_username.getText().toString().trim();
        if (TextUtils.isEmpty(username)) {
            Toast.makeText(this, "请设置登录名不能为空", Toast.LENGTH_SHORT).show();
            //return;
        }

        password = register_password.getText().toString().trim();
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "请输入密码不能为空", Toast.LENGTH_SHORT).show();
            //return;
        }

        confirm = register_password_confirm.getText().toString().trim();
        if (TextUtils.isEmpty(confirm)) {
            Toast.makeText(this, "确认密码不能为空", Toast.LENGTH_SHORT).show();
            //return;
        }

        phone = register_phone.getText().toString().trim();
        if (TextUtils.isEmpty(phone)) {
            Toast.makeText(this, "联系号码不能为空 ", Toast.LENGTH_SHORT).show();
            //return;
        }
        name=register_name.getText().toString().trim();
        if (TextUtils.isEmpty(name)) {
            Toast.makeText(this, "姓名不能为空 ", Toast.LENGTH_SHORT).show();
            //return;
        }
        if (!password.equals(confirm)) {
            Toast.makeText(this, "两次输入的密码不同", Toast.LENGTH_SHORT).show();
            //return;
        }
//
//        String text = register_veri_num_text.getText().toString().trim();
//        if (TextUtils.isEmpty(text)) {
//            Toast.makeText(this, "输入验证码", Toast.LENGTH_SHORT).show();
//            return;
//        }

        // TODO validate success, do something
        register();

    }
    private void register(){
        RequestParams params = new RequestParams();
        JSONObject json=new JSONObject();
        try {
            json.put("loginName",username);
            json.put("password",password);
            json.put("telNumber",phone);
            json.put("name",name);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        params.put("data",json.toString());
        BoatHttpClient.post_redirect(GlobalConstantUtil.DO + "site/UserRegController/register", params, new AsyncHttpResponseHandler() {

            @Override
            public void onSuccess(int i, Header[] headers, byte[] bytes) {
                handler.sendMessage(handler.obtainMessage(GlobalConstantUtil.LOGIN_RESULT, new String(bytes)));
            }

            @Override
            public void onFailure(int i, Header[] headers, byte[] bytes, Throwable throwable) {
                Toast.makeText(getApplicationContext(), i+ "获取信息失败", Toast.LENGTH_LONG).show();
                //handler.sendEmptyMessage(0);
            }
        });
        //Toast.makeText(getApplicationContext(), json.toString(), Toast.LENGTH_LONG).show();
    }
}
