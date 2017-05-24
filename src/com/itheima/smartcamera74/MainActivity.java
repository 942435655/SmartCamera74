package com.itheima.smartcamera74;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    private EditText mEtName;
    private EditText mEtUID;
    private EditText mEtPwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mEtName = (EditText) findViewById(R.id.et_name);
        mEtUID = (EditText) findViewById(R.id.et_uid);
        mEtPwd = (EditText) findViewById(R.id.et_pwd);
    }
    
    public void startConn(View v) {
        String name = mEtName.getText().toString().trim();
        String uid = mEtUID.getText().toString().trim();
        String pwd = mEtPwd.getText().toString().trim();
        if(TextUtils.isEmpty(name)) {
            Toast.makeText(getApplicationContext(), "名称不能为空", Toast.LENGTH_SHORT).show();
        }else if(TextUtils.isEmpty(uid) && uid.length() != 20) {
            Toast.makeText(getApplicationContext(), "UID错误", Toast.LENGTH_SHORT).show();
        }else if(TextUtils.isEmpty(pwd)) {
            Toast.makeText(getApplicationContext(), "密码不能为空", Toast.LENGTH_SHORT).show();
        }else {
            Intent intent = new Intent(this, CameraActivity.class);
            intent.putExtra("name", name);
            intent.putExtra("uid", uid);
            intent.putExtra("pwd", pwd);
            startActivity(intent);
            finish();
        }
        
    }
}
