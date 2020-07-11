package com.company;

public class SparseArray {
    public static void main(String[] args) {
        //创建一个二维数组
        //0表示没有棋子，1表示黑子，2表示白子
        int chessArr1[][]=new int[11][11];
        chessArr1[1][2]=1;
        chessArr1[2][3]=2;
        //将二维数组转化为稀疏数组
        int sum =0;
        for (int i = 0; i <chessArr1.length ; i++) {
            for (int j = 0; j <chessArr1[i].length ; j++) {
                if (chessArr1[i][j]!=0)
                    sum++;
            }
        }
        //创建稀疏数组
        int sparseArr[][]=new int[sum+1][3];
        sparseArr[0][0]=chessArr1.length;
        sparseArr[0][1]=chessArr1.length;
        sparseArr[0][2]=sum;

        //遍历二维数组给稀疏数组复制
        int count=0;
        for (int i = 0; i <chessArr1.length ; i++) {
            for (int j = 0; j <chessArr1[i].length ; j++) {
                if (chessArr1[i][j]!=0) {
                    count++;
                    sparseArr[count][0]=i;
                    sparseArr[count][1]=j;
                    sparseArr[count][2]=chessArr1[i][j];
                }
            }
        }

        //稀疏数组转化为二维数组
        int length1=sparseArr[0][0];
        int length2=sparseArr[0][1];
        int chessArr2[][]=new int[length1][length2];
        for (int i = 1; i <sparseArr.length ; i++) {
            chessArr2[sparseArr[i][0]][sparseArr[i][1]]=sparseArr[i][2];
        }

        //打印二维数组
        for (int i = 0; i <chessArr2.length ; i++) {
            for (int j = 0; j <chessArr2[i].length ; j++) {
                System.out.print(chessArr2[i][j]+"   ");
            }
            System.out.println();
        }

        //IO流把稀疏数组存储到文件
    }
}
