package com.zyn.expressinquiry.mvp.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.gson.Gson;
import com.orhanobut.logger.Logger;
import com.squareup.leakcanary.CanaryLog;
import com.zyn.expressinquiry.R;
import com.zyn.expressinquiry.app.EIApplication;
import com.zyn.expressinquiry.mvp.model.api.service.RetrofitService;
import com.zyn.expressinquiry.mvp.model.entity.BaseResponseData;
import com.zyn.expressinquiry.mvp.model.entity.ExpressData;
import com.zyn.expressinquiry.utils.NetUtils;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}
