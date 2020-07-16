package com.company;

public class DoubleLinkedList {
    public static void main(String[] args) {
        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3, "林冲", "豹子头");
        HeroNode2 hero4 = new HeroNode2(4, "鲁智深", "豹子头");
        DoubleLl dl=new DoubleLl();
        dl.addBySequence(hero4);
        dl.addBySequence(hero1);
        dl.addBySequence(hero3);
        dl.addBySequence(hero2);
        dl.show();


    }
}

class DoubleLl {
    public DoubleLl() {
        head = new HeroNode2(0, "", "");
    }

    public DoubleLl(HeroNode2 head) {
        this.head = head;
    }

    private HeroNode2 head;

    public HeroNode2 getHead() {
        return this.head;
    }

    /**
     * 遍历链表
     */
    public void show() {
        if (head.next == null) {
            System.out.println("链表为空");
        }
        HeroNode2 temp = head;
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
     * 添加到最后
     * @param heroNode
     */
    public void add(HeroNode2 heroNode) {
        HeroNode2 temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = heroNode;
        heroNode.pre=temp;
    }

    /**
     * 按照编号顺序添加
     */
    public void addBySequence(HeroNode2 heroNode){
        HeroNode2 temp=head.next;
        boolean Flag=true;
        if(head.next==null){
            head.next=heroNode;
            heroNode.pre=head;
            return;
        }
        while(temp!=null){
            if (temp.no>heroNode.no&&Flag){
                    Flag=false;
                    temp.pre.next=heroNode;
                    heroNode.pre=temp.pre;
                    heroNode.next=temp;
                    temp.pre=heroNode;
            }
            temp=temp.next;
        }
    }
    /**
     * 修改链表
     * @param heroNode
     */
    public void modifyByNo(HeroNode2 heroNode) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode2 temp = head.next;
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
     * 删除
     * @param no
     */
    public void delete(int no) {

        HeroNode2 temp = head.next;
        if (head.next == null) {
            System.out.println("链表已空");
        }
        boolean flag = true;
        while (temp != null && flag) {
            if (temp.no == no) {
                flag = false;
                temp.pre.next=temp.next;
                //有空指针异常
                if(temp.next==null){
                    return;
                }
                temp.next.pre=temp.pre;

            }
            temp = temp.next;

            //解决空指针异常
//            if (temp == null) {
//                break;
//            }
        }
        if (flag) {
            System.out.println("不存在编号为" + no + "英雄");
        }

    }
}

class HeroNode2 {
    public int no;
    public String name;
    public String nickname;
    public HeroNode2 next;
    public HeroNode2 pre;

    public HeroNode2(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;

    }

    public String toString() {
        return "HeroNode [no="+no+",name="+name+",nickname="+nickname+"]";
    }
}