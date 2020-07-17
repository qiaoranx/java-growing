package com.company;

public class Stack {
    public static void main(String[] args) {
//        ArrayStack as = new ArrayStack(3);
//        for (int i = 1; i < 4; i++) {
//            as.add(i);
//        }
//        as.out();
//        as.out();
//        as.out();
//        for (int i = 1; i < 4; i++) {
//            as.add(i * 10);
//        }
//        as.out();
//        as.out();
//        as.out();

            calculate("30+2*6-2");

            //遍历一个字符串的方法
        //定义一个index循环变量。
        //string.substring(index,index+1).charAt(0);
        //入数栈时，要考虑多位数的情况，遇到符号才入栈
    }

    public static void calculate(String s) {
        ArrayStack as=new ArrayStack(10);
        CharStack cs=new CharStack(10);
        char[] c= s.toCharArray();
        for (char c1 : c) {
            char temp=0;
            if(!cs.isEmpty()){
                temp=cs.out();
                cs.add(temp);
            }

            if (c1=='+'||c1=='-'||c1=='*'||c1=='/'){
                if(cs.isEmpty()){
                    cs.add(c1);
                }else if (c1<43||c1>45){
                       cs.add(c1);
                    } else if(temp<43||temp>45){
                    int t1=as.out();
                    int t2=as.out();
                    int res=0;
                    cs.out();
                    if(temp=='*'){
                         res=t1*t2;
                    }else{
                         res=t2/t1;
                    }
                    cs.add(c1);
                    as.add(res);
                }else{
                    cs.add(c1);
                }
            }else{
                
                as.add(c1-48);
            }
        }

//        System.out.println(as.out());
//        System.out.println(as.out());
//        System.out.println(as.out());
//        System.out.println(cs.out());
//        System.out.println(cs.out());

        int res=0;
        while (!cs.isEmpty()){

            int  t1=as.out();
            int  t2=as.out();
            char t3= cs.out();

            if(t3=='+'){
                res=t1+t2;
            }else {
                res=t2-t1;
            }
            as.add(res);
        }
        System.out.println(res);

    }
}

class ArrayStack{
    int[] stack;
    int maxsize;
    int top=-1;

    public ArrayStack(int size) {
        this.maxsize = size;
        stack=new int[this.maxsize];
    }

    public boolean isEmpty(){
        return top==-1;
    }

    public boolean isFull(){
        return top==maxsize-1;
    }

    /**
     * add
     * @param num
     */
    public void add(int num){

        if(!isFull()){
            stack[top+1]=num;
            top++;
        }else{
            System.out.println("栈满");
        }
    }

    public int out(){
        if(isEmpty()){
            throw new RuntimeException("栈空");
        }else{
            int temp=stack[top];
            top--;
            return temp;
        }
    }

    /**
     * 扩展一个比较运算符优先级的方法
     */

    //字符可以直接和int比较，char的底层也是int
    public int priority(int oper){
        if(oper=='*'||oper=='/'){
            return 1;
        }else if(oper=='+'||oper=='-'){
            return 0;
        }else{
            return -1;
        }
    }

    //判断是否为运算符
    public boolean isOper(char val){
        return val=='+'||val=='-'||val=='*'||val=='/';
    }

    //计算方法
    public int cal(int num1,int num2,char oper){
        int res=0;
        switch (oper){
            case '+':
                res=num1+num2;
                break;
            case '-':
                res=num2-num1;
                break;
            case '*':
                res=num1*num2;
                break;
            case '/':
                res=num2/num1;
                break;
        }
        return res;

    }
}

class CharStack{
    char[] stack;
    int maxsize;
    int top=-1;

    public CharStack(int size) {
        this.maxsize = size;
        stack=new char[this.maxsize];
    }

    public boolean isEmpty(){
        return top==-1;
    }

    public boolean isFull(){
        return top==maxsize-1;
    }

    /**
     * add
     * @param oper
     */
    public void add(char oper){

        if(!isFull()){
            stack[top+1]=oper;
            top++;
        }else{
            System.out.println("栈满");
        }
    }

    public char out(){
        if(isEmpty()){
            throw new RuntimeException("栈空");
        }else{
            char temp=stack[top];
            top--;
            return temp;
        }
    }

}
