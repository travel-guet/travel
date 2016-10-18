package com.example.travel.travel.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.travel.travel.R;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

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
    private String BoatUrl = "http://172.29.150.1:8080/boat/do/";
    private String jsondata=null;
    private String username;
    private String password;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 1) {
                Toast.makeText(getApplicationContext(), "登录成功", Toast.LENGTH_LONG).show();
                //tv.setText(datas);
            }
            if (msg.what == 0) {
                Toast.makeText(getApplicationContext(), "请检查网络", Toast.LENGTH_LONG).show();
            }
        }
    };

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
                submit(); //登录
                          //跳转页面
                          //写入cookie
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
        username = login_username.getText().toString().trim();
        if (TextUtils.isEmpty(username)) {
            Toast.makeText(this, "请输入账号", Toast.LENGTH_SHORT).show();
            return;
        }

        password = login_password.getText().toString().trim();
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something
        Runnable r = new Runnable() {
            @Override
            public void run() {
                Login(username, password);
            }
        };
        new Thread(r).start();

    }

    private boolean Login(String name, String passwd) {
        try {

            URL url = new URL(BoatUrl + "loginForm/checkValidate1");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();


            conn.setConnectTimeout(5000);
            conn.setRequestMethod("POST");

            StringBuilder data=new StringBuilder();
            data.append("username=").append(URLEncoder.encode(name,"utf-8")).append("&");
            data.append("password=").append(passwd).append("&");
            data.append("client=").append("i");
            byte[] entity=data.toString().getBytes();

            conn.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
            conn.setRequestProperty("Content-Length",entity.length+"");
            conn.setDoOutput(true);
            OutputStream os = conn.getOutputStream();
            //    os.write(entity);
            if(conn.getResponseCode()==200){
                InputStream is=conn.getInputStream();
                byte [] rep=new byte[1024];
                jsondata="";
                while(is.read(rep)!=-1){
                    jsondata=jsondata+new String(rep,0,rep.length);
                }
                handler.sendEmptyMessage(1);
                return true;
            } else{
                Log.v("shfkhshfkdsdshklfsss",conn.getResponseCode()+"");
                handler.sendEmptyMessage(0);
            }


//            cookieval=conn.getHeaderField("set-cookie");
//            if(cookieval!=null)
//            {
//                sessionid=cookieval.substring(0,cookieval.indexOf(";"));
//            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
