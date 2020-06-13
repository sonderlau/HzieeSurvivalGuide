package com.sonderliu199050418.personalfinancialassistant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import android.widget.Toast;
import com.sonderliu199050418.personalfinancialassistant.Database.UserSearch;
import com.sonderliu199050418.personalfinancialassistant.Model.User;



public class SystemConfiguration extends AppCompatActivity {


    // 修改密码
    private EditText password_edit_old;
    private EditText password_edit_new;
    private EditText password_edit_new_repeat;
    private Button password_edit_save;

    // 数据库操作类
    private UserSearch mUserSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_system_configuration);

        mUserSearch = new UserSearch(this);

        //* 部件绑定

        password_edit_old = findViewById(R.id.password_edit_old);
        password_edit_new = findViewById(R.id.password_edit_new);
        password_edit_new_repeat = findViewById(R.id.password_edit_new_repeat);


        password_edit_save = findViewById(R.id.button_password_edit_save);




        // 修改密码
        password_edit_save.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                String password = password_edit_old.getText() + "";
                if ( password.equals(""))
                {
                    Toast.makeText(SystemConfiguration.this, "密码不得为空！", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    User user = mUserSearch.queryUserByPassword(password);
                    if (mUserSearch.queryUserByPassword(password) == null) {
                        Toast.makeText(SystemConfiguration.this, "密码不存在！",Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        if (!user.getPassword().equals(password)) {
                            Toast.makeText(SystemConfiguration.this, "密码错误！",Toast.LENGTH_SHORT).show();
                        } else
                        {
                            String newPassword = password_edit_new.getText() + "";
                            String confirmNewPwd = password_edit_new_repeat.getText() + "";
                            if (!newPassword.equals(confirmNewPwd))
                            {
                                Toast.makeText(SystemConfiguration.this, "两次输入密码不一致！",Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                mUserSearch.changePassword(newPassword);
                                Toast.makeText(SystemConfiguration.this,"修改密码成功！",Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                }
            }
        });
    }
    private void cancel(){
        Intent back = new Intent(SystemConfiguration.this,Menu.class);
        startActivity(back);
    }

    // 对物理按钮的监听
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            finish();
            Intent intent = new Intent(SystemConfiguration.this, Menu.class);
            startActivity(intent);
        }
        return super.onKeyDown(keyCode, event);
    }
}
