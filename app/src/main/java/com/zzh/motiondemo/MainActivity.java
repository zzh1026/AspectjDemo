package com.zzh.motiondemo;

import android.Manifest;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ScreenUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.zzh.motiondemo.login.CanDoubleClick;
import com.zzh.motiondemo.login.CheckLogin;

public class MainActivity extends AppCompatActivity {

    private TextView mTv4;
    private TextView mTv5;
    private TextView mTv6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 0);
        }
        TextView textView = findViewById(R.id.tv);

//        new AlertDialog.Builder(this)
//                .setMessage("展示")
//                .setNegativeButton("去下去", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        ToastUtils.showShort("点击了取消");
//                    }
//                })
//                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        ToastUtils.showShort("点击了确定");
//                    }
//                })
//                .create()
//                .show();

        int screenWidth = ScreenUtils.getScreenWidth();
        float screenDensity = ScreenUtils.getScreenDensity();
        int screenDensityDpi = ScreenUtils.getScreenDensityDpi();
        StringBuilder sb = new StringBuilder();
        sb.append("screenWidth = " + screenWidth + "\n");
        sb.append("screenDensity = " + screenDensity + "\n");
        sb.append("screenDensityDpi = " + screenDensityDpi + "\n");

        textView.setText(sb.toString());

//        URL url = null;
//        try {
//            url = new URL("skdjf");
//            URLConnection urlConnection = url.openConnection();
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        mTv4 = (TextView) findViewById(R.id.tv4);
        mTv5 = (TextView) findViewById(R.id.tv5);
        mTv6 = (TextView) findViewById(R.id.tv6);
        mTv6.setText("当前登录状态" + MyApplication.isLogin);

        mTv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                tologin();
//                testAdvice();
//                testAdvice1();
                testAdvice2();
                testAdvice3();
            }
        });

        mTv5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyApplication.isLogin = !MyApplication.isLogin;
                mTv6.setText("当前登录状态" + MyApplication.isLogin);
            }
        });

        mTv6.setOnClickListener(new View.OnClickListener() {
            @CanDoubleClick
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(MainActivity.this, ScrollingActivity.class));
                LogUtils.e("点击了button");
            }
        });

        onTestListener();
    }

    public void testAdvice() {
        LogUtils.e("调用了首页的测试方法");
    }

    public void testAdvice1() {
        LogUtils.e("调用了首页的第二个测试方法");
    }

    public String testAdvice2() {
        LogUtils.e("调用了首页的第三个测试方法");
        return "返回第三个测试方法的返回值";
    }

    public void testAdvice3() {
        TextView tv = null;
        tv.setText("呵呵");
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    public void onTestListener() {
    }

    @CheckLogin
    public void tologin() {
        LogUtils.e("登录完毕跳转首页");
//        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.R) {
//            PendingIntent deleteRequest = MediaStore.createDeleteRequest(getContentResolver(),);
//        }
    }
}