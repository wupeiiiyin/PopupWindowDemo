package com.example.a11369.popupwindowdemo;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;

import java.util.ArrayList;

/**
 * Created by 11369 on 2018/3/25.
 */

public class Grid_but extends BaseAdapter {
    private Context mContext;
    boolean p = false;
    private ArrayList<String> mList;
    private boolean isChice[];
    //    Query_Cardt.DataBean mTypebean;
    private ArrayList<String> list2;

    public Grid_but(Context mContext, ArrayList<String> mList, ArrayList<String> list2) {
        this.mContext = mContext;
        this.mList = mList;
        this.list2 = list2;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.grid_pop, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.gridBut.setText(mList.get(position));
        viewHolder.gridBut.setTextColor(Color.parseColor("#333333"));
        viewHolder.gridBut.setEnabled(false);
//        viewHolder.gridBut.setBackgroundResource(Color.BLUE);
        viewHolder.gridBut.setBackgroundResource(R.drawable.bg_home_search_white);
        for (int j = 0; j < list2.size(); j++) {
            if (mList.get(position).equals(list2.get(j))) {
//        viewHolder.gridBut.findViewById(R.id.bubble)
                viewHolder.gridBut.setTextColor(Color.parseColor("#ffffff"));
                viewHolder.gridBut.setBackgroundResource(R.drawable.bg_button);
//                viewHolder.gridBut.setBackgroundColor(Color.parseColor("#F0F"));
            }
        }

        //传入按钮 跟 标识
//        getView(position, viewHolder.gridBut);
//        chiceState(position);
        return convertView;
    }

    public static class ViewHolder {
        public View rootView;
        public Button gridBut;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.gridBut = (Button) rootView.findViewById(R.id.grid_but);
        }

    }

//    public void chiceState(int position) {
//        //首次更新adapter不做修改
////        p = true;
//        //点击过后判断是 第一次点击还是多次点击
//        isChice[position] = isChice[position] == true ? false : true;
//        //更改 adapter
//        this.notifyDataSetChanged();
//    }


}

