package com.example.travel.travel.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.travel.travel.R;
import com.example.travel.travel.adapter.HotelListAdapter;
import com.example.travel.travel.model.Hotel;

import java.util.ArrayList;

public class ChooseHotelActivity extends AppCompatActivity implements View.OnClickListener{

    private ListView hotel_list_list_view;
    private ImageView back_iv;
    private ImageView find_iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_list);
        this.getSupportActionBar().hide();
        initView();


    }

    private void initView() {

        hotel_list_list_view = (ListView) findViewById(R.id.hotel_list_list_view);
        back_iv = (ImageView) findViewById(R.id.back_iv);
        back_iv.setOnClickListener(this);
        find_iv = (ImageView) findViewById(R.id.find_iv);
        find_iv.setOnClickListener(this);

        ArrayList<Hotel> arrayList = initAdapterData();
        HotelListAdapter adapter = new HotelListAdapter(ChooseHotelActivity.this, R.layout.activity_hotel_list_item, arrayList);
        hotel_list_list_view.setAdapter(adapter);
        hotel_list_list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //启动选择房间界面
                Intent intent = new Intent(ChooseHotelActivity.this , ChooseRoomActivity.class);
                startActivity(intent);
            }
        });

    }

    private ArrayList<Hotel> initAdapterData() {
        ArrayList<Hotel> arrayList = new ArrayList<Hotel>();

        Hotel hotel = new Hotel(R.mipmap.pic8, "如家精选酒店（桂林火车站店）", 36, "近桂林火车站，距离市中心3公里", 188);
        Hotel hotel1 = new Hotel(R.mipmap.pic9, "7天便捷酒店", 426, "近桂林火车站，距离市中心3公里", 98);
        Hotel hotel2 = new Hotel(R.mipmap.pic10, "如家精选酒店（桂林火车站店）", 36, "近桂林火车站，距离市中心3公里", 188);
        Hotel hotel3 = new Hotel(R.mipmap.pic11, "如家精选酒店（桂林火车站店）", 36, "近桂林火车站，距离市中心3公里", 188);

        arrayList.add(hotel);
        arrayList.add(hotel1);
        arrayList.add(hotel2);
        arrayList.add(hotel3);
        return arrayList;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.find_iv:
                Intent intent = new Intent(ChooseHotelActivity.this , FindHotelActivity.class);
                startActivity(intent);
                break;
            case R.id.back_iv:
                finish();
                break;
        }

    }
}
