package com.lgy.utilslibrary.mvp.PresenterView;

import com.lgy.utilslibrary.mvp.Presenter.model.TestResp;

/**
 * Created by ${lgy} on 2017/11/2210:20
 * 邮箱1343168198@qq.com
 * 描述： describe
 * 修改内容：
 */

public interface TestView extends BaseView {

    void onLoginSuccess(TestResp testResp);

}
