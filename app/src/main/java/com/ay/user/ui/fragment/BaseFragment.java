package com.ay.user.ui.fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.lgy.utilslibrary.Bean.ErrorMsg;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by ${lgy} on 2017/11/1708:41
 * 邮箱1343168198@qq.com
 * 描述： describe
 * 修改内容：
 */

public abstract class BaseFragment extends Fragment {


    private Unbinder unbinder;

    private Context mContext;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(getContentViewId(), container, false);
        unbinder = ButterKnife.bind(this, inflate);
        initView();
        initData();
        bindEventListener();
        return inflate;
    }

    public abstract int getContentViewId();

    protected void initView() {

    }

    public void initData() {
    }

    public void bindEventListener() {
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (unbinder != null) {
            unbinder.unbind();
        }
    }

    public ProgressDialog progressDialog;

    public ProgressDialog showProgressDialog() {
        progressDialog = new ProgressDialog(mContext);
        progressDialog.setMessage("加载中");
        progressDialog.show();
        return progressDialog;
    }

    public ProgressDialog showProgressDialog(CharSequence message) {
        progressDialog = new ProgressDialog(mContext);
        progressDialog.setMessage(message);
        progressDialog.show();
        return progressDialog;
    }

    public void dismissProgressDialog() {
        if (progressDialog != null && progressDialog.isShowing()) {
            // progressDialog.hide();会导致android.view.WindowLeaked
            progressDialog.dismiss();
        }
    }

    public void showLoading() {
        showProgressDialog();
    }


    public void hideLoading() {
        dismissProgressDialog();
    }

    public void loadDataFail(ErrorMsg msg) {
        Toast.makeText(mContext, msg.getErrorMsg(), Toast.LENGTH_SHORT).show();
    }

}
