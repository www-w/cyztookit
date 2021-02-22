package com.example.android.helloactivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.LiveData;
public class MyViewModel extends ViewModel{
	private MutableLiveData<String> txta=new MutableLiveData<String>("init val");
	private LiveData<String> txtb=Transformations.map(txta,a->{
		return "trans a:"+a;
	});
	public MutableLiveData<String> getTxtA(){
		return txta;
	}
	public LiveData<String> getTxtB(){
		return txtb;
	}

}
