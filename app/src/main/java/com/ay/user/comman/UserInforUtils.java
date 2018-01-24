package com.ay.user.comman;

import com.ay.user.utils.SPUtil;
import com.lgy.utilslibrary.utils.StringUtils;

/**
 * Created by ${lgy} on 2017/11/2414:27
 * 邮箱1343168198@qq.com
 * 描述： describe
 * 修改内容：
 */

public class UserInforUtils {
    private int userId;

    private String account;

    private String passWord;

    public static UserInforUtils getInstance() {
        return CreateUserInforUtils.USER_INFOR_UTILS;
    }

    static class CreateUserInforUtils {
        static final UserInforUtils USER_INFOR_UTILS = new UserInforUtils();
    }

    public int getUserId() {
        if (userId == 0) {
            userId = SPUtil.getInt("userid", 0);
        }
        return userId;
    }

    public void setUserId(int mUserId) {
        this.userId = mUserId;
        SPUtil.put("userid", mUserId);
    }

    public String getAccount() {
        if (StringUtils.isEmpty(account)) {
            account = SPUtil.getString("account","");
        }
        return account;
    }

    public void setAccount(String account) {
        SPUtil.put("account", account);
        this.account = account;
    }

    public String getPassWord() {
        if (StringUtils.isEmpty(passWord)) {
            passWord = SPUtil.getString("password", "");
        }
        return passWord;
    }

    public void setPassWord(String passWord) {
        SPUtil.put("password", passWord);
        this.passWord = passWord;
    }
}
