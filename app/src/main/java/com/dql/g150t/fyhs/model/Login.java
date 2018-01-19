package com.dql.g150t.fyhs.model;

/**
 * Created by G150T on 2017/7/13.
 */

public class Login {

    /**
     * returnMsg : 登陆成功！
     * code : 1
     * userId : 1003
     * isNew :1
     */

    private String returnMsg;
    private String code;
    private int userId;
    private int isNew;

    public int getIsNew() {
        return isNew;
    }

    public void setIsNew(int isNew) {
        this.isNew = isNew;
    }

    public String getReturnMsg() {
        return returnMsg;
    }

    public void setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
