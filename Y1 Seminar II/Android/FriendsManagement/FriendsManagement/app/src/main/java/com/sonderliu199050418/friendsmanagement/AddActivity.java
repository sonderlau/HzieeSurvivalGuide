package com.sonderliu199050418.friendsmanagement;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TableLayout;
import android.widget.TableRow;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static android.util.TypedValue.COMPLEX_UNIT_SP;

public class AddActivity extends AppCompatActivity {

    private static final String EXTRA_FRIEND_ID = "FriendID";
    private static final String TAG = "date";

    private TableLayout mTableLayout;
    private Button mDateButton;
    private EditText mNameEdit;
    private Button mSaveButton;
    private Button mCancelButton;
    private RadioButton mRadioButtonMan;
    private RadioButton mRadioButtonWoman;
    private List<CheckBox> mHobbys;
    private FriendInfo mFriendInfo;
    private Date mDate;




    @RequiresApi(api = Build.VERSION_CODES.N)
    private void GetDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(mFriendInfo.getDate());
        DatePickerDialog dialog = new DatePickerDialog(this,new DatePickerDialog.OnDateSetListener(){

            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                Calendar cal = Calendar.getInstance();
                cal.set(year,month,dayOfMonth);
                mDate = cal.getTime();
                String date = (String) DateFormat.format("yyyy年MM月dd日",mDate);
                mDateButton.setText(date);
            }
        }, calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH));
        dialog.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        UUID uuid = (UUID) getIntent().getSerializableExtra(EXTRA_FRIEND_ID);

        if (uuid == null) {
            mFriendInfo = new FriendInfo();
        } else {
            mFriendInfo = FriendsLab.get(AddActivity.this).getFriend(uuid);
        }

        mDate = mFriendInfo.getDate();

        // 存放所有兴趣的 checkbox
        mHobbys = new ArrayList<>();

        mDateButton = findViewById(R.id.birthday_button);
        mDateButton.setText(DateFormat.format("yyyy年MM月dd日",mDate));
        mDateButton.setOnClickListener(new View.OnClickListener() {

            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                GetDate();
            }
        });


        mRadioButtonMan = findViewById(R.id.radio_male);
        mRadioButtonWoman = findViewById(R.id.radio_female);
        if (mFriendInfo.getSex() == 0) {
            mRadioButtonMan.setChecked(false);
            mRadioButtonWoman.setChecked(true);
        }

        mSaveButton = findViewById(R.id.saveButton);
        mSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SaveFriend();
                finish();
            }
        });


        mCancelButton = findViewById(R.id.cancelButton);
        mCancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        mNameEdit = findViewById(R.id.name);
        mNameEdit.setText(mFriendInfo.getName());

        // 自动生成爱好列表的 checkbox 群
        InitTable();
        // 将爱好列表的字符串解析到 checkbox 群中 显示出来
        LoadHobby();


    }

    private void InitTable() {
        // 初始化 爱好列表
        mTableLayout = findViewById(R.id.tableLayout);
        CheckBox btn;
        TableRow row = new TableRow(this);
        TableRow.LayoutParams param1 = new TableRow.LayoutParams();
        param1.setMargins(20,8,8,8);

        for (int i = 1 ; i <= FriendInfo.hobbys.length ; i ++) {
            btn = new CheckBox(this);
            btn.setText(FriendInfo.hobbys[i-1]);
            btn.setPadding(8,8,8,8);
            btn.setTextSize(COMPLEX_UNIT_SP,18);
            btn.setLayoutParams(param1);
            btn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    int mCount = 0;
                    for (CheckBox c : mHobbys) {
                        if (c.isChecked()) {
                            mCount ++;
                        }
                        if (mCount > 3) {
                            buttonView.setChecked(false);
                        }
                    }
                }
            });
            mHobbys.add(btn);
            row.addView(btn);

            if (i % 3 == 0) {
                mTableLayout.addView(row);
                row = new TableRow(this);
            }
        }

        mTableLayout.addView(row);


    }

    // 保存数据 到 Friend 对象中
    private void SaveFriend() {
        mFriendInfo.setName(mNameEdit.getText().toString());
        mFriendInfo.setDate(mDate);
        mFriendInfo.setSex(mRadioButtonMan.isChecked() ? 1 : 0);
        SaveHobby();

        // 检查是否是 新增的 Friend 如果是 还需要加入到 FriendLab中
        if (FriendsLab.get(AddActivity.this).getFriend(mFriendInfo.getId()) == null) {
            FriendsLab.get(AddActivity.this).getFriends().add(mFriendInfo);
        }
    }



    // 从界面上解析 保存爱好
    // 遍历所有的爱好 拼接成字符
    private void SaveHobby() {
        String sHobby = "";
        for (CheckBox c : mHobbys) {
            if (c.isChecked()) {
                sHobby += c.getText() + " ";
            }
        }

        mFriendInfo.setHobby(sHobby);
    }

    private void LoadHobby() {
        String sHobby = mFriendInfo.getHobby();
        if (sHobby == null) {
            return;
        }
        for (CheckBox c : mHobbys) {
            if (sHobby.contains(c.getText().toString())) {
                c.setChecked(true);
            }
        }
    }

    public static Intent newIntent(Context context, UUID FriendID) {
        Intent intent = new Intent(context, AddActivity.class);

        intent.putExtra(EXTRA_FRIEND_ID,FriendID);
        return intent;

    }
}
