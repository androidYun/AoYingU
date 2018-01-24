package com.ay.user.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ay.user.R;
import com.ay.user.mvp.Presenter.ApplyListPresenter;
import com.ay.user.mvp.PresenterView.ApplyListView;
import com.ay.user.mvp.model.ApplyListRes;
import com.ay.user.ui.adapter.OrderGdAdapter;
import com.ay.user.utils.ToastUtil;
import com.ay.user.views.refreshlayout.RefreshLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * Created by ${lgy} on 2017/11/1708:40
 * 邮箱1343168198@qq.com
 * 描述： describe
 * 修改内容：
 */

public class AllOrderFragment extends MvpFragment<ApplyListPresenter> implements ApplyListView, RefreshLayout.OnRefreshListener {
    @BindView(R.id.rv_gd)
    RecyclerView rvGd;
    @BindView(R.id.refreshlayout)
    RefreshLayout refreshlayout;
    Unbinder unbinder;

    private OrderGdAdapter orderGdAdapter;

    private List<ApplyListRes.UserlistBean> mDataList = new ArrayList<>();

    private int type;

    private int pageNumber = 1;

    private int allPageNumer = 1;//总页数

    public static AllOrderFragment getInstance(int column) {
        Bundle bundle = new Bundle();
        bundle.putInt("type", column);
        AllOrderFragment orderFragment = new AllOrderFragment();
        orderFragment.setArguments(bundle);
        return orderFragment;
    }

    @Override
    public int getContentViewId() {
        return R.layout.fragment_order_gd;
    }

    @Override
    protected ApplyListPresenter createPresenter() {
        return new ApplyListPresenter(this);
    }

    @Override
    protected void initView() {
        super.initView();
        orderGdAdapter = new OrderGdAdapter(getContext(), R.layout.list_gd_item, mDataList);
        rvGd.setLayoutManager(new LinearLayoutManager(getContext()));
        rvGd.setAdapter(orderGdAdapter);
    }

    @Override
    public void initData() {
        super.initData();
        Bundle bundle = getArguments();
        type = bundle.getInt("type");
        pageNumber = 1;
        mvpPresenter.loadData("", type, pageNumber);
    }

    @Override
    public void bindEventListener() {
        super.bindEventListener();
        refreshlayout.setOnRefreshListener(this);
        refreshlayout.setHeaderColorSchemeColors(blue, red, green, yellow);
        refreshlayout.setFooterColorSchemeColors(blue, red, green, yellow);
    }

    @Override
    public void onApplyListSuccess(ApplyListRes applyListRes) {
        mDataList.clear();
        mDataList.addAll(applyListRes.userlist);
        orderGdAdapter.notifyDataSetChanged();
        allPageNumer = applyListRes.pageCount;
        pageNumber++;
    }

    @Override
    public void onLoadMoreSuccess(ApplyListRes applyListRes) {
        mDataList.addAll(applyListRes.userlist);
        orderGdAdapter.notifyDataSetChanged();
        allPageNumer = applyListRes.pageCount;
        pageNumber++;
    }

    @Override
    public void onHeaderRefresh() {
        refreshlayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                pageNumber = 1;
                mvpPresenter.loadData("", type, pageNumber);
                refreshlayout.setHeaderRefreshing(false);
            }
        }, 1000);
    }

    @Override
    public void onFooterRefresh() {
        refreshlayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                refreshlayout.setFooterRefreshing(false);
                if (pageNumber > allPageNumer) {
                    ToastUtil.show(getContext(), "没有更多数据");
                } else {
                    mvpPresenter.loadData("", type, pageNumber);
                }
            }
        }, 1000);
    }


}
