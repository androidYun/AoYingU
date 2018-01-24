package com.ay.user.ui.activity;


import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.ay.user.R;
import com.ay.user.bean.ApplyRecordBean;
import com.ay.user.mvp.Presenter.LoginPresenter;
import com.ay.user.ui.activity.base.MvpActivity;
import com.ay.user.ui.fragment.AllOrderFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by ${lgy} on 2017/11/1708:30
 * 邮箱1343168198@qq.com
 * 描述： describe
 * 修改内容：
 */

public class OrderGDActivity extends MvpActivity<LoginPresenter> {//跟单

    @BindView(R.id.tab_gd)
    TabLayout tabGd;
    @BindView(R.id.vp_gd)
    ViewPager vpGd;
    List<ApplyRecordBean> mDataTabList = new ArrayList<>();
    private OrderGdVpAdapter orderGdVpAdapter;

    @Override
    public int getContentViewId() {
        return R.layout.activity_gd_record;
    }

    @Override
    protected void initView() {
        super.initView();
        mDataTabList.add(new ApplyRecordBean("全部", -1));
        mDataTabList.add(new ApplyRecordBean("审核中", 0));
        mDataTabList.add(new ApplyRecordBean("审批成功", 1));
        mDataTabList.add(new ApplyRecordBean("审核失败", 2));
        orderGdVpAdapter = new OrderGdVpAdapter(getSupportFragmentManager());
        vpGd.setAdapter(orderGdVpAdapter);
        //绑定
        tabGd.setupWithViewPager(vpGd);
    }

    @Override
    protected LoginPresenter createPresenter() {
        return null;
    }

    @Override
    public void initData() {
        super.initData();
    }

    public class OrderGdVpAdapter extends FragmentPagerAdapter {

        public OrderGdVpAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            int type = mDataTabList.get(position).getType();
            return AllOrderFragment.getInstance(type);
        }

        @Override
        public int getCount() {
            return mDataTabList.size();
        }

        //重写这个方法，将设置每个Tab的标题
        @Override
        public CharSequence getPageTitle(int position) {
            return mDataTabList.get(position).getApplyState();
        }
    }
}
