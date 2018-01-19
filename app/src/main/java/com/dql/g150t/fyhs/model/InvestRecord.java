package com.dql.g150t.fyhs.model;

import java.util.List;

/**
 * Created by ST on 2017/7/22.
 */

public class InvestRecord {

    /**
     * msg : 查询成功
     * borrowTypes : [{"addtime":"1429783736","type_name":"信用标","type_commodity_name":"信用标","is_home_display":1,"uptime":"1500259522","description":"以各类银行（商业）承兑汇票作为质押品的融资项目。","status":1,"id":1},{"addtime":"1429783736","type_name":"抵押标","type_commodity_name":"抵押标","is_home_display":1,"uptime":"1500259597","description":"由电联担保作为保证人的融资项目。","status":1,"id":2},{"addtime":"1429783736","type_name":"担保标","type_commodity_name":"担保标","is_home_display":1,"uptime":"1500259616","description":"为车辆按揭业务提供资金周转，实现快捷购车。","status":1,"id":3},{"addtime":"1429783736","type_name":"流转标","type_commodity_name":"流标","is_home_display":1,"uptime":"1500349802","description":"以物品典当方式的融资项目，由电联典当提供连带转让担保。","status":1,"id":4},{"addtime":"1453284776","type_name":"新手专享","type_commodity_name":"新手专享","is_home_display":1,"uptime":"1500259547","description":"新手专享","status":1,"id":6}]
     * borrows : [{"id":1401,"site_id":0,"user_id":1003,"borrow_id":235,"tender_type":0,"contract_no":null,"status":1,"money":1200,"account":1200,"interest":12.8,"repayment_account":1212.8,"repayment_yesaccount":0,"repayment_yesinterest":0,"wait_account":1212.8,"wait_interest":12.8,"addtime":"1461131955","addip":"117.185.87.158","no_code":null,"user_red_id":0,"b_id":235,"b_account":120000,"b_status":5,"b_name":"小金宝076","b_apr":12.8,"b_time_limit":30,"b_type":1,"b_is_day":1},{"id":1400,"site_id":0,"user_id":1003,"borrow_id":235,"tender_type":0,"contract_no":null,"status":1,"money":105000,"account":105000,"interest":1120,"repayment_account":106120,"repayment_yesaccount":0,"repayment_yesinterest":0,"wait_account":106120,"wait_interest":1120,"addtime":"1461131844","addip":"117.185.87.158","no_code":null,"user_red_id":0,"b_id":235,"b_account":120000,"b_status":5,"b_name":"小金宝076","b_apr":12.8,"b_time_limit":30,"b_type":1,"b_is_day":1},{"id":1372,"site_id":0,"user_id":1003,"borrow_id":228,"tender_type":0,"contract_no":null,"status":1,"money":105000,"account":105000,"interest":1120,"repayment_account":106120,"repayment_yesaccount":0,"repayment_yesinterest":0,"wait_account":106120,"wait_interest":1120,"addtime":"1460969325","addip":"117.185.87.158","no_code":null,"user_red_id":0,"b_id":228,"b_account":200000,"b_status":5,"b_name":"小金宝070","b_apr":12.8,"b_time_limit":30,"b_type":1,"b_is_day":1},{"id":1314,"site_id":0,"user_id":1003,"borrow_id":214,"tender_type":0,"contract_no":null,"status":1,"money":300000,"account":300000,"interest":3200,"repayment_account":303200,"repayment_yesaccount":0,"repayment_yesinterest":0,"wait_account":303200,"wait_interest":3200,"addtime":"1460437879","addip":"117.185.87.158","no_code":null,"user_red_id":0,"b_id":214,"b_account":300000,"b_status":5,"b_name":"小金宝060","b_apr":12.8,"b_time_limit":30,"b_type":1,"b_is_day":1},{"id":1301,"site_id":0,"user_id":1003,"borrow_id":206,"tender_type":0,"contract_no":null,"status":2,"money":30000,"account":30000,"interest":68.83,"repayment_account":30068.83,"repayment_yesaccount":30068.83,"repayment_yesinterest":68.83,"wait_account":0,"wait_interest":0,"addtime":"1460181458","addip":"183.193.116.40","no_code":null,"user_red_id":0,"b_id":206,"b_account":30000,"b_status":6,"b_name":"小金宝053","b_apr":11.8,"b_time_limit":7,"b_type":1,"b_is_day":1},{"id":1300,"site_id":0,"user_id":1003,"borrow_id":205,"tender_type":0,"contract_no":null,"status":1,"money":60000,"account":60000,"interest":640,"repayment_account":60640,"repayment_yesaccount":0,"repayment_yesinterest":0,"wait_account":60640,"wait_interest":640,"addtime":"1460181377","addip":"183.193.116.40","no_code":null,"user_red_id":0,"b_id":205,"b_account":100000,"b_status":5,"b_name":"小金宝052","b_apr":12.8,"b_time_limit":30,"b_type":1,"b_is_day":1},{"id":1279,"site_id":0,"user_id":1003,"borrow_id":198,"tender_type":0,"contract_no":null,"status":2,"money":20000,"account":20000,"interest":45.89,"repayment_account":20045.89,"repayment_yesaccount":20045.89,"repayment_yesinterest":45.89,"wait_account":0,"wait_interest":0,"addtime":"1459582687","addip":"183.193.122.195","no_code":null,"user_red_id":0,"b_id":198,"b_account":20000,"b_status":6,"b_name":"小金宝045","b_apr":11.8,"b_time_limit":7,"b_type":1,"b_is_day":1},{"id":1205,"site_id":0,"user_id":1003,"borrow_id":174,"tender_type":0,"contract_no":null,"status":2,"money":102800,"account":102800,"interest":1096.53,"repayment_account":103896.53,"repayment_yesaccount":103896.53,"repayment_yesinterest":1096.53,"wait_account":0,"wait_interest":0,"addtime":"1458450731","addip":"101.45.134.82","no_code":null,"user_red_id":0,"b_id":174,"b_account":120000,"b_status":6,"b_name":"小金宝022","b_apr":12.8,"b_time_limit":30,"b_type":1,"b_is_day":1},{"id":1184,"site_id":0,"user_id":1003,"borrow_id":165,"tender_type":0,"contract_no":null,"status":2,"money":88000,"account":88000,"interest":938.67,"repayment_account":88938.67,"repayment_yesaccount":88938.67,"repayment_yesinterest":938.67,"wait_account":0,"wait_interest":0,"addtime":"1457839514","addip":"101.45.134.82","no_code":null,"user_red_id":0,"b_id":165,"b_account":300000,"b_status":6,"b_name":"小金宝013","b_apr":12.8,"b_time_limit":30,"b_type":1,"b_is_day":1},{"id":1183,"site_id":0,"user_id":1003,"borrow_id":165,"tender_type":0,"contract_no":null,"status":2,"money":103000,"account":103000,"interest":1098.67,"repayment_account":104098.67,"repayment_yesaccount":104098.67,"repayment_yesinterest":1098.67,"wait_account":0,"wait_interest":0,"addtime":"1457785604","addip":"101.45.134.82","no_code":null,"user_red_id":0,"b_id":165,"b_account":300000,"b_status":6,"b_name":"小金宝013","b_apr":12.8,"b_time_limit":30,"b_type":1,"b_is_day":1}]
     * page : {"totalPage":1,"begin":0,"pageSize":20,"currentPage":1,"totalCount":10}
     * type : tender
     * status : 1
     */

    private String msg;
    private PageBean page;
    private String type;
    private String status;
    private List<BorrowTypesBean> borrowTypes;
    private List<BorrowsBean> borrows;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public PageBean getPage() {
        return page;
    }

    public void setPage(PageBean page) {
        this.page = page;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<BorrowTypesBean> getBorrowTypes() {
        return borrowTypes;
    }

    public void setBorrowTypes(List<BorrowTypesBean> borrowTypes) {
        this.borrowTypes = borrowTypes;
    }

    public List<BorrowsBean> getBorrows() {
        return borrows;
    }

    public void setBorrows(List<BorrowsBean> borrows) {
        this.borrows = borrows;
    }

    public static class PageBean {
        /**
         * totalPage : 1
         * begin : 0
         * pageSize : 20
         * currentPage : 1
         * totalCount : 10
         */

        private int totalPage;
        private int begin;
        private int pageSize;
        private int currentPage;
        private int totalCount;

        public int getTotalPage() {
            return totalPage;
        }

        public void setTotalPage(int totalPage) {
            this.totalPage = totalPage;
        }

        public int getBegin() {
            return begin;
        }

        public void setBegin(int begin) {
            this.begin = begin;
        }

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        public int getCurrentPage() {
            return currentPage;
        }

        public void setCurrentPage(int currentPage) {
            this.currentPage = currentPage;
        }

        public int getTotalCount() {
            return totalCount;
        }

        public void setTotalCount(int totalCount) {
            this.totalCount = totalCount;
        }
    }

    public static class BorrowTypesBean {
        /**
         * addtime : 1429783736
         * type_name : 信用标
         * type_commodity_name : 信用标
         * is_home_display : 1
         * uptime : 1500259522
         * description : 以各类银行（商业）承兑汇票作为质押品的融资项目。
         * status : 1
         * id : 1
         */

        private String addtime;
        private String type_name;
        private String type_commodity_name;
        private int is_home_display;
        private String uptime;
        private String description;
        private int status;
        private int id;

        public String getAddtime() {
            return addtime;
        }

        public void setAddtime(String addtime) {
            this.addtime = addtime;
        }

        public String getType_name() {
            return type_name;
        }

        public void setType_name(String type_name) {
            this.type_name = type_name;
        }

        public String getType_commodity_name() {
            return type_commodity_name;
        }

        public void setType_commodity_name(String type_commodity_name) {
            this.type_commodity_name = type_commodity_name;
        }

        public int getIs_home_display() {
            return is_home_display;
        }

        public void setIs_home_display(int is_home_display) {
            this.is_home_display = is_home_display;
        }

        public String getUptime() {
            return uptime;
        }

        public void setUptime(String uptime) {
            this.uptime = uptime;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
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

    public static class BorrowsBean {
        /**
         * id : 1401
         * site_id : 0
         * user_id : 1003
         * borrow_id : 235
         * tender_type : 0
         * contract_no : null
         * status : 1
         * money : 1200
         * account : 1200
         * interest : 12.8
         * repayment_account : 1212.8
         * repayment_yesaccount : 0
         * repayment_yesinterest : 0
         * wait_account : 1212.8
         * wait_interest : 12.8
         * addtime : 1461131955
         * addip : 117.185.87.158
         * no_code : null
         * user_red_id : 0
         * b_id : 235
         * b_account : 120000
         * b_status : 5
         * b_name : 小金宝076
         * b_apr : 12.8
         * b_time_limit : 30
         * b_type : 1
         * b_is_day : 1
         * left_days: -11
         */

        private int id;
        private int site_id;
        private int user_id;
        private int borrow_id;
        private int tender_type;
        private Object contract_no;
        private int status;
        private int money;
        private int account;
        private double interest;
        private double repayment_account;
        private Object repayment_yesaccount;
        private Object repayment_yesinterest;
        private double wait_account;
        private double wait_interest;
        private String addtime;
        private String addip;
        private Object no_code;
        private int user_red_id;
        private int b_id;
        private int b_account;
        private int b_status;
        private String b_name;
        private double b_apr;
        private int b_time_limit;
        private int b_type;
        private int b_is_day;
        private Object left_days;

        public Object getLeft_days() {
            return left_days;
        }

        public void setLeft_days(Object left_days) {
            this.left_days = left_days;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getSite_id() {
            return site_id;
        }

        public void setSite_id(int site_id) {
            this.site_id = site_id;
        }

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public int getBorrow_id() {
            return borrow_id;
        }

        public void setBorrow_id(int borrow_id) {
            this.borrow_id = borrow_id;
        }

        public int getTender_type() {
            return tender_type;
        }

        public void setTender_type(int tender_type) {
            this.tender_type = tender_type;
        }

        public Object getContract_no() {
            return contract_no;
        }

        public void setContract_no(Object contract_no) {
            this.contract_no = contract_no;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getMoney() {
            return money;
        }

        public void setMoney(int money) {
            this.money = money;
        }

        public int getAccount() {
            return account;
        }

        public void setAccount(int account) {
            this.account = account;
        }

        public double getInterest() {
            return interest;
        }

        public void setInterest(double interest) {
            this.interest = interest;
        }

        public double getRepayment_account() {
            return repayment_account;
        }

        public void setRepayment_account(double repayment_account) {
            this.repayment_account = repayment_account;
        }

        public Object getRepayment_yesaccount() {
            return repayment_yesaccount;
        }

        public void setRepayment_yesaccount(Object repayment_yesaccount) {
            this.repayment_yesaccount = repayment_yesaccount;
        }

        public Object getRepayment_yesinterest() {
            return repayment_yesinterest;
        }

        public void setRepayment_yesinterest(Object repayment_yesinterest) {
            this.repayment_yesinterest = repayment_yesinterest;
        }

        public double getWait_account() {
            return wait_account;
        }

        public void setWait_account(double wait_account) {
            this.wait_account = wait_account;
        }

        public double getWait_interest() {
            return wait_interest;
        }

        public void setWait_interest(double wait_interest) {
            this.wait_interest = wait_interest;
        }

        public String getAddtime() {
            return addtime;
        }

        public void setAddtime(String addtime) {
            this.addtime = addtime;
        }

        public String getAddip() {
            return addip;
        }

        public void setAddip(String addip) {
            this.addip = addip;
        }

        public Object getNo_code() {
            return no_code;
        }

        public void setNo_code(Object no_code) {
            this.no_code = no_code;
        }

        public int getUser_red_id() {
            return user_red_id;
        }

        public void setUser_red_id(int user_red_id) {
            this.user_red_id = user_red_id;
        }

        public int getB_id() {
            return b_id;
        }

        public void setB_id(int b_id) {
            this.b_id = b_id;
        }

        public int getB_account() {
            return b_account;
        }

        public void setB_account(int b_account) {
            this.b_account = b_account;
        }

        public int getB_status() {
            return b_status;
        }

        public void setB_status(int b_status) {
            this.b_status = b_status;
        }

        public String getB_name() {
            return b_name;
        }

        public void setB_name(String b_name) {
            this.b_name = b_name;
        }

        public double getB_apr() {
            return b_apr;
        }

        public void setB_apr(double b_apr) {
            this.b_apr = b_apr;
        }

        public int getB_time_limit() {
            return b_time_limit;
        }

        public void setB_time_limit(int b_time_limit) {
            this.b_time_limit = b_time_limit;
        }

        public int getB_type() {
            return b_type;
        }

        public void setB_type(int b_type) {
            this.b_type = b_type;
        }

        public int getB_is_day() {
            return b_is_day;
        }

        public void setB_is_day(int b_is_day) {
            this.b_is_day = b_is_day;
        }
    }
}
