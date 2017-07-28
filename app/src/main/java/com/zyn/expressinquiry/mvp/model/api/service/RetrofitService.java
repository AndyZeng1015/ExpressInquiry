package com.zyn.expressinquiry.mvp.model.api.service;

import android.support.annotation.NonNull;

import com.google.gson.Gson;
import com.orhanobut.logger.Logger;
import com.zyn.expressinquiry.mvp.model.api.Api;
import com.zyn.expressinquiry.mvp.model.entity.BaseResponseData;
import com.zyn.expressinquiry.mvp.model.entity.ExpressData;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.Buffer;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Desc:
 * CreateDate: 2017/7/3 11:35
 * Author: Created by ZengYinan
 * Email: 498338021@qq.com
 */

public class RetrofitService {
    private static final String BASEURL = "https://route.showapi.com/";

    private static Api mApi;

    /**
     * 初始化网络通信服务
     */
    public static void init() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .retryOnConnectionFailure(true)//连接失败后是否重新连接
                .addInterceptor(loggingInterceptor)//设置拦截器
                .connectTimeout(10, TimeUnit.SECONDS)//超时时间10S
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASEURL)
                .build();


        mApi = retrofit.create(Api.class);
    }

    //自定义拦截器，打印请求地址
    //注意！！！此处不能使用response.body.string获取返回的json数据，会导致关闭错误
    private static final Interceptor loggingInterceptor = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            final Request request = chain.request();

            Logger.t("RetrofitService").d(request.url());

            final Response response = chain.proceed(request);

//            BaseResponseData<ExpressData> data = new Gson().fromJson(response.body().string(), BaseResponseData.class);

            //Logger.t("RetrofitService").d(data.toString());

            return response;
        }
    };


    /*--------------------------------- API ---------------------------------*/

    /**
     * 获取查询的物流信息
     * @param map
     * @return
     */
    public static Observable<BaseResponseData<ExpressData>> getExpressData(Map<String, String> map){
        return mApi.searchExpress(map)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
