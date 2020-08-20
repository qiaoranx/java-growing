package com.company.hashtable;


public class HashTableDemo {
    public static void main(String[] args) {
        HashTable ht=new HashTable(7);
        Employee emp0=new Employee(1,"zs");
        Employee emp1=new Employee(2,"ls");
        Employee emp2=new Employee(3,"ww");
        Employee emp3=new Employee(4,"zl");
        ht.add(emp0);
        ht.add(emp1);
        ht.add(emp2);
        ht.add(emp3);
        ht.show();
        System.out.println("===============================");
        System.out.println(ht.query(3)==null?"没有该员工":ht.query(3).name);
    }
}
class HashTable{
    public EmpLinkedList[] empArr;
    private int size;

    public HashTable(int size) {
        this.size=size;
        empArr=new EmpLinkedList[size];
        for (int i = 0; i <size ; i++) {
            empArr[i]=new EmpLinkedList();
        }

    }

    public Employee query(int id){
        int num=hash(id);
        Employee emp= empArr[num].query(id);
        return emp;
    }

    public void add(Employee emp){
        int num=hash(emp.id);
        empArr[num].add(emp);
    }

    public void show(){
        for (int i = 0; i <size ; i++) {
            empArr[i].show(i);
        }
    }

    //编写散列函数，如取模法
    private int hash(int id){
        return id%size;
    }
}

class Employee{
    public int id;
    public String name;
    public Employee next;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

class EmpLinkedList{
    public Employee head;

    //添加雇员到链表
    public void add(Employee emp){
        if(head==null){
            head=emp;
            return;
        }
        Employee temp=head;
        while (true){
            if(temp.next==null){
                break;
            }
            temp.next=temp;
        }
        temp.next=emp;
    }

    //遍历链表的雇员信息
    public void show(int no){
        if(head==null){
            System.out.println("第"+no+"条链表为空");
            return;
        }
        Employee temp=head;
        while (true){
            System.out.println("第"+no+"条链表为： "+temp.id+";"+temp.name);
            if(temp.next==null){
                break;
            }
            temp.next=temp;
        }
    }

    //查找
    public Employee query(int id){
        while (true){
            if(head==null){
                break;
            }
            Employee temp=head;
            //
            if(temp.id==id){
                return temp;
            }
            //
            if(temp.next==null){
                break;
            }

            temp.next=temp;
        }
        return null;
    }
}