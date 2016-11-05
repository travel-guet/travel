package com.example.travel.travel.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.travel.travel.R;
import com.example.travel.travel.model.Hotel;

import java.util.List;

/**
 * Created by feng on 2016/10/31.
 */

public class HotelListAdapter extends ArrayAdapter<Hotel> {

    private Context context;

    private int resourceId;
    private View view;
    private ViewHolder viewHolder;

    public static class ViewHolder {
        public View rootView;
        public ImageView hotel_iv;
        public TextView hotel_name_tv;
        public TextView hotel_address_tv;
        public TextView comment_nums_tv;
        public TextView start_value_tv;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.hotel_iv = (ImageView) rootView.findViewById(R.id.hotel_iv);
            this.hotel_name_tv = (TextView) rootView.findViewById(R.id.hotel_name_tv);
            this.hotel_address_tv = (TextView) rootView.findViewById(R.id.hotel_address_tv);
            this.comment_nums_tv = (TextView) rootView.findViewById(R.id.comment_nums_tv);
            this.start_value_tv = (TextView) rootView.findViewById(R.id.start_value_tv);
        }

    }

    public HotelListAdapter(Context context, int resource, List<Hotel> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resourceId = resource;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Hotel hotel = getItem(position);
        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(resourceId, null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);

        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.hotel_iv.setImageResource(hotel.getResourceId());
        viewHolder.hotel_name_tv.setText(hotel.getHotelName());
        viewHolder.hotel_address_tv.setText(hotel.getHotelAddress());
        viewHolder.comment_nums_tv.setText(hotel.getCommentNums() + "");
        viewHolder.start_value_tv.setText(hotel.getHotelMinStartPrice() + "");


        return view;
    }


}
