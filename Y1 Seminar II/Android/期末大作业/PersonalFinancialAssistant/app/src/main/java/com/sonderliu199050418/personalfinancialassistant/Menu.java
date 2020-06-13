package com.sonderliu199050418.personalfinancialassistant;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;


public class Menu extends AppCompatActivity {

    private static final String TAG = "MenuActivity";

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    //* 选项标题
    public String[] options = new String[]
            {"新增支出", "新增收入",  "数据明细","数据查找" ,"系统设置",  "注销"};

    //* 选项图标
    public int[] icons = new int[]
            {R.drawable.ic_outcome, R.drawable.ic_income,
            R.drawable.ic_datasearch,R.drawable.ic_search, R.drawable.ic_system_settings, R.drawable.ic_exit};

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_activity);


        mLayoutManager = new LinearLayoutManager(Menu.this);
        mAdapter = new OptionsAdapter(options,icons);

        mRecyclerView = findViewById(R.id.options_recycler_view);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);




    }


    private class OptionsAdapter extends RecyclerView.Adapter<OptionViewHolder> {


        private String[] optionTitles;
        private int[] optionIcons;

        public OptionsAdapter(String[] optionTitles, int[] optionIcons) {
            this.optionTitles = optionTitles;
            this.optionIcons = optionIcons;
        }
        public void updateOptions(String[] optionTitles, int[] optionIcons) {
            this.optionTitles = optionTitles;
            this.optionIcons = optionIcons;

            notifyDataSetChanged();
        }

        @NonNull
        @Override
        public OptionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            //* 实例化显示的对象
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.option_view,parent,false);
            //* 实例化 ViewHolder
            return new OptionViewHolder(v);
        }


        @Override
        public void onBindViewHolder(@NonNull OptionViewHolder holder, final int position) {
            //* 绑定数据
                //* 标题 背景图片
            holder.mOptionTitle.setText(optionTitles[position]);

            holder.mOptionIcon.setBackgroundResource(optionIcons[position]);

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //* 对点击进行跳转
                    Intent intent = null;
                    switch (position) {
                        case 0:
                            intent = new Intent(Menu.this, NewExpenditures.class);
                            break;
                        case 1:
                            intent = new Intent(Menu.this, NewIncome.class);
                            break;
                        case 2:
                            intent = new Intent(Menu.this, InformationSummary.class);
                            break;
                        case 3:
                            intent = new Intent(Menu.this, DataSearch.class);
                            break;
                        case 4:
                            intent = new Intent(Menu.this, SystemConfiguration.class);
                            break;
                    }

                    if (intent == null){
                       finish();
                    }else {
                        startActivity(intent);
                    }



                }
            });
        }

        @Override
        public int getItemCount() {
            return optionTitles == null ? 0 : optionTitles.length;
        }


    }


    static class OptionViewHolder extends RecyclerView.ViewHolder {
        private TextView mOptionTitle;
        private ImageView mOptionIcon;

        OptionViewHolder(@NonNull View itemView) {
            super(itemView);
            mOptionTitle = itemView.findViewById(R.id.option_view_text);
            mOptionIcon = itemView.findViewById(R.id.option_view_icon);
        }


    }

    // 对物理按钮的监听
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            finish();
            Intent intent = new Intent(Menu.this, Menu.class);
            startActivity(intent);
        }
        return super.onKeyDown(keyCode, event);
    }




}


