package com.company.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class PropertyUtil {
    private PropertyUtil(){

    }
    private static ResourceBundle bundle=ResourceBundle.getBundle("conf");
    public static String proUtil(String key){
      return bundle.getString(key);
    }

    public static String timeUtil(String pattern){
        SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间
        sdf.applyPattern(pattern);
      return sdf.format(new Date());
    }

}
