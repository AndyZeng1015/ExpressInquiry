package com.zyn.expressinquiry.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Desc:
 * CreateDate: 2017/7/4 16:42
 * Author: Created by ZengYinan
 * Email: 498338021@qq.com
 */

public class DateUtils {

    /**
     * 返回格式如 yyyyMMddHHmmss 的日期数据
     * @return
     */
    public static String getTimestamp(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = new Date();
        return sdf.format(date);
    }
}
