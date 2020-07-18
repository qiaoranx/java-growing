package com.company;

public class Calculator {
    public static void main(String[] args) {
          String expression="300+2" ;
          CalStack numStack=new CalStack(10);
          CalStack operStack=new CalStack(10);
          int index=0;
          int num1=0;
          int num2=0;
          int oper=0;
          int res=0;
          char ch=0;
        String str="";
        while(true){
              ch=expression.substring(index,index+1).charAt(0);
              if(operStack.isOper(ch)){
                  if(!operStack.isEmpty()){
                      if(operStack.priority(ch)<=operStack.priority(operStack.peek())){
                          num1=numStack.out();
                          num2=numStack.out();
                          oper=operStack.out();
                          res=numStack.cal(num1,num2,oper);
                          numStack.add(res);
                          operStack.add(ch);
                      }else{
                          operStack.add(ch);
                      }
                  }else{
                        operStack.add(ch);
                  }
              }else{
                  str+=ch;
                  if(index==expression.length()-1){
                      numStack.add(Integer.parseInt(str));
                      str="";
                  }else{
                      if(operStack.isOper(expression.substring(index+1,index+2).charAt(0))){
                          numStack.add(Integer.parseInt(str));
                          str="";
                      }
                  }
              }
              index++;
              if(index>=expression.length()){
                  break;
              }
          }

          while (!operStack.isEmpty()){
              num1=numStack.out();
              num2=numStack.out();
              oper=operStack.out();
              res=numStack.cal(num1,num2,oper);
              numStack.add(res);
          }
        System.out.println(res);


    }
}

class CalStack{
    int[] stack;
    int maxsize;
    int top=-1;

    public CalStack(int size) {
        this.maxsize = size;
        stack=new int[this.maxsize];
    }

    public boolean isEmpty(){
        return top==-1;
    }

    public boolean isFull(){
        return top==maxsize-1;
    }

    public int peek(){
        return stack[top];
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
    public int cal(int num1,int num2,int oper){
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
