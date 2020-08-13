package com.company;



public class Queen {
    //一维数组存储八皇后位置，arr[i]=val,表示第i+1个皇后（放在第i+1行）放在第val+1列
    int max=8;
    int[] arr=new int[max];
    public static void main(String[] args) {
        Queen q=new Queen();
        q.put(0);


    }
    //下棋
    public void put(int n){
        //八个皇后已经摆好
        if(n==max){
            System.out.println(print(arr));
            return;
        }
        //循环的是列数
        for (int i = 0; i <max ; i++) {
            arr[n]=i;
            if(check(n)){
                //不冲突，递归
                put(n+1);
            }
            //冲突就继续进行for循环，第n个皇后放在下一列
        }

    }
    //检查第n个皇后和前面的是否冲突
    public  boolean check(int n){
        for (int i = 0; i <n ; i++) {
            //判断是否在同一列或者对角线
            if(arr[i]==arr[n]||Math.abs(n-i)==Math.abs(arr[n]-arr[i])){
                return false;
            }
        }
        return true;
    }
    //打印一种摆法的结果
    public static String print(int[] arr){
        String str="";
        for (int i : arr) {
            str+=i+" ";
        }
        return str;
    }
}
