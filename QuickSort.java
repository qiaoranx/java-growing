package com.company.sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        //
        int[] arr={-9,78,0,23,-567,70};
        sort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));

    }
    public static void sort(int[] arr,int left,int right){
         int l=left;
         int r=right;
         int mid=arr[(l+r)/2];
         int temp=0;
         while (l<r){
             while (arr[l]<mid){
                 l++;
             }
             while (arr[r]>mid){
                 r--;
             }
             //左右都符合中值大小
             if(l>=r){
                 break;
             }
             //交换
             temp=arr[r];
             arr[r]=arr[l];
             arr[l]=temp;

             if(arr[l]==mid){
                 l++;
             }

             if(arr[r]==mid){
                r--;
             }
         }
//防止栈溢出
         if(l==r){
             l++;
             r--;
         }

         //左右递归
         if(left<r){
            sort(arr,left,r);
             System.out.println(arr);
         }

        if(l<right){
            sort(arr,l,right);
            System.out.println(arr);
        }
    }
}
