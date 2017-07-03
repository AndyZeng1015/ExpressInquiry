package com.zyn.expressinquiry.mvp.view.activity.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.zyn.expressinquiry.app.ActivityManager;

/**
 * Desc: Activity的基类
 * CreateDate: 2017/7/3 16:52
 * Author: Created by ZengYinan
 * Email: 498338021@qq.com
 */

public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //将本Activity加入到LinkedList集合中
        ActivityManager.getInstance().addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //当本Activity被销毁时，从LinkedList集合中移除
        ActivityManager.getInstance().removeActivity(this);
    }
}
