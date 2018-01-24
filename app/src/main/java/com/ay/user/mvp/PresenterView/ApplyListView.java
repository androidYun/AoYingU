package com.ay.user.mvp.PresenterView;

import com.ay.user.mvp.model.ApplyListRes;
import com.lgy.utilslibrary.mvp.PresenterView.BaseView;

/**
 * Created by ${lgy} on 2017/11/2115:16
 * 邮箱1343168198@qq.com
 * 描述： describe
 * 修改内容：
 */

public interface ApplyListView extends BaseView {
    void onApplyListSuccess(ApplyListRes applyListRes);

    void onLoadMoreSuccess(ApplyListRes applyListRes);

}
