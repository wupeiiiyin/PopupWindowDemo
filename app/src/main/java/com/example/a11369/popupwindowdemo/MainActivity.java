package com.example.a11369.popupwindowdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> str;
    private ArrayList<String> card;
    private MyGridView grid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        initAdapter();


    }

    private void initAdapter() {
        final Grid_but grid_but = new Grid_but(this, str, card);
        grid.setAdapter(grid_but);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.e("TAG", "onItemClick: 点击了第" + i + "个条目");
                card.add("分组" + i);
                grid_but.notifyDataSetChanged();
            }
        });
//        ListView listView = new ListView(this);
//        listView.setItemsCanFocus(true);
//        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);//可多选
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
//                android.R.layout.simple_list_item_single_choice, str);
//        listView.setAdapter(adapter);
//        setContentView(listView);
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Log.e("TAG", "onItemClick: 点击了第"+i+"个条目" );
//            }
//        });
    }

    private void initData() {
        str = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            str.add("分组" + i);
        }
        card = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            card.add("分组" + i);
        }
    }

    private void initView() {
        grid = (MyGridView) findViewById(R.id.grid);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }
}
