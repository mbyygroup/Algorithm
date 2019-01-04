package com.mbyy.algoritum.vo.Stack;

//栈的底层实现
public class StackX {
    private int maxSize;   //这里使用数组来实现栈，所以需要先规定大小，如果拿链表实现则不需要
//    private long[] stackArray;
    private char[] stackArray;
    private int top;

    public StackX(int size){
        maxSize=size;
        stackArray=new char[maxSize];
        top=-1;
    }

    //往栈内添加数据
    public void push(char j){
        if (isFull()==false)
            stackArray[++top]=j;
        else
            System.out.println("栈已满，无法继续添加");
    }

    //从栈内取数据
    public long pop(){
        return stackArray[top--];
    }

    //得到栈顶的值
    public long peek(){
        return stackArray[top];
    }

    //判断是否为空
    public boolean isEmpty(){
        return top==-1;
    }

    //判断栈是否满了
    public boolean isFull(){
        return top==maxSize-1;
    }

}
