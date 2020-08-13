package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation {
    public static void main(String[] args) {
        String str="1+((   2+3.888 )*4.5)-5";
        List<String> lst=PolandNotation.toList(str);
        System.out.println(lst);
        List<String> calList=PolandNotation.convert(lst);
        System.out.println(calList);
        float res=cal(calList);
        System.out.println(res);
    }

    public static List<String>  getStringList(String str){
        String[] split=str.split(" ");
        List<String> lst=new ArrayList<>();
        for (String s : split) {
            lst.add(s);
        }
        return lst;
    }

    public static float cal(List<String> lst){
        Stack<String> stringStack = new Stack<>();
        for (String s : lst) {
            //"\\d+"正则表达式匹配的是多位数
            if(!s.matches("[0-9]*\\.?[0-9]+")){
                float num1=Float.parseFloat(stringStack.pop());
                float num2=Float.parseFloat(stringStack.pop());
                float res=0f;
                switch(s){
                    case "+":
                        res=num1+num2;
                        break;
                    case "-":
                        res=num2-num1;
                        break;
                    case "*":
                        res=num1*num2;
                        break;
                    case "/":
                        res=num2/num1;
                        break;

                }
                stringStack.push(res+"");
            }else{
                stringStack.push(s);
            }
        }
        return Float.parseFloat(stringStack.pop());
    }

    public static List<String> convert(List<String> lst){
        //s1是运算符栈
        Stack<String> s1=new Stack<>();
        List<String> s2=new ArrayList<>();
        for (String s : lst) {
            if(s.matches("[0-9]*\\.?[0-9]+")){
                s2.add(s);
            }else{
                if(s1.empty()||s1.peek().equals("(")||"(".equals(s)){
                    s1.push(s);
                }else if(")".equals(s)){
                    while (!"(".equals(s1.peek())){
                        s2.add(s1.pop());
                    }
                    s1.pop();
                }else{
                    while (!s1.empty()&&operator(s)<=operator(s1.peek())){
                         s2.add(s1.pop());
                    }
                    s1.push(s);
                }
            }
        }
        while (!s1.empty()){
            s2.add(s1.pop());
        }
        return s2;
    }

    public static int operator(String str){
        switch (str){
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
            case "(":
                return 0;
        }
        throw new RuntimeException("运算符不合法");
    }

    public static List<String> toList(String str){
        //去除空白字符
       String[] space=str.split("\\s+");
       String newStr="";
        for (String s : space) {
            newStr+=s;
        }
        //考虑小数点
        List<String> lst=new ArrayList<>();
        for (int i = 0; i <newStr.length() ;) {
            if(newStr.charAt(i)<48&&newStr.charAt(i)!=46||newStr.charAt(i)>57){
               lst.add(newStr.charAt(i)+"");
               i++;
            }else{
                String s="";
                while (i <newStr.length()&&newStr.charAt(i)>=48&&newStr.charAt(i)<=57||
                        i <newStr.length()&&newStr.charAt(i)==46){
                    s+=newStr.charAt(i);
                    i++;
                }
                lst.add(s);
            }
        }
        return lst;
    }
}
