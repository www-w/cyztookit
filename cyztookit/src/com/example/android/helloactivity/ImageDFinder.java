package com.example.android.helloactivity;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.Exception;
import android.graphics.Bitmap;
import android.graphics.Color;
import java.lang.Math;
public class ImageDFinder{
    private Bitmap bi;
    public ImageDFinder(Bitmap bmp){
        bi=bmp.copy(Bitmap.Config.ARGB_8888,true);
    }

    public Bitmap CompareVerticalSplit(int startY,int endY,int startY2,double scale){
        for(int r=0;r<endY-startY;r++){
            int row=startY+r;
            int row2=(int)Math.round(scale*r)+startY2;
            for(int col=0;col<bi.getWidth();col++){
                if(rgbDeference(bi.getPixel(col,row),bi.getPixel(col,row2))>20){
                    bi.setPixel(col,row,Color.RED);
                }
		else{
			bi.setPixel(col,row,bi.getPixel(col,row)&0xff00ff00);
		}
            }
        }
        return bi;
/*        try{
            FileOutputStream fos = new FileOutputStream("t.png");
            ImageIO.write(bi,"png",fos);
            fos.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        */
    }
    private int rgbDeference(int a,int b){
        int x1,x2,sum=0;
        // r
        x1=a%256;
        x2=b%256;
        a>>=8;
        b>>=8;
        sum+=Math.abs(x1-x2);
        // r
        x1=a%256;
        x2=b%256;
        a>>=8;
        b>>=8;
        sum+=Math.abs(x1-x2);
        // r
        x1=a%256;
        x2=b%256;
        sum+=Math.abs(x1-x2);
        return sum;
    }
    public Bitmap getImg(){
        return bi;
    }
}
