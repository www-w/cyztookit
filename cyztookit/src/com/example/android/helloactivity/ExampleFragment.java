package com.example.android.helloactivity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.os.Bundle;
import androidx.fragment.app.Fragment;

public class ExampleFragment extends Fragment{
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,
            Bundle savedInstanceState){
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.example_fragment,container,false);
    }
}
