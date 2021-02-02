package com.example.android.helloactivity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.os.Bundle;

public class ExampleFragment2 extends Fragment{
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,
            Bundle savedInstanceState){
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.example_fragment2,container,false);
    }
}
