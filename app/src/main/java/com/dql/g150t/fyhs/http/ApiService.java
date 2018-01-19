package com.dql.g150t.fyhs.http;


import com.dql.g150t.fyhs.model.BackReturnForWeb;
import com.dql.g150t.fyhs.model.BankCard;
import com.dql.g150t.fyhs.model.BaseStatus;
import com.dql.g150t.fyhs.model.BindCard;
import com.dql.g150t.fyhs.model.City;
import com.dql.g150t.fyhs.model.Code;
import com.dql.g150t.fyhs.model.Collection;
import com.dql.g150t.fyhs.model.Country;
import com.dql.g150t.fyhs.model.DiscountCoupon;
import com.dql.g150t.fyhs.model.Index;
import com.dql.g150t.fyhs.model.Invest;
import com.dql.g150t.fyhs.model.InvestDetail;
import com.dql.g150t.fyhs.model.InvestRecord;
import com.dql.g150t.fyhs.model.Login;
import com.dql.g150t.fyhs.model.MoneyRecordDetail;
import com.dql.g150t.fyhs.model.MyInfo;
import com.dql.g150t.fyhs.model.NewDetail;
import com.dql.g150t.fyhs.model.NewDetailRecord;
import com.dql.g150t.fyhs.model.PlatformAnnouncement;
import com.dql.g150t.fyhs.model.PlatformAnnouncementDetail;
import com.dql.g150t.fyhs.model.Protocol;
import com.dql.g150t.fyhs.model.Province;
import com.dql.g150t.fyhs.model.Realname;
import com.dql.g150t.fyhs.model.Recharge;
import com.dql.g150t.fyhs.model.RecomUrl;
import com.dql.g150t.fyhs.model.Regist;
import com.dql.g150t.fyhs.model.ToRealname;
import com.dql.g150t.fyhs.model.ToRecharge;
import com.dql.g150t.fyhs.model.ToWithDraw;
import com.dql.g150t.fyhs.model.URL;
import com.dql.g150t.fyhs.model.WithDraw;

import java.util.Map;

import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;


public interface ApiService {

    //注册
    @POST("app_user/regist.dql")
    Observable<Regist> Register(@FieldMap Map<String, String> map);

    //登录
    @FormUrlEncoded
    @POST("app_user/login.dql")
    Observable<Login> login(@FieldMap Map<String, String> map);

    //获取验证码
    @POST("app_user/getCode.dql")
    Observable<Code> getCode(@FieldMap Map<String, String> map);

    //首页
    @FormUrlEncoded
    @POST("app_home/toIndex.dql")
    Observable<Index> index(@FieldMap Map<String, String> map);

    //我的页面
    @FormUrlEncoded
    @POST("app_user/toMyAccount.dql")
    Observable<MyInfo> MyInfo(@FieldMap Map<String, String> map);

    /*//我的页面
    @FormUrlEncoded
    @POST("app_user/toMyAccount.dql")
    Call<ResponseBody> MyInfo2(@FieldMap Map<String, String> map);*/

    //判断是否绑卡和已绑定银行卡
    @FormUrlEncoded
    @POST("app_user/toBankCard.dql")
    Observable<BankCard> bankcard(@FieldMap Map<String, String> map);

    //进入提现页面
    @FormUrlEncoded
    @POST("app_user/toCash.dql")
    Observable<ToWithDraw> toWithDraw(@FieldMap Map<String, String> map);

    //提现
    @FormUrlEncoded
    @POST("app_user/cashApply.dql")
    Observable<WithDraw> getWithDraw(@FieldMap Map<String, String> map);

    //进入充值页面
    @FormUrlEncoded
    @POST("app_user/toRecharge.dql")
    Observable<ToRecharge> toRecharge(@FieldMap Map<String, String> map);

    //线下充值
//    @FormUrlEncoded
//    @POST("app_user/offlineRecharge.dql")
//    Observable<Recharge> getRecharge(@FieldMap Map<String, String> map);

    //进入实名认证页面
    @FormUrlEncoded
    @POST("app_user/toPersonalAuth.dql")
    Observable<ToRealname> toReal(@FieldMap Map<String, String> map);

    //实名认证
    @FormUrlEncoded
    @POST("app_user/realApprove.dql")
    Observable<Realname> real(@FieldMap Map<String, String> map);

    //获取省列表
    @POST("app_user/findCityByProvince.dql")
    Observable<Province> getProvinceList();

    //获取市列表
    @FormUrlEncoded
    @POST("app_user/findCityByCity.dql")
    Observable<City> getCityList(@Field("id") String provinceId);

    //获取区列表
    @FormUrlEncoded
    @POST("app_user/findCityByArea.dql")
    Observable<Country> getCountryList(@Field("id") String cityId);

    //获取区列表
    @FormUrlEncoded
    @POST("app_user/bankCardSave.dql")
    Observable<BindCard> getBindCard(@FieldMap Map<String, String> map);

    //获取资金记录
    @FormUrlEncoded
    @POST("app_user/financialRecord.dql")
    Observable<MoneyRecordDetail> getMoneyRecordDetail(@FieldMap Map<String, String> map);

    //持有中
    @FormUrlEncoded
    @POST("app_user/tenderOrCollectionRecords.dql")
    Observable<InvestRecord> getInvestRecord(@FieldMap Map<String, String> map);

    //已还款
    @FormUrlEncoded
    @POST("app_user/tenderOrCollectionRecords.dql")
    Observable<Collection> getCollection(@FieldMap Map<String, String> map);

    //项目详情
    @FormUrlEncoded
    @POST("app_borrow/toInvestByBorrowId.dql")
    Observable<InvestDetail> getInvestDetail(@FieldMap Map<String, String> map);

    //红包列表
    @FormUrlEncoded
    @POST("app_user/toUserRed.dql")
    Observable<DiscountCoupon> getDiscountCoupon(@FieldMap Map<String, String> map);

    //热门活动列表
    @FormUrlEncoded
    @POST("app_activity/toActivity.dql")
    Observable<NewDetail> getNewDetail(@FieldMap Map<String, String> map);

    //热门活动详细
    @FormUrlEncoded
    @POST("app_activity/toActivityById.dql")
    Observable<NewDetailRecord> getNewDetailRecord(@FieldMap Map<String, String> map);

    //平台公告列表
    @FormUrlEncoded
    @POST("app_activity/findAnnouncement.dql")
    Observable<PlatformAnnouncement> getPlatformAnnouncement(@FieldMap Map<String, String> map);

    //平台公告详细
    @FormUrlEncoded
    @POST("app_activity/toNewsDetail.dql")
    Observable<PlatformAnnouncementDetail> getPlatformAnnouncementDetail(@FieldMap Map<String, String> map);

    //投资列表
    @FormUrlEncoded
    @POST("app_borrow/toAllInvest.dql")
    Observable<Invest> getIvest(@FieldMap Map<String, String> map);

    //投标
    @FormUrlEncoded
    @POST("app_borrow/tender.dql")
    Observable<BaseStatus> tender(@FieldMap Map<String, String> map);

    //url
    @POST("app_home/toUrl.dql")
    Observable<URL> url();

    //协议
    @POST("app_home/toRegProtocol.dql")
    Observable<Protocol> toProtocol();

    //推荐有奖链接
    @FormUrlEncoded
    @POST("app_user/getRecomUrl.dql")
    Observable<RecomUrl> getRecomUrl(@FieldMap Map<String, String> map);
    //充值
    @FormUrlEncoded
    @POST("app_user/rechargeWeb.dql")
    Observable<Recharge> getRecharge(@FieldMap Map<String, String> map);


    //充值回调

    @FormUrlEncoded
    @POST("app_user/backReturnForWeb.dql")
    Observable<BackReturnForWeb> getBackReturnForWeb(@FieldMap Map<String, String> map);

}

