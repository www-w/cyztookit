package com.example.android.helloactivity;
import android.app.Activity;
import android.os.Bundle;
class BaseActivity extends Activity{
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        ActivityCollector.add(this);
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        ActivityCollector.remove(this);
    }
    protected void finishAll(){
        ActivityCollector.finishAll();
    }
}
