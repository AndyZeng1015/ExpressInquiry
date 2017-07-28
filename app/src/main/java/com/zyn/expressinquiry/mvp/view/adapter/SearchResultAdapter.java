package com.zyn.expressinquiry.mvp.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zyn.expressinquiry.R;
import com.zyn.expressinquiry.mvp.model.entity.ExpressData;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Desc:
 * CreateDate: 2017/7/28 10:31
 * Author: Created by ZengYinan
 * Email: 498338021@qq.com
 */

public class SearchResultAdapter extends RecyclerView.Adapter<SearchResultAdapter.SearchResultViewHolder> {

    private List<ExpressData.DataBean> mDataBeanList;

    public SearchResultAdapter(List<ExpressData.DataBean> dataBeen) {
        mDataBeanList = dataBeen;
    }

    @Override
    public SearchResultViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_search_result, parent, false);
        return new SearchResultViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SearchResultViewHolder holder, int position) {
        if (mDataBeanList != null) {
            holder.setData(mDataBeanList.get(position));
        }
    }

    @Override
    public int getItemCount() {
        if (mDataBeanList != null) {
            return mDataBeanList.size();
        }
        return 0;
    }

    public class SearchResultViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_date)
        TextView tvDate;
        @BindView(R.id.tv_content)
        TextView tvContent;

        public SearchResultViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(itemView);
        }

        public void setData(ExpressData.DataBean dataBean) {
            tvDate.setText(dataBean.getTime());
            tvContent.setText(dataBean.getContext());
        }
    }

}
