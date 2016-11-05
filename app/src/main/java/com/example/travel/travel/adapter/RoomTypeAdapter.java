package com.example.travel.travel.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.travel.travel.R;
import com.example.travel.travel.model.RoomType;

import java.util.List;

/**
 * Created by feng on 2016/11/4.
 */

public class RoomTypeAdapter extends ArrayAdapter<RoomType> {

    private Context context;

    private int resourceId;
    private View view;
    private ViewHolder viewHolder;

    public static class ViewHolder {
        public View rootView;
        public TextView room_type_name_tv;
        public CheckBox check_box;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.room_type_name_tv = (TextView) rootView.findViewById(R.id.room_type_name_tv);
            this.check_box = (CheckBox) rootView.findViewById(R.id.check_box);
        }

    }

    public RoomTypeAdapter(Context context, int resource, List<RoomType> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resourceId = resource;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        RoomType roomType = getItem(position);
        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(resourceId , null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);

        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.room_type_name_tv.setText(roomType.getRoomTypeName());
        return view;
    }


}
