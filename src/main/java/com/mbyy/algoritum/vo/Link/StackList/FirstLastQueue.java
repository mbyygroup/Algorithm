package com.mbyy.algoritum.vo.Link.StackList;

import com.mbyy.algoritum.vo.Link.twos_link.Link;

//用链表实现队列
public class FirstLastQueue {
    private Link first;
    private Link last;

    public FirstLastQueue(){
        first=null;
        last=null;
    }

    public boolean isEmpty(){
        return first==null;
    }

    public void insertLast(long dd){
        Link newLink=new Link(dd);
        if (isEmpty()){
            first=newLink;
        }
        else {
            last.next=newLink;
        }
        last=newLink;
    }

    public long deleteFirst(){
        long temp=first.dData;
        if (first.next==null){
            last=null;
        }
        first=first.next;
        return temp;
    }

    public void displayList(){
        Link current=first;
        while (current!=null){
            current.displayLink();
            current=current.next;
        }
        System.out.println("");
    }
}
