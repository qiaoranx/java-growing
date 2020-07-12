package com.company;


import java.util.Stack;

public class SingleLinkedList {
    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "林冲", "豹子头");
        HeroNode hero4 = new HeroNode(4, "宋江", "及时雨");
        HeroNode hero5 = new HeroNode(5, "卢俊义", "玉麒麟");
        HeroNode hero6 = new HeroNode(6, "林冲", "豹子头");

        SingleLl sl1=new SingleLl();
        sl1.addByOrder(hero1);
        sl1.addByOrder(hero3);
        sl1.addByOrder(hero2);
        sl1.show();
        System.out.println("==================S1=====================");
       SingleLl sl2=new SingleLl();
        sl2.addByOrder(hero4);
        sl2.addByOrder(hero5);
        sl2.addByOrder(hero6);
        sl2.show();
        System.out.println("==================S2====================");
        HeroNode zipHead=SingleLl.zipLl(sl1.getHead(),sl2.getHead(),2,3);
        SingleLl zip=new SingleLl(zipHead);
        zip.show();
        System.out.println("==================ZIP=====================");






    }
}

/**
 * 该链表结构的顺序是添加元素的顺序，怎样能够实现按照节点编号的顺序存储？
 */

//定义单向链表
class SingleLl {
    public SingleLl() {
        head = new HeroNode(0, "", "");
    }

    public SingleLl(HeroNode head) {
        this.head = head;
    }

    private HeroNode head;

    public HeroNode getHead() {
        return this.head;
    }

    /**
     * 向链表添加数据
     *
     * @param heroNode
     */
    public void add(HeroNode heroNode) {
        HeroNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = heroNode;
    }

    /**
     * 按照编号顺序添加
     *
     * @param heroNode
     */
    public void addByOrder(HeroNode heroNode) {
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no > heroNode.no) {
                break;
            } else if (temp.next.no == heroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.println("英雄编号+" + heroNode.no + "已经存在");
        } else {
            heroNode.next = temp.next;
            temp.next = heroNode;
        }

    }

    /**
     * 按照编号修改英雄name
     *
     * @param heroNode
     */
    public void modifyByNo(HeroNode heroNode) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;
        boolean flag = true;
        while (flag && temp != null) {
            if (temp.no == heroNode.no) {
                flag = false;
                temp.name = heroNode.name;
                temp.nickname = heroNode.nickname;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.println("没有找到编号为" + heroNode.no + "的英雄");
        }
    }

    /**
     * 删除指定编号的元素
     *
     * @param no
     */
    public void delete(int no) {

        HeroNode temp = head;
        boolean flag = true;
        while (temp.next != null && flag) {
            if (temp.next.no == no) {
                flag = false;
                temp.next = temp.next.next;

            }
            temp = temp.next;

            //解决空指针异常
            if (temp == null) {
                break;
            }
        }
        if (flag) {
            System.out.println("不存在编号为" + no + "英雄");
        }
        if (head.next == null) {
            System.out.println("链表已空");
        }
    }

    /**
     * 遍历链表
     */
    public void show() {
        if (head.next == null) {
            System.out.println("链表为空");
        }
        HeroNode temp = head;
        while (temp.next != null) {
            if (temp.no == 0) {
                System.out.println("HeroNode head [no=0]");
            } else {
                System.out.println(temp);
            }
            temp = temp.next;
        }
        System.out.println(temp);
    }

    /**
     * 不统计链表头结点
     *
     * @param head
     * @return
     */
    public int getLength(HeroNode head) {
        if (head.next == null) {
            return 0;
        }
        HeroNode temp = head;
        int length = 0;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }

    //新浪链表面试题
    //获得倒数第k个节点
    //先遍历链表获得链表有效节点数
    //再借助指向第一个有效节点的辅助变量遍历size-k次，获得的就是所求节点


    //腾讯面试
    //反转链表
    public static void reverseLl(HeroNode head) {
        if (head.next == null || head.next.next == null) {
            return;
        }
        //定义辅助变量来遍历原来的链表
        HeroNode cur = head.next;
        HeroNode next = null;//指向当前节点的下一节点
        HeroNode reverseHead = new HeroNode(0, "", "");
        while (cur != null) {
            next = cur.next;
            cur.next = reverseHead.next;
            reverseHead.next = cur;
            cur = next;
        }
        head.next = reverseHead.next;
    }

    //百度面试
    //逆序打印单向链表
    //方式一：将链表反转
    //方式二：应用栈的结构
    public static void reversePrint(HeroNode head) {
        new Stack<HeroNode>();
    }

    //练习将两个有序的链表合并为一个有序的新链表
    //升序
    public static HeroNode zipLl(HeroNode head1, HeroNode head2,int l1,int l2) {
        HeroNode cur1 = head1.next;
        HeroNode cur2 = head2.next;
        HeroNode next1 = null; //指向当前节点的下一节点
        HeroNode next2 = null; //指向当前节点的下一节点

        HeroNode newHead = new HeroNode(0, "", "");
        //第一种情况其中一个链表为空
        if(head1.next==null){
            return head2;
        }else if(head2.next==null){
            return head1;
        }
        //第二种情况链表不等长
        while (cur2 != null&&cur1!=null) {
            if (cur1.no < cur2.no) {
                next1 = cur1.next;
                cur1.next = newHead.next;
                newHead.next = cur1;
                cur1 = next1;
            } else {
                next2 = cur2.next;
                cur2.next = newHead.next;
                newHead.next = cur2;
                cur2 = next2;
            }
        }
        if(l1<l2){
            while(cur2!=null){
                next2 = cur2.next;
                cur2.next = newHead.next;
                newHead.next = cur2;
                cur2 = next2;
            }
        }else if(l1>l2){
            while(cur1!=null){
                next1 = cur1.next;
                cur1.next = newHead.next;
                newHead.next = cur1;
                cur1 = next1;
            }
        }else{
            if(cur1==null){
                cur2.next = newHead.next;
                newHead.next = cur2;
            }else{
                cur1.next = newHead.next;
                newHead.next = cur1;
            }
        }
        return newHead;
    }
}


//定义HeroNode节点对象
class HeroNode{
    public  int no;
    public String name;
    public String nickname;
    public HeroNode next;

    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;

    }


    //this关键字区分局部变量和实例变量
    //super关键字区分父类和子类的变量
    @Override
    public String toString() {
        return "HeroNode [no="+no+",name="+name+",nickname="+nickname+"]";
    }
}






