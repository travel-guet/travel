package com.example.travel.travel.activity;



import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.travel.travel.R;
import com.example.travel.travel.model.BoatTicket;
import com.example.travel.travel.model.HotelTicket;
import com.example.travel.travel.model.Ticket;
import com.example.travel.travel.model.User;
import com.example.travel.travel.utils.BoatHttpClient;
import com.example.travel.travel.utils.GlobalConstantUtil;
import com.example.travel.travel.utils.SharedPreferencesUtils;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import cz.msebera.android.httpclient.Header;

public class OrderListActivity extends AppCompatActivity implements View.OnClickListener{


//http://localhost:8080/boat/do/site/PhoneController/list?params={%22userId%22:%220FD2573BFC6D4A6B879BD7CA51B8F2EC%22}

    private Button check_order_btn;
    private Button edit_user_info_btn;
    private User user;
    private TextView textView;
    private BoatTicket boatTicket;
    private HotelTicket hotelTicket;
    private Ticket ticket;
    private List<Object> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_list);
        check_order_btn=(Button)findViewById(R.id.check_order);
        textView=(TextView)findViewById(R.id.textView);
        check_order_btn.setOnClickListener(this);
        edit_user_info_btn=(Button)findViewById(R.id.edit_user_info);
        edit_user_info_btn.setOnClickListener(this);
        textView.setOnClickListener(this);
        user=new User();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.check_order:CheckALLOrder();break;
            case R.id.edit_user_info:edit_user_info();break;
        }
    }


    private void CheckALLOrder() {
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
                textView.setText(new String(bytes));
                JsonParsing(new String(bytes));
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
        if(TextUtils.isEmpty(SharedPreferencesUtils.getString(
                OrderListActivity.this, GlobalConstantUtil.USER_ID_FILENAME))){
            Toast.makeText(getApplicationContext(), "请先登录", Toast.LENGTH_LONG).show();
            return;
        }

        params.add("userId",SharedPreferencesUtils.getString(
                OrderListActivity.this, GlobalConstantUtil.USER_ID_FILENAME));
        BoatHttpClient.post_redirect(GlobalConstantUtil.DO + "site/PhoneController/getUsers", params, new AsyncHttpResponseHandler() {

            @Override
            public void onSuccess(int i, Header[] headers, byte[] bytes) {
                //handler.sendMessage(handler.obtainMessage(GlobalConstantUtil.LOGIN_RESULT, new String(bytes)));
                Toast.makeText(getApplicationContext(), new String(bytes), Toast.LENGTH_LONG).show();
                JsontoObject(new String(bytes));
                Toast.makeText(getApplicationContext(), user.toString(), Toast.LENGTH_LONG).show();


            }

            @Override
            public void onFailure(int i, Header[] headers, byte[] bytes, Throwable throwable) {
                Toast.makeText(getApplicationContext(), i+ "获取信息失败", Toast.LENGTH_LONG).show();
                //handler.sendEmptyMessage(0);
            }
        });
    }

    private void CheckHotelBook(){
        RequestParams params = new RequestParams();
        BoatHttpClient.post_redirect(GlobalConstantUtil.DO + "site/PhoneController/hotelList", params, new AsyncHttpResponseHandler() {

            @Override
            public void onSuccess(int i, Header[] headers, byte[] bytes) {
                //handler.sendMessage(handler.obtainMessage(GlobalConstantUtil.LOGIN_RESULT, new String(bytes)));
                Toast.makeText(getApplicationContext(), new String(bytes), Toast.LENGTH_LONG).show();
                JsontoObject(new String(bytes));
                Toast.makeText(getApplicationContext(), user.toString(), Toast.LENGTH_LONG).show();


            }

            @Override
            public void onFailure(int i, Header[] headers, byte[] bytes, Throwable throwable) {
                Toast.makeText(getApplicationContext(), i+ "获取信息失败", Toast.LENGTH_LONG).show();
                //handler.sendEmptyMessage(0);
            }
        });
    }


    private void JsontoObject(String data){
        try {
            JSONObject json=new JSONObject(data);
            user.setLoginName(json.getString("loginName"));
            user.setPassword(json.getString("password"));
            user.setAddress(json.getString("address"));
            user.setName(json.getString("name"));
            user.setTelNumber("telNumber");
            user.setEmail("email");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    private void JsonParsing(String json){
        try {
            String sp=",\\{\"createTime\"";
            String json1=json.substring(1,json.length()-1);
            String []hello=json1.split(sp);
            for(int i=1;i<hello.length;i++){
                hello[i]="{\"createTime\""+hello[i];
                JSONObject jsonn=new JSONObject(hello[i]);
                switch (jsonn.getString("ordersType")){
                    case"1":boatTicket=new BoatTicket();break;
                    case"2":;break;
                    case"3":;break;
                    case"4":;break;
                    case"5":;break;
                    default:break;
                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
