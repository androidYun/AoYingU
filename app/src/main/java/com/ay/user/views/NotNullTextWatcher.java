package com.ay.user.views;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import com.lgy.utilslibrary.utils.StringUtils;

/**
 * Created by ${lgy} on 2017/8/1612:24
 * 邮箱1343168198@qq.com
 * 描述： describe
 * 修改内容：
 */

public class NotNullTextWatcher implements TextWatcher {
    private View view;

    private EditText[] editTextList;

    public NotNullTextWatcher(View view, EditText... editText) {
        this.view = view;
        editTextList = editText;
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        if (StringUtils.isEmpty(s.toString())) {
            view.setEnabled(false);
        } else {
            if (editTextList == null || editTextList.length == 0) {//没有关联的编辑框直接返回
                view.setEnabled(true);
                return;
            }
            for (int i = 0; i < editTextList.length; i++) {//遍历
                EditText editText = editTextList[i];
                if (StringUtils.isEmpty(editText.getText().toString())) {
                    view.setEnabled(false);
                    return;
                }
                if ((i+1) == editTextList.length) {
                    view.setEnabled(true);
                }
            }
        }
    }
}
