package com.dql.g150t.fyhs.activity;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bigkoo.pickerview.OptionsPickerView;
import com.dql.g150t.fyhs.MyApplication;
import com.dql.g150t.fyhs.R;
import com.dql.g150t.fyhs.base.BaseActivity;
import com.dql.g150t.fyhs.model.BankCard;
import com.dql.g150t.fyhs.model.BindCard;
import com.dql.g150t.fyhs.model.City;
import com.dql.g150t.fyhs.model.Country;
import com.dql.g150t.fyhs.model.Province;
import com.dql.g150t.fyhs.utils.BankcardCheckUtils;
import com.dql.g150t.fyhs.utils.SoftInputUtil;
import com.dql.g150t.fyhs.utils.ToastUtil;
import com.dql.g150t.fyhs.view.TopBar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class BindCardActivity extends BaseActivity {

    @BindView(R.id.topbar)//topbar
            TopBar topbar;
    @BindView(R.id.tv_choose_bank)//选择银行--textview
            TextView tvChooseBank;
    @BindView(R.id.ll_choose_bank)//选择银行--LinearLayout
            LinearLayout llChooseBank;
    @BindView(R.id.et_bank_number)//银行卡号输入框
            EditText etBankNumber;
    @BindView(R.id.et_name)//开户名输入框
            EditText etName;
    @BindView(R.id.et_phone)//预留手机号输入框
            EditText etPhone;
    @BindView(R.id.btn_submit)//审核按钮
            Button btnSubmit;
    @BindView(R.id.et_province)
    TextView etProvince;//省份
    @BindView(R.id.et_city)
    TextView etCity;//城市
    @BindView(R.id.et_country)
    TextView etCountry;//区
    /*@BindView(R.id.et_branch)
    EditText etBranch;*/
    @BindView(R.id.et_password)
    EditText etPassword;

    private static final String TAG = "BindCardActivity";

    private Activity mActivity;
    private MyApplication application;
    private ArrayList<Integer> bankIdList = new ArrayList<>();//银行id集合
    private ArrayList<String> bankNameList = new ArrayList<>();//银行英文名称集合
    private ArrayList<String> bankValueList = new ArrayList<>();//银行中文名称集合
    private ArrayList<BankCard.BanklistsBean> bankCardList = new ArrayList<>();//银行卡列表集合

    private String bankId = "";//选中银行卡id
    private String bankName = "";//选中银行卡英文名称

    private ArrayList<Province.ProvinceBean> provinceList = new ArrayList<>();//省份列表集合
    private ArrayList<String> provinceName = new ArrayList<>();//省份名称集合
    private ArrayList<String> provinceId = new ArrayList<>();//省份id集合

    private ArrayList<City.CityBean> cityList = new ArrayList<>();//城市列表集合
    private ArrayList<String> cityName = new ArrayList<>();//城市名称集合
    private ArrayList<String> cityNIDs = new ArrayList<>();//城市id集合

    private ArrayList<Country.AreaBean> countryList = new ArrayList<>();//区域列表集合
    private ArrayList<String> countryName = new ArrayList<>();//区域名称集合
    private ArrayList<String> countryNIDs = new ArrayList<>();//区域id集合

    private String provinceNID = "";//选中省份id
    private String cityNID = "";//选中城市id
    private String countryNID = "";//选中区域id

    OptionsPickerView bankOptions;
    OptionsPickerView provinceOptions;
    OptionsPickerView cityOptions;
    OptionsPickerView countryOptions;

    @Override
    public void init() {
        mActivity = BindCardActivity.this;
        application = (MyApplication) getApplication();
        bankOptions = new OptionsPickerView(mActivity);
        provinceOptions = new OptionsPickerView(mActivity);
        cityOptions = new OptionsPickerView(mActivity);
        countryOptions = new OptionsPickerView(mActivity);
        topbar.setOnTopbarClickListener(new TopBar.topbarClickListener() {
            @Override
            public void leftClick() {
                finish();
            }

            @Override
            public void rightClick() {

            }
        });
        getBankCard();
        getProvince();
    }

    /**
     * 绑定银行卡
     */
    private void bindCard() {
        //String branch = etBranch.getText().toString();
        String password = etPassword.getText().toString();
        String bankCard = etBankNumber.getText().toString();
        String bankMobile = etPhone.getText().toString();
        String owner = etName.getText().toString();
        if (provinceNID.equals("")) {
            ToastUtil.showToast(mActivity, "请选择省份");
        }
        if (cityNID.equals("")) {
            ToastUtil.showToast(mActivity, "请选择城市");
            return;
        }
        if (countryNID.equals("")) {
            ToastUtil.showToast(mActivity, "请选择地区");
            return;
        }
        if (bankId.equals("")) {
            ToastUtil.showToast(mActivity, "请选择银行");
            return;
        }
       /* if (branch.isEmpty()) {
            ToastUtil.showToast(mActivity, "请输入开户地");
            return;
        }*/
        if (password.isEmpty()) {
            ToastUtil.showToast(mActivity, "请输入交易密码");
            return;
        }
        if (bankCard.isEmpty()) {
            ToastUtil.showToast(mActivity, "请输入银行卡号");
            return;
        }
        if (bankMobile.isEmpty()) {
            ToastUtil.showToast(mActivity, "请输入开户手机号");
            return;
        }
        if (owner.isEmpty()) {
            ToastUtil.showToast(mActivity, "请输入开户名");
            return;
        }
        if (bankMobile.length() < 11 || bankMobile.length() > 11) {
            ToastUtil.showToast(mActivity, "请输入正确的开户手机号");
            return;
        }
        if (!BankcardCheckUtils.checkBankCard(bankCard)){
            ToastUtil.showToast(mActivity,"请输入正确的银行卡");
            return;
        }
        /*if (bankCard.length() < 19 || bankCard.length() > 19) {
            ToastUtil.showToast(mActivity, "请输入正确的银行卡号");
            return;
        }*/
        Map<String, String> map = new HashMap<>();
        map.put("userid", application.userId);
        map.put("paypassword", password);
        map.put("bank", bankName);
        map.put("province", provinceNID);
        map.put("city", cityNID);
        map.put("area", countryNID);
       // map.put("branch", branch);
        map.put("bank_cardno", bankCard);
        application.apiService.getBindCard(map);
        application.apiService.getBindCard(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<BindCard>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "onError: "+e.toString() );
                    }

                    @Override
                    public void onNext(BindCard bindCard) {
                        Log.e(TAG, "onNext: "+bindCard.getStatus() );
                        if (bindCard.getStatus().equals("1")){
                            ToastUtil.showToast(mActivity,bindCard.getMsg());
                            finish();
                        }else{
                            ToastUtil.showToast(mActivity,bindCard.getMsg());
                            return;
                        }
                    }
                });
    }

    /**
     * 获取银行卡列表
     */
    private void getBankCard() {
        Map<String, String> map = new HashMap<>();
        map.put("userid", application.userId);
        application.apiService.bankcard(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<BankCard>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(BankCard bankCard) {
                        Log.e("getBankListSuccess", bankCard.getBanklists().toString());

                        bankCardList.clear();
                        bankNameList.clear();
                        bankIdList.clear();
                        bankCardList.addAll(bankCard.getBanklists());
                        for (int i = 0; i < bankCardList.size(); i++) {
                            bankIdList.add(bankCardList.get(i).getId());
                            bankNameList.add(bankCardList.get(i).getValue());
                            bankValueList.add(bankCardList.get(i).getName());
                        }
                        bankOptions = new OptionsPickerView(mActivity);
                        bankOptions.setPicker(bankValueList);
                        bankOptions.setTitle("选择银行");
                        bankOptions.setCyclic(false);
                        bankOptions.setSelectOptions(0);
                        bankOptions.setOnoptionsSelectListener(new OptionsPickerView.OnOptionsSelectListener() {
                            @Override
                            public void onOptionsSelect(int options1, int option2, int options3) {
                                bankId = bankIdList.get(options1) + "";
                                bankName = bankNameList.get(options1);
                                tvChooseBank.setText(bankValueList.get(options1));
                            }
                        });
                    }
                });
    }

    /**
     * 获取省
     */
    private void getProvince() {
        application.apiService.getProvinceList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Province>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Province province) {
                        provinceName.clear();
                        provinceId.clear();
                        provinceList.clear();
                        provinceList.addAll(province.getProvince());
                        for (int i = 0; i < provinceList.size(); i++) {
                            provinceName.add(provinceList.get(i).getName());
                            provinceId.add(provinceList.get(i).getId() + "");
                        }
                        provinceOptions.setPicker(provinceName);
                        provinceOptions.setTitle("选择省");
                        provinceOptions.setCyclic(false);
                        provinceOptions.setSelectOptions(0);
                        provinceOptions.setOnoptionsSelectListener(new OptionsPickerView.OnOptionsSelectListener() {
                            @Override
                            public void onOptionsSelect(int options1, int option2, int options3) {
                                etCity.setVisibility(View.VISIBLE);
                                etProvince.setText(provinceName.get(options1));
                                provinceNID = provinceId.get(options1);
                                getCity(provinceNID);
                            }
                        });
                    }
                });
    }

    /**
     * 选择城市
     *
     * @param id
     */
    private void getCity(String id) {

        application.apiService.getCityList(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<City>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(City city) {
                        cityName.clear();
                        cityNIDs.clear();
                        cityList.clear();
                        cityList.addAll(city.getCity());
                        for (int i = 0; i < cityList.size(); i++) {
                            cityName.add(cityList.get(i).getName());
                            cityNIDs.add(cityList.get(i).getId() + "");
                        }
                        cityOptions.setPicker(cityName);
                        cityOptions.setTitle("选择市");
                        cityOptions.setCyclic(false);
                        cityOptions.setSelectOptions(0);
                        //etCity.setText(cityName.get(0));
                        cityNID = cityNIDs.get(0);
                        cityOptions.setOnoptionsSelectListener(new OptionsPickerView.OnOptionsSelectListener() {
                            @Override
                            public void onOptionsSelect(int options1, int option2, int options3) {
                                etCountry.setVisibility(View.VISIBLE);
                                etCity.setText(cityName.get(options1));
                                cityNID = cityNIDs.get(options1);
                                getCounty(cityNID);
                            }
                        });
                    }
                });
    }

    /**
     * 选择区
     *
     * @param id
     */
    private void getCounty(String id) {

        application.apiService.getCountryList(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Country>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Country country) {
                        countryName.clear();
                        countryNIDs.clear();
                        countryList.clear();
                        countryList.addAll(country.getArea());
                        for (int i = 0; i < countryList.size(); i++) {
                            countryName.add(countryList.get(i).getName());
                            countryNIDs.add(countryList.get(i).getId() + "");
                        }
                        //etCountry.setText(countryName.get(0));
                        countryNID = countryNIDs.get(0);
                        countryOptions.setPicker(countryName);
                        countryOptions.setTitle("选择区");
                        countryOptions.setCyclic(false);
                        countryOptions.setSelectOptions(0);
                        countryOptions.setOnoptionsSelectListener(new OptionsPickerView.OnOptionsSelectListener() {
                            @Override
                            public void onOptionsSelect(int options1, int option2, int options3) {
                                etCountry.setText(countryName.get(options1));
                                countryNID = countryNIDs.get(options1);
                            }
                        });
                    }
                });
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_bind_card;
    }

    @Override
    public Activity bindActivity() {
        return this;
    }


    @OnClick({R.id.ll_choose_bank, R.id.btn_submit, R.id.et_province, R.id.et_city, R.id.et_country})
    public void onClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_choose_bank://选择银行卡按钮
                if (SoftInputUtil.isOpen(mActivity)) {
                    SoftInputUtil.closeSoftInput(mActivity, tvChooseBank);
                }
                bankOptions.show();
                break;
            case R.id.et_province:
                if (SoftInputUtil.isOpen(mActivity)) {
                    SoftInputUtil.closeSoftInput(mActivity, etProvince);
                }
                provinceOptions.show();
                break;
            case R.id.et_city:
                if (provinceNID.equals("")){
                    ToastUtil.showToast(mActivity,"请先选择省");
                    return;
                }else{
                    if (SoftInputUtil.isOpen(mActivity)) {
                        SoftInputUtil.closeSoftInput(mActivity, etCity);

                    }
                    cityOptions.show();
                }
                break;
            case R.id.et_country:
                if (cityNID==""){
                    ToastUtil.showToast(mActivity,"请先选择市");
                    return;
                }else{
                    if (SoftInputUtil.isOpen(mActivity)) {
                        SoftInputUtil.closeSoftInput(mActivity, etCountry);
                    }
                    countryOptions.show();
                }

                break;
            case R.id.btn_submit://审核按钮
                bindCard();
                break;
        }
    }


}
