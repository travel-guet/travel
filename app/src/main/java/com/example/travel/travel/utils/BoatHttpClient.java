package com.example.travel.travel.utils;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

/**
 * Created by yue on 2016/10/18.
 */

public class BoatHttpClient {
    private static final String BASE_URL="http://192.168.43.125:8080/boat";
    private static AsyncHttpClient client=new AsyncHttpClient();

    public static void get(String url, RequestParams params, AsyncHttpResponseHandler responseHandler){
        client.get(url,params,responseHandler);
    }
    public static void post(String url,RequestParams params,AsyncHttpResponseHandler responseHandler){
        client.post(url,params,responseHandler);
    }
    public static void post_redirect(String url, RequestParams params, AsyncHttpResponseHandler responseHandler){
        client.setEnableRedirects(true,true,true);
        client.post(url,params,responseHandler);
    }
}


