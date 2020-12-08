/*
 * Copyright (C) 2007 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.helloactivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.CheckBox;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.RadioButton;
import android.widget.CompoundButton;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

/**
 * 表单填写例子
 */
public class LoginFormActivity extends Activity {
    // 定义日志用的标记
    private String tag="LoginFormActivity";
    private LoginFormActivityNative nat=new LoginFormActivityNative();
    /**
     * Called with the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginform);
        initView();
    }
    EditText etName;
    EditText etAge;
    EditText etAddr;
    EditText etPhone;
    RadioGroup rgGender;
    CheckBox cbMusic;
    CheckBox cbArt;
    CheckBox cbBasket;
    CheckBox cbReading;
    TextView tvShow;
    Button btnOk;
    private void initView(){
        etName=findViewById(R.id.et_name);
        etAge= findViewById(R.id.et_age);
        etAddr=findViewById(R.id.et_address);
        etPhone=findViewById(R.id.et_phone);
        rgGender=findViewById(R.id.rg_gender);
        cbMusic=findViewById(R.id.cb_music);
        cbArt=findViewById(R.id.cb_art);
        cbBasket=findViewById(R.id.cb_basketball);
        cbReading=findViewById(R.id.cb_reading);
        tvShow=findViewById(R.id.tv_show);
        btnOk=findViewById(R.id.btnok);
        rgGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            public void onCheckedChanged(RadioGroup group, int checkedId){
                RadioButton rb=group.findViewById(checkedId);
                CharSequence t=rb.getText();
                nat.SetGender(t.toString());
                Toast.makeText(LoginFormActivity.this,t,Toast.LENGTH_SHORT).show();
}
        });
        CompoundButton.OnCheckedChangeListener cbcl=new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){
                CharSequence cq=buttonView.getText();
                nat.SetHobby(cq.toString(),isChecked);
                Toast.makeText(LoginFormActivity.this,cq+String.valueOf(isChecked),Toast.LENGTH_SHORT).show();
            }
        };
        cbMusic.setOnCheckedChangeListener(cbcl);
        cbArt.setOnCheckedChangeListener(cbcl);
        cbBasket.setOnCheckedChangeListener(cbcl);
        cbReading.setOnCheckedChangeListener(cbcl);
        btnOk.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // native
                nat.SetName(etName.getText().toString());
                nat.SetAge(Integer.parseInt(0+etAge.getText().toString()));
                nat.SetAddress(etAddr.getText().toString());
                nat.SetPhone(etPhone.getText().toString());
                tvShow.setText(nat.GetResult());
                // Do something in response to button click
                /* java
                CharSequence gender="";
                RadioButton rb=findViewById(rgGender.getCheckedRadioButtonId());
                if(rb!=null){
                    gender=rb.getText();
                }
                StringBuilder sb=new StringBuilder();
                sb.append("姓名：").append(etName.getText()).append("\n")
                    .append("年龄：").append(etAge.getText()).append("\n")
                    .append("地址：").append(etAddr.getText()).append("\n")
                    .append("电话：").append(etPhone.getText()).append("\n")
                    .append("性别：").append(gender).append("\n")
                    .append("爱好：")
                    ;
                if(cbMusic.isChecked())sb.append(cbMusic.getText()).append(" ");
                if(cbArt.isChecked())sb.append(cbArt.getText()).append(" ");
                if(cbBasket.isChecked())sb.append(cbBasket.getText()).append(" ");
                if(cbReading.isChecked())sb.append(cbReading.getText()).append(" ");
                tvShow.setText(sb.toString());
                */
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.item1:
                Toast.makeText(LoginFormActivity.this,"item1～",Toast.LENGTH_LONG).show();
                break;
            case R.id.item2:
                Toast.makeText(LoginFormActivity.this,"item2～",Toast.LENGTH_LONG).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onStart(){
        super.onStart();
        Log.d(tag,"onStart");
    }
    @Override
    public void onResume(){
        super.onResume();
        Log.d(tag,"onResume");
    }
    @Override
    public void onPause(){
        super.onPause();
        Log.d(tag,"onPause");
    }
    @Override
    public void onStop(){
        super.onStop();
        Log.d(tag,"onStop");
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.d(tag,"onDestroy");
    }
    @Override 
    public void onRestart(){
        super.onRestart();
        Log.d(tag,"onRestart");
    }

}

