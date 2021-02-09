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
import android.widget.EditText;

import androidx.core.app.ActivityCompat;

public class LogActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);
        initView();
    }

    private EditText etlog;
    private void initView() {
        etlog = findViewById(R.id.etlog);
	ExeCommand exe=new ExeCommand().run("logcat -d");
	etlog.setText(exe.getResult());

    }

}
