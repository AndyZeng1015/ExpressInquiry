package com.zyn.expressinquiry.mvp.model.api.service;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.orhanobut.logger.Logger;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * Desc:
 * CreateDate: 2017/7/28 11:46
 * Author: Created by ZengYinan
 * Email: 498338021@qq.com
 */

final class GsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private final Gson gson;
    private final TypeAdapter<T> adapter;

    GsonResponseBodyConverter(Gson gson, TypeAdapter<T> adapter) {
        this.gson = gson;
        this.adapter = adapter;
    }

    @Override public T convert(ResponseBody value) throws IOException {
        JsonReader jsonReader = gson.newJsonReader(value.charStream());
        Logger.t("ZYN").e(jsonReader.toString());
        try {
            return adapter.read(jsonReader);
        } catch (Exception e){
            e.printStackTrace();
        }finally {
            value.close();
        }
        return null;
    }
}
