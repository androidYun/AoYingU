package com.ay.user.ui.adapter;

import android.content.Context;

import com.ay.user.R;
import com.ay.user.mvp.model.ApplyListRes;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.List;

/**
 * Created by ${lgy} on 2017/11/1708:57
 * 邮箱1343168198@qq.com
 * 描述： describe
 * 修改内容：
 */

public class OrderGdAdapter extends CommonAdapter<ApplyListRes.UserlistBean> {
    public OrderGdAdapter(Context context, int layoutId, List<ApplyListRes.UserlistBean> datas) {
        super(context, layoutId, datas);
    }

    @Override
    protected void convert(ViewHolder holder, ApplyListRes.UserlistBean userlistBean, int position) {
        holder.setText(R.id.tv_name, userlistBean.name);
        holder.setText(R.id.tv_content, userlistBean.proName);
        holder.setText(R.id.tv_money, "额度:" + userlistBean.balance + "元");
        holder.setText(R.id.tv_time, userlistBean.time);
        if (userlistBean.stateCode.equals("0")) {// 状态码 0：审核中，1：审核成功，2：审核失败
            holder.setImageResource(R.id.iv_state, R.mipmap.ic_shz);
        } else if (userlistBean.stateCode.equals("1")) {
            holder.setImageResource(R.id.iv_state, R.mipmap.ic_shtg);
        } else if (userlistBean.stateCode.equals("2")) {
            holder.setImageResource(R.id.iv_state, R.mipmap.ic_jujue);
        }
    }
}
