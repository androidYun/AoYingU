package com.ay.user.mvp.Presenter;

import com.ay.user.comman.UserInforUtils;
import com.ay.user.mvp.PresenterView.ProductListView;
import com.ay.user.mvp.model.ProductListRes;
import com.ay.user.mvp.req.ProductListReq;
import com.lgy.utilslibrary.retrofit.ApiCallback;

/**
 * Created by ${lgy} on 2017/11/2115:15
 * 邮箱1343168198@qq.com
 * 描述： describe
 * 修改内容：
 */

public class ProductListPresenter extends BasePresenter<ProductListView> {
    private ProductListReq productListReq;

    public ProductListPresenter(ProductListView mvpView) {
        super(mvpView);
        productListReq = new ProductListReq();
    }

    public void loadData() {
        int userId = UserInforUtils.getInstance().getUserId();
        productListReq.setUserId(userId);
        productListReq.setCommand(4);
        addSubscription(apiStores.getProcduceList(productListReq), new ApiCallback<ProductListRes>(mvpView, true) {
            @Override
            public void onSuccess(ProductListRes model) {
                mvpView.onProductSuccess(model);
            }
        });
    }
}
