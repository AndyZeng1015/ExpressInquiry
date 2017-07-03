package com.zyn.expressinquiry.app;

import android.app.Activity;

import java.util.LinkedList;

/**
 * Desc: 管理Activity
 * CreateDate: 2017/7/3 13:31
 * Author: Created by ZengYinan
 * Email: 498338021@qq.com
 */

public class ActivityManager {
    private LinkedList<Activity> mActivityList = new LinkedList<Activity>();
    private static ActivityManager instance;

    private ActivityManager() {
    }

    public static ActivityManager getInstance() {
        if (null == instance) {
            synchronized (ActivityManager.class) {
                if (null == instance) {
                    instance = new ActivityManager();
                }
            }
        }
        return instance;
    }

    // 添加Activity到容器中
    public void addActivity(Activity activity) {
        mActivityList.add(activity);
    }

    //移除一个Activity
    public void removeActivity(Activity activity) {
        mActivityList.remove(activity);
    }

    //退出所有的activity
    public void exit() {
        for (Activity activity :
                mActivityList) {
            activity.finish();
        }
        System.exit(0);
    }
}
