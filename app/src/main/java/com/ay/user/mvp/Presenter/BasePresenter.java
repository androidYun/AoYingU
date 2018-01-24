package com.ay.user.mvp.Presenter;

import com.ay.user.httpservice.ApiStores;
import com.lgy.utilslibrary.mvp.PresenterView.BaseView;
import com.lgy.utilslibrary.retrofit.ApiClient;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;


/**
 * 作者：${李桂云} on 2016/10/25 11:32
 * 邮箱：1343168198@qq.com
 */
public abstract class BasePresenter<V extends BaseView> {
    public V mvpView;
    protected ApiStores apiStores;
    private CompositeSubscription mCompositeSubscription;


    private boolean isShowProgress;

    public BasePresenter(V view) {
        attachView(view);
    }

    public void attachView(V mvpView) {
        this.mvpView = mvpView;
        ApiClient instance = ApiClient.getInstance();
        apiStores = instance.retrofit().create(ApiStores.class);
    }


    public void detachView() {
        this.mvpView = null;
        onUnsubscribe();
    }


    //RXjava取消注册，以避免内存泄露
    public void onUnsubscribe() {
        if (mCompositeSubscription != null && mCompositeSubscription.hasSubscriptions()) {
            mCompositeSubscription.unsubscribe();
        }
    }


    public void addSubscription(Observable observable, Subscriber subscriber) {
        if (mCompositeSubscription == null) {
            mCompositeSubscription = new CompositeSubscription();
        }
        mCompositeSubscription.add(observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber));
    }



}
