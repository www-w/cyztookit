package com.example.android.helloactivity;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

public class ViewModelActivity extends AppCompatActivity{
	MyViewModel myvm;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_viewmodel);
		initView();
		myvm=new ViewModelProvider(this).get(MyViewModel.class);
		myvm.getTxtA().observe(this,a->{
			viewmodeltxta.setText(a);
		});
		myvm.getTxtB().observe(this,a->{
			viewmodeltxtb.setText(a);
		});
	}
	TextView viewmodeltxta;
	TextView viewmodeltxtb;
	TextView viewmodeltxtc;
	void initView(){
		viewmodeltxta = findViewById(R.id.viewmodeltxta);
		viewmodeltxtb = findViewById(R.id.viewmodeltxtb);
		viewmodeltxtc = findViewById(R.id.viewmodeltxtc);
		Button viewmodelBtnA=findViewById(R.id.viewmodelBtnA);
		viewmodelBtnA.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
				myvm.getTxtA().setValue("click changed");
            }
        });

	}


}
