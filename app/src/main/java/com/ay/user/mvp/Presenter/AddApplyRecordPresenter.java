package com.ay.user.mvp.Presenter;

import com.ay.user.comman.UserInforUtils;
import com.ay.user.mvp.PresenterView.AddApplyRecordView;
import com.ay.user.mvp.model.AddApplyRecordRes;
import com.ay.user.mvp.model.ProductListRes;
import com.ay.user.mvp.req.ApplyStaffReq;
import com.ay.user.mvp.req.ProductListReq;
import com.lgy.utilslibrary.retrofit.ApiCallback;

/**
 * Created by ${lgy} on 2017/11/2115:15
 * 邮箱1343168198@qq.com
 * 描述： describe
 * 修改内容：
 */

public class AddApplyRecordPresenter extends BasePresenter<AddApplyRecordView> {
    private ApplyStaffReq applyStaffResp;

    private ProductListReq productListResp;

    public AddApplyRecordPresenter(AddApplyRecordView mvpView) {
        super(mvpView);
    }

    public void loadData(String phone, String name, String job, String balance, String productId, String companyNo) {
        int userId = UserInforUtils.getInstance().getUserId();
        applyStaffResp = new ApplyStaffReq();
        applyStaffResp.setPhone(phone);
        applyStaffResp.setUserId(userId);
        applyStaffResp.setBalance(balance);
        applyStaffResp.setJob(job);
        applyStaffResp.setProductId(productId);
        applyStaffResp.setCompanyNo(companyNo);
        applyStaffResp.setName(name);
        applyStaffResp.setCommand(2);
        addSubscription(apiStores.addApplyRecord(applyStaffResp), new ApiCallback<AddApplyRecordRes>(mvpView, true) {
            @Override
            public void onSuccess(AddApplyRecordRes model) {
                mvpView.onLoginSuccess(model);
            }
        });
    }

    public void loadProductListData() {
        int userId = UserInforUtils.getInstance().getUserId();
        productListResp = new ProductListReq();
        productListResp.setUserId(userId);
        productListResp.setCommand(4);
        addSubscription(apiStores.getProcduceList(productListResp), new ApiCallback<ProductListRes>(mvpView, false) {
            @Override
            public void onSuccess(ProductListRes model) {
                mvpView.onLoginSuccess(model);
            }
        });
    }
}
