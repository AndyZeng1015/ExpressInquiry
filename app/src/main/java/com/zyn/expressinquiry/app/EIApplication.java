package com.zyn.expressinquiry.app;

import android.app.Application;

import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;
import com.zyn.expressinquiry.mvp.model.api.service.RetrofitService;

/**
 * Desc:
 * CreateDate: 2017/6/29 0:03
 * Author: Created by ZengYinan
 * Email: 498338021@qq.com
 */

public class EIApplication extends Application {

    private RefWatcher mRefWatcher;

    private static EIApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        LeakCanaryInit();
        LoggerInit();
        RetrofitInit();
    }

    public static EIApplication getInstance() {
        return instance;
    }

    /**
     * 初始化logger
     */
    private void LoggerInit() {
        Logger.init();
    }

    /**
     * 初始化LeakCanary
     */
    private void LeakCanaryInit() {
        mRefWatcher = LeakCanary.install(this);
    }

    /**
     * 初始化Retrofit
     */
    private void RetrofitInit(){
        RetrofitService.init();
    }
}
