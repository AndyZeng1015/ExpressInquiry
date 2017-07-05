package com.zyn.expressinquiry.mvp.model.entity;

/**
 * Desc: 接口返回对象基类
 * CreateDate: 2017/7/3 11:07
 * Author: Created by ZengYinan
 * Email: 498338021@qq.com
 */

public class BaseResponseData<T> {
    private int showapi_res_code;//返回码
    private String showapi_res_error;//错误信息
    private T data;//包含信息

    public int getShowapi_res_code() {
        return showapi_res_code;
    }

    public void setShowapi_res_code(int showapi_res_code) {
        this.showapi_res_code = showapi_res_code;
    }

    public String getShowapi_res_error() {
        return showapi_res_error;
    }

    public void setShowapi_res_error(String showapi_res_error) {
        this.showapi_res_error = showapi_res_error;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "BaseResponseData{" +
                "showapi_res_code=" + showapi_res_code +
                ", showapi_res_error='" + showapi_res_error + '\'' +
                ", data=" + data +
                '}';
    }
}
