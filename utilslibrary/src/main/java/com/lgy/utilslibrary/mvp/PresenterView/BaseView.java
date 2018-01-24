package com.lgy.utilslibrary.mvp.PresenterView;


import com.lgy.utilslibrary.Bean.ErrorMsg;

/**
 * 作者：${李桂云} on 2016/10/25 11:32
 * 邮箱：1343168198@qq.com
 */
public interface BaseView {

    void showLoading();

    void hideLoading();

    void loadDataFail(ErrorMsg msg);


}
