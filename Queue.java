package com.company;

import java.util.Scanner;

/**
 * 数组存储队列存在的问题：数组不能复用
 * 解决方法：
 * front和rear作出调整
 * front指向队列第一个元素
 * rear指向队列最后一个元素的后一个位置
 * 队列为空的条件 rear=front
 * 队列已满的条件 (rear+1)%maxSize=front
 * 队列有效数据个数（rear+maxSize-front）%maxSize
 */
public class Queue {
    public static void main(String[] args) {
        boolean start=true;
        ArrayQueue aq=new ArrayQueue(3);
        while (start){
            System.out.println("请选择操作编号：");
            System.out.print("1 查看头数据   2 添加数据  3 取出数据  4 退出");
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
                    start=false;
                    break;
                default:
                    System.out.println("请输入正确的编号");
            }
        }
        System.out.println("程序已退出");

    }
}

class ArrayQueue{
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        this.front = -1;//指向第一个元素之前
        this.rear = -1;//指向最后一个元素
        this.arr = new int[maxSize];
    }

    public boolean idFull(){
        return rear==maxSize-1;
    }

    public boolean isEmpty(){
        return rear==front;
    }

    public void addQueue(int n){
        if (idFull()){
            System.out.println("队列已满");
            return;
        }
        rear++;
        arr[rear]=n;
    }

    public int outQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列为空");
        }
        front++;
        return arr[front];
    }

    public void showAll(){
        if (isEmpty()){
            System.out.println("队列为空");
            return;
        }
        for (int i = 0; i <arr.length ; i++) {
            System.out.println(arr[i]);
        }
    }

    public void headShow(){
        if (isEmpty()){
            System.out.println("队列为空");
            return;
        }
        System.out.println(arr[front+1]);
    }
}
