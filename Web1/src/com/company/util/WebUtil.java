package com.company.util;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Enumeration;

public class WebUtil {
    public static void makeRequestToObject(HttpServletRequest request,Object obj){
           Class c=obj.getClass();
          Enumeration fieldNames= request.getParameterNames();
          while (fieldNames.hasMoreElements()){
              String fieldname=(String) fieldNames.nextElement();
              String methodName="set"+fieldname.toUpperCase().charAt(0)+fieldname.substring(1);
              try {
                  Method setMethod=c.getMethod(methodName,String.class);
                  setMethod.invoke(obj,request.getParameter(fieldname));
                  setMethod.invoke(obj,request.getParameter(fieldname));
              } catch (Exception e) {
                  e.printStackTrace();
              }
          }
    }
}
