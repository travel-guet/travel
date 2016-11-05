package com.example.travel.travel.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.travel.travel.R;
import com.example.travel.travel.model.Room;

import java.util.List;

/**
 * Created by feng on 2016/11/4.
 */

public class RoomAdapter extends ArrayAdapter<Room> {

    private Context context;

    private int resourceId;
    private View view;
    private ViewHolder viewHolder;


    public static class ViewHolder {
        public View rootView;
        public ImageView room_iv;
        public TextView room_type_name_tv;
        public TextView room_area_tv;
        public TextView start_value_tv;
        public Button reserve_btn;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.room_iv = (ImageView) rootView.findViewById(R.id.room_iv);
            this.room_type_name_tv = (TextView) rootView.findViewById(R.id.room_type_name_tv);
            this.room_area_tv = (TextView) rootView.findViewById(R.id.room_area_tv);
            this.start_value_tv = (TextView) rootView.findViewById(R.id.start_value_tv);
            this.reserve_btn = (Button) rootView.findViewById(R.id.reserve_btn);
            reserve_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                }
            });
        }

    }

    public RoomAdapter(Context context, int resource, List<Room> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resourceId = resource;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Room room = getItem(position);
        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(resourceId , null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);

        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.room_type_name_tv.setText(room.getRoomTypeName());
        viewHolder.room_area_tv.setText(room.getArea() + "");
        viewHolder.start_value_tv.setText(room.getStartValue() + "");
        return view;
    }


}
