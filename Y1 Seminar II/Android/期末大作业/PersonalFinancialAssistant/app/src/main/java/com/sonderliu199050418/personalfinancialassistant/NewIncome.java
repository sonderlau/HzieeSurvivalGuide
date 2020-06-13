package com.sonderliu199050418.personalfinancialassistant;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.sonderliu199050418.personalfinancialassistant.Database.UserSearch;

import java.util.Calendar;

public class NewIncome extends AppCompatActivity {


    private TextInputEditText income_money_text;
    private TextInputEditText income_payer_text;
    private TextInputEditText income_note_text;

    private Button save;



    private Button setDate;

    private UserSearch mUserSearch;

    private RadioButton isCreditCard;

    private String time;

    private int yearValue;
    private int monthValue;
    private int dayValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addinaccount);

        mUserSearch = new UserSearch(this);

        setDate = findViewById(R.id.set_date);

        income_money_text =  findViewById(R.id.income_money_text);
        income_payer_text =  findViewById(R.id.income_payer_text);
        income_note_text = findViewById(R.id.income_note_text);
        save = findViewById(R.id.button_income_save);

        isCreditCard = findViewById(R.id.radio_button_one);

        save.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                String i_money = income_money_text.getText() + "";
                String payer = income_payer_text.getText() + "";
                String i_text = income_note_text.getText() + "";
                String i_type = isCreditCard.isChecked() ? "信用卡" : "现金";



                if (  i_money.equals("") ) {

                    //* 钱数为空

                    Toast.makeText(NewIncome.this, "不得为空！", Toast.LENGTH_SHORT).show();

                }

                    mUserSearch.addIncome(i_money,String.valueOf(yearValue),String.valueOf(monthValue),String.valueOf(dayValue), i_type, payer, i_text);
                    Toast.makeText(NewIncome.this, "保存成功！", Toast.LENGTH_SHORT).show();


            }
        });

        setDate.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                getDate();
            }
        });



    }
    private void getDate(){
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog dpd = new DatePickerDialog(this,R.style.ThemeDialog, new DatePickerDialog.OnDateSetListener() {
            @Override public void onDateSet(DatePicker view, int year, int month, int day) {
                String TAG = "date";
                Log.d(TAG, "onDateSet: " + year + "年： " + (month + 1) + "月： " + day + "日");
                yearValue = year;
                monthValue = month + 1;
                dayValue = day;
            }
        }, year, month, day);
        dpd.show();


    }

    // 对物理按钮的监听
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            finish();
            Intent intent = new Intent(NewIncome.this, Menu.class);
            startActivity(intent);
        }
        return super.onKeyDown(keyCode, event);
    }
}


