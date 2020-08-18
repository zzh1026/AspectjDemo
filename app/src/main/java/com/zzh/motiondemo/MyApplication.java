package com.zzh.motiondemo;

import android.app.Application;
import android.content.DialogInterface;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;

/**
 * 车主邦
 * ---------------------------
 * <p>
 * Created by zhaozh on 2020/7/30.
 */
public class MyApplication extends Application {

    public static boolean isLogin;  //是否登录

    @Override
    public void onCreate() {
        super.onCreate();

        LogUtils.getConfig().setGlobalTag("alog");
        Toast.makeText(this,"toast", Toast.LENGTH_SHORT).show();
        LogUtils.e("MyApplication is start");


    }
}
