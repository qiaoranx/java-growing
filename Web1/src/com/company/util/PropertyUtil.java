package com.company.util;

import java.util.ResourceBundle;

public class PropertyUtil {
    private PropertyUtil(){

    }
   private static ResourceBundle bundle=ResourceBundle.getBundle("conf");
    public static String proUtil(String key){
      return bundle.getString(key);
    }

}
