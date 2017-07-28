package com.zyn.expressinquiry.mvp.view.activity;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.orhanobut.logger.Logger;
import com.squareup.haha.perflib.Main;
import com.zyn.expressinquiry.R;
import com.zyn.expressinquiry.di.component.DaggerMainViewComponent;
import com.zyn.expressinquiry.di.module.MainViewModule;
import com.zyn.expressinquiry.mvp.contract.MainContract;
import com.zyn.expressinquiry.mvp.model.entity.BaseResponseData;
import com.zyn.expressinquiry.mvp.model.entity.ExpressData;
import com.zyn.expressinquiry.mvp.view.activity.base.BaseActivity;
import com.zyn.expressinquiry.mvp.view.adapter.SearchResultAdapter;
import com.zyn.expressinquiry.mvp.view.widget.LoadingDialog;

import java.util.ArrayList;
import java.util.List;

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
    @BindView(R.id.iv_scanner)
    ImageView mIvScanner;
    @BindView(R.id.rlv_list)
    RecyclerView mRlvList;
    @BindView(R.id.srl_refresh)
    SwipeRefreshLayout mSrlRefresh;

    private static Dialog mDialog;

    private List<ExpressData.DataBean> mDataBeanList = new ArrayList<ExpressData.DataBean>();
    private SearchResultAdapter mSearchResultAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initView();
        super.onCreate(savedInstanceState);
        initData();
        initDagger();
    }

    private void initData(){
        mRlvList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mSearchResultAdapter = new SearchResultAdapter(mDataBeanList);
        mRlvList.setAdapter(mSearchResultAdapter);
    }

    private void initDagger() {
        DaggerMainViewComponent.builder().mainViewModule(new MainViewModule(this)).build().inject(this);

    }

    private void initView() {
        setContentView(R.layout.activity_main);
    }

    @Override
    public void showLoadingView() {
        if(mDialog == null){
            mDialog = LoadingDialog.getLoadingDialog(MainActivity.this, "加载中...");
        }
        mDialog.show();
    }

    @Override
    public void hideLoadingView() {
        if(mDialog != null){
            mDialog.dismiss();
        }
    }

    @Override
    public void setData(BaseResponseData<ExpressData> data) {
        mDataBeanList.clear();
        if(data.getShowapi_res_code() != 0){
            //失败
            Toast.makeText(MainActivity.this, data.getShowapi_res_error(), Toast.LENGTH_SHORT).show();
        }else{
            Logger.t("ZYN").e(data.getData().getExpTextName());
            mDataBeanList.addAll(data.getData().getData());
        }
        mSearchResultAdapter.notifyDataSetChanged();
    }

    @OnClick(R.id.btn_search)
    public void onViewClicked() {
        mIMainPresenter.loadData(mEtContent.getText().toString().trim());
    }
}
