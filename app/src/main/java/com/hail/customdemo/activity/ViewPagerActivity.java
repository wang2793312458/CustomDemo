package com.hail.customdemo.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.GridView;
import android.widget.RadioButton;

import com.hail.customdemo.R;
import com.hail.customdemo.adapter.GridViewAdapter;
import com.hail.customdemo.adapter.MyViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ViewPagerActivity extends AppCompatActivity {
    private GridView gridViewFirst;
    private GridView gridViewSecond;
    private GridView gridViewThird;

    @BindView(R.id.index_home_viewpager)
    ViewPager viewPager;
    @BindView(R.id.index_home_rb1)
    RadioButton rbFirst;
    @BindView(R.id.index_home_rb2)
    RadioButton rbSecond;
    @BindView(R.id.index_home_rb3)
    RadioButton rbThird;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        ButterKnife.bind(this);
        initGridView();
        initViewPager();
    }

    //动态添加gridview
    private void initGridView() {
        gridViewFirst = (GridView) LayoutInflater.from(this).inflate(R.layout.activity_viewpager_gridview, null);
        gridViewFirst.setAdapter(new GridViewAdapter(this, 0));
        gridViewSecond = (GridView) LayoutInflater.from(this).inflate(R.layout.activity_viewpager_gridview, null);
        gridViewSecond.setAdapter(new GridViewAdapter(this, 1));
        gridViewThird = (GridView) LayoutInflater.from(this).inflate(R.layout.activity_viewpager_gridview, null);
        gridViewThird.setAdapter(new GridViewAdapter(this, 2));
    }

    /**
     * //初始化viewpager
     */
    private void initViewPager() {
        List<View> listGridView = new ArrayList<>();//以下实现动态添加三组gridview
        listGridView.add(gridViewFirst);
        listGridView.add(gridViewSecond);
        listGridView.add(gridViewThird);
        viewPager.setAdapter(new MyViewPagerAdapter(listGridView));
        rbFirst.setChecked(true);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (position == 0) {
                    rbFirst.setChecked(true);
                } else if (position == 1) {
                    rbSecond.setChecked(true);
                } else if (position == 2) {
                    rbThird.setChecked(true);
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
