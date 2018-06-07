package com.jarvan.dagger2demo.util;

import android.text.TextUtils;

/**
 * 创建日期：2018/6/7 on 上午10:54
 * 描述: 空值处理工具
 * 作者:张冰
 */
public class EmptyUtils {
    public static String checkString(String s){
        return TextUtils.isEmpty(s)?"":s;
    }

    public static long checkS2Long(String s){
        try {
            return Long.parseLong(s);
        }catch (Exception e){}
        return 0;
    }

}
