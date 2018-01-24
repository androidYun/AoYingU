package com.ay.user.views.pop;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ay.user.R;
import com.ay.user.listener.SelectProductListener;
import com.ay.user.mvp.model.ProductListRes;
import com.ay.user.views.WheelView;
import com.ay.user.views.pop.base.BasePopupWindow;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by ${lgy} on 2017/11/2413:42
 * 邮箱1343168198@qq.com
 * 描述： describe
 * 修改内容：
 */

public class SelectProductPop extends BasePopupWindow {
    @BindView(R.id.tv_cancle)
    TextView tvCancle;
    @BindView(R.id.tv_confirm)
    TextView tvConfirm;
    @BindView(R.id.wheel_view)
    WheelView wheelView;
    @BindView(R.id.rv_pop)
    RelativeLayout rvPop;

    private List<ProductListRes.DataBean> mDataList = new ArrayList<>();

    private List<String> wheelData = new ArrayList<>();

    private int selectPosition;

    private SelectProductListener selectProductListener;

    public SelectProductPop(Activity context, List<ProductListRes.DataBean> mDataList, SelectProductListener selectProductListener) {
        super(context);
        this.selectProductListener = selectProductListener;
        this.mDataList = mDataList;
        initView();
        initData();
    }

    public void initView() {
        ButterKnife.bind(this, mPopupView);
    }

    public void initData() {
        for (int i = 0; i < mDataList.size(); i++) {
            wheelData.add(mDataList.get(i).name);
        }
        wheelView.setOffset(1);
        wheelView.setItems(wheelData);
        wheelView.setOnWheelViewListener(new WheelView.OnWheelViewListener() {
            @Override
            public void onSelected(int selectedIndex, String item) {
                selectPosition = selectedIndex;
            }
        });

    }

    @Override
    public View onCreatePopupView() {
        return LayoutInflater.from(mContext).inflate(R.layout.pop_select_product, null);
    }

    @Override
    public View initAnimaView() {
        return null;
    }

    @Override
    protected Animation initShowAnimation() {
        return null;
    }

    @Override
    public View getClickToDismissView() {
        return mPopupView.findViewById(R.id.rv_pop);
    }

    @OnClick({R.id.tv_cancle, R.id.tv_confirm})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_cancle:
                dismissWithOutAnima();
                break;
            case R.id.tv_confirm:
                if (mDataList.size() > selectPosition) {
                    dismissWithOutAnima();
                    selectProductListener.onSelectSuccess(mDataList.get(selectPosition));
                }
                break;
        }
    }
}
