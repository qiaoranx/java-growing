package com.company.sort;

import java.lang.reflect.Array;
import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] arr={22,3,10,7,11};
        int[] newArr=  insertBack(arr);
        for (int i : newArr) {
            System.out.print(i+" ");
        }
    }

    public static int[] insertBack(int[] arr){
        int count=0;
        //循环要插入的数据，从第二个开始，第一个默认在一个有序数组中
        for (int i = 1; i <arr.length ; i++) {
            count++;
            int num=arr[i];
            //下标从有序数组的最后一个开始，即要插入的元素前一个元素
            int index=i-1;
            while (index>=0&&arr[index]>num){
                count++;
                arr[index+1]=arr[index];
                index--;
            }
            if(index+1!=i){
                arr[index+1]=num;
            }

            System.out.println(Arrays.toString(arr));
        }
        System.out.println(count);
        return arr;
    }

    public static int[] insert(int[] arr){
        int[] newArr=new int[arr.length];
        newArr[0]=arr[0];
        for (int i = 1; i <arr.length ; i++) {
            boolean flag=true;
            for (int j = 0; j <i ; j++) {
                if(arr[i]<newArr[j]){
                    insertArr(j,i-1,newArr);
                    newArr[j]= arr[i];
                    flag=false;
                    break;
                }
            }
            if(flag){
                newArr[i]=arr[i];
            }
        }
        return newArr;
    }

    public static void insertArr(int start,int end,int[] newArr){
        for (int j = end; j >=start ; j--) {
            newArr[j+1]=newArr[j];
        }
    }

}
