package com.example.travel.travel.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.travel.travel.R;
import com.example.travel.travel.adapter.RoomTypeAdapter;
import com.example.travel.travel.customview.ImageCycleView;
import com.example.travel.travel.model.RoomType;

import java.util.ArrayList;
import java.util.List;

public class FindHotelActivity extends AppCompatActivity implements View.OnClickListener {

    private static final java.lang.String TAG = "FindHotelActivity" ;
    private ImageCycleView mImageCycleView;
    private ImageView back_iv;
    private ImageCycleView image_circle_view_pager;
    private EditText query_condition_et;
    private TextView check_in_tv;
    private TextView live_days_tv;
    private TextView check_out_tv;
    private Spinner choose_room_type_spinner;
    private Button find_btn;
    private Spinner spinner;
    private TextView room_type_tv;
    private LinearLayout room_type_linear_layout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_hotel);
        initView();
        this.getSupportActionBar().hide();

        showImageCircleView();   //显示轮播图

    }


    private void showImageCircleView() {

        mImageCycleView = (ImageCycleView) findViewById(R.id.image_circle_view_pager);
//		mImageCycleView.setAutoCycle(false); //关闭自动播放
//		mImageCycleView.setCycleDelayed(2000);//设置自动轮播循环时间
//
//		mImageCycleView.setIndicationStyle(ImageCycleView.IndicationStyle.COLOR,
//				Color.BLUE, Color.RED, 1f);

//		mImageCycleView.setIndicationStyle(ImageCycleView.IndicationStyle.IMAGE,
//				R.drawable.dian_unfocus, R.drawable.dian_focus, 1f);

//		Log.e("eee", Environment.getExternalStorageDirectory().getPath()+ File.separator+"a1.jpg");

        List<ImageCycleView.ImageInfo> list = new ArrayList<ImageCycleView.ImageInfo>();

        //res图片资源
        list.add(new ImageCycleView.ImageInfo(R.mipmap.pic8, "", ""));
        list.add(new ImageCycleView.ImageInfo(R.mipmap.pic9, "", ""));
        list.add(new ImageCycleView.ImageInfo(R.mipmap.pic10, "", ""));

        //SD卡图片资源
//		list.add(new ImageCycleView.ImageInfo(new File(Environment.getExternalStorageDirectory(),"a1.jpg"),"11111",""));
//		list.add(new ImageCycleView.ImageInfo(new File(Environment.getExternalStorageDirectory(),"a2.jpg"),"22222",""));
//		list.add(new ImageCycleView.ImageInfo(new File(Environment.getExternalStorageDirectory(),"a3.jpg"),"33333",""));


        //使用网络加载图片
//		list.add(new ImageCycleView.ImageInfo("http://img.lakalaec.com/ad/57ab6dc2-43f2-4087-81e2-b5ab5681642d.jpg","11","eeee"));
//		list.add(new ImageCycleView.ImageInfo("http://img.lakalaec.com/ad/cb56a1a6-6c33-41e4-9c3c-363f4ec6b728.jpg","222","rrrr"));
//		list.add(new ImageCycleView.ImageInfo("http://img.lakalaec.com/ad/e4229e25-3906-4049-9fe8-e2b52a98f6d1.jpg", "333", "tttt"));

//		mImageCycleView.setOnPageClickListener(new ImageCycleView.OnPageClickListener() {
//			@Override
//			public void onClick(View imageView, ImageCycleView.ImageInfo imageInfo) {
//				Toast.makeText(MainActivity.this, "你点击了" + imageInfo.value.toString(), Toast.LENGTH_SHORT).show();
//			}
//		});

        mImageCycleView.loadData(list, new ImageCycleView.LoadImageCallBack() {
            @Override
            public ImageView loadAndDisplay(ImageCycleView.ImageInfo imageInfo) {

                //本地图片
                ImageView imageView = new ImageView(FindHotelActivity.this);
                imageView.setImageResource(Integer.parseInt(imageInfo.image.toString()));
                return imageView;


//				//使用SD卡图片
//				SmartImageView smartImageView=new SmartImageView(MainActivity.this);
//				smartImageView.setImageURI(Uri.fromFile((File)imageInfo.image));
//				return smartImageView;

//				//使用SmartImageView，既可以使用网络图片也可以使用本地资源
//				SmartImageView smartImageView=new SmartImageView(MainActivity.this);
//				smartImageView.setImageResource(Integer.parseInt(imageInfo.image.toString()));
//				return smartImageView;

                //使用BitmapUtils,只能使用网络图片
//				BitmapUtils bitmapUtils = new BitmapUtils(MainActivity.this);
//				ImageView imageView = new ImageView(MainActivity.this);
//				bitmapUtils.display(imageView, imageInfo.image.toString());
//				return imageView;


            }
        });

    }

    private void initView() {

        back_iv = (ImageView) findViewById(R.id.back_iv);
        back_iv.setOnClickListener(this);
        image_circle_view_pager = (ImageCycleView) findViewById(R.id.image_circle_view_pager);
        query_condition_et = (EditText) findViewById(R.id.query_condition_et);
        check_in_tv = (TextView) findViewById(R.id.check_in_tv);
        check_in_tv.setOnClickListener(this);
        live_days_tv = (TextView) findViewById(R.id.live_days_tv);
        check_out_tv = (TextView) findViewById(R.id.check_out_tv);
        check_out_tv.setOnClickListener(this);

       /* choose_room_type_spinner = (Spinner) findViewById(R.id.choose_room_type_spinner);   //房间类型选择下拉列表
        spinner = (Spinner) findViewById(R.id.choose_room_type_spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item); //系统sdk里面的R文件
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter.add("房间类型");
        adapter.add("单人间");
        adapter.add("双人间/标准间");
        adapter.add("三人房");
        adapter.add("大床房");
        adapter.add("套间");
        adapter.add("商务间");
        spinner.setAdapter(adapter);*/


        find_btn = (Button) findViewById(R.id.find_btn);
        find_btn.setOnClickListener(this);

        room_type_tv = (TextView) findViewById(R.id.room_type_tv);
        room_type_linear_layout = (LinearLayout) findViewById(R.id.room_type_linear_layout);
        room_type_linear_layout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.find_btn:     //查询酒店按钮
                Toast.makeText(this , "查询成功" , Toast.LENGTH_SHORT).show();
                finish();
                break;
            case R.id.back_iv:      //返回上一步按钮
                finish();
                break;
            case R.id.room_type_linear_layout:          //房间类型选择按钮
                Log.e(TAG , "运行到这里");
                //显示选择房间类型对话框
                showChooseRoomDialog();
                break;
            case R.id.check_in_tv:
                Intent intent = new Intent(FindHotelActivity.this , ChooseLiveDateActivity.class);
                startActivity(intent);
                break;
        }
    }

    /**
     *显示选择房间类型对话框
     * */
    private void showChooseRoomDialog() {

        View view = LayoutInflater.from(this).inflate(R.layout.dialog_room_type , null);
        ListView listView = (ListView) view.findViewById(R.id.room_type_list_view);
        ArrayList<RoomType> arrayList = initAdapterData();
        RoomTypeAdapter adapter = new RoomTypeAdapter(FindHotelActivity.this , R.layout.dialog_room_type_item , arrayList);
        listView.setAdapter(adapter);
        AlertDialog.Builder dialog = new AlertDialog.Builder(FindHotelActivity.this);
        dialog.setView(view);
        dialog.setCancelable(true);
        dialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        dialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        dialog.show();

    }

    private ArrayList<RoomType> initAdapterData() {

        ArrayList<RoomType> arrayList = new ArrayList<RoomType>();

        RoomType roomType = new RoomType("单人间");
        RoomType roomType1 = new RoomType("双人间/标准间");
        RoomType roomType2 = new RoomType("三人房");
        RoomType roomType3 = new RoomType("大床房");
        RoomType roomType4 = new RoomType("套间");
        RoomType roomType5 = new RoomType("商务间");

        arrayList.add(roomType);
        arrayList.add(roomType1);
        arrayList.add(roomType2);
        arrayList.add(roomType3);
        arrayList.add(roomType4);
        arrayList.add(roomType5);

        return  arrayList;
    }

    private void submit() {
        // validate
        String et = query_condition_et.getText().toString().trim();
        if (TextUtils.isEmpty(et)) {
            Toast.makeText(this, "请输入酒店名称/品牌", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something


    }
}
