package com.ay.user.mvp.Presenter;

import com.ay.user.comman.UserInforUtils;
import com.ay.user.mvp.PresenterView.ApplyListView;
import com.ay.user.mvp.model.ApplyListRes;
import com.ay.user.mvp.req.ApplyListReq;
import com.lgy.utilslibrary.retrofit.ApiCallback;

/**
 * Created by ${lgy} on 2017/11/2115:15
 * 邮箱1343168198@qq.com
 * 描述： describe
 * 修改内容：
 */

public class ApplyListPresenter extends BasePresenter<ApplyListView> {
    private ApplyListReq applyListReq;

    public ApplyListPresenter(ApplyListView view) {
        super(view);
    }

    public void loadData(String key, int type,int pageIndex) {
        applyListReq = new ApplyListReq();
        int userId = UserInforUtils.getInstance().getUserId();
        applyListReq.setUserId(0);
        applyListReq.setKey(key);
        applyListReq.setType(type);
        applyListReq.setCommand(3);
        applyListReq.setUserId(userId);
        applyListReq.setPageIndex(pageIndex);
        addSubscription(apiStores.getApplyListRecord(applyListReq), new ApiCallback<ApplyListRes>(mvpView, true) {
            @Override
            public void onSuccess(ApplyListRes model) {
                mvpView.onApplyListSuccess(model);
            }
        });
    }
    public void loadMoreData(String key, int type,int pageIndex) {
        applyListReq = new ApplyListReq();
        int userId = UserInforUtils.getInstance().getUserId();
        applyListReq.setUserId(0);
        applyListReq.setKey(key);
        applyListReq.setType(type);
        applyListReq.setCommand(3);
        applyListReq.setUserId(userId);
        applyListReq.setPageIndex(pageIndex);
        addSubscription(apiStores.getApplyListRecord(applyListReq), new ApiCallback<ApplyListRes>(mvpView, true) {
            @Override
            public void onSuccess(ApplyListRes model) {
                mvpView.onLoadMoreSuccess(model);
            }
        });
    }
}
