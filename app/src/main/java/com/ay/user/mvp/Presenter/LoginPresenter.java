package com.ay.user.mvp.Presenter;

import com.ay.user.mvp.PresenterView.LoginView;
import com.ay.user.mvp.model.LoginRes;
import com.ay.user.mvp.req.LoginReq;
import com.lgy.utilslibrary.retrofit.ApiCallback;

/**
 * Created by ${lgy} on 2017/11/2115:15
 * 邮箱1343168198@qq.com
 * 描述： describe
 * 修改内容：
 */

public class LoginPresenter extends BasePresenter<LoginView> {
    private LoginReq loginRep;

    public LoginPresenter(LoginView mvpView) {
        super(mvpView);
        loginRep = new LoginReq();
    }

    public void loadData(String userName, String passWord) {
        loginRep.setUserId(0);
        loginRep.setPassWord(passWord);
        loginRep.setUserName(userName);
        loginRep.setCommand(1);
        addSubscription(apiStores.loadDataByRetrofit(loginRep), new ApiCallback<LoginRes>(mvpView, true) {
            @Override
            public void onSuccess(LoginRes model) {
                mvpView.onLoginSuccess(model);
                mvpView.saveUserInfor(model);
            }
        });
    }
}
