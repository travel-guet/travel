package com.example.travel.travel.activity;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.travel.travel.R;
import com.example.travel.travel.fragment.BaseFragment;
import com.example.travel.travel.fragment.HomeFragment;
import com.example.travel.travel.fragment.PersonalFragment;
import com.example.travel.travel.model.TabEntity;
import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;

import java.util.ArrayList;
import java.util.List;

/**启动界面*/
public class MainActivity extends AppCompatActivity implements PersonalFragment.OnFragmentInteractionListener ,HomeFragment.OnFragmentInteractionListener{


    private CommonTabLayout tabLayout;
    private ViewPager mViewPager;
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
    private String[] mTitles = {"主页" , "旅游团" , "我"};
    private int[] mIconSelectIds = {
            R.mipmap.main_tab_home_pressed  ,
            R.mipmap.main_tab_tour_group_pressed , R.mipmap.main_personal_center_pressed};
    private int[] mIconUnselectIds  = {
            R.mipmap.main_tab_home, R.mipmap.main_tab_tour_group , R.mipmap.main_personal_center };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.getSupportActionBar().hide();
        initView();
    }

    private void initView() {

        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntity(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i]));
        }
        List<BaseFragment> fragments = initFragments();
        FragmentAdapter adapter = new FragmentAdapter(fragments, getSupportFragmentManager());
        mViewPager.setAdapter(adapter);
        mViewPager.addOnPageChangeListener(new PageChangeListener());  //滑动viewPager的时候，tabLayout跟着滑动
        tabLayout = (CommonTabLayout) findViewById(R.id.tab);        //把viewpage控件放在tab上
        tabLayout.setTabData(mTabEntities);
        tabLayout.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                mViewPager.setCurrentItem(position);
            }

            @Override
            public void onTabReselect(int position) {
                if (position == 0) {
                    // tabLayout.showMsg(0, mRandom.nextInt(100) + 1);         //设置提示信息 ，像QQ那种红色提示
//                    UnreadMsgUtils.show(mTabLayout_2.getMsgView(0), mRandom.nextInt(100) + 1);
                }
            }
        });


    }

    /**
     * 主页，旅游团，个人中心Fragment的ViewPager的监听器
     * 当ViewPager中页面的状态发生改变时调用
     */
    class PageChangeListener implements ViewPager.OnPageChangeListener
    {

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            tabLayout.setCurrentTab(position);
        }

        @Override
        public void onPageScrollStateChanged(int state) {
        }
    }

    private List<BaseFragment> initFragments() {
        List<BaseFragment> fragments = new ArrayList<BaseFragment>();

        BaseFragment homeFragment = new HomeFragment();
        fragments.add(homeFragment);

        /*BaseFragment operateFragment = new TourGroupFragment();
        fragments.add(operateFragment);*/

        BaseFragment noteFragment = new PersonalFragment();
        fragments.add(noteFragment);

        return fragments;
    }


    class FragmentAdapter extends FragmentPagerAdapter {
        private List<BaseFragment> mFragments;

        public FragmentAdapter(List<BaseFragment> fragments, FragmentManager fm) {
            super(fm);
            mFragments = fragments;
        }

        @Override
        public Fragment getItem(int i)
        {
            return mFragments.get(i);
        }


        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragments.get(position).getTitle();
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
