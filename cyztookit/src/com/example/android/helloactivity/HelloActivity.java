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
public class HelloActivity extends BaseActivity {
    String tag="HelloActivityLOGGER";
    private Button button1;
    private Button buttondialog;
    private Button btnhel1;
    private Button btnhel2;
    private Button btnhel3;


    /**
     * Called with the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Toast.makeText(HelloActivity.this,"oncreate"+this.toString(),Toast.LENGTH_SHORT).show();
        Toast.makeText(HelloActivity.this,tag+"taskid"+getTaskId(),Toast.LENGTH_SHORT).show();
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
        btnhel1=findViewById(R.id.btnhel1);
        btnhel2=findViewById(R.id.btnhel2);
        btnhel3=findViewById(R.id.btnhel3);
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //Intent intent = new Intent(HelloActivity.this,SecondActivity.class);
                //Intent intent = new Intent(HelloActivity.this,HelloActivity.class);
                Intent intent = new Intent("com.topv1.START_UP");
                //intent.putExtra("ddd","这是数据，，！");
                
                //Intent intent = new Intent();
                //intent.setAction(Intent.ACTION_CALL);
                //intent.setAction(Intent.ACTION_DIAL);
                //intent.setAction("android.settings.SETTINGS");
                //intent.setData(Uri.parse("tel:10086"));
                //intent.setAction("com.android.contacts.action.LIST_CONTACTS");

                startActivity(intent);
                //startActivityForResult(intent,33);
            }
        });
        buttondialog.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //Intent intent = new Intent("com.topv1.START_DIALOG");
                Intent intent = new Intent(HelloActivity.this,LoginFormActivity.class);
                try{
                    startActivity(intent);
                }catch(Exception e){
                    Toast.makeText(HelloActivity.this,e.getMessage(),Toast.LENGTH_SHORT);
                    e.printStackTrace();
                }
            }
        });
        btnhel1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //Intent intent = new Intent("com.topv1.START_UP");
                try{
                    Intent intent = new Intent("com.topv1.START_THIRD");
                    startActivity(intent);
                }catch(Exception e){
                    Toast.makeText(HelloActivity.this,e.getMessage(),Toast.LENGTH_SHORT);
                    e.printStackTrace();
                }
            }
        });
        btnhel2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent("com.topv1.START_FORTH");
                startActivity(intent);
            }
        });
        // 摄像头调用
        btnhel3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(HelloActivity.this,CameraActivity.class);
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
                Toast.makeText(HelloActivity.this,"item1～",Toast.LENGTH_SHORT).show();
                break;
            case R.id.item2:
                Toast.makeText(HelloActivity.this,"item2～",Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onStart(){
        super.onStart();
        Log.d(tag,"onStart");
        Toast.makeText(HelloActivity.this,"onStart",Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onResume(){
        super.onResume();
        Log.d(tag,"onResume");
        Toast.makeText(HelloActivity.this,"onResume",Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onPause(){
        super.onPause();
        Log.d(tag,"onPause");
        Toast.makeText(HelloActivity.this,"onPause",Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onStop(){
        super.onStop();
        Log.d(tag,"onStop");
        Toast.makeText(HelloActivity.this,"onStop",Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.d(tag,"onDestroy");
        Toast.makeText(HelloActivity.this,"onDestroy",Toast.LENGTH_SHORT).show();
    }
    @Override 
    public void onRestart(){
        super.onRestart();
        Log.d(tag,"onRestart");
        Toast.makeText(HelloActivity.this,"onRestart",Toast.LENGTH_SHORT).show();
    }

}

