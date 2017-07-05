package com.zyn.expressinquiry.mvp.view.activity;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.orhanobut.logger.Logger;
import com.zyn.expressinquiry.R;
import com.zyn.expressinquiry.di.component.DaggerMainViewComponent;
import com.zyn.expressinquiry.mvp.contract.MainContract;
import com.zyn.expressinquiry.mvp.model.entity.BaseResponseData;
import com.zyn.expressinquiry.mvp.model.entity.ExpressData;
import com.zyn.expressinquiry.mvp.view.activity.base.BaseActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements MainContract.IMainView {


    @Inject
    MainContract.IMainPresenter mIMainPresenter;
    @BindView(R.id.et_content)
    EditText mEtContent;
    @BindView(R.id.btn_search)
    Button mBtnSearch;
    @BindView(R.id.rlv_list)
    RecyclerView mRlvList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initView();
        initDagger();
        super.onCreate(savedInstanceState);
    }

    private void initDagger() {
        DaggerMainViewComponent.create().inject(this);
    }

    private void initView() {
        setContentView(R.layout.activity_main);
    }

    @Override
    public void showLoadingView() {

    }

    @Override
    public void hideLoadingView() {

    }

    @Override
    public void setData(BaseResponseData<ExpressData> data) {

    }

    @OnClick(R.id.btn_search)
    public void onViewClicked() {
        mIMainPresenter.loadData("443775912155");
    }
}
