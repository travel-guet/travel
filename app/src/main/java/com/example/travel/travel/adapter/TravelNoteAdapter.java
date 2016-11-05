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
import com.example.travel.travel.model.TravelNote;

import java.util.List;

/**
 * Created by feng on 2016/10/31.
 */

public class TravelNoteAdapter extends ArrayAdapter<TravelNote> {

    private Context context;

    private int resourceId;
    private View view;
    private ViewHolder viewHolder;


    public static class ViewHolder {
        public View rootView;
        public ImageView travel_note_iv;
        public TextView travel_note_title_tv;
        public TextView see_people_nums_tv;
        public TextView publish_date_tv;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.travel_note_iv = (ImageView) rootView.findViewById(R.id.travel_note_iv);
            this.travel_note_title_tv = (TextView) rootView.findViewById(R.id.travel_note_title_tv);
            this.see_people_nums_tv = (TextView) rootView.findViewById(R.id.see_people_nums_tv);
            this.publish_date_tv = (TextView) rootView.findViewById(R.id.publish_date_tv);
        }

    }


    public TravelNoteAdapter(Context context, int resource, List<TravelNote> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resourceId = resource;
    }


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        TravelNote travelNote = getItem(position);
        if(convertView == null) {
            view = LayoutInflater.from(context).inflate(resourceId, null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);

        }
        else
        {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.travel_note_iv.setImageResource(travelNote.getImageResourceId());
        viewHolder.travel_note_title_tv.setText(travelNote.getTitle() + "");
        viewHolder.publish_date_tv.setText(travelNote.getPublishDate());

        return view;
    }


}
