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

import androidx.core.app.ActivityCompat;
//import androidx.appcompat.app.AppCompatActivity;

public class CameraActivity extends Activity implements ActivityCompat.OnRequestPermissionsResultCallback{
    private final int CAMERA_REQUEST = 100;
    private ImageView ivLifa;
    private static final String[] needPermissions={
            Manifest.permission.CAMERA
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        initView();
    }

    private void initView() {
        ivLifa = findViewById(R.id.iv_lifa);
    }

    public void btnOpenCamera(View view) {
        for (String permission:needPermissions) {
            if(PackageManager.PERMISSION_GRANTED != ActivityCompat.checkSelfPermission(this,permission)){
                if(ActivityCompat.shouldShowRequestPermissionRationale(this,permission)){
                    // 用户曾经拒绝
                    new AlertDialog.Builder(this)
                            .setTitle("需要权限")
                            .setMessage("要拍照需要摄像头权限！")
                            .setPositiveButton("去授权", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    ActivityCompat.requestPermissions(CameraActivity.this,needPermissions,12);
                                }
                            }).setNegativeButton("就不", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(CameraActivity.this,"用不了的",Toast.LENGTH_SHORT);
                        }
                    }).show();
                }else {
                    ActivityCompat.requestPermissions(CameraActivity.this, needPermissions, 12);
                }
                return;
            }
        }
        try {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, CAMERA_REQUEST);
        }catch(Exception e){
            Toast.makeText(this,e.getMessage(),Toast.LENGTH_SHORT);
            e.printStackTrace();
        }
    }

    public void onRequestPermissionsResult(int requestCode,  String[] permissions, int[] grantResults) {
        Toast.makeText(this,"进入授权回调",Toast.LENGTH_SHORT);
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode!=12)return;
        for(int p : grantResults){
            if(p!= PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this,"有权限没有开启哦~",Toast.LENGTH_SHORT);
                return;
            }
        }
        Toast.makeText(this,"授权成功，再点试试吧~",Toast.LENGTH_SHORT);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch(requestCode){
            case CAMERA_REQUEST:
                if(resultCode == RESULT_OK)
                {
                      Bitmap bmp = (Bitmap)data.getExtras().get("data");
                      ivLifa.setImageBitmap(bmp);
        //            Toast.makeText(CameraActivity.this,"camera ret",Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
