package com.example.travel.travel.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ScrollView;

/**
 * Created by a on 2016/10/13.
 * 这个类暂时没用，activity_register.xml中没有用自定义控件，而是用系统的Scrollview控件，
 * */
public class Register_ScrollView extends ScrollView {
    GestureDetector gestureDetector;

    public void setGestureDetector(GestureDetector gestureDetector) {
        this.gestureDetector = gestureDetector;
    }


    public Register_ScrollView(Context context) {
        super(context);
    }

    public Register_ScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Register_ScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        gestureDetector.onTouchEvent(ev);
        super.onTouchEvent(ev);
        return true;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        gestureDetector.onTouchEvent(ev);
        super.dispatchTouchEvent(ev);
        return true;
    }
}
