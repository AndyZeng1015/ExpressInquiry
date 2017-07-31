package com.zyn.expressinquiry.mvp.presenter;

import com.orhanobut.logger.Logger;
import com.zyn.expressinquiry.mvp.contract.MainContract;
import com.zyn.expressinquiry.mvp.model.api.service.RetrofitService;
import com.zyn.expressinquiry.mvp.model.entity.BaseResponseData;
import com.zyn.expressinquiry.mvp.model.entity.ExpressData;
import com.zyn.expressinquiry.utils.DateUtils;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * Desc:
 * CreateDate: 2017/7/4 16:39
 * Author: Created by ZengYinan
 * Email: 498338021@qq.com
 */

public class MainPresenter implements MainContract.IMainPresenter {

    MainContract.IMainView mIMainView;

    public MainPresenter(MainContract.IMainView mainView){
        this.mIMainView = mainView;
    }

    @Override
    public void loadData(String searchData) {
        mIMainView.showLoadingView();
        Map<String, String> map = new HashMap<String, String>();
        map.put("com", "auto");
        map.put("nu", searchData);
        map.put("showapi_appid", "41642");
        map.put("showapi_timestamp", DateUtils.getTimestamp());
        map.put("showapi_sign", "7ef175fff6cb42a3893fafa8563a9b08");
        RetrofitService.getExpressData(map)
                .subscribe(new Observer<BaseResponseData<ExpressData>>() {

                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull BaseResponseData<ExpressData> expressDataBaseResponseData) {
                        mIMainView.setData(expressDataBaseResponseData);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        e.printStackTrace();
                        mIMainView.hideLoadingView();
                    }

                    @Override
                    public void onComplete() {
                        mIMainView.hideLoadingView();
                    }
                });
    }

    @Override
    public void loadDataByRefresh(String searchData) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("com", "auto");
        map.put("nu", searchData);
        map.put("showapi_appid", "41642");
        map.put("showapi_timestamp", DateUtils.getTimestamp());
        map.put("showapi_sign", "7ef175fff6cb42a3893fafa8563a9b08");
        RetrofitService.getExpressData(map)
                .subscribe(new Observer<BaseResponseData<ExpressData>>() {

                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull BaseResponseData<ExpressData> expressDataBaseResponseData) {
                        mIMainView.setData(expressDataBaseResponseData);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        e.printStackTrace();
                        mIMainView.hideRefreshView();
                    }

                    @Override
                    public void onComplete() {
                        mIMainView.hideRefreshView();
                    }
                });
    }
}
