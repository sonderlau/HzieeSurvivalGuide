package com.sonderliu199050418.personalfinancialassistant;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.service.autofill.Dataset;
import android.text.InputType;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.sonderliu199050418.personalfinancialassistant.Database.DBOpenHelper;
import com.sonderliu199050418.personalfinancialassistant.Database.UserSearch;
import com.sonderliu199050418.personalfinancialassistant.Model.User;

import java.util.ArrayList;

public class DataSearch extends AppCompatActivity {

    private static final String TAG = "DataSearch";
    private EditText yearValue;
    private EditText monthValue;
    private EditText dayValue;

    private Button searchButton;

    private RadioButton source;

    private RadioGroup searchBy;

    private LinearLayout GlobalLinearLayout;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_search);

        //* 通过按钮切换输入内容
        yearValue = findViewById(R.id.search_year);
        monthValue = findViewById(R.id.search_month);
        dayValue = findViewById(R.id.search_day);

        source = findViewById(R.id.radio_button_search_type);

        searchButton = findViewById(R.id.button_search);

        GlobalLinearLayout = findViewById(R.id.search_global_layout);

        searchBy = findViewById(R.id.search_radio_group);
        ScrollView scrollView = findViewById(R.id.data_scroll_view);

        //* 初始情况
        setEditTextEditable(false,monthValue);
        setEditTextEditable(false,dayValue);

        searchBy.setOnCheckedChangeListener((group, checkedId) -> {
            Log.d(TAG, "onCreate: " + checkedId);
            switch (checkedId) {
                case R.id.radio_button_search_year:
                    Log.d(TAG, "onCreate: 年份");
                    setEditTextEditable(false,monthValue);
                    setEditTextEditable(false,dayValue);
                    break;
                case R.id.radio_button_search_month:
                    Log.d(TAG, "onCreate: 月份");
                    setEditTextEditable(true,monthValue);
                    setEditTextEditable(false,dayValue);
                    break;
                case R.id.radio_button_search_day:
                    Log.d(TAG, "onCreate: 天");
                    setEditTextEditable(true,monthValue);
                    setEditTextEditable(true,dayValue);
            }


        });


        searchButton.setOnClickListener(v -> {
            String year = yearValue.getText().toString();
            String month = monthValue.getText().toString();
            String day = dayValue.getText().toString();
            UserSearch search = new UserSearch(DataSearch.this);
            ArrayList<User> users = search.queryDataBySpecification(source.isChecked() ? 1 : 0, year, month, day);

            if (users.size() != 0) {
                //* 有数据

                TableLayout DataPresentationTableLayout = new TableLayout(DataSearch.this);
                DataPresentationTableLayout.setStretchAllColumns(true);

                String[] TableHeadTitle = {"金额", "类型", "地点", "年/月/日", "备注"};

                //* 表格首行
                TableRow tableRow = new TableRow(DataSearch.this);

                for (String headTitle : TableHeadTitle) {
                    TextView textView = new TextView(DataSearch.this);
                    textView.setTextSize(20);
                    textView.setText(headTitle);
                    textView.setTextColor(R.color.black_800);
                    tableRow.addView(textView);
                }

                DataPresentationTableLayout.addView(tableRow,
                        new TableLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));


                //* 将数据打印

                if (source.isChecked()){
                    //* 收入打印
                    for (int i = 0; i < users.size(); i++) {
                        User user = users.get(i);

                        tableRow = new TableRow(DataSearch.this);

                        TextView textView = new TextView(DataSearch.this);
                        textView.setTextSize(18);
                        textView.setText(user.getIncome_Money());
                        textView.setTextColor(R.color.black_800);
                        tableRow.addView(textView);

                        textView = new TextView(DataSearch.this);
                        textView.setTextSize(18);
                        textView.setText(user.getIncome_Type());
                        textView.setTextColor(R.color.black_800);
                        tableRow.addView(textView);

                        textView = new TextView(DataSearch.this);
                        textView.setTextSize(18);
                        textView.setText(user.getPayer());
                        textView.setTextColor(R.color.black_800);
                        tableRow.addView(textView);

                        textView = new TextView(DataSearch.this);
                        textView.setTextSize(18);
                        String income_time = user.getIncome_Time_Year() + "/" + user.getIncome_Money() + "/" + user.getIncome_Time_Day();
                        textView.setText(income_time);
                        textView.setTextColor(R.color.black_800);
                        tableRow.addView(textView);


                        textView = new TextView(DataSearch.this);
                        textView.setTextSize(18);
                        textView.setText(user.getIncome_Note());
                        textView.setTextColor(R.color.black_800);
                        tableRow.addView(textView);



                        DataPresentationTableLayout.addView(tableRow, new TableLayout.LayoutParams(
                                ViewGroup.LayoutParams.WRAP_CONTENT,
                                ViewGroup.LayoutParams.MATCH_PARENT));

                    }

                }else {
                    //* 支出打印
                    for (int i = 0; i < users.size(); i++) {
                        User user = users.get(i);

                        tableRow = new TableRow(DataSearch.this);

                        TextView textView = new TextView(DataSearch.this);
                        textView.setTextSize(18);
                        textView.setText(user.getExpendituresMoney());
                        textView.setTextColor(R.color.black_800);
                        tableRow.addView(textView);

                        textView = new TextView(DataSearch.this);
                        textView.setTextSize(18);
                        textView.setText(user.getExpendituresType());
                        textView.setTextColor(R.color.black_800);
                        tableRow.addView(textView);

                        textView = new TextView(DataSearch.this);
                        textView.setTextSize(18);
                        textView.setText(user.getPlaceName());
                        textView.setTextColor(R.color.black_800);
                        tableRow.addView(textView);


                        textView = new TextView(DataSearch.this);
                        textView.setTextSize(18);
                        String time = user.getExpendituresTimeYear() + "/" + user.getExpendituresTimeMonth() + "/" + user.getExpendituresTimeDay();
                        textView.setText(time);
                        textView.setTextColor(R.color.black_800);
                        tableRow.addView(textView);


                        textView = new TextView(DataSearch.this);
                        textView.setTextSize(18);
                        textView.setText(user.getExpendituresNote());
                        textView.setTextColor(R.color.black_800);
                        tableRow.addView(textView);


                        // 新建的TableRow添加到TableLayout
                        DataPresentationTableLayout.addView(tableRow, new TableLayout.LayoutParams(
                                ViewGroup.LayoutParams.MATCH_PARENT,
                                ViewGroup.LayoutParams.MATCH_PARENT));

                    }
                }


                scrollView.removeAllViews();
                scrollView.addView(DataPresentationTableLayout);
            }else {
                scrollView.removeAllViews();
            }
        });


    }

    private void setEditTextEditable(boolean editable,EditText editText){
        if (editable){
            editText.setFocusableInTouchMode(true);

            editText.setFocusable(true);


        }else {
            editText.setFocusable(false);

            editText.setFocusableInTouchMode(false);
        }
    }

    // 对物理按钮的监听
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            finish();
            Intent intent = new Intent(DataSearch.this, Menu.class);
            startActivity(intent);
        }
        return super.onKeyDown(keyCode, event);
    }

}

