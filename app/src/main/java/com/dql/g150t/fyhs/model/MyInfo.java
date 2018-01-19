package com.dql.g150t.fyhs.model;

/**
 * Created by G150T on 2017/7/17.
 */

public class MyInfo {


    /**
     * msg : 获取成功
     * userInfo : {"id":1,"user_id":1,"sex":-1,"province":"","city":""}
     * countRecharge : 10.00
     * creditIntegral :
     * countBorrowMap2 : {"paymentAll":2020,"waitPayAll":2020,"allInterest":20,"repayedAll":0,"faFee":0,"waitInterest2":20}
     * pany :
     * financeCondition :
     * waitForPayNum : 1
     * latestWaitTimeMap :
     * countTenderMoney : {"repayedMoney":"","repayedInterest":"","repayedCapital":"","lateInterest":""}
     * waitNum : 0
     * messagesNum : 38
     * investCount : 0
     * redCount : 2
     * countBorrowTenderMap1 : {"tenderTotal":"","repayedTotal":"","repaymentYesinterestTotal":"","repayedCap":"","waitForPayTotal":"","waitCap":"","waitInterest":""}
     * spouseInfo :
     * email :
     * latestWaitPayMap : {"latestWaitPay":"1518330712"}
     * res : -2020.0
     * countBorrowMap : {"repayedMoney":0,"waitPayMoney":2000,"payedInterest":0,"waitInterest":20,"borrowAllMoney":2000}
     * itLevel : {"id":1,"name":"白手起家","least_integral":1,"img_url":"/uploadFile/image/20150701/20150701172152_475.gif","description":"1"}
     * assetsInfo :
     * borrower :
     * countCash :
     * mobile : {"id":1,"user_id":1,"randCode":"353820","mobileNum":"15867300380","passed":1,"addTime":"1513575844","addIp":"192.168.0.113","approTime":"1513575844"}
     * isNew : 1
     * isSign : false
     * realName : {"id":4,"user_id":1,"real_name":"陈诗凯","card_type":"1","id_card_no":"330206199106283114","birthdate":"1991年06月28日","sex":0,"addtime":"1515666429","addip":"127.0.0.1","status":1,"remark":"实名认证成功"}
     * privateOwnerInfo :
     * contactWay :
     * user : {"id":1,"style":1,"platform_id":1,"oldinvest_times":0,"userName":"15867300380","password":"dc483e80a7a0bd9ef71d8cf973673924"}
     * account : {"id":1,"user_id":1,"total":52014,"use_money":52014,"no_use_money":0,"collection":0,"times":3}
     * status : 1
     */

    private String msg;
    private UserInfoBean userInfo;
    private String countRecharge;
    private String creditIntegral;
    private CountBorrowMap2Bean countBorrowMap2;
    private String pany;
    private String financeCondition;
    private String waitForPayNum;
    private String latestWaitTimeMap;
    private CountTenderMoneyBean countTenderMoney;
    private String waitNum;
    private String messagesNum;
    private String investCount;
    private String redCount;
    private CountBorrowTenderMap1Bean countBorrowTenderMap1;
    private String spouseInfo;
    private String email;
    private LatestWaitPayMapBean latestWaitPayMap;
    private String res;
    private CountBorrowMapBean countBorrowMap;
    private ItLevelBean itLevel;
    private String assetsInfo;
    private String borrower;
    private String countCash;
    private MobileBean mobile;
    private String isNew;
    private boolean isSign;
    private RealNameBean realName;
    private String privateOwnerInfo;
    private String contactWay;
    private UserBean user;
    private AccountBean account;
    private String status;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public UserInfoBean getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfoBean userInfo) {
        this.userInfo = userInfo;
    }

    public String getCountRecharge() {
        return countRecharge;
    }

    public void setCountRecharge(String countRecharge) {
        this.countRecharge = countRecharge;
    }

    public String getCreditIntegral() {
        return creditIntegral;
    }

    public void setCreditIntegral(String creditIntegral) {
        this.creditIntegral = creditIntegral;
    }

    public CountBorrowMap2Bean getCountBorrowMap2() {
        return countBorrowMap2;
    }

    public void setCountBorrowMap2(CountBorrowMap2Bean countBorrowMap2) {
        this.countBorrowMap2 = countBorrowMap2;
    }

    public String getPany() {
        return pany;
    }

    public void setPany(String pany) {
        this.pany = pany;
    }

    public String getFinanceCondition() {
        return financeCondition;
    }

    public void setFinanceCondition(String financeCondition) {
        this.financeCondition = financeCondition;
    }

    public String getWaitForPayNum() {
        return waitForPayNum;
    }

    public void setWaitForPayNum(String waitForPayNum) {
        this.waitForPayNum = waitForPayNum;
    }

    public String getLatestWaitTimeMap() {
        return latestWaitTimeMap;
    }

    public void setLatestWaitTimeMap(String latestWaitTimeMap) {
        this.latestWaitTimeMap = latestWaitTimeMap;
    }

    public CountTenderMoneyBean getCountTenderMoney() {
        return countTenderMoney;
    }

    public void setCountTenderMoney(CountTenderMoneyBean countTenderMoney) {
        this.countTenderMoney = countTenderMoney;
    }

    public String getWaitNum() {
        return waitNum;
    }

    public void setWaitNum(String waitNum) {
        this.waitNum = waitNum;
    }

    public String getMessagesNum() {
        return messagesNum;
    }

    public void setMessagesNum(String messagesNum) {
        this.messagesNum = messagesNum;
    }

    public String getInvestCount() {
        return investCount;
    }

    public void setInvestCount(String investCount) {
        this.investCount = investCount;
    }

    public String getRedCount() {
        return redCount;
    }

    public void setRedCount(String redCount) {
        this.redCount = redCount;
    }

    public CountBorrowTenderMap1Bean getCountBorrowTenderMap1() {
        return countBorrowTenderMap1;
    }

    public void setCountBorrowTenderMap1(CountBorrowTenderMap1Bean countBorrowTenderMap1) {
        this.countBorrowTenderMap1 = countBorrowTenderMap1;
    }

    public String getSpouseInfo() {
        return spouseInfo;
    }

    public void setSpouseInfo(String spouseInfo) {
        this.spouseInfo = spouseInfo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LatestWaitPayMapBean getLatestWaitPayMap() {
        return latestWaitPayMap;
    }

    public void setLatestWaitPayMap(LatestWaitPayMapBean latestWaitPayMap) {
        this.latestWaitPayMap = latestWaitPayMap;
    }

    public String getRes() {
        return res;
    }

    public void setRes(String res) {
        this.res = res;
    }

    public CountBorrowMapBean getCountBorrowMap() {
        return countBorrowMap;
    }

    public void setCountBorrowMap(CountBorrowMapBean countBorrowMap) {
        this.countBorrowMap = countBorrowMap;
    }

    public ItLevelBean getItLevel() {
        return itLevel;
    }

    public void setItLevel(ItLevelBean itLevel) {
        this.itLevel = itLevel;
    }

    public String getAssetsInfo() {
        return assetsInfo;
    }

    public void setAssetsInfo(String assetsInfo) {
        this.assetsInfo = assetsInfo;
    }

    public String getBorrower() {
        return borrower;
    }

    public void setBorrower(String borrower) {
        this.borrower = borrower;
    }

    public String getCountCash() {
        return countCash;
    }

    public void setCountCash(String countCash) {
        this.countCash = countCash;
    }

    public MobileBean getMobile() {
        return mobile;
    }

    public void setMobile(MobileBean mobile) {
        this.mobile = mobile;
    }

    public String getIsNew() {
        return isNew;
    }

    public void setIsNew(String isNew) {
        this.isNew = isNew;
    }

    public boolean isIsSign() {
        return isSign;
    }

    public void setIsSign(boolean isSign) {
        this.isSign = isSign;
    }

    public RealNameBean getRealName() {
        return realName;
    }

    public void setRealName(RealNameBean realName) {
        this.realName = realName;
    }

    public String getPrivateOwnerInfo() {
        return privateOwnerInfo;
    }

    public void setPrivateOwnerInfo(String privateOwnerInfo) {
        this.privateOwnerInfo = privateOwnerInfo;
    }

    public String getContactWay() {
        return contactWay;
    }

    public void setContactWay(String contactWay) {
        this.contactWay = contactWay;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
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

    public static class UserInfoBean {
        /**
         * id : 1
         * user_id : 1
         * sex : -1
         * province :
         * city :
         */

        private int id;
        private int user_id;
        private int sex;
        private String province;
        private String city;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public int getSex() {
            return sex;
        }

        public void setSex(int sex) {
            this.sex = sex;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }
    }

    public static class CountBorrowMap2Bean {
        /**
         * paymentAll : 2020.0
         * waitPayAll : 2020.0
         * allInterest : 20.0
         * repayedAll : 0.0
         * faFee : 0.0
         * waitInterest2 : 20.0
         */

        private String paymentAll;
        private String waitPayAll;
        private String allInterest;
        private String repayedAll;
        private String faFee;
        private String waitInterest2;

        public String getPaymentAll() {
            return paymentAll;
        }

        public void setPaymentAll(String paymentAll) {
            this.paymentAll = paymentAll;
        }

        public String getWaitPayAll() {
            return waitPayAll;
        }

        public void setWaitPayAll(String waitPayAll) {
            this.waitPayAll = waitPayAll;
        }

        public String getAllInterest() {
            return allInterest;
        }

        public void setAllInterest(String allInterest) {
            this.allInterest = allInterest;
        }

        public String getRepayedAll() {
            return repayedAll;
        }

        public void setRepayedAll(String repayedAll) {
            this.repayedAll = repayedAll;
        }

        public String getFaFee() {
            return faFee;
        }

        public void setFaFee(String faFee) {
            this.faFee = faFee;
        }

        public String getWaitInterest2() {
            return waitInterest2;
        }

        public void setWaitInterest2(String waitInterest2) {
            this.waitInterest2 = waitInterest2;
        }
    }

    public static class CountTenderMoneyBean {
        /**
         * repayedMoney :
         * repayedInterest :
         * repayedCapital :
         * lateInterest :
         */

        private String repayedMoney;
        private String repayedInterest;
        private String repayedCapital;
        private String lateInterest;

        public String getRepayedMoney() {
            return repayedMoney;
        }

        public void setRepayedMoney(String repayedMoney) {
            this.repayedMoney = repayedMoney;
        }

        public String getRepayedInterest() {
            return repayedInterest;
        }

        public void setRepayedInterest(String repayedInterest) {
            this.repayedInterest = repayedInterest;
        }

        public String getRepayedCapital() {
            return repayedCapital;
        }

        public void setRepayedCapital(String repayedCapital) {
            this.repayedCapital = repayedCapital;
        }

        public String getLateInterest() {
            return lateInterest;
        }

        public void setLateInterest(String lateInterest) {
            this.lateInterest = lateInterest;
        }
    }

    public static class CountBorrowTenderMap1Bean {
        /**
         * tenderTotal :
         * repayedTotal :
         * repaymentYesinterestTotal :
         * repayedCap :
         * waitForPayTotal :
         * waitCap :
         * waitInterest :
         */

        private String tenderTotal;
        private String repayedTotal;
        private String repaymentYesinterestTotal;
        private String repayedCap;
        private String waitForPayTotal;
        private String waitCap;
        private String waitInterest;

        public String getTenderTotal() {
            return tenderTotal;
        }

        public void setTenderTotal(String tenderTotal) {
            this.tenderTotal = tenderTotal;
        }

        public String getRepayedTotal() {
            return repayedTotal;
        }

        public void setRepayedTotal(String repayedTotal) {
            this.repayedTotal = repayedTotal;
        }

        public String getRepaymentYesinterestTotal() {
            return repaymentYesinterestTotal;
        }

        public void setRepaymentYesinterestTotal(String repaymentYesinterestTotal) {
            this.repaymentYesinterestTotal = repaymentYesinterestTotal;
        }

        public String getRepayedCap() {
            return repayedCap;
        }

        public void setRepayedCap(String repayedCap) {
            this.repayedCap = repayedCap;
        }

        public String getWaitForPayTotal() {
            return waitForPayTotal;
        }

        public void setWaitForPayTotal(String waitForPayTotal) {
            this.waitForPayTotal = waitForPayTotal;
        }

        public String getWaitCap() {
            return waitCap;
        }

        public void setWaitCap(String waitCap) {
            this.waitCap = waitCap;
        }

        public String getWaitInterest() {
            return waitInterest;
        }

        public void setWaitInterest(String waitInterest) {
            this.waitInterest = waitInterest;
        }
    }

    public static class LatestWaitPayMapBean {
        /**
         * latestWaitPay : 1518330712
         */

        private String latestWaitPay;

        public String getLatestWaitPay() {
            return latestWaitPay;
        }

        public void setLatestWaitPay(String latestWaitPay) {
            this.latestWaitPay = latestWaitPay;
        }
    }

    public static class CountBorrowMapBean {
        /**
         * repayedMoney : 0.0
         * waitPayMoney : 2000.0
         * payedInterest : 0.0
         * waitInterest : 20.0
         * borrowAllMoney : 2000.0
         */

        private String repayedMoney;
        private String waitPayMoney;
        private String payedInterest;
        private String waitInterest;
        private String borrowAllMoney;

        public String getRepayedMoney() {
            return repayedMoney;
        }

        public void setRepayedMoney(String repayedMoney) {
            this.repayedMoney = repayedMoney;
        }

        public String getWaitPayMoney() {
            return waitPayMoney;
        }

        public void setWaitPayMoney(String waitPayMoney) {
            this.waitPayMoney = waitPayMoney;
        }

        public String getPayedInterest() {
            return payedInterest;
        }

        public void setPayedInterest(String payedInterest) {
            this.payedInterest = payedInterest;
        }

        public String getWaitInterest() {
            return waitInterest;
        }

        public void setWaitInterest(String waitInterest) {
            this.waitInterest = waitInterest;
        }

        public String getBorrowAllMoney() {
            return borrowAllMoney;
        }

        public void setBorrowAllMoney(String borrowAllMoney) {
            this.borrowAllMoney = borrowAllMoney;
        }
    }

    public static class ItLevelBean {
        /**
         * id : 1
         * name : 白手起家
         * least_integral : 1
         * img_url : /uploadFile/image/20150701/20150701172152_475.gif
         * description : 1
         */

        private int id;
        private String name;
        private String least_integral;
        private String img_url;
        private String description;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLeast_integral() {
            return least_integral;
        }

        public void setLeast_integral(String least_integral) {
            this.least_integral = least_integral;
        }

        public String getImg_url() {
            return img_url;
        }

        public void setImg_url(String img_url) {
            this.img_url = img_url;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }

    public static class MobileBean {
        /**
         * id : 1
         * user_id : 1
         * randCode : 353820
         * mobileNum : 15867300380
         * passed : 1
         * addTime : 1513575844
         * addIp : 192.168.0.113
         * approTime : 1513575844
         */

        private int id;
        private int user_id;
        private String randCode;
        private String mobileNum;
        private int passed;
        private String addTime;
        private String addIp;
        private String approTime;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public String getRandCode() {
            return randCode;
        }

        public void setRandCode(String randCode) {
            this.randCode = randCode;
        }

        public String getMobileNum() {
            return mobileNum;
        }

        public void setMobileNum(String mobileNum) {
            this.mobileNum = mobileNum;
        }

        public int getPassed() {
            return passed;
        }

        public void setPassed(int passed) {
            this.passed = passed;
        }

        public String getAddTime() {
            return addTime;
        }

        public void setAddTime(String addTime) {
            this.addTime = addTime;
        }

        public String getAddIp() {
            return addIp;
        }

        public void setAddIp(String addIp) {
            this.addIp = addIp;
        }

        public String getApproTime() {
            return approTime;
        }

        public void setApproTime(String approTime) {
            this.approTime = approTime;
        }
    }

    public static class RealNameBean {
        /**
         * id : 4
         * user_id : 1
         * real_name : 陈诗凯
         * card_type : 1
         * id_card_no : 330206199106283114
         * birthdate : 1991年06月28日
         * sex : 0
         * addtime : 1515666429
         * addip : 127.0.0.1
         * status : 1
         * remark : 实名认证成功
         */

        private int id;
        private int user_id;
        private String real_name;
        private String card_type;
        private String id_card_no;
        private String birthdate;
        private int sex;
        private String addtime;
        private String addip;
        private String status;
        private String remark;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public String getReal_name() {
            return real_name;
        }

        public void setReal_name(String real_name) {
            this.real_name = real_name;
        }

        public String getCard_type() {
            return card_type;
        }

        public void setCard_type(String card_type) {
            this.card_type = card_type;
        }

        public String getId_card_no() {
            return id_card_no;
        }

        public void setId_card_no(String id_card_no) {
            this.id_card_no = id_card_no;
        }

        public String getBirthdate() {
            return birthdate;
        }

        public void setBirthdate(String birthdate) {
            this.birthdate = birthdate;
        }

        public int getSex() {
            return sex;
        }

        public void setSex(int sex) {
            this.sex = sex;
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

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }
    }

    public static class UserBean {
        /**
         * id : 1
         * style : 1
         * platform_id : 1
         * oldinvest_times : 0
         * userName : 15867300380
         * password : dc483e80a7a0bd9ef71d8cf973673924
         */

        private int id;
        private String style;
        private String platform_id;
        private String oldinvest_times;
        private String userName;
        private String password;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getStyle() {
            return style;
        }

        public void setStyle(String style) {
            this.style = style;
        }

        public String getPlatform_id() {
            return platform_id;
        }

        public void setPlatform_id(String platform_id) {
            this.platform_id = platform_id;
        }

        public String getOldinvest_times() {
            return oldinvest_times;
        }

        public void setOldinvest_times(String oldinvest_times) {
            this.oldinvest_times = oldinvest_times;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

    public static class AccountBean {
        /**
         * id : 1
         * user_id : 1
         * total : 52014.0
         * use_money : 52014.0
         * no_use_money : 0.0
         * collection : 0.0
         * times : 3
         */

        private int id;
        private int user_id;
        private String total;
        private String use_money;
        private String no_use_money;
        private String collection;
        private String times;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public String getTotal() {
            return total;
        }

        public void setTotal(String total) {
            this.total = total;
        }

        public String getUse_money() {
            return use_money;
        }

        public void setUse_money(String use_money) {
            this.use_money = use_money;
        }

        public String getNo_use_money() {
            return no_use_money;
        }

        public void setNo_use_money(String no_use_money) {
            this.no_use_money = no_use_money;
        }

        public String getCollection() {
            return collection;
        }

        public void setCollection(String collection) {
            this.collection = collection;
        }

        public String getTimes() {
            return times;
        }

        public void setTimes(String times) {
            this.times = times;
        }
    }
}
