package com.mbyy.algoritum.vo.Stack;


//队列底层实现
//有eItems属性的实现
public class LowQueue {
    //实现原理：底层是数组，从第一位一直添加到设置的最大下标，如果之前的数据已经被取用，
    // 那么再次添加会从数组第一位开始，取得时候也是从第1位开始取，取完后再回到下标0的
    // 地方重新开始取数据
    private int maxSize;
    private long[] queArray;
    private int front;      //取元素的下标
    private int rear;        //添加元素的下标
    private int nItems;      //元素数量

    public LowQueue(int s){
        maxSize=s;
        queArray=new long[maxSize];
        front=0;
        rear=-1;
        nItems=0;
    }

    public void insert(long j){
        if (nItems!=maxSize) {
            if (rear == maxSize - 1)
                rear = -1;
            queArray[++rear] = j;
            nItems++;
        }else
            System.out.println("队列已满，增加失败");
    }

    public long remove(){
        if (nItems>0) {
            long temp = queArray[front++];
            if (front == maxSize) {
                front = 0;
            }
            nItems--;
            return temp;
        }else
            System.out.println("队列已经没有值了");
            return -1;
    }

    public long peekFront(){
        return queArray[front];
    }

    public boolean isEmpty(){
        return nItems==0;
    }

    public boolean isFull(){
        return nItems==maxSize;
    }

    public int size(){
        return nItems;
    }
}
