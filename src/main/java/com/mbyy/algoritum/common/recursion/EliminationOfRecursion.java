package com.mbyy.algoritum.common.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 消除递归：
 * 一个算法用递归的方法从概念上容易理解，但实际效率不高
 *这种情况下把递归算法改为非递归算法会非常有用，这种转化
 *经常会用到栈
 * */
public class EliminationOfRecursion {
    static int theNumber;
    static int theAnswer;
    static StackX theStack;
//    static int codePart;
//    static Params theseParam;

//    转化为基于栈写法的原递归方法
//    int triangle(int n){
//        if (n==1){
//            return 1;
//        }else {
//            return (n+triangle(n-1));
//        }
//    }

    public static void main(String[] args) throws IOException {
        System.out.print("Enter a number: ");
        theNumber = getInt();
//        recTriangle();
        stackTriangle();
        System.out.println("Triangle=" + theAnswer);
    }

//    在实践中人们往往一开始就重新思考基于栈的算法而不是从递归的算法转化，这样才更加实用

//    public static void recTriangle(){
//        theStack=new StackX(10000);
//        codePart=1;
//        while (step()==false);
//    }
//
//    public static boolean step(){
//        switch (codePart){
//            case 1:
//                theseParam=new Params(theNumber,6);
//                theStack.push(theseParam);
//                codePart=2;
//                break;
//            case 2:
//                theseParam=theStack.peek();
//                if (theseParam.n==1){
//                    theAnswer=1;
//                    codePart=5;
//                } else {
//                  codePart=3;
//                }
//                break;
//            case 3:
//                Params newParam=new Params(theseParam.n-1,4);
//                theStack.push(newParam);
//                codePart=2;
//                break;
//            case 4:
//                theseParam=theStack.peek();
//                theAnswer=theAnswer+theseParam.n;
//                codePart=5;
//                break;
//            case 5:
//                theseParam=theStack.peek();
//                codePart=theseParam.returnAddress;
//                theStack.pop();
//                break;
//            case 6:
//                return true;
//        }
//        return false;
//    }

    //对上面代码进行精简
    public static void stackTriangle() {
        theStack = new StackX(10000);
        theAnswer = 0;
        while (theNumber > 0) {
            theStack.push(theNumber);
            --theNumber;
        }
        while (!theStack.isEmpty()) {
            int newN = theStack.pop();
            theAnswer += newN;
        }
    }

    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }

    public static int getInt() throws IOException {
        String s = getString();
        return Integer.parseInt(s);
    }
}

//class Params{
//    public int n;
//    public int returnAddress;
//    public Params(int nn,int ra){
//        n=nn;
//        returnAddress=ra;
//    }
//}

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
