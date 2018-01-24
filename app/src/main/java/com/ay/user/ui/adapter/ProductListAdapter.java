package com.ay.user.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.ay.user.R;
import com.ay.user.mvp.model.ProductListRes;
import com.ay.user.ui.activity.ProductDetailActivity;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.List;

/**
 * Created by ${lgy} on 2017/11/2910:40
 * 邮箱1343168198@qq.com
 * 描述： describe
 * 修改内容：
 */

public class ProductListAdapter extends CommonAdapter<ProductListRes.DataBean> {
    public ProductListAdapter(Context context, int layoutId, List<ProductListRes.DataBean> datas) {
        super(context, layoutId, datas);
    }

    @Override
    protected void convert(ViewHolder holder, final ProductListRes.DataBean dataBean, int position) {
        holder.setText(R.id.tv_cp_name, dataBean.name);
        holder.setOnClickListener(R.id.lv_cp_item, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, ProductDetailActivity.class);
                intent.putExtra("title", dataBean.name);
                intent.putExtra("content", dataBean.intro);
                mContext.startActivity(intent);
            }
        });
    }
}
