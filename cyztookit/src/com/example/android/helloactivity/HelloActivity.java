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
import android.net.Uri;


/**
 * A minimal "Hello, World!" application.
 */
public class HelloActivity extends Activity {
    String tag="hello";
    private Button button1;
    private Button buttondialog;
    /**
     * Called with the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Toast.makeText(HelloActivity.this,"oncreate",Toast.LENGTH_LONG).show();
        // Set the layout for this activity.  You can find it
        // in res/layout/hello_activity.xml
        //View view = getLayoutInflater().inflate(R.layout.hello_activity, null);
        //setContentView(view);
        setContentView(R.layout.hello_activity);
        Log.d(tag,"onCreate");
        initView();
    }
    private void initView(){
        button1=findViewById(R.id.button1);
        buttondialog=findViewById(R.id.buttonOpenDialog);
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //Intent intent = new Intent(HelloActivity.this,SecondActivity.class);
                Intent intent = new Intent("com.topv1.START_UP");
                intent.putExtra("ddd","这是数据，，！");
                
                //Intent intent = new Intent();
                //intent.setAction(Intent.ACTION_CALL);
                //intent.setAction(Intent.ACTION_DIAL);
                //intent.setAction("android.settings.SETTINGS");
                //intent.setData(Uri.parse("tel:10086"));
                //intent.setAction("com.android.contacts.action.LIST_CONTACTS");

                //startActivity(intent);
                startActivityForResult(intent,33);
            }
        });
        buttondialog.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent("com.topv1.START_DIALOG");
                startActivity(intent);
            }
        });
    }
    @Override
    protected void onActivityResult(int reqcode,int resultcode,Intent data){
        switch(reqcode){
            case 33:
                if(resultcode==RESULT_OK){
                    button1.setText(data.getStringExtra("rt"));
                }
                break;
        }
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
                Toast.makeText(HelloActivity.this,"item1～",Toast.LENGTH_LONG).show();
                break;
            case R.id.item2:
                Toast.makeText(HelloActivity.this,"item2～",Toast.LENGTH_LONG).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onStart(){
        super.onStart();
        Log.d(tag,"onStart");
        Toast.makeText(HelloActivity.this,"onStart",Toast.LENGTH_LONG).show();
    }
    @Override
    public void onResume(){
        super.onResume();
        Log.d(tag,"onResume");
        Toast.makeText(HelloActivity.this,"onResume",Toast.LENGTH_LONG).show();
    }
    @Override
    public void onPause(){
        super.onPause();
        Log.d(tag,"onPause");
        Toast.makeText(HelloActivity.this,"onPause",Toast.LENGTH_LONG).show();
    }
    @Override
    public void onStop(){
        super.onStop();
        Log.d(tag,"onStop");
        Toast.makeText(HelloActivity.this,"onStop",Toast.LENGTH_LONG).show();
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.d(tag,"onDestroy");
        Toast.makeText(HelloActivity.this,"onDestroy",Toast.LENGTH_LONG).show();
    }
    @Override 
    public void onRestart(){
        super.onRestart();
        Log.d(tag,"onRestart");
        Toast.makeText(HelloActivity.this,"onRestart",Toast.LENGTH_LONG).show();
    }

}

