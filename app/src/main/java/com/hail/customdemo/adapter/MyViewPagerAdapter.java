package com.hail.customdemo.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by 小智
 * on 2017/8/1
 * 描述：
 */

public class MyViewPagerAdapter extends PagerAdapter {
    List<View> list;

    public MyViewPagerAdapter(List<View> list) {
        // TODO Auto-generated constructor stub
        this.list = list;
    }

    /**
     * 获取当前要显示对象的数量
     */
    @Override
    public int getCount() {
        return list.size();
    }

    //  判断  当前的view 是否是  Object 对象,判断是否用对象生成界面
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    /**
     * 当前要显示的对象（图片）
     */
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(list.get(position));
        return list.get(position);
    }

    /**
     * 从ViewGroup中移除当前对象（图片）
     */
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(list.get(position));
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "1";
    }
}
