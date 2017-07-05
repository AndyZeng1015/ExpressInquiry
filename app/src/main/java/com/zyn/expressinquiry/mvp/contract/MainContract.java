package com.zyn.expressinquiry.mvp.contract;

import com.zyn.expressinquiry.mvp.model.entity.BaseResponseData;
import com.zyn.expressinquiry.mvp.model.entity.ExpressData;

/**
 * Desc:
 * CreateDate: 2017/7/4 11:43
 * Author: Created by ZengYinan
 * Email: 498338021@qq.com
 */

public interface MainContract {
    public interface IMainView{
        void showLoadingView();//显示加载框
        void hideLoadingView();//隐藏加载框
        void setData(BaseResponseData<ExpressData> data);//返回数据
    }

    public interface IMainPresenter{
        void loadData(String searchData);//加载数据
    }

}
