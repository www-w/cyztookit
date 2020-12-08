package com.example.android.helloactivity;

public class LoginFormActivityNative{
    static{
        System.loadLibrary("native");
    }
    private native void setName(String name);
    private native void setAge(int age);
    private native void setAddress(String addr);
    private native void setPhone(String phone);
    private native void setGender(String gender);
    private native void setHobby(String hobby,boolean b);
    private native String getResult();
    
    public void SetName(String name){
        setName(name);
    }
    public void SetAge(int age){
        setAge(age);
    }
    public void SetAddress(String addr){
        setAddress(addr);
    }
    public void SetPhone(String phone){
        setPhone(phone);
    }
    public void SetGender(String gender){
        setGender(gender);
    }
    public void SetHobby(String hobby,boolean b){
        setHobby(hobby,b);
    }
    public String GetResult(){
        return getResult();
    }
}
