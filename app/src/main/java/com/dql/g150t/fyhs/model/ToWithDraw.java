package com.dql.g150t.fyhs.model;

/**
 * Created by G150T on 2017/7/18.
 */

public class ToWithDraw {

    /**
     * msg : 成功
     * freeCredit : 28.59
     * account : {"use_money":28.59,"no_use_money":0,"collection":577292.8,"user_id":1003,"virtual_money":null,"total":48.59,"username":null,"id":1002,"type":null,"realName":null}
     * status : 1
     */

    private String msg;
    private double freeCredit;
    private AccountBean account;
    private String status;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public double getFreeCredit() {
        return freeCredit;
    }

    public void setFreeCredit(double freeCredit) {
        this.freeCredit = freeCredit;
    }

    public AccountBean getAccount() {
        return account;
    }

    public void setAccount(AccountBean account) {
        this.account = account;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static class AccountBean {
        /**
         * use_money : 28.59
         * no_use_money : 0
         * collection : 577292.8
         * user_id : 1003
         * virtual_money : null
         * total : 48.59
         * username : null
         * id : 1002
         * type : null
         * realName : null
         */

        private double use_money;
        private int no_use_money;
        private double collection;
        private int user_id;
        private Object virtual_money;
        private double total;
        private Object username;
        private int id;
        private Object type;
        private Object realName;

        public double getUse_money() {
            return use_money;
        }

        public void setUse_money(double use_money) {
            this.use_money = use_money;
        }

        public int getNo_use_money() {
            return no_use_money;
        }

        public void setNo_use_money(int no_use_money) {
            this.no_use_money = no_use_money;
        }

        public double getCollection() {
            return collection;
        }

        public void setCollection(double collection) {
            this.collection = collection;
        }

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public Object getVirtual_money() {
            return virtual_money;
        }

        public void setVirtual_money(Object virtual_money) {
            this.virtual_money = virtual_money;
        }

        public double getTotal() {
            return total;
        }

        public void setTotal(double total) {
            this.total = total;
        }

        public Object getUsername() {
            return username;
        }

        public void setUsername(Object username) {
            this.username = username;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Object getType() {
            return type;
        }

        public void setType(Object type) {
            this.type = type;
        }

        public Object getRealName() {
            return realName;
        }

        public void setRealName(Object realName) {
            this.realName = realName;
        }
    }
}
