package com.dql.g150t.fyhs.model;

/**
 * Created by hwg on 2017/4/10.
 */

public class BaseStatus {

    /**
     * msg : 密码修改成功，请重新登录！
     * status : 1
     */

    private String msg;
    private int status;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
