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
import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;
import android.provider.MediaStore;
import java.io.File;
import android.content.Context;
import android.net.Uri;
import android.Manifest;
import android.content.pm.PackageManager;
import androidx.core.app.ActivityCompat;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import java.net.URL;
import java.io.InputStream;
import android.graphics.ImageDecoder;
import android.graphics.BitmapFactory;
import android.content.ContentResolver;
import android.graphics.drawable.BitmapDrawable;

public class ImageDFinderActivity extends AppCompatActivity{
    private static final String[] needPermissions={
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE
    };
    private boolean hasPermission(){
        for (String permission:needPermissions) {
            if(PackageManager.PERMISSION_GRANTED != ActivityCompat.checkSelfPermission(this,permission)){
                return false;
            }
        }
        return true;
    }
    private void grant(){
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
                                ActivityCompat.requestPermissions(ImageDFinderActivity.this,needPermissions,12);
                            }
                        }).setNegativeButton("就不", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(ImageDFinderActivity.this,"用不了的",Toast.LENGTH_SHORT).show();
                            }
                        }).show();
                }else {
                    ActivityCompat.requestPermissions(ImageDFinderActivity.this, needPermissions, 12);
                }
                return;
            }
        }
    }
    public void onRequestPermissionsResult(int requestCode,  String[] permissions, int[] grantResults) {
        Toast.makeText(this,"进入授权回调",Toast.LENGTH_SHORT).show();
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode!=12)return;
        for(int p : grantResults){
            if(p!= PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this,"有权限没有开启哦~",Toast.LENGTH_SHORT).show();
                return;
            }
        }
        Toast.makeText(this,"授权成功，再点试试吧~",Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imgdfinder);
        grant();
        initView();
    }
    @Override
    protected void onResume(){
        super.onResume();
        if(!hasPermission())return;
        tv.setText(getLastPhotoByPath(this).toString());
        ImageDFinder idf = new ImageDFinder(getBitmap(getLastPhotoByPath(this)));
		tv.setCompoundDrawables(null,null,null,new BitmapDrawable(getResources(),idf.CompareVerticalSplit(370,1021,1049,637D/651D)));
    }

    TextView tv;
    ImageView imgfinderImgView; 
    void initView(){
        tv = findViewById(R.id.imgfinderTV);
        imgfinderImgView = findViewById(R.id.imgfinderImgView);
    }
    private Bitmap getBitmap(Uri uri){
        try{
            ContentResolver resolver = getContentResolver();
            InputStream is =resolver.openInputStream(uri); 
            return BitmapFactory.decodeStream(is);
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }



    private Drawable LoadImageFromWebOperations(String url)
    {
         try
         {
             ContentResolver resolver = getContentResolver();
             InputStream is =resolver.openInputStream(Uri.parse(url)); 
             //InputStream is = (InputStream) new URL(url).getContent();
             Drawable d = Drawable.createFromStream(is, "src name");
             return d;
         }catch (Exception e) {
             e.printStackTrace();
            tv.setText(e.toString());
             return null;
         }
     }
    /**

     * 	  本次查询的就是针对 相机里面的图片进行搜查,获得最近一排的一张照片,的路径


     * @return 路径
     *
    */

    public static Uri getLastPhotoByPath(Context context) {


        Cursor myCursor = null;

        Uri uriExternal = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;

        Uri pathLast = uriExternal;
        // Create a Cursor to obtain the file Path for the large image

        String[] largeFileProjection = {

            MediaStore.Images.ImageColumns._ID

            };

        String largeFileSort = MediaStore.Images.ImageColumns._ID + " DESC";

        myCursor =

            context.getContentResolver().query(

                    MediaStore.Images.Media.EXTERNAL_CONTENT_URI,

                    largeFileProjection, null, null, largeFileSort);



        if (myCursor.getCount()<1) {

            myCursor.close();

            return pathLast;

        }

        if(myCursor.moveToNext()) {

            String data = myCursor.getString(myCursor.getColumnIndexOrThrow(MediaStore.Images.Media._ID));


            pathLast=Uri.withAppendedPath(uriExternal, data);


        }

        myCursor.close();

        return pathLast;



    }

}
