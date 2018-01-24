package com.ay.user.mvp.PresenterView;

import com.ay.user.mvp.model.ProductListRes;
import com.lgy.utilslibrary.mvp.PresenterView.BaseView;

/**
 * Created by ${lgy} on 2017/11/2115:16
 * 邮箱1343168198@qq.com
 * 描述： describe
 * 修改内容：
 */

public interface ProductListView extends BaseView {
    void onProductSuccess(ProductListRes productListRes);

}
