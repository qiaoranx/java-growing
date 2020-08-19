package com.company.sort;

import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        //
        int[] arr={53,3,542,748,14,214};
        radix(arr);
    }

    public static void radix(int[] arr){
        int[][] bucket=new int[10][arr.length];
        //定义一个一维数组存放每个桶中有效存放的数据个数
        int[] bucketCounts=new int[10];
        //先选出最大的数
        int m=1;
        int max=arr[0];
        while (m<arr.length){
            if(max<arr[m]){
                max=arr[m];
            }
            m++;
        }
        int times=(max+"").length();
        for (int j = 0; j <=times ; j++) {
            for (int i = 0; i <arr.length ; i++) {
                //取出个位
                int digit=(int)(arr[i]/Math.pow(10,j+0.0))%10;
                bucket[digit][bucketCounts[digit]]=arr[i];
                bucketCounts[digit]++;
            }
            //数据从桶里取出来
            int l=0;
            for (int i = 0; i <bucketCounts.length ; i++) {
                if(bucketCounts[i]==0){
                    continue;
                }
                for (int k = 0; k <bucketCounts[i]; k++) {
                    arr[l]=  bucket[i][k];
                    l++;
                }
                //
                bucketCounts[i]=0;
            }
            System.out.println(Arrays.toString(arr));
        }
    }
}
