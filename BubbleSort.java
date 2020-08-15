package com.company.sort;
//冒泡排序的优化，如果发现某次排序中交换的次数为0就可以提前结束排序了
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr={22,3,10,7,11};
        bubble(arr);
        System.out.println("=================================");
        for (int i : arr) {
            System.out.print(i+" ");
        }
    }
    //时间复杂度n2
    public static void bubble(int[] arr){
        int temp=0;
        int count=0;
        for (int i = 0; i <arr.length-1 ; i++) {
            boolean flag=true;
            for (int j = 0; j <arr.length-i-1 ; j++) {
                if(arr[j]>arr[j+1]){
                    flag=false;
                    temp=arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j]=temp;
                    count++;
                }
            }

            if(flag){
                System.out.println(count);
                return;
            }

        }
        System.out.println(count);
    }
}
