package com.ay.user.ui.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.ay.user.R;
import com.ay.user.comman.UserInforUtils;
import com.ay.user.mvp.Presenter.LoginPresenter;
import com.ay.user.mvp.PresenterView.LoginView;
import com.ay.user.mvp.model.LoginRes;
import com.ay.user.ui.activity.base.MvpActivity;
import com.ay.user.utils.ToastUtil;
import com.ay.user.views.NotNullTextWatcher;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by ${lgy} on 2017/11/2115:12
 * 邮箱1343168198@qq.com
 * 描述： describe
 * 修改内容：
 */

public class LoginActivity extends MvpActivity<LoginPresenter> implements LoginView {
    @BindView(R.id.ev_account)
    EditText evAccount;
    @BindView(R.id.ev_pwd)
    EditText evPwd;
    @BindView(R.id.ev_name)
    EditText evName;
    @BindView(R.id.btn_confirm)
    Button btnConfirm;
    @BindView(R.id.tv_forget_pwd)
    TextView tvForgetPwd;

    @Override
    public int getContentViewId() {
        return R.layout.activity_login;
    }

    @Override
    protected LoginPresenter createPresenter() {
        return new LoginPresenter(this);
    }

    @Override
    protected void initView() {
        super.initView();
        evAccount.addTextChangedListener(new NotNullTextWatcher(btnConfirm, evPwd));
        evPwd.addTextChangedListener(new NotNullTextWatcher(btnConfirm, evAccount));
    }

    @Override
    public void initData() {
        super.initData();
        String account = UserInforUtils.getInstance().getAccount();
        String passWord = UserInforUtils.getInstance().getPassWord();
        evAccount.setText(account);
        evPwd.setText(passWord);
    }


    @Override
    public void onLoginSuccess(LoginRes loginResp) {
        ToastUtil.showLong(this, "登录成功");
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    @Override
    public void saveUserInfor(LoginRes loginResp) {
        UserInforUtils.getInstance().setUserId(loginResp.getUserId());
        UserInforUtils.getInstance().setAccount(evAccount.getText().toString());
        UserInforUtils.getInstance().setPassWord(evPwd.getText().toString());
    }


    @OnClick({R.id.btn_confirm, R.id.tv_forget_pwd})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_confirm:
                String account = evAccount.getText().toString();
                String passWord = evPwd.getText().toString();
                mvpPresenter.loadData(account, passWord);
                break;
            case R.id.tv_forget_pwd:
                startActivity(new Intent(this, ForgetPwdActivity.class));
                break;
        }
    }
}
