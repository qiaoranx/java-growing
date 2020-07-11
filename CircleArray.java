package com.company;

import com.sun.corba.se.impl.resolver.SplitLocalResolverImpl;

import java.util.Scanner;

public class CircleArray {
    public static void main(String[] args) {
        boolean start=true;
        Circle aq=new Circle(3);
        while (start){
            System.out.println("请选择操作编号：");
            System.out.print("1 查看头数据   2 添加数据  3 取出数据 4 显示全部数据  5 退出");
            System.out.println();
            Scanner sc=new Scanner(System.in);
            switch(sc.nextInt()){
                case 1:
                    System.out.print("头数据为");
                    aq.headShow();
                    break;
                case 2:
                    System.out.println("请输入添加的数字");
                    aq.addQueue(sc.nextInt());
                    break;
                case 3:
                    try{
                        System.out.println("取出的数据为"+ aq.outQueue());
                    }
                    catch (RuntimeException e){
                        System.out.println(e.getMessage());
                    }

                    break;
                case 4:
                    aq.showAll();
                    break;
                case 5:
                    start=false;
                    break;
                default:
                    System.out.println("请输入正确的编号");
            }
        }
        System.out.println("程序已退出");

    }
}

class Circle{
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public Circle(int maxSize) {
        this.maxSize = maxSize;
        //front指向队列第一个元素
        // rear指向队列最后一个元素的后一个位置
        this.front = 0;
        this.rear = 0;
        this.arr = new int[maxSize];
    }
    public boolean idFull(){
        return (rear+1)%maxSize==front;
    }

    public boolean isEmpty(){
        return rear==front;
    }

    public void addQueue(int n){
        if (idFull()){
            System.out.println("队列已满");
            return;
        }
        arr[rear]=n;
        rear=(rear+1)%maxSize;
    }

    public int outQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列为空");
        }
        int val=arr[front];
        front=(front+1)%maxSize;
        return val;
    }

    public void showAll(){
        if (isEmpty()){
            System.out.println("队列为空");
            return;
        }
        for (int i = front; i <front+getSize() ; i++) {
            System.out.println(arr[i%maxSize]);
        }
    }

    private int getSize(){
        return (rear+maxSize-front)%maxSize;
    }

    public void headShow(){
        if (isEmpty()){
            System.out.println("队列为空");
            return;
        }
        System.out.println(arr[front]);
    }


}
