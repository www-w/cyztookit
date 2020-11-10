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
import android.view.View;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;


/**
 * A minimal "Hello, World!" application.
 */
public class ThirdActivity extends BaseActivity {
    String tag="third ";
    private Button button1;
    private Button button2;
    private Button button3;
    /**
     * Called with the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_activity);
        Toast.makeText(ThirdActivity.this,tag+"taskid"+getTaskId(),Toast.LENGTH_SHORT).show();
        initView();
    }
    private void initView(){
        button1=findViewById(R.id.btnthi1);
        button2=findViewById(R.id.btnthi2);
        button3=findViewById(R.id.btnthi3);
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent=new Intent(ThirdActivity.this,HelloActivity.class);
                startActivity(intent);
            }
        });
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent=new Intent("com.topv1.START_UP");
                startActivity(intent);
            }
        });
        button3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent=new Intent("com.topv1.START_FORTH");
                startActivity(intent);
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
                Toast.makeText(ThirdActivity.this,"item1～",Toast.LENGTH_LONG).show();
                break;
            case R.id.item2:
                Toast.makeText(ThirdActivity.this,"item2～",Toast.LENGTH_LONG).show();
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

