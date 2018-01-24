package com.ay.user.ui.activity;

import android.content.Intent;
import android.os.Handler;

import com.ay.user.R;
import com.ay.user.comman.UserInforUtils;
import com.ay.user.mvp.Presenter.LoginPresenter;
import com.ay.user.mvp.PresenterView.LoginView;
import com.ay.user.mvp.model.LoginRes;
import com.ay.user.ui.activity.base.MvpActivity;
import com.lgy.utilslibrary.Bean.ErrorMsg;
import com.lgy.utilslibrary.utils.StringUtils;


/**
 * Created by ${lgy} on 2017/11/2808:32
 * 邮箱1343168198@qq.com
 * 描述： describe
 * 修改内容：
 */

public class WelComeActivity extends MvpActivity<LoginPresenter> implements LoginView {


    @Override
    protected LoginPresenter createPresenter() {
        return new LoginPresenter(this);
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_welcome;
    }

    @Override
    public void initData() {
        super.initData();
        final String account = UserInforUtils.getInstance().getAccount();
        final String password = UserInforUtils.getInstance().getPassWord();
        if (StringUtils.isEmpty(account) || StringUtils.isEmpty(password)) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(new Intent(WelComeActivity.this, LoginActivity.class));
                    finish();
                }
            }, 500);

        } else {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    mvpPresenter.loadData(account, password);
                }
            }, 500);

        }
    }

    @Override
    public void onLoginSuccess(LoginRes loginResp) {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    @Override
    public void loadDataFail(ErrorMsg msg) {
        super.loadDataFail(msg);
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }

    @Override
    public void saveUserInfor(LoginRes loginResp) {

    }
}
