package com.example.android.helloactivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.MutableLiveData;
class MyViewModel extends ViewModel{
	private MutableLiveData<String> txta;
	public MutableLiveData<String> getTxtA(){
		if(txta==null)txta=new MutableLiveData<String>();
		return txta;
	}

}