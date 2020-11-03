package com.example.android.helloactivity;
import android.app.Activity;
import java.util.ArrayList;
class ActivityCollector{
    private static ArrayList<Activity> list=new ArrayList<>();
    public static void add(Activity act){
        if(act == null)return;
        list.add(act);
    }
    public static void remove(Activity a){
        list.remove(a);
    }
    public static void finishAll(){
        for(Activity a : list){
            if(a.isFinishing())continue;
            a.finish();
        }
        list.clear();
    }
}
