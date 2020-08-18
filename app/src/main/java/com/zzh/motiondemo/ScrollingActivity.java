package com.zzh.motiondemo;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.blankj.utilcode.util.ToastUtils;

import java.io.OutputStream;

public class ScrollingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);

    }

    public void insertImage(View view) {
        String desplayName =  "david.jpg";
        ContentResolver contentResolver = getContentResolver();
        ContentValues values = new ContentValues();
        values.put(MediaStore.Images.ImageColumns.DISPLAY_NAME, desplayName);
        values.put(MediaStore.Images.ImageColumns.MIME_TYPE, "image/jpeg");
        values.put(MediaStore.Downloads.RELATIVE_PATH, Environment.DIRECTORY_PICTURES);

        Uri imageUrl = contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);

        try {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
            OutputStream outputStream = contentResolver.openOutputStream(imageUrl);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);
            outputStream.close();
            ToastUtils.showShort("添加成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void quert(View view) {
        Uri external = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        String selection = MediaStore.Images.Media.DISPLAY_NAME + "=?";
        String s = "";

//        getContentResolver().query(external, );


    }
}