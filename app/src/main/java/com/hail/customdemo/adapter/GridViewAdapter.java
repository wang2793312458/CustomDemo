package com.hail.customdemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.hail.customdemo.R;
import com.hail.customdemo.data.MyGridViewData;

import butterknife.ButterKnife;

/**
 * Created by 小智
 * on 2017/8/1
 * 描述：
 */

public class GridViewAdapter extends BaseAdapter {
    //数据在MyConstant中定义好了
    private LayoutInflater inflater;
    private int page;
    private Context context;
    public GridViewAdapter(Context context, int page) {
        super();
        this.inflater = LayoutInflater.from(context);
        this.page = page;
        this.context=context;
    }

    @Override
    public int getCount() {
        if (page != -1) {
            return 8;
        } else {
            return MyGridViewData.navSort.length;
        }
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView==null){
            viewHolder=new ViewHolder();
            convertView=inflater.inflate(R.layout.activity_viewpager_gridview_item,null);
            viewHolder.iv_navsort=(ImageView)convertView.findViewById(R.id.index_home_iv_navsort);
            viewHolder.tv_navsort=(TextView) convertView.findViewById(R.id.index_home_tv_navsort);
            ButterKnife.bind(viewHolder,convertView);
            convertView.setTag(viewHolder);
        }else {
            viewHolder= (ViewHolder) convertView.getTag();
        }
        viewHolder.iv_navsort.setImageResource(MyGridViewData.navSortImages[position+8*page]);
        viewHolder.tv_navsort.setText(MyGridViewData.navSort[position+8*page]);


        //在这里处理gridview每个icon的逻辑，跳转activity
        if(position==8-1 && page==2){
            viewHolder.iv_navsort.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View arg0) {
                    Toast.makeText(context, "text>>>"+MyGridViewData.navSort[position+8*page], Toast.LENGTH_SHORT).show();
                }
            });
        }else{
            viewHolder.iv_navsort.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View arg0) {
                    // TODO Auto-generated method stub
                    Toast.makeText(context, "else   text>>>"+MyGridViewData.navSort[position+8*page], Toast.LENGTH_SHORT).show();
                }
            });
        }
        return convertView;
    }

    //gridview 适配器的holder类
    class ViewHolder {
        public ImageView iv_navsort;
        public TextView tv_navsort;
    }
}
