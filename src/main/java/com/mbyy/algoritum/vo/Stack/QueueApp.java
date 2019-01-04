package com.mbyy.algoritum.vo.Stack;

public class QueueApp {
    public static void main(String[] args) {
//        Queue queue=new Queue(5);
//        queue.insert(10);
//        queue.insert(20);
//        queue.insert(30);
//        queue.insert(40);
//        queue.insert(50);
////        queue.insert(60);
//        System.out.println(queue.remove());
//        System.out.println(queue.remove());
//        queue.insert(60);
//        queue.insert(70);
//        System.out.println(queue.remove());
//        System.out.println(queue.remove());
//        System.out.println(queue.remove());
//        System.out.println(queue.remove());
//        System.out.println(queue.remove());
//        System.out.println(queue.remove());
//        int a=10;
//        System.out.println(a++);
//        System.out.println(a);
        PriorityQ theQ=new PriorityQ(5);
        theQ.insert(30);
        theQ.insert(20);
        theQ.insert(10);
        theQ.insert(40);
        theQ.insert(50);
        while (!theQ.isEmpty()){
            long item=theQ.remove();
            System.out.println(item+" ");
        }

    }
}
