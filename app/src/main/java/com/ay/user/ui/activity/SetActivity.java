package com.ay.user.ui.activity;

import android.content.Intent;
import android.view.View;

import com.ay.user.R;
import com.ay.user.ui.activity.base.BaseActivity;

import butterknife.OnClick;

/**
 * Created by ${lgy} on 2017/11/2908:30
 * 邮箱1343168198@qq.com
 * 描述： describe
 * 修改内容：
 */

public class SetActivity extends BaseActivity {
    @Override
    public int getContentViewId() {
        return R.layout.activity_set;
    }



    @OnClick({R.id.lv_forget_pwd, R.id.btn_confirm})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.lv_forget_pwd:
                startActivity(new Intent(this, ForgetPwdActivity.class));
                break;
            case R.id.btn_confirm:
                startActivity(new Intent(this, LoginActivity.class));
                break;
        }
    }
}
