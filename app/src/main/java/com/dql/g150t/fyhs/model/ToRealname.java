package com.dql.g150t.fyhs.model;

/**
 * Created by G150T on 2017/7/18.
 */

public class ToRealname {

    /**
     * msg : 获取成功
     * realName : {"user_id":1003,"addtime":"1456225275","real_name":"张水丽","id_card_no":"310111196412120821","province":40,"city":41,"area":52,"audit_user":205,"remark":"审核通过：鞠毅恺","addip":"101.226.125.18","card_type":"1","card_pic1":null,"card_pic2":null,"birthdate":"1964-12-12","sex":1,"nation":"汉族","audit_time":"1456226152","id":595,"status":1}
     * status : 1
     */

    private String msg;
    private RealNameBean realName;
    private String status;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public RealNameBean getRealName() {
        return realName;
    }

    public void setRealName(RealNameBean realName) {
        this.realName = realName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static class RealNameBean {
        /**
         * user_id : 1003
         * addtime : 1456225275
         * real_name : 张水丽
         * id_card_no : 310111196412120821
         * province : 40
         * city : 41
         * area : 52
         * audit_user : 205
         * remark : 审核通过：鞠毅恺
         * addip : 101.226.125.18
         * card_type : 1
         * card_pic1 : null
         * card_pic2 : null
         * birthdate : 1964-12-12
         * sex : 1
         * nation : 汉族
         * audit_time : 1456226152
         * id : 595
         * status : 1
         */

        private int user_id;
        private String addtime;
        private String real_name;
        private String id_card_no;
        private int province;
        private int city;
        private int area;
        private int audit_user;
        private String remark;
        private String addip;
        private String card_type;
        private Object card_pic1;
        private Object card_pic2;
        private String birthdate;
        private int sex;
        private String nation;
        private String audit_time;
        private String id;
        private int status;

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

        public String getReal_name() {
            return real_name;
        }

        public void setReal_name(String real_name) {
            this.real_name = real_name;
        }

        public String getId_card_no() {
            return id_card_no;
        }

        public void setId_card_no(String id_card_no) {
            this.id_card_no = id_card_no;
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

        public int getAudit_user() {
            return audit_user;
        }

        public void setAudit_user(int audit_user) {
            this.audit_user = audit_user;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getAddip() {
            return addip;
        }

        public void setAddip(String addip) {
            this.addip = addip;
        }

        public String getCard_type() {
            return card_type;
        }

        public void setCard_type(String card_type) {
            this.card_type = card_type;
        }

        public Object getCard_pic1() {
            return card_pic1;
        }

        public void setCard_pic1(Object card_pic1) {
            this.card_pic1 = card_pic1;
        }

        public Object getCard_pic2() {
            return card_pic2;
        }

        public void setCard_pic2(Object card_pic2) {
            this.card_pic2 = card_pic2;
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

        public String getNation() {
            return nation;
        }

        public void setNation(String nation) {
            this.nation = nation;
        }

        public String getAudit_time() {
            return audit_time;
        }

        public void setAudit_time(String audit_time) {
            this.audit_time = audit_time;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }
    }
}
