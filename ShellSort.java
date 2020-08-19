package com.company.sort;

import java.util.Arrays;

public class ShellSort {

    public static void main(String[] args) {
        //,5,4,6,0
        int[] arr={8,9,1,7,2,3};
        System.out.println("原始数据：");
        System.out.println(Arrays.toString(arr));
        sort2(arr);
    }
    public static void sort(int[] arr){
        boolean flag=true;
        int gap=arr.length;
        do{
            gap=gap/2;
            for (int i=gap; i <arr.length ; i++) {
                int temp=0;
                for (int j = i-gap; j >=0 ; j-=gap) {
                    if(gap==0){
                        return;
                    }
                    if(arr[j]>arr[j+gap]){
                        temp=arr[j];
                        arr[j]=arr[j+gap];
                        arr[j+gap]=temp;
                    }
                }
            }
            if(gap==0){
                flag=false;
            }
        }while (flag);
        //步长的概念

    }

    //移位希尔排序
    public static void sort2(int[] arr){
        boolean flag=true;
        int gap=arr.length;
        do{
            gap=gap/2;
            for (int i = gap; i <arr.length ; i++) {
                //直接插入排序
                int index=i;
                int num=arr[i];
                if(arr[i]<arr[i-gap]){
                    while (index-gap>=0&&num<arr[index-gap]){
                        arr[index]=arr[index-gap];
                        index-=gap;
                    }
                    arr[index]=num;
                    System.out.println(Arrays.toString(arr));
                }
            }
            if(gap==0){
                flag=false;
            }
        }while (flag);
    }

}
