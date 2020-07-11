package com.company;



public class SingleLinkedList {
    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "林冲", "豹子头");

//        SingleLl sl=new SingleLl();
//        sl.add(hero1);
//        sl.add(hero2);
//        sl.add(hero3);
//        sl.show();

        SingleLl sl1=new SingleLl();
        sl1.addByOrder(hero1);
        sl1.addByOrder(hero3);
        sl1.addByOrder(hero2);
        sl1.show();
        //sl1.modifyByNo(new HeroNode(2,"修改后的名字","玉麒麟"));
        //sl1.show();
       // sl1.modifyByNo(new HeroNode(9,"没有编号","测试"));
        sl1.delete(1);
        sl1.delete(1);
        sl1.delete(3);
        sl1.show();
        sl1.delete(2);



    }
}

/**
 * 该链表结构的顺序是添加元素的顺序，怎样能够实现按照节点编号的顺序存储？
 */

//定义单向链表
class SingleLl{
    public SingleLl() {
        head=new HeroNode(0,"","");
    }
    private HeroNode head;

    /**
     * 向链表添加数据
     * @param heroNode
     */
    public void add(HeroNode heroNode){
        HeroNode temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=heroNode;
    }

    /**
     * 按照编号顺序添加
     * @param heroNode
     */
    public void addByOrder(HeroNode heroNode){
        HeroNode temp=head;
        boolean flag=false;
        while(true){
            if (temp.next==null){
                break;
            }
            if(temp.next.no>heroNode.no){
                break;
            }else if(temp.next.no==heroNode.no){
                flag= true;
                break;
            }
            temp=temp.next;
        }
        if (flag){
            System.out.println("英雄编号+"+heroNode.no+"已经存在");
        }else{
            heroNode.next=temp.next;
            temp.next=heroNode;
        }

    }

    /**
     * 按照编号修改英雄name
     * @param heroNode
     */
    public void modifyByNo(HeroNode heroNode){
        if (head.next==null){
            System.out.println("链表为空");
            return;
        }
        HeroNode temp=head.next;
        boolean flag=true;
        while (flag&&temp!=null) {
            if (temp.no == heroNode.no) {
                flag=false;
                temp.name = heroNode.name;
                temp.nickname = heroNode.nickname;
            }
            temp = temp.next;
        }
        if (flag){
            System.out.println("没有找到编号为"+heroNode.no+"的英雄");
        }
    }


    public void delete(int no){

        HeroNode temp=head;
        boolean flag=true;
        while (temp.next!=null&&flag){
            if (temp.next.no==no){
                flag=false;
                temp.next=temp.next.next;

            }
                temp=temp.next;

            //解决空指针异常
            if (temp==null){
             break;
            }
        }
        if(flag){
            System.out.println("不存在编号为"+no+"英雄");
        }
        if(head.next==null){
            System.out.println("链表已空");
        }
    }
    /**
     * 遍历链表
     */
    public void show(){
        if (head.next==null){
            System.out.println("链表为空");
        }
        HeroNode temp=head;
        while(temp.next!=null){
            if (temp.no==0){
                System.out.println("HeroNode head [no=0]");
            }else{
                System.out.println(temp);
            }
            temp=temp.next;
        }
        System.out.println(temp);
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






