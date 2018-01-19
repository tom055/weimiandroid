package com.dql.g150t.fyhs.model;

import java.util.List;

/**
 * Created by ST on 2017/7/24.
 */

public class NewDetail {

    /**
     * msg : 获取成功
     * page : {"totalCount":1,"begin":0,"pageSize":5,"currentPage":1,"totalPage":1}
     * list : [{"add_time":"1500878021","red_type":2,"keyAndValue":"7","start_time":"2017-07-24","red_id":1,"end_time":"2017-07-31","limit_num":23,"imgs":null,"activity_name":"23","img":"/gcs/uploadFile/image/20170724/20170724143334_383.jpg","status":1,"id":20,"type":1,"content":"11"}]
     * status : 1
     */

    private String msg;
    private PageBean page;
    private String status;
    private List<ListBean> list;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class PageBean {
        /**
         * totalCount : 1
         * begin : 0
         * pageSize : 5
         * currentPage : 1
         * totalPage : 1
         */

        private int totalCount;
        private int begin;
        private int pageSize;
        private int currentPage;
        private int totalPage;

        public int getTotalCount() {
            return totalCount;
        }

        public void setTotalCount(int totalCount) {
            this.totalCount = totalCount;
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

        public int getTotalPage() {
            return totalPage;
        }

        public void setTotalPage(int totalPage) {
            this.totalPage = totalPage;
        }
    }

    public static class ListBean {
        /**
         * add_time : 1500878021
         * red_type : 2
         * keyAndValue : 7
         * start_time : 2017-07-24
         * red_id : 1
         * end_time : 2017-07-31
         * limit_num : 23
         * imgs : null
         * activity_name : 23
         * img : /gcs/uploadFile/image/20170724/20170724143334_383.jpg
         * status : 1
         * id : 20
         * type : 1
         * content : 11
         */

        private String add_time;
        private int red_type;
        private String keyAndValue;
        private String start_time;
        private int red_id;
        private String end_time;
        private int limit_num;
        private Object imgs;
        private String activity_name;
        private String img;
        private int status;
        private int id;
        private int type;
        private String content;

        public String getAdd_time() {
            return add_time;
        }

        public void setAdd_time(String add_time) {
            this.add_time = add_time;
        }

        public int getRed_type() {
            return red_type;
        }

        public void setRed_type(int red_type) {
            this.red_type = red_type;
        }

        public String getKeyAndValue() {
            return keyAndValue;
        }

        public void setKeyAndValue(String keyAndValue) {
            this.keyAndValue = keyAndValue;
        }

        public String getStart_time() {
            return start_time;
        }

        public void setStart_time(String start_time) {
            this.start_time = start_time;
        }

        public int getRed_id() {
            return red_id;
        }

        public void setRed_id(int red_id) {
            this.red_id = red_id;
        }

        public String getEnd_time() {
            return end_time;
        }

        public void setEnd_time(String end_time) {
            this.end_time = end_time;
        }

        public int getLimit_num() {
            return limit_num;
        }

        public void setLimit_num(int limit_num) {
            this.limit_num = limit_num;
        }

        public Object getImgs() {
            return imgs;
        }

        public void setImgs(Object imgs) {
            this.imgs = imgs;
        }

        public String getActivity_name() {
            return activity_name;
        }

        public void setActivity_name(String activity_name) {
            this.activity_name = activity_name;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
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

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }
}
