package com.dql.g150t.fyhs.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by hwg on 2017/4/1.
 */

public class TimeTypeChangeUtils {

    /**
     * string转换成date类型
     */
    public Date stringToDate(String time){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd") ;
        Date date = null ;
        try {
            date = sdf.parse(time) ;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date ;
    }

    /**
     * date转换成long
     * @param date
     * @return
     */
    public long dateToLong(Date date){

        long time = date.getTime() ;

        return time;
    }

    /**
     * date转换成string
     * @return
     */
    public String dateToString(Date date){
        String format = "yyyy-MM-dd" ;
        return new SimpleDateFormat(format).format(date) ;
    }

}
