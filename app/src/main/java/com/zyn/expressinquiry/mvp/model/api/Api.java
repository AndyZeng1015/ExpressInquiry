package com.zyn.expressinquiry.mvp.model.api;

import com.zyn.expressinquiry.mvp.model.entity.BaseResponseData;
import com.zyn.expressinquiry.mvp.model.entity.ExpressData;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Desc: Api接口
 * CreateDate: 2017/6/28 23:11
 * Author: Created by ZengYinan
 * Email: 498338021@qq.com
 */

public interface Api {
    /**
     *  查询快递
     *  @param map 查询参数
     * @return
     */
    @GET("64-19")
    Observable<BaseResponseData<ExpressData>> searchExpress(@QueryMap Map<String, String> map);
}
