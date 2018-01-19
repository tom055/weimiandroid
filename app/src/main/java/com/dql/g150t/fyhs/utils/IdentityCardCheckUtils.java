package com.dql.g150t.fyhs.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 验证身份证号是否合理
 * Created by hwg on 2017/3/29.
 */

public class IdentityCardCheckUtils {

    /**
     * 输入15位或18位的身份证号都可以
     * @param idCard
     * @return
     */
    public static boolean checkIdCard(String idCard){
        return checkFifteenIdCard(idCard) || checkEighteenIdCard(idCard) ;
    }


    /**
     * 15位身份证号
     * @param idCard
     * @return
     */
    public static boolean checkFifteenIdCard(String idCard){
        String s = "^[1-9]\\d{5}\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{2}$" ;
        Pattern p = Pattern.compile(s) ;
        Matcher m = p.matcher(idCard) ;
        return m.matches() ;
    }

    /**
     * 18位身份证号
     * @param idCard
     * @return
     */
    public static boolean checkEighteenIdCard(String idCard){
        String s = "^[1-9]\\d{5}(18|19|([23]\\d))\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$" ;
        Pattern p = Pattern.compile(s) ;
        Matcher m = p.matcher(idCard) ;
        return m.matches() ;
    }
}
