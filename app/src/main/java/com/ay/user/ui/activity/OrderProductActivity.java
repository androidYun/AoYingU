package com.ay.user.ui.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ay.user.R;
import com.ay.user.mvp.Presenter.ProductListPresenter;
import com.ay.user.mvp.PresenterView.ProductListView;
import com.ay.user.mvp.model.ProductListRes;
import com.ay.user.ui.activity.base.MvpActivity;
import com.ay.user.ui.adapter.ProductListAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by ${lgy} on 2017/11/2412:48
 * 邮箱1343168198@qq.com
 * 描述： describe
 * 修改内容：
 */

public class OrderProductActivity extends MvpActivity<ProductListPresenter> implements ProductListView {
    @BindView(R.id.rv_cp_list)
    RecyclerView rvCpList;
    private ProductListAdapter productListAdapter;

    private List<ProductListRes.DataBean> mListData = new ArrayList<>();

    @Override
    public int getContentViewId() {
        return R.layout.activity_cp_list;
    }

    @Override
    protected ProductListPresenter createPresenter() {
        return new ProductListPresenter(this);
    }

    @Override
    public void initData() {
        super.initData();
        productListAdapter = new ProductListAdapter(this, R.layout.list_cp_list_item, mListData);
        rvCpList.setLayoutManager(new LinearLayoutManager(this));
        rvCpList.setAdapter(productListAdapter);
        mvpPresenter.loadData();
    }

    @Override
    public void onProductSuccess(ProductListRes productListRes) {
        mListData.clear();
        mListData.addAll(productListRes.data);
        productListAdapter.notifyDataSetChanged();
    }

}
