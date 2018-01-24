package com.ay.user.mvp.Presenter;

import com.ay.user.comman.UserInforUtils;
import com.ay.user.mvp.PresenterView.ForgetPwdView;
import com.ay.user.mvp.model.ForgetPwdRes;
import com.ay.user.mvp.req.ModifyPwdReq;
import com.lgy.utilslibrary.retrofit.ApiCallback;

/**
 * Created by ${lgy} on 2017/11/2115:15
 * 邮箱1343168198@qq.com
 * 描述： describe
 * 修改内容：
 */

public class ForgetPwdPresenter extends BasePresenter<ForgetPwdView> {
    private ModifyPwdReq modifyPwdReq;

    public ForgetPwdPresenter(ForgetPwdView mvpView) {
        super(mvpView);
        modifyPwdReq = new ModifyPwdReq();
    }

    public void loadData(String oldPwd, String newPwd) {
        int userId = UserInforUtils.getInstance().getUserId();
        modifyPwdReq.setUserId(userId);
        modifyPwdReq.setOldPwd(oldPwd);
        modifyPwdReq.setNewPwd(newPwd);
        modifyPwdReq.setCommand(5);
        addSubscription(apiStores.modifyPassword(modifyPwdReq), new ApiCallback<ForgetPwdRes>(mvpView, true) {
            @Override
            public void onSuccess(ForgetPwdRes model) {
                mvpView.onForgetPwdSuccess(model);
            }
        });
    }
}
