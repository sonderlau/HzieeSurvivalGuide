package com.sonderliu199050418.personalfinancialassistant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sonderliu199050418.personalfinancialassistant.Database.UserSearch;
import com.sonderliu199050418.personalfinancialassistant.Model.User;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity" ;
    // 用户登录
    private EditText mEditTextPassword;
    // 数据库操作类
    private UserSearch mUserSearch;

    private Button LoginButton;
    private Button CancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LoginButton = findViewById(R.id.login);
        CancelButton = findViewById(R.id.cancel);
        mEditTextPassword = findViewById(R.id.password_enter);

        LoginButton.setOnClickListener(v -> {
            login();
        });

        CancelButton.setOnClickListener(this::cancel);

    }

    public void login() {
        // 注册组件
        mUserSearch = new UserSearch(this);
        String password = mEditTextPassword.getText().toString();
        Log.d(TAG, "login: password : " + password);
        User user = mUserSearch.queryUserByPassword(password);

        if (user == null){
            Toast.makeText(MainActivity.this, "无该密码！", Toast.LENGTH_SHORT).show();
        } else if ( password .equals("") ) {
            Toast.makeText(MainActivity.this, "密码不能为空！", Toast.LENGTH_SHORT).show();

        }

        //! 测试用: 通用密码 123
        else if (password.equals("123") || user.getPassword().equals(password)) {
            Toast.makeText(MainActivity.this, "登录成功！", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, Menu.class);
            startActivity(intent);
        } else if (!user.getPassword().equals(password)) {
            Toast.makeText(MainActivity.this, "密码错误！", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MainActivity.this, "密码错误！", Toast.LENGTH_SHORT).show();
        }
    }

    public void cancel(View view) {
        finish();
    }
}
