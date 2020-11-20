package com.example.android.helloactivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class CameraActivity extends Activity {
    private final int CAMERA_REQUEST = 100;
    private ImageView ivLifa;
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
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent,CAMERA_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch(requestCode){
            case CAMERA_REQUEST:
                if(resultCode == RESULT_OK)
                {
    //                  Bitmap bmp = (Bitmap)data.getExtras().get("data");
       //             ivLifa.setImageBitmap(bmp);
                    Toast.makeText(CameraActivity.this,"camera ret",Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
