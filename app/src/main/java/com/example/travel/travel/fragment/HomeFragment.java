package com.example.travel.travel.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.travel.travel.R;
import com.example.travel.travel.activity.ChooseHotelActivity;
import com.example.travel.travel.adapter.TravelNoteAdapter;
import com.example.travel.travel.customview.ImageCycleView;
import com.example.travel.travel.model.TravelNote;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends BaseFragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    private ImageCycleView mImageCycleView;
    private TextView home_tv;
    private ImageCycleView image_circle_view_pager;
    private LinearLayout parkland_ticket_linear_layout;
    private LinearLayout tour_guide_reserve_linear_layout;
    private LinearLayout inside_city_reserve_ticket_linear_layout;
    private LinearLayout route_reserve_linear_layout;
    private LinearLayout hotel_reserve_linear_layout;
    private ListView travel_note_list_view;
    private LinearLayout two_river_four_lake_boat_ticket_linear_layout;


    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        showImageCircleView(view);   //显示轮播图


        initView(view);
        return view;
    }

    private void showImageCircleView(View view) {

        mImageCycleView = (ImageCycleView) view.findViewById(R.id.image_circle_view_pager);
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
        list.add(new ImageCycleView.ImageInfo(R.mipmap.pic1, "", ""));
        list.add(new ImageCycleView.ImageInfo(R.mipmap.pic2, "", ""));
        list.add(new ImageCycleView.ImageInfo(R.mipmap.pic3, "", ""));

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
                ImageView imageView = new ImageView(getActivity());
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

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    private void initView(View view) {

        home_tv = (TextView) view.findViewById(R.id.home_tv);
        image_circle_view_pager = (ImageCycleView) view.findViewById(R.id.image_circle_view_pager);
        parkland_ticket_linear_layout = (LinearLayout) view.findViewById(R.id.parkland_ticket_linear_layout);
        tour_guide_reserve_linear_layout = (LinearLayout) view.findViewById(R.id.tour_guide_reserve_linear_layout);
        inside_city_reserve_ticket_linear_layout = (LinearLayout) view.findViewById(R.id.inside_city_reserve_ticket_linear_layout);
        route_reserve_linear_layout = (LinearLayout) view.findViewById(R.id.route_reserve_linear_layout);
        hotel_reserve_linear_layout = (LinearLayout) view.findViewById(R.id.hotel_reserve_linear_layout);
        two_river_four_lake_boat_ticket_linear_layout = (LinearLayout) view.findViewById(R.id.two_river_four_lake_boat_ticket_linear_layout);
        travel_note_list_view = (ListView) view.findViewById(R.id.travel_note_list_view);

        hotel_reserve_linear_layout.setOnClickListener(this);
        parkland_ticket_linear_layout.setOnClickListener(this);
        tour_guide_reserve_linear_layout.setOnClickListener(this);
        route_reserve_linear_layout.setOnClickListener(this);
        inside_city_reserve_ticket_linear_layout.setOnClickListener(this);
        two_river_four_lake_boat_ticket_linear_layout.setOnClickListener(this);

        ArrayList<TravelNote> arrayList = initAdapterData();    //初始化adapter数据
        TravelNoteAdapter adapter = new TravelNoteAdapter(this.getActivity() , R.layout.travel_note_list_view_item , arrayList);
        travel_note_list_view.setAdapter(adapter);
    }


    /**初始化游记的数据列表*/
    private ArrayList<TravelNote> initAdapterData() {

        ArrayList<TravelNote> arrayList = new ArrayList<TravelNote>();
        TravelNote travelNote = new TravelNote(R.mipmap.pic6 , "绝美风景观赏地！从日月双塔窥探桂林风景文化" , 150 , "2016-10-28");
        TravelNote travelNote1 = new TravelNote(R.mipmap.pic5 , "十家超高人气酒店推荐！" , 150 , "2016-9-28");

        arrayList.add(travelNote);
        arrayList.add(travelNote);

        return arrayList;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.hotel_reserve_linear_layout:
                //进入酒店界面
                Intent intent = new Intent(this.getActivity() , ChooseHotelActivity.class);
                startActivity(intent);
                break;
        }
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
