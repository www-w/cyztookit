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
 * 滚动banner测试
 */
public class ViewPagerActivity extends Activity {
    // 定义日志用的标记
    private String tag="ViewPagerActivity";
    /**
     * Called with the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try{
            setContentView(R.layout.viewpager_activity);
        }catch(Exception e){
            Toast.makeText(ViewPagerActivity.this,e.getMessage(),Toast.LENGTH_SHORT);
            tag=e.getMessage();
            e.printStackTrace();
        }
        setContentView(R.layout.hello_activity);
        TextView tv=findViewById(R.id.text);
        tv.setText(tag);

        initView();
    }
    private void initView(){
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
                Toast.makeText(ViewPagerActivity.this,"item1～",Toast.LENGTH_LONG).show();
                break;
            case R.id.item2:
                Toast.makeText(ViewPagerActivity.this,"item2～",Toast.LENGTH_LONG).show();
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

