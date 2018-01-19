package com.dql.g150t.fyhs.model;

import java.util.List;

/**
 * Created by G150T on 2017/7/18.
 */

public class BankCard {


    /**
     * msg : 成功
     * banklists : [{"id":300,"status":0,"order":10,"type_id":25,"pid":"0","name":"中国银行","value":"中国银行","addtime":0,"addip":""},{"id":301,"status":0,"order":10,"type_id":25,"pid":"0","name":"中国光大银行","value":"中国光大银行","addtime":0,"addip":""},{"id":302,"status":0,"order":10,"type_id":25,"pid":"0","name":"广东发展银行","value":"广东发展银行","addtime":0,"addip":""},{"id":303,"status":0,"order":10,"type_id":25,"pid":"0","name":"上海浦东发展银行","value":"上海浦东发展银行","addtime":0,"addip":""},{"id":463,"status":0,"order":10,"type_id":25,"pid":"0","name":"深圳发展银行","value":"深圳发展银行","addtime":0,"addip":""},{"id":465,"status":0,"order":10,"type_id":25,"pid":"0","name":"农业银行","value":"农业银行","addtime":0,"addip":""},{"id":466,"status":0,"order":10,"type_id":25,"pid":"0","name":"华夏银行","value":"华夏银行","addtime":0,"addip":""},{"id":467,"status":0,"order":10,"type_id":25,"pid":"0","name":"浙江泰隆商业银行","value":"浙江泰隆商业银行","addtime":0,"addip":""},{"id":468,"status":0,"order":10,"type_id":25,"pid":"0","name":"兴业银行","value":"兴业银行","addtime":0,"addip":""},{"id":469,"status":0,"order":10,"type_id":25,"pid":"0","name":"建设银行","value":"建设银行","addtime":0,"addip":""},{"id":470,"status":0,"order":10,"type_id":25,"pid":"0","name":"交通银行","value":"交通银行","addtime":0,"addip":""},{"id":471,"status":0,"order":10,"type_id":25,"pid":"0","name":"招商银行","value":"招商银行","addtime":0,"addip":""},{"id":472,"status":0,"order":10,"type_id":25,"pid":"0","name":"北京银行","value":"北京银行","addtime":0,"addip":""},{"id":473,"status":0,"order":10,"type_id":25,"pid":"0","name":"工商银行","value":"工商银行","addtime":0,"addip":""},{"id":528,"status":0,"order":10,"type_id":25,"pid":"0","name":"中国民生银行","value":"中国民生银行","addtime":0,"addip":""},{"id":536,"status":0,"order":0,"type_id":25,"pid":"0","name":"中信银行","value":"中信银行","addtime":0,"addip":""},{"id":539,"status":0,"order":10,"type_id":25,"pid":"0","name":"上海银行","value":"上海银行","addtime":0,"addip":""},{"id":540,"status":0,"order":10,"type_id":25,"pid":"0","name":"天津银行","value":"天津银行","addtime":0,"addip":""},{"id":541,"status":0,"order":10,"type_id":25,"pid":"0","name":"大连银行","value":"大连银行","addtime":0,"addip":""},{"id":542,"status":0,"order":10,"type_id":25,"pid":"0","name":"杭州银行","value":"杭州银行","addtime":0,"addip":""},{"id":543,"status":0,"order":10,"type_id":25,"pid":"0","name":"宁波银行","value":"宁波银行","addtime":0,"addip":""},{"id":544,"status":0,"order":10,"type_id":25,"pid":"0","name":"厦门银行","value":"厦门银行","addtime":0,"addip":""},{"id":545,"status":0,"order":10,"type_id":25,"pid":"0","name":"广州银行","value":"广州银行","addtime":0,"addip":""},{"id":546,"status":0,"order":10,"type_id":25,"pid":"0","name":"平安银行","value":"平安银行","addtime":0,"addip":""},{"id":547,"status":0,"order":10,"type_id":25,"pid":"0","name":"浙商银行","value":"浙商银行","addtime":0,"addip":""},{"id":548,"status":0,"order":10,"type_id":25,"pid":"0","name":"上海农村商业银行","value":"上海农村商业银行","addtime":0,"addip":""},{"id":549,"status":0,"order":10,"type_id":25,"pid":"0","name":"重庆银行","value":"重庆银行","addtime":0,"addip":""},{"id":550,"status":0,"order":10,"type_id":25,"pid":"0","name":"中国邮政储蓄银行","value":"中国邮政储蓄银行","addtime":0,"addip":""},{"id":551,"status":0,"order":10,"type_id":25,"pid":"0","name":"江苏银行","value":"江苏银行","addtime":0,"addip":""},{"id":552,"status":0,"order":10,"type_id":25,"pid":"0","name":"北京农村商业银行","value":"北京农村商业银行","addtime":0,"addip":""},{"id":553,"status":0,"order":10,"type_id":25,"pid":"0","name":"济宁银行","value":"济宁银行","addtime":0,"addip":""},{"id":554,"status":0,"order":10,"type_id":25,"pid":"0","name":"台州银行","value":"台州银行","addtime":0,"addip":""},{"id":617,"status":0,"order":10,"type_id":25,"pid":"0","name":"浙江省农村信用社联合社","value":"浙江省农村信用社联合社","addtime":0,"addip":""},{"id":618,"status":0,"order":10,"type_id":25,"pid":"0","name":"渤海银行","value":"渤海银行","addtime":0,"addip":""}]
     * bankCard : {"user_id":1003,"addtime":"1457782679","province":40,"city":41,"area":52,"bank":"建设银行","branch":"团结路支行","bank_cardno":"6227001216200241721","addip":"101.45.134.82","status":1,"id":371}
     * status : 1
     */

    private String msg;
    private BankCardBean bankCard;
    private String status;
    private List<BanklistsBean> banklists;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public BankCardBean getBankCard() {
        return bankCard;
    }

    public void setBankCard(BankCardBean bankCard) {
        this.bankCard = bankCard;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<BanklistsBean> getBanklists() {
        return banklists;
    }

    public void setBanklists(List<BanklistsBean> banklists) {
        this.banklists = banklists;
    }

    public static class BankCardBean {
        /**
         * user_id : 1003
         * addtime : 1457782679
         * province : 40
         * city : 41
         * area : 52
         * bank : 建设银行
         * branch : 团结路支行
         * bank_cardno : 6227001216200241721
         * addip : 101.45.134.82
         * status : 1
         * id : 371
         */

        private int user_id;
        private String addtime;
        private int province;
        private int city;
        private int area;
        private String bank;
        private String branch;
        private String bank_cardno;
        private String addip;
        private int status;
        private int id;

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public String getAddtime() {
            return addtime;
        }

        public void setAddtime(String addtime) {
            this.addtime = addtime;
        }

        public int getProvince() {
            return province;
        }

        public void setProvince(int province) {
            this.province = province;
        }

        public int getCity() {
            return city;
        }

        public void setCity(int city) {
            this.city = city;
        }

        public int getArea() {
            return area;
        }

        public void setArea(int area) {
            this.area = area;
        }

        public String getBank() {
            return bank;
        }

        public void setBank(String bank) {
            this.bank = bank;
        }

        public String getBranch() {
            return branch;
        }

        public void setBranch(String branch) {
            this.branch = branch;
        }

        public String getBank_cardno() {
            return bank_cardno;
        }

        public void setBank_cardno(String bank_cardno) {
            this.bank_cardno = bank_cardno;
        }

        public String getAddip() {
            return addip;
        }

        public void setAddip(String addip) {
            this.addip = addip;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }

    public static class BanklistsBean {
        /**
         * id : 300
         * status : 0
         * order : 10
         * type_id : 25
         * pid : 0
         * name : 中国银行
         * value : 中国银行
         * addtime : 0
         * addip :
         */

        private int id;
        private int status;
        private int order;
        private int type_id;
        private String pid;
        private String name;
        private String value;
        private int addtime;
        private String addip;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getOrder() {
            return order;
        }

        public void setOrder(int order) {
            this.order = order;
        }

        public int getType_id() {
            return type_id;
        }

        public void setType_id(int type_id) {
            this.type_id = type_id;
        }

        public String getPid() {
            return pid;
        }

        public void setPid(String pid) {
            this.pid = pid;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public int getAddtime() {
            return addtime;
        }

        public void setAddtime(int addtime) {
            this.addtime = addtime;
        }

        public String getAddip() {
            return addip;
        }

        public void setAddip(String addip) {
            this.addip = addip;
        }
    }
}
