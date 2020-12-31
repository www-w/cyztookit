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
import android.widget.SeekBar;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import androidx.core.app.NotificationCompat;
import android.os.Build;
import android.app.NotificationManager;
import android.app.NotificationChannel;
import android.app.PendingIntent;
import androidx.core.app.NotificationManagerCompat;
import android.os.Handler;
import android.os.Message;


/**
 * A minimal "Progress" application.
 */
public class ThirdActivity extends android.app.Activity {
    String tag="third ";
    private Button button1;
    private Button button2;
    private Button button3;
    private ProgressBar pb;
    private SeekBar sk;
    private TextView tvloading;
    private TextView tvlog;
    /**
     * Called with the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_activity);
        Toast.makeText(ThirdActivity.this,"Build.VERSION.SDK_INT:"+Build.VERSION.SDK_INT+"\nBuild.VERSION_CODES.O:"+Build.VERSION_CODES.O,Toast.LENGTH_SHORT).show();
        createNotificationChannel();

        initView();
        notify1();
        notify2();
        notify3();
        notify4();

    }
    private void notify4(){
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID);
        builder.setContentTitle("Picture Download")
            .setContentText("Download in progress")
            .setSmallIcon(R.drawable.img)
        .setStyle(new NotificationCompat.BigTextStyle()
                .bigText("M8uch longer text that cannot fit one line..."))
            .setPriority(NotificationCompat.PRIORITY_LOW);
        //notificationManager.notify(126, builder.build());//可有可无

        // Issue the initial notification with zero progress
        int PROGRESS_MAX = 100;
        int PROGRESS_CURRENT = 30;
        builder.setProgress(PROGRESS_MAX, PROGRESS_CURRENT, false);
        notificationManager.notify(126, builder.build());

        // Do the job here that tracks the progress.
        // Usually, this should be in a
        // worker thread
        // To show progress, update PROGRESS_CURRENT and update the notification with:
        // builder.setProgress(PROGRESS_MAX, PROGRESS_CURRENT, false);
        // notificationManager.notify(notificationId, builder.build());

        // When done, update the notification one more time to remove the progress bar
        /*builder.setContentText("Download complete")
            .setProgress(0,0,false);
        notificationManager.notify(126, builder.build());*/
    }
    private void notify1(){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
        .setSmallIcon(R.drawable.img)
        .setContentTitle("title")
        .setContentText("content")
        .setPriority(NotificationCompat.PRIORITY_MAX);
        NotificationManagerCompat notimanager=NotificationManagerCompat.from(this);
        try{
            notimanager.notify(123,builder.build());
        }catch(Exception e){
            Toast.makeText(ThirdActivity.this,e.getMessage(),Toast.LENGTH_LONG).show();
            tvloading.setText(e.getMessage());
        }
    }
    private void notify2(){
        // Create an explicit intent for an Activity in your app
        Intent intent = new Intent(this, ForthActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.img)
            .setContentTitle("My notification")
            .setContentText("Hello World!")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            // Set the intent that will fire when the user taps the notification
            .setContentIntent(pendingIntent)
            //.setFullScreenIntent(pendingIntent, true)
            .setCategory(NotificationCompat.CATEGORY_MESSAGE)
            .setAutoCancel(true);
        NotificationManagerCompat notimanager=NotificationManagerCompat.from(this);
        notimanager.notify(124,builder.build());
    }
    private void notify3(){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
        .setSmallIcon(R.drawable.img)
        .setContentTitle("My notification")
        .setContentText("Much longer text that cannot fit one line...")
        .setStyle(new NotificationCompat.BigTextStyle()
                .bigText("M8uch longer text that cannot fit one line..."))
        .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        NotificationManagerCompat notimanager=NotificationManagerCompat.from(this);
        notimanager.notify(125,builder.build());
    }
    String CHANNEL_ID="cid 10";
    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = ("cannelnamek");
            String description = ("desc");
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
    int progress=0;
    long mtid,ttid,htid;
    private Handler handler=new Handler(new Handler.Callback(){
        @Override
        public boolean handleMessage(Message msg){
            switch(msg.what){
                case 1:
                    progress++;
                    sk.setProgress(progress);
                    if(progress<100)handler.sendEmptyMessageDelayed(1,1000);
                    htid=Thread.currentThread().getId();
                    tvlog.setText("mtid:"+mtid+"\nttid:"+ttid+"\nhtid:"+htid);
                    break;
            }
	    return false;
        }
    });
    private void initView(){
        button1=findViewById(R.id.btnthi1);
        button2=findViewById(R.id.btnthi2);
        button3=findViewById(R.id.btnthi3);
        pb=findViewById(R.id.pb);
        sk=findViewById(R.id.sk);
        tvloading=findViewById(R.id.tvloading);
        tvlog=findViewById(R.id.tvlog);
        mtid=Thread.currentThread().getId();
        sk.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            @Override
            public void onProgressChanged(SeekBar bar,int progress,boolean frombuser){
                tvloading.setText("正在加载中："+progress+"%");
                pb.setProgress(progress);
                pb.setVisibility(View.VISIBLE);
            }
            @Override
            public void onStartTrackingTouch(SeekBar bar){
                Toast.makeText(ThirdActivity.this,"touch start",Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onStopTrackingTouch(SeekBar bar){
                Toast.makeText(ThirdActivity.this,"touch Stoped at: "+bar.getProgress(),Toast.LENGTH_SHORT).show();
                if(bar.getProgress()==bar.getMax()){
                    pb.setVisibility(View.GONE);
                }else{
                }
            }
        });
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Thread t=new Thread(new Runnable(){
                    @Override
                    public void run(){
                        ttid=Thread.currentThread().getId();
                        handler.sendEmptyMessage(1);
                    }
                });
                t.start();
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

