package com.company;

public class Maze {
    public static void main(String[] args) {
        //地图
        int[][] map=new int[3][5];
        for (int i = 0; i <5 ; i++) {
            map[0][i]=1;
            map[2][i]=1;
        }
        for (int i = 0; i <3 ; i++) {
            map[i][0]=1;
            map[i][4]=1;
        }
        //地图初始化
        for (int i = 0; i <3 ; i++) {
            for (int j = 0; j <5 ; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
        //设置起点
        int i=1;
        int j=1;
        //设置终点
        int k=1;
        int l=3;
        road(map,i,j);
        System.out.println("======================================");
        //走过的路径
        for (int m = 0; m <3 ; m++) {
            for (int n = 0; n <5 ; n++) {
                System.out.print(map[m][n]+" ");
            }
            System.out.println();
        }

    }

    //0未走过，1墙，2走过能走通，3走过未走通
    //走迷宫策略：下->右->上->左
    public static boolean road(int[][] map,int i,int j){
        if(map[1][3]==2){
            return true;
        }else{
            if(map[i][j]==0){
                //假设可以走通
                map[i][j]=2;
                if(road(map,i+1,j)){
                    return true;
                }else if(road(map,i-1,j)){
                    return true;
                }else if(road(map,i,j-1)){
                    return true;
                }else if(road(map,i,j+1)){
                    return true;
                }else{
                    map[i][j]=3;
                    return false;
                }
            }else {
                return false;
            }
        }
    }
}
