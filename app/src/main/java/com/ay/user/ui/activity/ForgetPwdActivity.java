package com.ay.user.ui.activity;

import android.widget.Button;
import android.widget.EditText;

import com.ay.user.R;
import com.ay.user.mvp.Presenter.ForgetPwdPresenter;
import com.ay.user.mvp.PresenterView.ForgetPwdView;
import com.ay.user.mvp.model.ForgetPwdRes;
import com.ay.user.ui.activity.base.MvpActivity;
import com.ay.user.views.NotNullTextWatcher;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by ${lgy} on 2017/11/2512:12
 * 邮箱1343168198@qq.com
 * 描述： describe
 * 修改内容：
 */

public class ForgetPwdActivity extends MvpActivity<ForgetPwdPresenter> implements ForgetPwdView {
    @BindView(R.id.ev_original_pwd)
    EditText evOriginalPwd;
    @BindView(R.id.ev_new_pwd)
    EditText evNewPwd;
    @BindView(R.id.btn_confirm)
    Button btnConfirm;

    @Override
    protected ForgetPwdPresenter createPresenter() {
        return new ForgetPwdPresenter(this);
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_forget_pwd;
    }

    @Override
    protected void initView() {
        super.initView();
        evNewPwd.addTextChangedListener(new NotNullTextWatcher(btnConfirm, evNewPwd, evOriginalPwd));
    }

    @Override
    public void initData() {
        super.initData();

    }

    @Override
    public void onForgetPwdSuccess(ForgetPwdRes forgetPwdRes) {
        finish();
    }


    @OnClick(R.id.btn_confirm)
    public void onViewClicked() {
        String oriPwd = evOriginalPwd.getText().toString();
        String newPwd = evNewPwd.getText().toString();
        mvpPresenter.loadData(oriPwd, newPwd);
    }
}
