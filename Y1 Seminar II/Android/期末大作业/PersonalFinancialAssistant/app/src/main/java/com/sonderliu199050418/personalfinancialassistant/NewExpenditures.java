package com.sonderliu199050418.personalfinancialassistant;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.sonderliu199050418.personalfinancialassistant.Database.UserSearch;

import java.util.Calendar;

public class NewExpenditures extends AppCompatActivity {

    private EditText amounts;
    private EditText time;
    private EditText type;
    private EditText place;
    private EditText note;
    private Button save;
    private UserSearch mUserSearch;

    private Button setDate;

    private int yearValue;
    private int monthValue;
    private int dayValue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addoutaccount);

        mUserSearch = new UserSearch(this);


        amounts = findViewById(R.id.outcome_amounts);
        place = findViewById(R.id.outcome_place);
        note = findViewById(R.id.outcome_note);
        setDate = findViewById(R.id.set_date);



        save = findViewById(R.id.button_outcome_save);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String o_money = amounts.getText() + "";
                String o_note = note.getText() + "";
                String o_place = place.getText() + "";


                RadioButton type = findViewById(R.id.radio_button_outcome_one);

                String o_type = type.isChecked() ? "信用卡" : "现金";


                if (o_money.equals("")) {

                    Toast.makeText(NewExpenditures.this, "不能为空 ！", Toast.LENGTH_SHORT).show();

                }

                mUserSearch.addOutcome(o_money, String.valueOf(yearValue), String.valueOf(monthValue), String.valueOf(dayValue), o_type, o_place, o_note);
                Toast.makeText(NewExpenditures.this, "保存成功 ！", Toast.LENGTH_SHORT).show();

            }
        });


        setDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDate();
            }
        });

    }

    private void getDate() {
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog dpd = new DatePickerDialog(this, R.style.ThemeDialog, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
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
            Intent intent = new Intent(NewExpenditures.this, Menu.class);
            startActivity(intent);
        }
        return super.onKeyDown(keyCode, event);
    }
}
