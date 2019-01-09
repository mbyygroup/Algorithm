package com.mbyy.algoritum.common.recursion;

class StackX {
    public int maxSize;
    //    public Params[] stackArray;
    private int[] stackArray;
    private int top;

    public StackX(int s) {
        maxSize = s;
//        stackArray=new Params[maxSize];
        stackArray = new int[maxSize];
        top = -1;
    }

    //    public void push(Params p){
//        stackArray[++top]=p;
//    }
    public void push(int p) {
        stackArray[++top] = p;
    }
//    public Params pop(){
//        return stackArray[top--];
//    }
//    public Params peek(){
//        return stackArray[top];
//    }

    public int pop() {
        return stackArray[top--];
    }

    public int peek() {
        return stackArray[top];
    }

    public boolean isEmpty() {
        return (top == -1);
    }
}
