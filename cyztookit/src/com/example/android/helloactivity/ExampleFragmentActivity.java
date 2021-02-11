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
import android.widget.Toast;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class ExampleFragmentActivity extends AppCompatActivity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fragmenttest);
		initView();
	}
	void initView(){
		Button btnAdd = findViewById(R.id.fragtestbtnadd);
		Button btnReplace= findViewById(R.id.fragtestbtnreplace);
		btnAdd.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View view){
				FragmentManager fragmentManager = getSupportFragmentManager();
				FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
				ExampleFragment fragment = new ExampleFragment();
				fragmentTransaction.add(R.id.fragleft, fragment);
				fragmentTransaction.commit();
			}

		});
	}

}
