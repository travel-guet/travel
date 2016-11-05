package com.example.travel.travel.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.travel.travel.R;
import com.squareup.timessquare.CalendarPickerView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 选择日历控件
 */
public class ChooseLiveDateActivity extends AppCompatActivity implements View.OnClickListener {
    /**
     * Toast
     */
    private static final String TAG = "ChooseLiveDateActivity";
    /**
     * 退出本activity左箭头图片
     */
    private ImageView back_iv;
    /**
     * 日历控件实例
     */
    private CalendarPickerView calendar;
    private Button positive_btn;
    /**入住月份日*/
    private static String checkInDateStr;
    /**入住是星期几*/
    private static String checkInWeekStr;
    /**离店月份日*/
    private static String checkOutDateStr;
    /**离店是星期几*/
    private static String checkOutWeekStr;
    /**居住几天*/
    private static int liveDays = 1;   //默认为居住1天

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_live_date);

        initView();
        getSupportActionBar().hide();

    }

    /**
     * 初始化控件
     */
    private void initView() {
        back_iv = (ImageView) findViewById(R.id.back_iv);
        back_iv.setOnClickListener(this);

        Calendar nextYear = Calendar.getInstance();
        nextYear.add(Calendar.YEAR, 1);  //日历的范围

        calendar = (CalendarPickerView) findViewById(R.id.calendar_view);
        Date today = new Date();
        calendar.init(today, nextYear.getTime())     //日历的最小日期和最大日期
                .inMode(CalendarPickerView.SelectionMode.RANGE); //日历的选择模式


        positive_btn = (Button) findViewById(R.id.positive_btn);
        positive_btn.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.back_iv)    //返回按钮
        {
            this.finish();
        } else if (view.getId() == R.id.positive_btn) {

            //获取用户显示的日期
            List<Date> selectedDates = calendar.getSelectedDates();    //获取选中的日期
            Date checkInDate = null;
            Date checkOutDate = null;
            SimpleDateFormat formatter = new SimpleDateFormat("MM月dd日");
            SimpleDateFormat sdf = new SimpleDateFormat("EEEE");  //周

            liveDays = selectedDates.size() - 1;    //居住几天晚上

            if (selectedDates.size() >= 1) {     //如果选择的日期大于等于1个
                checkInDate = selectedDates.get(0);    //获取入住时间月份日
                this.checkInWeekStr = sdf.format(checkInDate);  //获取入住时间星期几
                this.checkInDateStr = formatter.format(checkInDate);
            }
            if (selectedDates.size() >= 2) {    //如果选择的日期大于等于2个
                checkOutDate = selectedDates.get(selectedDates.size() - 1);   //获取退房时间
                this.checkOutWeekStr = sdf.format(checkOutDate);  //获取入住时间星期几
                this.checkOutDateStr = formatter.format(checkOutDate);
            }

            //对日期的显示形式做处理。
            this.checkInWeekStr = checkInWeekStr.replace("星期" , "周");
            this.checkOutWeekStr = checkOutWeekStr.replace("星期" , "周");

            //回调数据到ChildFragmentReserveHotelAllDay上，显示时间
            Intent intent = new Intent();
            intent.putExtra("checkInDate" , checkInDateStr);
            intent.putExtra("checkOutDate" , checkOutDateStr);
            setResult(RESULT_OK, intent);



            this.finish();
        }
    }

    @Override
    protected void onDestroy() {

        super.onDestroy();
    }


    public static String getCheckInDateStr() {
        return checkInDateStr;
    }

    public static String getCheckInWeekStr() {
        return checkInWeekStr;
    }

    public static String getCheckOutDateStr() {
        return checkOutDateStr;
    }

    public static String getCheckOutWeekStr() {
        return checkOutWeekStr;
    }

    public static void setCheckInDateStr(String checkInDateStr) {
        ChooseLiveDateActivity.checkInDateStr = checkInDateStr;
    }

    public static void setCheckInWeekStr(String checkInWeekStr) {
        ChooseLiveDateActivity.checkInWeekStr = checkInWeekStr;
    }

    public static void setCheckOutDateStr(String checkOutDateStr) {
        ChooseLiveDateActivity.checkOutDateStr = checkOutDateStr;
    }

    public static void setCheckOutWeekStr(String checkOutWeekStr) {
        ChooseLiveDateActivity.checkOutWeekStr = checkOutWeekStr;
    }

    public static int getLiveDays() {
        return liveDays;
    }
}
