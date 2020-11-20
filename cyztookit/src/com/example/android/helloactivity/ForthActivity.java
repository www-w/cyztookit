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
import android.widget.EditText;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.app.DatePickerDialog;
import android.widget.DatePicker;
import android.content.DialogInterface;
import java.util.Calendar;

/**
 * A minimal "Hello, World!" application.
 */
public class ForthActivity extends BaseActivity {
    String tag="four ";
    private Button button1;
    private Button button2;
    private Button button3;
    /**
     * Called with the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forth_activity);
        Toast.makeText(ForthActivity.this,tag+"taskid"+getTaskId(),Toast.LENGTH_SHORT).show();
        initView();
    }
    private void initView(){
        button1=findViewById(R.id.btnfour1);
        button2=findViewById(R.id.btnfour2);
        button3=findViewById(R.id.btnfour3);
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                new AlertDialog.Builder(ForthActivity.this)
                    .setTitle("标题")
                    .setMessage("内容")
                    .setPositiveButton("是",new DialogInterface.OnClickListener(){
                        @Override
                        public void onClick(DialogInterface di,int which){
                            Toast.makeText(ForthActivity.this,"yes:"+which,Toast.LENGTH_SHORT).show();
                        }
                    })
                    .setNegativeButton("否",new DialogInterface.OnClickListener(){
                        @Override
                        public void onClick(DialogInterface di,int which){
                            Toast.makeText(ForthActivity.this,"no:"+which,Toast.LENGTH_SHORT).show();
                        }
                    })
                    .setCancelable(false)
                    .show();
            }
        });
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String [] lst={"赤","橙","黄","绿","青","蓝","紫","b","c","赤","橙","黄","绿","青","蓝","紫","b","c"};
                new AlertDialog.Builder(ForthActivity.this)
                    .setTitle("标题")
                    .setSingleChoiceItems(lst,-1,new DialogInterface.OnClickListener(){
                        @Override
                        public void onClick(DialogInterface di,int which){
                            Toast.makeText(ForthActivity.this,"sel:"+which,Toast.LENGTH_SHORT).show();
                        }
                    })
                    .setPositiveButton("是",new DialogInterface.OnClickListener(){
                        @Override
                        public void onClick(DialogInterface di,int which){
                            Toast.makeText(ForthActivity.this,"yes:"+which,Toast.LENGTH_SHORT).show();
                        }
                    })
                    .setNegativeButton("否",new DialogInterface.OnClickListener(){
                        @Override
                        public void onClick(DialogInterface di,int which){
                            Toast.makeText(ForthActivity.this,"no:"+which,Toast.LENGTH_SHORT).show();
                        }
                    })
                    .setCancelable(false)
                    .show();
            }
        });
        button3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String [] lst={"赤","橙","黄","绿","青","蓝","紫","b","c","赤","橙","黄","绿","青","蓝","紫","b","c"};
                new AlertDialog.Builder(ForthActivity.this)
                    .setTitle("标题")
                    .setMultiChoiceItems(java.util.Arrays.copyOf(lst,2),new boolean[]{false,true},new DialogInterface.OnMultiChoiceClickListener(){
                        @Override
                        public void onClick(DialogInterface di,int which,boolean b){
                            Toast.makeText(ForthActivity.this,"sel:"+which+"b:"+b,Toast.LENGTH_SHORT).show();
                        }
                    })
                    .setPositiveButton("是",new DialogInterface.OnClickListener(){
                        @Override
                        public void onClick(DialogInterface di,int which){
                            Toast.makeText(ForthActivity.this,"yes:"+which,Toast.LENGTH_SHORT).show();
                        }
                    })
                    .setNegativeButton("否",new DialogInterface.OnClickListener(){
                        @Override
                        public void onClick(DialogInterface di,int which){
                            Toast.makeText(ForthActivity.this,"no:"+which,Toast.LENGTH_SHORT).show();
                        }
                    })
                    .setCancelable(false)
                    .show();
            }
        });
    }
    public void btnDiyDialog(View view){
        View v=View.inflate(this,R.layout.second_activity,null);
        final EditText et=v.findViewById(R.id.saipt);
        new AlertDialog.Builder(ForthActivity.this)
            .setTitle("自定义视图")
            .setView(v)
            .setPositiveButton("是",new DialogInterface.OnClickListener(){
                @Override
                public void onClick(DialogInterface di,int which){
                    Toast.makeText(ForthActivity.this,"yes:"+which,Toast.LENGTH_SHORT).show();
                    Toast.makeText(ForthActivity.this,et.getText(),Toast.LENGTH_SHORT).show();
                }
            })
        .setNegativeButton("否",new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface di,int which){
                Toast.makeText(ForthActivity.this,"no:"+which,Toast.LENGTH_SHORT).show();
            }
        })
        .setCancelable(false)
            .show();
    }
    public void btnProgressDialog(View view){
        final ProgressDialog pd = new ProgressDialog(this);
        pd.setTitle("进度条");
        pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        pd.setCancelable(false);
        pd.show();
        pd.setProgress(30);
        new Thread(new Runnable(){
            @Override
            public void run(){
                for(int i=0;i<101;i++){
                    try{
                    Thread.sleep(100);
                    }catch(InterruptedException ie){
                        ie.printStackTrace();
                    }
                    pd.setProgress(i);
                }
                pd.dismiss();
            }
        }).start();
    }
    public void btnDatepickerDialog(View view){
        Calendar c=Calendar.getInstance();
        int y=c.get(Calendar.YEAR);
        int m=c.get(Calendar.MONTH);
        int d=c.get(Calendar.DAY_OF_MONTH);
        new DatePickerDialog(this,new DatePickerDialog.OnDateSetListener(){
            @Override
            public void onDateSet(DatePicker dp,int y,int m,int d){
                Toast.makeText(ForthActivity.this,y+"/"+(m+1)+"/"+d,Toast.LENGTH_SHORT).show();
            }
        },y,m,d).show();
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
                Toast.makeText(ForthActivity.this,"item1～",Toast.LENGTH_LONG).show();
                break;
            case R.id.item2:
                Toast.makeText(ForthActivity.this,"item2～",Toast.LENGTH_LONG).show();
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

