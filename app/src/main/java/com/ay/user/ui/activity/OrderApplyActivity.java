package com.ay.user.ui.activity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ay.user.R;
import com.ay.user.listener.SelectProductListener;
import com.ay.user.mvp.Presenter.AddApplyRecordPresenter;
import com.ay.user.mvp.PresenterView.AddApplyRecordView;
import com.ay.user.mvp.model.AddApplyRecordRes;
import com.ay.user.mvp.model.ProductListRes;
import com.ay.user.ui.activity.base.MvpActivity;
import com.ay.user.utils.ToastUtil;
import com.ay.user.views.NotNullTextWatcher;
import com.ay.user.views.pop.SelectProductPop;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * Created by ${lgy} on 2017/11/2412:48
 * 邮箱1343168198@qq.com
 * 描述： describe
 * 修改内容：
 */

public class OrderApplyActivity extends MvpActivity<AddApplyRecordPresenter> implements AddApplyRecordView, SelectProductListener {


    @BindView(R.id.ev_name)
    EditText evName;
    @BindView(R.id.ev_phone)
    EditText evPhone;
    @BindView(R.id.ev_profession)
    EditText evProfession;
    @BindView(R.id.ev_asset)
    EditText evAsset;
    @BindView(R.id.btn_confirm)
    Button btnConfirm;
    @BindView(R.id.ev_product_name)
    EditText evProductName;


    private SelectProductPop selectProductPop;

    private ProductListRes.DataBean dataBean;

    private List<ProductListRes.DataBean> mDataList = new ArrayList<>();

    @Override
    protected AddApplyRecordPresenter createPresenter() {
        return new AddApplyRecordPresenter(this);
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_baodan;
    }

    @Override
    protected void initView() {
        super.initView();
        evName.addTextChangedListener(new NotNullTextWatcher(btnConfirm, evAsset, evPhone, evProfession,evProductName));
        evAsset.addTextChangedListener(new NotNullTextWatcher(btnConfirm, evName, evPhone, evProfession,evProductName));
        evPhone.addTextChangedListener(new NotNullTextWatcher(btnConfirm, evAsset, evName, evProfession,evProductName));
        evProfession.addTextChangedListener(new NotNullTextWatcher(btnConfirm, evAsset, evPhone, evName,evProductName));
        evProductName.addTextChangedListener(new NotNullTextWatcher(btnConfirm, evAsset, evPhone, evProfession,evName));
    }

    @Override
    public void initData() {
        super.initData();


    }

    @Override
    public void onLoginSuccess(AddApplyRecordRes addApplyRecordResp) {
        ToastUtil.show(this, "申请成功");
        finish();
    }

    @Override
    public void onLoginSuccess(ProductListRes productListRes) {
        mDataList.clear();
        mDataList.addAll(productListRes.data);
        selectProductPop = new SelectProductPop(this, mDataList, this);
        selectProductPop.showPopupWindow();
    }

    @Override
    public void onSelectSuccess(ProductListRes.DataBean dataBean) {
        this.dataBean = dataBean;
        evProductName.setText(dataBean.name);
    }

    @OnClick({R.id.btn_confirm, R.id.lv_select_product})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_confirm:
                if (dataBean == null) {
                    ToastUtil.show(this, "请选择产品类型");
                    return;
                }
                String name = evName.getText().toString();
                String asset = evAsset.getText().toString();//资产
                String phone = evPhone.getText().toString();//手机号
                String profession = evProfession.getText().toString();//职业
                mvpPresenter.loadData(phone, name, profession, asset, dataBean.id, "123");
                break;
            case R.id.lv_select_product:
                if (mDataList.size() == 0) {
                    mvpPresenter.loadProductListData();
                } else {
                    selectProductPop.showPopupWindow();
                }
                break;
        }
    }

}
