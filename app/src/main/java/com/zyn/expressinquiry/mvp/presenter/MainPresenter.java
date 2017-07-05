package com.zyn.expressinquiry.mvp.presenter;

import android.os.SystemClock;
import android.provider.Settings;
import android.util.Log;
import android.widget.Toast;

import com.orhanobut.logger.Logger;
import com.zyn.expressinquiry.mvp.contract.MainContract;
import com.zyn.expressinquiry.mvp.model.api.service.RetrofitService;
import com.zyn.expressinquiry.mvp.model.entity.BaseResponseData;
import com.zyn.expressinquiry.mvp.model.entity.ExpressData;
import com.zyn.expressinquiry.utils.DateUtils;

import org.reactivestreams.Subscriber;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;
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

    public MainPresenter(){
    }

    @Override
    public void loadData(String searchData) {
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
                        Logger.t("MainPresenter").d(expressDataBaseResponseData.toString());
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Logger.t("MainPresenter").d(e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        Logger.t("MainPresenter").d("onComplete");
                    }
                });
    }
}
