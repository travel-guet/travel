package com.example.travel.travel.activity;



import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.travel.travel.R;
import com.example.travel.travel.utils.BoatHttpClient;
import com.example.travel.travel.utils.GlobalConstantUtil;
import com.example.travel.travel.utils.SharedPreferencesUtils;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class OrderListActivity extends AppCompatActivity implements View.OnClickListener{




    private Button check_order_btn;
    private Button edit_user_info_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_list);
        check_order_btn=(Button)findViewById(R.id.check_order);
        check_order_btn.setOnClickListener(this);
        edit_user_info_btn=(Button)findViewById(R.id.edit_user_info);
        edit_user_info_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.check_order:CheckOrder();break;
            case R.id.edit_user_info:edit_user_info();break;
        }
    }


    private void CheckOrder() {
        RequestParams params = new RequestParams();
        JSONObject json=new JSONObject();
        try {
            json.put("userId", SharedPreferencesUtils.getString(
                    OrderListActivity.this, GlobalConstantUtil.USER_ID_FILENAME));
            json.put("ordersType","1");
            json.put("ordersState","");
            json.put("customerName","");
            json.put("ordersNumber","");
            json.put("ticketName","");
            json.put("timeStart","");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        params.put("params",json.toString());
        BoatHttpClient.post_redirect(GlobalConstantUtil.DO + "site/PhoneController/list", params, new AsyncHttpResponseHandler() {

            @Override
            public void onSuccess(int i, Header[] headers, byte[] bytes) {
                //handler.sendMessage(handler.obtainMessage(GlobalConstantUtil.LOGIN_RESULT, new String(bytes)));
                Toast.makeText(getApplicationContext(), new String(bytes), Toast.LENGTH_LONG).show();

            }

            @Override
            public void onFailure(int i, Header[] headers, byte[] bytes, Throwable throwable) {
                Toast.makeText(getApplicationContext(), i+ "获取信息失败", Toast.LENGTH_LONG).show();
                //handler.sendEmptyMessage(0);
            }
        });
    }
    private void edit_user_info(){
        RequestParams params = new RequestParams();
        params.add("userId",SharedPreferencesUtils.getString(
                OrderListActivity.this, GlobalConstantUtil.USER_ID_FILENAME));
        BoatHttpClient.post_redirect(GlobalConstantUtil.DO + "site/PhoneController/getUsers", params, new AsyncHttpResponseHandler() {

            @Override
            public void onSuccess(int i, Header[] headers, byte[] bytes) {
                //handler.sendMessage(handler.obtainMessage(GlobalConstantUtil.LOGIN_RESULT, new String(bytes)));
                Toast.makeText(getApplicationContext(), new String(bytes), Toast.LENGTH_LONG).show();

            }

            @Override
            public void onFailure(int i, Header[] headers, byte[] bytes, Throwable throwable) {
                Toast.makeText(getApplicationContext(), i+ "获取信息失败", Toast.LENGTH_LONG).show();
                //handler.sendEmptyMessage(0);
            }
        });
    }
    private void JsontoObject(String json){

    }
}
