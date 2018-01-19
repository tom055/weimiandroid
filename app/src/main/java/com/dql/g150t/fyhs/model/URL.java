package com.dql.g150t.fyhs.model;

/**
 * Created by ST on 2017/8/5.
 */

public class URL {

    /**
     * profileUrl : /gcs/wap/aboutUs/about/profile.jsp
     * historyUrl : /gcs/wap/aboutUs/about/history.jsp
     * teamUrl : /gcs/wap/aboutUs/about/team.jsp
     * certUrl : /gcs/wap/aboutUs/about/cert.jsp
     * contactUrl : /gcs/wap/aboutUs/about/contact.jsp
     * cultureUrl : /gcs/wap/aboutUs/about/culture.jsp
     * styleUrl : /gcs/wap/aboutUs/about/style.jsp
     */

    private String profileUrl;//公司简介
    private String historyUrl;//发展历程
    private String teamUrl;//企业团队
    private String certUrl;//认证资质
    private String contactUrl;//联系我们
    private String cultureUrl;//企业文化
    private String styleUrl;//企业风采

    public String getProfileUrl() {
        return profileUrl;
    }

    public void setProfileUrl(String profileUrl) {
        this.profileUrl = profileUrl;
    }

    public String getHistoryUrl() {
        return historyUrl;
    }

    public void setHistoryUrl(String historyUrl) {
        this.historyUrl = historyUrl;
    }

    public String getTeamUrl() {
        return teamUrl;
    }

    public void setTeamUrl(String teamUrl) {
        this.teamUrl = teamUrl;
    }

    public String getCertUrl() {
        return certUrl;
    }

    public void setCertUrl(String certUrl) {
        this.certUrl = certUrl;
    }

    public String getContactUrl() {
        return contactUrl;
    }

    public void setContactUrl(String contactUrl) {
        this.contactUrl = contactUrl;
    }

    public String getCultureUrl() {
        return cultureUrl;
    }

    public void setCultureUrl(String cultureUrl) {
        this.cultureUrl = cultureUrl;
    }

    public String getStyleUrl() {
        return styleUrl;
    }

    public void setStyleUrl(String styleUrl) {
        this.styleUrl = styleUrl;
    }
}
