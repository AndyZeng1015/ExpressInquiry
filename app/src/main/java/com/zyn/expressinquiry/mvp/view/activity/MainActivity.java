package com.zyn.expressinquiry.mvp.view.activity;

import android.Manifest;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.zyn.expressinquiry.R;
import com.zyn.expressinquiry.di.component.DaggerMainViewComponent;
import com.zyn.expressinquiry.di.module.MainViewModule;
import com.zyn.expressinquiry.mvp.contract.MainContract;
import com.zyn.expressinquiry.mvp.model.entity.BaseResponseData;
import com.zyn.expressinquiry.mvp.model.entity.ExpressData;
import com.zyn.expressinquiry.mvp.view.activity.base.BaseActivity;
import com.zyn.expressinquiry.mvp.view.adapter.SearchResultAdapter;
import com.zyn.expressinquiry.mvp.view.widget.LoadingDialog;
import com.zyn.scancodelib.CommonScanActivity;
import com.zyn.scancodelib.utils.Constant;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.RuntimePermissions;

@RuntimePermissions
public class MainActivity extends BaseActivity implements MainContract.IMainView {


    private static final int SCANNER_CODE = 1;
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
        initListener();
    }

    private void initListener() {
        //下拉刷新
        mSrlRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mIMainPresenter.loadDataByRefresh(mEtContent.getText().toString().trim());
            }
        });

        //点击扫描
        mIvScanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivityPermissionsDispatcher.startActionWithCheck(MainActivity.this);
            }
        });

    }

    @NeedsPermission(Manifest.permission.CAMERA)
    public void startAction() {
        Intent intent = new Intent(MainActivity.this, CommonScanActivity.class);
        intent.putExtra(Constant.REQUEST_SCAN_MODE,Constant.REQUEST_SCAN_MODE_ALL_MODE);
        startActivityForResult(intent, SCANNER_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        MainActivityPermissionsDispatcher.onRequestPermissionsResult(this, requestCode, grantResults);
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
    public void hideRefreshView(){
        if(mSrlRefresh.isRefreshing()){
            mSrlRefresh.setRefreshing(false);
        }
    }

    @Override
    public void setData(BaseResponseData<ExpressData> data) {
        mDataBeanList.clear();
        if(data.getShowapi_res_code() != 0){
            //失败
            Toast.makeText(MainActivity.this, data.getShowapi_res_error(), Toast.LENGTH_SHORT).show();
        }else{
            if(data.getShowapi_res_body().getRet_code() != 0 || data.getShowapi_res_body().getMsg() != null){
                //失败
                Toast.makeText(MainActivity.this, data.getShowapi_res_body().getMsg(), Toast.LENGTH_SHORT).show();
            }else{
                mDataBeanList.addAll(data.getShowapi_res_body().getData());
            }
        }
        mSearchResultAdapter.notifyDataSetChanged();
    }

    @OnClick(R.id.btn_search)
    public void onViewClicked() {
        mIMainPresenter.loadData(mEtContent.getText().toString().trim());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(data != null){
            switch (requestCode){
                case SCANNER_CODE:
                    mEtContent.setText(data.getStringExtra("data"));
                    break;
                default:
                    break;
            }
        }
    }
}
