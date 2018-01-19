package com.dql.g150t.fyhs.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by hwg on 2017/4/11.
 */

public class LoginPwdFormatUtils {

    /**
     * 登陆密码必须由字母和数字组成
     */
    public boolean checkLoginPwd(String loginPwd){
        Pattern p = Pattern.compile("[a-zA-Z0-9]{6,12}") ;
        Matcher m = p.matcher(loginPwd) ;

        return m.matches() ;
    }

}
