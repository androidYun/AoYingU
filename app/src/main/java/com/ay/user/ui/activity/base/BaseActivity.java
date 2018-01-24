package com.ay.user.ui.activity.base;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.lgy.utilslibrary.Bean.ErrorMsg;

import butterknife.ButterKnife;

/**
 * Created by ${lgy} on 2017/11/1708:30
 * 邮箱1343168198@qq.com
 * 描述： describe
 * 修改内容：
 */

public abstract class BaseActivity extends AppCompatActivity {
    public Activity mActivity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int viewId = getContentViewId();
        setContentView(viewId);
        ButterKnife.bind(this);
        mActivity = this;
        initView();
        initData();
        bindEventListener();
    }

    public abstract int getContentViewId();

    protected void initView() {

    }

    public void initData() {
    }

    public void bindEventListener() {
    }

    public ProgressDialog progressDialog;

    public ProgressDialog showProgressDialog() {
        progressDialog = new ProgressDialog(mActivity);
        progressDialog.setMessage("加载中");
        progressDialog.show();
        return progressDialog;
    }

    public ProgressDialog showProgressDialog(CharSequence message) {
        progressDialog = new ProgressDialog(mActivity);
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
        Toast.makeText(this, msg.getErrorMsg(), Toast.LENGTH_SHORT).show();
    }

}
