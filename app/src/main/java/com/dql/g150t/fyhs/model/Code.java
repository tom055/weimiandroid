package com.dql.g150t.fyhs.model;

/**
 * Created by G150T on 2017/7/13.
 */

public class Code {

    /**
     * mobileCode : 314598
     * userName : 15728040262
     * message : 验证码发送成功
     * status : 1
     */

    private String mobileCode;
    private String userName;
    private String message;
    private String status;

    public String getMobileCode() {
        return mobileCode;
    }

    public void setMobileCode(String mobileCode) {
        this.mobileCode = mobileCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
