package com.company.sort;

public class SelectSort {
    public static void main(String[] args) {
        int[] arr={22,3,10,7,11};
        select(arr);
        for (int i : arr) {
            System.out.print(i+" ");
        }
    }
    //时间复杂度n2
    //但是执行时间选择排序比冒泡排序快
    public static void select(int[] arr){
        //比较的轮次
        int count=0;
        for (int i = 0; i <arr.length-1 ; i++) {
            int minIndex=i;
            int min=arr[i];
            boolean flag=false;
            for (int j = i+1; j <arr.length; j++) {
                if(min>arr[j]){
                    flag=true;
                    min=arr[j];
                    minIndex=j;
                    count++;
                }
            }
            if(flag){
                arr[minIndex]=arr[i];
                arr[i]=min;
                count++;
            }
        }
        System.out.println(count);
    }
}
