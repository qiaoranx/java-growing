package com.company;

public class CircleLinkedList {
    public static void main(String[] args) {
        Cll c=new Cll();
        Node n1=new Node(1);
        Node n2=new Node(2);
        Node n3=new Node(3);
        Node n4=new Node(4);
        Node n5=new Node(5);


//        c.add(n1);
        c.add(n2);
        c.add(n3);
        c.add(n4);
        c.add(n5);
        c.show();
        System.out.println("======================");
        c.out(0,2);

    }
}

class Cll{
    Node first;

    public Cll(Node first) {
        this.first = first;
        first.next=this.first;
    }

    public Cll() {
        this.first = new Node();
        first.next=first;
    }

    /**
     * add添加到末端
     */
    public void add(Node node){
        Node temp=first;
        while(temp.next!=first){
            temp=temp.next;
        }
        temp.next=node;
        node.next=first;
    }

    /**
     * 遍历
     */

    public void show(){
        Node temp=first;
        while(temp.next!=first){
            System.out.println(temp.no);
            temp=temp.next;
        }
        System.out.println(temp.no);
    }

    /**
     * out of queue
     */
    public void out(int n,int m){
        Node temp=first;
        for (int i = 0; i <n ; i++) {
            temp=temp.next;
        }
        if(m==1){
            while (temp.next!=first){
                System.out.println(temp.no);
                temp=temp.next;
            }
            System.out.println(temp .no);
            return;
        }
        while (temp.next!=temp){
            for (int i = 1; i <m-1; i++) {
                temp=temp.next;
            }
            System.out.println(temp.next.no);
            temp.next=temp.next.next;
            temp=temp.next;
        }
        System.out.println(temp.no);

    }
}

class Node{
    public  int no;
    public Node next;

    public Node(int no) {
        this.no = no;

    }

    public Node() {

    }


    @Override
    public String toString() {
        return "HeroNode [no="+no+"]";
    }
}


