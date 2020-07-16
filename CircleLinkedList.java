package com.company;

public class CircleLinkedList {
    public static void main(String[] args) {
        Cll c=new Cll();
        Node n1=new Node(1);
        Node n2=new Node(2);
        Node n3=new Node(3);
        Node n4=new Node(4);

        c.add(n1);
        c.add(n2);
        c.add(n3);
        c.add(n4);
        c.show();

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


