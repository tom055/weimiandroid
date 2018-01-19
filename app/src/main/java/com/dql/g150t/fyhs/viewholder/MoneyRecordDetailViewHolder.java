package com.dql.g150t.fyhs.viewholder;

import android.view.ViewGroup;
import android.widget.TextView;

import com.dql.g150t.fyhs.R;
import com.dql.g150t.fyhs.model.MoneyRecordDetail;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by G150T on 2017/7/21.
 */

public class MoneyRecordDetailViewHolder extends BaseViewHolder<MoneyRecordDetail.LogsBean> {

    private TextView tv_remark, /*tv_money,*/ tv_operation_money,/* tv_use_money, tv_no_use_money,*/ tv_add_time;

    public MoneyRecordDetailViewHolder(ViewGroup parent) {
        super(parent, R.layout.item_money_record_detail);
        tv_remark = $(R.id.tv_remark);//资金详情
        //tv_money = $(R.id.tv_money);//总金额
        tv_operation_money = $(R.id.tv_operation_money) ;//操作金额
        //tv_use_money = $(R.id.tv_use_money) ;//可用金额
        //tv_no_use_money = $(R.id.tv_no_use_money) ;//冻结金额
        tv_add_time = $(R.id.tv_add_time);//添加时间
    }

    @Override
    public void setData(MoneyRecordDetail.LogsBean data) {
        super.setData(data);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") ;
        long addTime = Long.parseLong(data.getAddtime());
        String time = sdf.format(new Date(addTime * 1000L)) ;
        tv_add_time.setText(time);

        String type = data.getType();
        if (type.equals("recharge")){
            tv_remark.setText("用户充值");
        }else if (type.equals("borrow_fee")){
            tv_remark.setText("融资服务费");
        }else if (type.equals("cash_cancel")){
            tv_remark.setText("取消提现解冻");
        }else if (type.equals("cash_frost")){
            tv_remark.setText("提现冻结");
        }else if (type.equals("tender")){
            tv_remark.setText("投标");
        }else if (type.equals("borrow_success")){
            tv_remark.setText("借款入帐");
        }else if (type.equals("margin")){
            tv_remark.setText("保证金");
        }else if (type.equals("invest")){
            tv_remark.setText("扣除冻结款");
        }else if (type.equals("fee")){
            tv_remark.setText("充值手续费");
        }else if (type.equals("award_lower")){
            tv_remark.setText("扣除投标奖励");
        }else if (type.equals("award_add")){
            tv_remark.setText("投标奖励");
        }else if (type.equals("repayment")){
            tv_remark.setText("还款扣除");
        }else if (type.equals("invest_false")){
            tv_remark.setText("投标失败资金返回");
        }else if (type.equals("withdraw_fee")){
            tv_remark.setText("提现手续费");
        }else if (type.equals("collection")){
            tv_remark.setText("待收金额");
        }else if (type.equals("borrow_frost")){
            tv_remark.setText("解冻借款担保金");
        }else if (type.equals("invest_repayment")){
            tv_remark.setText("投资回款");
        }else if (type.equals("vip")){
            tv_remark.setText("vip会员费");
        }else if (type.equals("realname")){
            tv_remark.setText("实名认证费用");
        }else if (type.equals("withdraw_success")){
            tv_remark.setText("提现成功");
        }else if (type.equals("withdraw_false")){
            tv_remark.setText("提现失败");
        }else if (type.equals("system_repayment")){
            tv_remark.setText("逾期系统还款");
        }else if (type.equals("late_rate")){
            tv_remark.setText("逾期利息");
        }else if (type.equals("ticheng")){
            tv_remark.setText("投标提成");
        }else if (type.equals("late_collection")){
            tv_remark.setText("逾期收入");
        }else if (type.equals("scene_account")){
            tv_remark.setText("现场认证费用");
        }else if (type.equals("vouch_advanced")){
            tv_remark.setText("担保垫付扣费");
        }else if (type.equals("borrow_kouhui")){
            tv_remark.setText("借款人罚金扣回");
        }else if (type.equals("vouch_awardpay")){
            tv_remark.setText("担保奖励支付");
        }else if (type.equals("vouch_award")){
            tv_remark.setText("担保奖励接收");
        }else if (type.equals("margin_vouch")){
            tv_remark.setText("担保成功冻结");
        }else if (type.equals("video")){
            tv_remark.setText("视频认证费用");
        }else if (type.equals("tender_mange")){
            tv_remark.setText("利息管理费用");
        }else if (type.equals("repayment_wy")){
            tv_remark.setText("提前还款违约");
        }else if (type.equals("invest_repayment_wy")){
            tv_remark.setText("客户提前还款违约");
        }else if (type.equals("realname2")){
            tv_remark.setText("实名认证费用冻结");
        }else if (type.equals("realname_fail")){
            tv_remark.setText("实名认证失败");
        }else if (type.equals("secondFee_frost")){
            tv_remark.setText("秒标利息冻结");
        }else if (type.equals("shop_expense")){
            tv_remark.setText("积分商城消费");
        }else if (type.equals("bad_bill_frost")){
            tv_remark.setText("坏账计提(冻结)");
        }else if (type.equals("mall_back")){
            tv_remark.setText("商城退款");
        }else if (type.equals("service_free")){
            tv_remark.setText("服务费");
        }else if (type.equals("into_yuebao")){
            tv_remark.setText("财生宝转入");
        }else if (type.equals("out_yuebao")){
            tv_remark.setText("财生宝转出");
        }else if (type.equals("income_yuebao")){
            tv_remark.setText("财生宝收益");
        }else if (type.equals("debt_buy")){
            tv_remark.setText("债权认购成功");
        }else if (type.equals("debt_transfer")){
            tv_remark.setText("债权转让成功");
        }else if (type.equals("debt_interest_out")){
            tv_remark.setText("债权支付利息");
        }else if (type.equals("debt_interest_in")){
            tv_remark.setText("债权利息收入");
        }else if (type.equals("debt_fee")){
            tv_remark.setText("债权转让手续费");
        }else if (type.equals("after_advance_repay")){
            tv_remark.setText("垫付后还款");
        }else if (type.equals("invest_repay_website")){
            tv_remark.setText("投资回款(网站垫付)");
        }else if (type.equals("add_interest_account")){
            tv_remark.setText("加息收益");
        }
        DecimalFormat df = new DecimalFormat("0.00");
        String money = df.format(data.getMoney());


        if (type.equals("recharge")){
            tv_operation_money.setText("用户充值"+money+"元" );
        }else if (type.equals("borrow_fee")){
            tv_operation_money.setText("融资服务费"+money+"元" );
        }else if (type.equals("cash_cancel")){
            tv_operation_money.setText("取消提现解冻"+ money+"元");
        }else if (type.equals("cash_frost")){
            tv_operation_money.setText("提现冻结"+money+"元" );
        }else if (type.equals("tender")){
            tv_operation_money.setText("投标"+ money+"元");
        }else if (type.equals("borrow_success")){
            tv_operation_money.setText("借款入帐"+ money+"元");
        }else if (type.equals("margin")){
            tv_operation_money.setText("保证金"+money+"元");
        }else if (type.equals("invest")){
            tv_operation_money.setText("扣除冻结款"+money+"元");
        }else if (type.equals("fee")){
            tv_operation_money.setText("充值手续费"+ money+"元");
        }else if (type.equals("award_lower")){
            tv_operation_money.setText("扣除投标奖励"+ money+"元");
        }else if (type.equals("award_add")){
            tv_operation_money.setText("投标奖励"+ money+"元");
        }else if (type.equals("repayment")){
            tv_operation_money.setText("还款扣除"+money+"元");
        }else if (type.equals("invest_false")){
            tv_operation_money.setText("投标失败资金返回"+ money+"元");
        }else if (type.equals("withdraw_fee")){
            tv_operation_money.setText("提现手续费"+money+"元");
        }else if (type.equals("collection")){
            tv_operation_money.setText("待收金额"+ money+"元");
        }else if (type.equals("borrow_frost")){
            tv_operation_money.setText("解冻借款担保金"+ money+"元");
        }else if (type.equals("invest_repayment")){
            tv_operation_money.setText("投资回款"+money+"元");
        }else if (type.equals("vip")){
            tv_operation_money.setText("vip会员费"+ money+"元");
        }else if (type.equals("realname")){
            tv_operation_money.setText("实名认证费用"+money+"元");
        }else if (type.equals("withdraw_success")){
            tv_operation_money.setText("提现成功"+ money+"元");
        }else if (type.equals("withdraw_false")){
            tv_operation_money.setText("提现失败"+ money+"元");
        }else if (type.equals("system_repayment")){
            tv_operation_money.setText("逾期系统还款"+money+"元");
        }else if (type.equals("late_rate")){
            tv_operation_money.setText("逾期利息"+ money+"元");
        }else if (type.equals("ticheng")){
            tv_operation_money.setText("投标提成"+ money+"元");
        }else if (type.equals("late_collection")){
            tv_operation_money.setText("逾期收入"+ money+"元");
        }else if (type.equals("scene_account")){
            tv_operation_money.setText("现场认证费用"+ money+"元");
        }else if (type.equals("vouch_advanced")){
            tv_operation_money.setText("担保垫付扣费"+money+"元");
        }else if (type.equals("borrow_kouhui")){
            tv_operation_money.setText("借款人罚金扣回"+ money+"元");
        }else if (type.equals("vouch_awardpay")){
            tv_operation_money.setText("担保奖励支付"+money+"元");
        }else if (type.equals("vouch_award")){
            tv_operation_money.setText("担保奖励接收"+ money+"元");
        }else if (type.equals("margin_vouch")){
            tv_operation_money.setText("担保成功冻结"+ money+"元");
        }else if (type.equals("video")){
            tv_operation_money.setText("视频认证费用"+ money+"元");
        }else if (type.equals("tender_mange")){
            tv_operation_money.setText("利息管理费用"+ money+"元");
        }else if (type.equals("repayment_wy")){
            tv_operation_money.setText("提前还款违约"+ money+"元");
        }else if (type.equals("invest_repayment_wy")){
            tv_operation_money.setText("客户提前还款违约"+ money+"元");
        }else if (type.equals("realname2")){
            tv_operation_money.setText("实名认证费用冻结"+money+"元");
        }else if (type.equals("realname_fail")){
            tv_operation_money.setText("实名认证失败"+money+"元");
        }else if (type.equals("secondFee_frost")){
            tv_operation_money.setText("秒标利息冻结"+ money+"元");
        }else if (type.equals("shop_expense")){
            tv_operation_money.setText("积分商城消费"+ money+"元");
        }else if (type.equals("bad_bill_frost")){
            tv_operation_money.setText("坏账计提(冻结)"+ money+"元");
        }else if (type.equals("mall_back")){
            tv_operation_money.setText("商城退款"+ money+"元");
        }else if (type.equals("service_free")){
            tv_operation_money.setText("服务费"+ money+"元");
        }else if (type.equals("into_yuebao")){
            tv_operation_money.setText("财生宝转入"+ money+"元");
        }else if (type.equals("out_yuebao")){
            tv_operation_money.setText("财生宝转出"+ money+"元");
        }else if (type.equals("income_yuebao")){
            tv_operation_money.setText("财生宝收益"+ money+"元");
        }else if (type.equals("debt_buy")){
            tv_operation_money.setText("债权认购成功"+money+"元");
        }else if (type.equals("debt_transfer")){
            tv_operation_money.setText("债权转让成功"+ money+"元");
        }else if (type.equals("debt_interest_out")){
            tv_operation_money.setText("债权支付利息"+money+"元");
        }else if (type.equals("debt_interest_in")){
            tv_operation_money.setText("债权利息收入"+ money+"元");
        }else if (type.equals("debt_fee")){
            tv_operation_money.setText("债权转让手续费"+ money+"元");
        }else if (type.equals("after_advance_repay")){
            tv_operation_money.setText("垫付后还款"+ money+"元");
        }else if (type.equals("invest_repay_website")){
            tv_operation_money.setText("投资回款(网站垫付)"+ money+"元");
        }else if (type.equals("add_interest_account")){
            tv_operation_money.setText("加息收益"+ money+"元");
        }
/*
        if (data.getFlow().equals("in")){
            tv_remark.setText("充值");
        }else if (data.getFlow().equals("out")){
            tv_remark.setText("支出");
        }else if (data.getFlow().equals("thaw")){
            tv_remark.setText("解冻");
        }else if (data.getFlow().equals("out_yuebao")){
            tv_remark.setText("存入");
        }else if (data.getFlow().equals("into_yuebao")){
            tv_remark.setText("取出");
        }else{
            tv_remark.setText("冻结");
        }
        //tv_remark.setText(data.getRemark());

        //tv_money.setText("总金额: ￥" + data.getTotal());
//        tv_operation_money.setText("操作金额:" + data.getMoney() + "￥");
        //tv_use_money.setText("可用金额: ￥" + data.getUse_money());
        //tv_no_use_money.setText("冻结金额: ￥" + data.getNo_use_money());

        if (data.getFlow().equals("in")){
            tv_operation_money.setText("+" + data.getMoney());
        }else if (data.getFlow().equals("out")){
            tv_operation_money.setText("-" + data.getMoney());
        }else if (data.getFlow().equals("thaw")){
            tv_operation_money.setText("解冻￥" + data.getMoney());
        }else if (data.getFlow().equals("out_yuebao")){
            tv_operation_money.setText("转出￥" + data.getMoney());
        }else if (data.getFlow().equals("into_yuebao")){
            tv_operation_money.setText("取出￥" + data.getMoney());
        }else{
            tv_operation_money.setText("冻结￥" + data.getMoney());
        }*/
    }
}
