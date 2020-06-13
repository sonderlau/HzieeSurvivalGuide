package com.sonderliu199050418.personalfinancialassistant;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.sonderliu199050418.personalfinancialassistant.Database.UserSearch;
import com.sonderliu199050418.personalfinancialassistant.Model.User;


import java.util.ArrayList;
import java.util.List;

public class InformationSummary extends AppCompatActivity {

    private UserSearch mUserSearch;
    private LinearLayout GlobalLinearLayout;
    private Button button_Back;
    private TextView information_number_textView;
    private RadioButton money_source_income;
    private TabLayout tabLayout;
    private ViewPager2 viewpager;
    private List<String> evenList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.showinfo);

        //?

        tabLayout = findViewById(R.id.tab_layout);
        viewpager = findViewById(R.id.pager);
        evenList.add("0");
        evenList.add("1");

//        正常的用法
        viewpager.setAdapter(new InformationAdapter(InformationSummary.this, evenList));

//        TabLayout和ViewPager的绑定
        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(tabLayout, viewpager, (tab, position) -> tab.setText(position == 0 ? "支出" : "收入"));
        tabLayoutMediator.attach();


        //?

        mUserSearch = new UserSearch(this);
        button_Back = findViewById(R.id.back);
        GlobalLinearLayout = findViewById(R.id.ShowInfo);

        information_number_textView = findViewById(R.id.information_number);

//        RadioGroup radioGroup = findViewById(R.id.ratio_button_money_source);
//        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//
//                GlobalLinearLayout.removeViewInLayout(findViewById(R.id.info_view));
//                changeSearchResult();
//            }
//        });
//
//        money_source_income = findViewById(R.id.source_income);


//        button_Back.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                finish();
//                Intent intent = new Intent(InformationSummary.this, Menu.class);
//                startActivity(intent);
//            }
//        });
    }


    // 对物理按钮的监听
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            finish();
            Intent intent = new Intent(InformationSummary.this, Menu.class);
            startActivity(intent);
        }
        return super.onKeyDown(keyCode, event);
    }



}



