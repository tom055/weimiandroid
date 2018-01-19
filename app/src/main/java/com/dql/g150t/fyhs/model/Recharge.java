package com.dql.g150t.fyhs.model;

/**
 * Created by G150T on 2017/7/20.
 */

public class Recharge {


    /**
     * msg : 成功
     * recharge : {"user_id":11124,"addtime":"1504769731","payment":8,"money":2,"amount":2,"trade_no":"2017090715353170329","fee":0,"remark":null,"addip":"122.246.149.54","verify_remark":null,"verify_time":null,"ap_style":null,"verify_userid":null,"param":null,"status":0,"id":null,"type":1}
     * fyRechargeWebBean : {"user_id":"11124","mchnt_cd":"0002900F0518231","mchnt_order_id":"2017090715353170329","amt":"200","bank_card":"6013820800101214508","back_url":"http://www.gaofengzc.comrecharge/backReturnForWeb.dql","id_no":"341024199107159734","id_type":"0","logo_tp":"0","home_url":"http://www.gaofengzc.comrecharge/backReturnForWeb.dql","re_url":"http://www.gaofengzc.comfront_recharge/toRecharge.dql?device=app","rem1":"","rem2":"","rem3":"","sign_tp":"md5","enctp":"1","fm":"ZY59pATs+OBZs6pBDWeDcF33vPCAlLmFs9ixstf8QV+o61OQfYOtYum50x2q0u3I54siuiDO5Zfu\nXiyzf8XuQlaLflTmpWSwOXI79TiqVR0+RUvcvvEmSh4sdj1ALVw+btkDnzzE8Aqavxb15Yp188nk\n9GbC/e/X9VsWpMWe6a8A4f1y7tueUIq9UvTnnGDiz32YvGtTm55Tiri7erNScBo3RzcUrgLsBYQU\nb4pWbt0czaG0hN6c1iR/FW8q8XauN748JcbVpjj01vkX9VnuJSanHVdM7LgGgdIA9K4yHwmFtv90\n7jCbDHhbgyqZWJ0ft/tfNBoLXzUzU1KJRp3qYOpLe51Oiw417RbzyNFhj8O9Mx/MX0/ssDjSN7yB\nlzrJfOvecruOfZ6ikvpsaVLmXWGHsqyfQGbPLjHSOaFpYa8jeL5LgiGa2l3TGLXcD7AP44kxo7NB\nVmk4//18avhsJVmUTN68BFYJvq+ol+xxDuGR7D8Mgpmz5BdmtulQBNMmNoWUTWOW+gCottkG7TZw\nuDGo1hX+T8h406Nmb2/G3AKpUU+liNMgkrrtrEx2MR0Ez30fHzDbyPyIQ4Z2F3NUBChcudSipCnC\n/3Au+56SWkjYrtOtr4BiucHLv3hTWjG2uAnuAEx60JAAPJTGbpjQIWi0JAtzEgZ4RXppeumCDPac\nEXj5XC3aeAAqteXRwHu+cSAf1hf3+84F3C2NLIuqCxuq9BM706ECz6XcH4PRz2UTdGjl2DcLjovM\n4BWaGl9iN+pcW/Ahb0X0tDsAM3b5viH0hTln8HIV7lhmcz2Hh9OJQn6HHBFawgtVsNQf5/NR","version":"2.0","sign":"7fe0ee9fe44ab8b0871035626dde3aa2","name":"张飞","type":"10","beginDate":null,"endDate":null,"delete_flag":null,"page":null,"id":null}
     * status : 1
     */

    private String msg;
    private RechargeBean recharge;
    private FyRechargeWebBeanBean fyRechargeWebBean;
    private String status;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public RechargeBean getRecharge() {
        return recharge;
    }

    public void setRecharge(RechargeBean recharge) {
        this.recharge = recharge;
    }

    public FyRechargeWebBeanBean getFyRechargeWebBean() {
        return fyRechargeWebBean;
    }

    public void setFyRechargeWebBean(FyRechargeWebBeanBean fyRechargeWebBean) {
        this.fyRechargeWebBean = fyRechargeWebBean;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static class RechargeBean {
        /**
         * user_id : 11124
         * addtime : 1504769731
         * payment : 8
         * money : 2
         * amount : 2
         * trade_no : 2017090715353170329
         * fee : 0
         * remark : null
         * addip : 122.246.149.54
         * verify_remark : null
         * verify_time : null
         * ap_style : null
         * verify_userid : null
         * param : null
         * status : 0
         * id : null
         * type : 1
         */

        private int user_id;
        private String addtime;
        private int payment;
        private int money;
        private int amount;
        private String trade_no;
        private int fee;
        private Object remark;
        private String addip;
        private Object verify_remark;
        private Object verify_time;
        private Object ap_style;
        private Object verify_userid;
        private Object param;
        private int status;
        private Object id;
        private int type;

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

        public int getPayment() {
            return payment;
        }

        public void setPayment(int payment) {
            this.payment = payment;
        }

        public int getMoney() {
            return money;
        }

        public void setMoney(int money) {
            this.money = money;
        }

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        public String getTrade_no() {
            return trade_no;
        }

        public void setTrade_no(String trade_no) {
            this.trade_no = trade_no;
        }

        public int getFee() {
            return fee;
        }

        public void setFee(int fee) {
            this.fee = fee;
        }

        public Object getRemark() {
            return remark;
        }

        public void setRemark(Object remark) {
            this.remark = remark;
        }

        public String getAddip() {
            return addip;
        }

        public void setAddip(String addip) {
            this.addip = addip;
        }

        public Object getVerify_remark() {
            return verify_remark;
        }

        public void setVerify_remark(Object verify_remark) {
            this.verify_remark = verify_remark;
        }

        public Object getVerify_time() {
            return verify_time;
        }

        public void setVerify_time(Object verify_time) {
            this.verify_time = verify_time;
        }

        public Object getAp_style() {
            return ap_style;
        }

        public void setAp_style(Object ap_style) {
            this.ap_style = ap_style;
        }

        public Object getVerify_userid() {
            return verify_userid;
        }

        public void setVerify_userid(Object verify_userid) {
            this.verify_userid = verify_userid;
        }

        public Object getParam() {
            return param;
        }

        public void setParam(Object param) {
            this.param = param;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public Object getId() {
            return id;
        }

        public void setId(Object id) {
            this.id = id;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }
    }

    public static class FyRechargeWebBeanBean {
        /**
         * user_id : 11124
         * mchnt_cd : 0002900F0518231
         * mchnt_order_id : 2017090715353170329
         * amt : 200
         * bank_card : 6013820800101214508
         * back_url : http://www.gaofengzc.comrecharge/backReturnForWeb.dql
         * id_no : 341024199107159734
         * id_type : 0
         * logo_tp : 0
         * home_url : http://www.gaofengzc.comrecharge/backReturnForWeb.dql
         * re_url : http://www.gaofengzc.comfront_recharge/toRecharge.dql?device=app
         * rem1 :
         * rem2 :
         * rem3 :
         * sign_tp : md5
         * enctp : 1
         * fm : ZY59pATs+OBZs6pBDWeDcF33vPCAlLmFs9ixstf8QV+o61OQfYOtYum50x2q0u3I54siuiDO5Zfu
         Xiyzf8XuQlaLflTmpWSwOXI79TiqVR0+RUvcvvEmSh4sdj1ALVw+btkDnzzE8Aqavxb15Yp188nk
         9GbC/e/X9VsWpMWe6a8A4f1y7tueUIq9UvTnnGDiz32YvGtTm55Tiri7erNScBo3RzcUrgLsBYQU
         b4pWbt0czaG0hN6c1iR/FW8q8XauN748JcbVpjj01vkX9VnuJSanHVdM7LgGgdIA9K4yHwmFtv90
         7jCbDHhbgyqZWJ0ft/tfNBoLXzUzU1KJRp3qYOpLe51Oiw417RbzyNFhj8O9Mx/MX0/ssDjSN7yB
         lzrJfOvecruOfZ6ikvpsaVLmXWGHsqyfQGbPLjHSOaFpYa8jeL5LgiGa2l3TGLXcD7AP44kxo7NB
         Vmk4//18avhsJVmUTN68BFYJvq+ol+xxDuGR7D8Mgpmz5BdmtulQBNMmNoWUTWOW+gCottkG7TZw
         uDGo1hX+T8h406Nmb2/G3AKpUU+liNMgkrrtrEx2MR0Ez30fHzDbyPyIQ4Z2F3NUBChcudSipCnC
         /3Au+56SWkjYrtOtr4BiucHLv3hTWjG2uAnuAEx60JAAPJTGbpjQIWi0JAtzEgZ4RXppeumCDPac
         EXj5XC3aeAAqteXRwHu+cSAf1hf3+84F3C2NLIuqCxuq9BM706ECz6XcH4PRz2UTdGjl2DcLjovM
         4BWaGl9iN+pcW/Ahb0X0tDsAM3b5viH0hTln8HIV7lhmcz2Hh9OJQn6HHBFawgtVsNQf5/NR
         * version : 2.0
         * sign : 7fe0ee9fe44ab8b0871035626dde3aa2
         * name : 张飞
         * type : 10
         * beginDate : null
         * endDate : null
         * delete_flag : null
         * page : null
         * id : null
         */

        private String user_id;
        private String mchnt_cd;
        private String mchnt_order_id;
        private String amt;
        private String bank_card;
        private String back_url;
        private String id_no;
        private String id_type;
        private String logo_tp;
        private String home_url;
        private String re_url;
        private String rem1;
        private String rem2;
        private String rem3;
        private String sign_tp;
        private String enctp;
        private String fm;
        private String version;
        private String sign;
        private String name;
        private String type;
        private Object beginDate;
        private Object endDate;
        private Object delete_flag;
        private Object page;
        private Object id;

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        public String getMchnt_cd() {
            return mchnt_cd;
        }

        public void setMchnt_cd(String mchnt_cd) {
            this.mchnt_cd = mchnt_cd;
        }

        public String getMchnt_order_id() {
            return mchnt_order_id;
        }

        public void setMchnt_order_id(String mchnt_order_id) {
            this.mchnt_order_id = mchnt_order_id;
        }

        public String getAmt() {
            return amt;
        }

        public void setAmt(String amt) {
            this.amt = amt;
        }

        public String getBank_card() {
            return bank_card;
        }

        public void setBank_card(String bank_card) {
            this.bank_card = bank_card;
        }

        public String getBack_url() {
            return back_url;
        }

        public void setBack_url(String back_url) {
            this.back_url = back_url;
        }

        public String getId_no() {
            return id_no;
        }

        public void setId_no(String id_no) {
            this.id_no = id_no;
        }

        public String getId_type() {
            return id_type;
        }

        public void setId_type(String id_type) {
            this.id_type = id_type;
        }

        public String getLogo_tp() {
            return logo_tp;
        }

        public void setLogo_tp(String logo_tp) {
            this.logo_tp = logo_tp;
        }

        public String getHome_url() {
            return home_url;
        }

        public void setHome_url(String home_url) {
            this.home_url = home_url;
        }

        public String getRe_url() {
            return re_url;
        }

        public void setRe_url(String re_url) {
            this.re_url = re_url;
        }

        public String getRem1() {
            return rem1;
        }

        public void setRem1(String rem1) {
            this.rem1 = rem1;
        }

        public String getRem2() {
            return rem2;
        }

        public void setRem2(String rem2) {
            this.rem2 = rem2;
        }

        public String getRem3() {
            return rem3;
        }

        public void setRem3(String rem3) {
            this.rem3 = rem3;
        }

        public String getSign_tp() {
            return sign_tp;
        }

        public void setSign_tp(String sign_tp) {
            this.sign_tp = sign_tp;
        }

        public String getEnctp() {
            return enctp;
        }

        public void setEnctp(String enctp) {
            this.enctp = enctp;
        }

        public String getFm() {
            return fm;
        }

        public void setFm(String fm) {
            this.fm = fm;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public String getSign() {
            return sign;
        }

        public void setSign(String sign) {
            this.sign = sign;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public Object getBeginDate() {
            return beginDate;
        }

        public void setBeginDate(Object beginDate) {
            this.beginDate = beginDate;
        }

        public Object getEndDate() {
            return endDate;
        }

        public void setEndDate(Object endDate) {
            this.endDate = endDate;
        }

        public Object getDelete_flag() {
            return delete_flag;
        }

        public void setDelete_flag(Object delete_flag) {
            this.delete_flag = delete_flag;
        }

        public Object getPage() {
            return page;
        }

        public void setPage(Object page) {
            this.page = page;
        }

        public Object getId() {
            return id;
        }

        public void setId(Object id) {
            this.id = id;
        }
    }
}
