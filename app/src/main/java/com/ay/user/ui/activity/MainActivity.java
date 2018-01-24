package com.ay.user.ui.activity;

import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ay.user.R;
import com.ay.user.ui.activity.base.BaseActivity;
import com.ay.user.views.CircleImageView;
import com.ay.user.views.NaviTitleView;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindView(R.id.iv_head)
    CircleImageView ivHead;
    @BindView(R.id.tv_title_content)
    TextView tvTitleContent;
    @BindView(R.id.ll_pd)
    LinearLayout llPd;
    @BindView(R.id.ll_gd)
    LinearLayout llGd;
    @BindView(R.id.ll_cp)
    LinearLayout llCp;
    @BindView(R.id.navi_view)
    NaviTitleView naviView;


    @Override
    public int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    public void bindEventListener() {
        super.bindEventListener();
        naviView.setRightClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SetActivity.class));
            }
        });
        naviView.visibleLeftRes(false);
    }

    @OnClick({R.id.ll_pd, R.id.ll_gd, R.id.ll_cp})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_pd:
                startActivity(new Intent(this, OrderApplyActivity.class));
                break;
            case R.id.ll_gd:
                startActivity(new Intent(this, OrderGDActivity.class));
                break;
            case R.id.ll_cp:
                startActivity(new Intent(this, OrderProductActivity.class));

                break;
        }
    }


}
