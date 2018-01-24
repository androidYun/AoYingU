package com.ay.user.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ay.user.R;
import com.ay.user.mvp.Presenter.BasePresenter;

import butterknife.BindColor;

/**
 * Created by ${lgy} on 2017/11/2510:28
 * 邮箱1343168198@qq.com
 * 描述： describe
 * 修改内容：
 */

public abstract class MvpFragment<P extends BasePresenter> extends BaseFragment {
    @BindColor(R.color.dph_blue)
    public int blue;
    @BindColor(R.color.red)
    public int red;
    @BindColor(R.color.green)
    public int green;
    @BindColor(R.color.yellow)
    public int yellow;
    protected P mvpPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mvpPresenter = createPresenter();
        return super.onCreateView(inflater, container, savedInstanceState);
    }


    protected abstract P createPresenter();


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mvpPresenter != null) {
            mvpPresenter.detachView();
        }
    }
}
