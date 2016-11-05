package com.example.travel.travel.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.travel.travel.R;
import com.example.travel.travel.adapter.RoomAdapter;
import com.example.travel.travel.model.Room;

import java.util.ArrayList;

public class ChooseRoomActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageView back_iv;
    private ImageView find_iv;
    private ImageView room_iv;
    private TextView hotel_address_tv;
    private LinearLayout hotel_address_linear_layout;
    private LinearLayout hotel_comment_linear_layout;
    private TextView check_in_date_tv;
    private TextView check_out_date_tv;
    private ListView room_list_list_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_room);
        initView();

        this.getSupportActionBar().hide();
    }

    private void initView() {
        back_iv = (ImageView) findViewById(R.id.back_iv);
        back_iv.setOnClickListener(this);
        find_iv = (ImageView) findViewById(R.id.find_iv);
        room_iv = (ImageView) findViewById(R.id.room_iv);
        hotel_address_tv = (TextView) findViewById(R.id.hotel_address_tv);
        hotel_address_linear_layout = (LinearLayout) findViewById(R.id.hotel_address_linear_layout);
        hotel_comment_linear_layout = (LinearLayout) findViewById(R.id.hotel_comment_linear_layout);
        check_in_date_tv = (TextView) findViewById(R.id.check_in_date_tv);
        check_out_date_tv = (TextView) findViewById(R.id.check_out_date_tv);

        ArrayList<Room> arrayList = initAdapterDate();
        RoomAdapter adapter = new RoomAdapter(this , R.layout.activity_room_item , arrayList);
        room_list_list_view = (ListView) findViewById(R.id.room_list_list_view);
        room_list_list_view.setAdapter(adapter);
        room_list_list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }

    private ArrayList<Room> initAdapterDate() {

        ArrayList<Room> arrayList = new ArrayList<Room>();

        Room room = new Room(R.mipmap.pic5 , "高级大床房" , 32 , 288);
        Room room1 = new Room(R.mipmap.pic5 , "标准双人间" , 30 , 388);
        Room room2 = new Room(R.mipmap.pic5 , "豪华套间" , 60 , 1099);

        arrayList.add(room);
        arrayList.add(room1);
        arrayList.add(room2);

        return arrayList;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.back_iv:
                finish();
                break;

        }
    }
}
