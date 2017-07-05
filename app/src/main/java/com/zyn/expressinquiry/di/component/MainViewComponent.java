package com.zyn.expressinquiry.di.component;

import com.zyn.expressinquiry.di.module.MainViewModule;
import com.zyn.expressinquiry.mvp.view.activity.MainActivity;

import dagger.Component;

/**
 * Desc:
 * CreateDate: 2017/7/4 17:37
 * Author: Created by ZengYinan
 * Email: 498338021@qq.com
 */

@Component(modules = {MainViewModule.class})
public interface MainViewComponent {
    public void inject(MainActivity activity);
}
