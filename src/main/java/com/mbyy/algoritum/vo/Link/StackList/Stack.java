package com.mbyy.algoritum.vo.Link.StackList;

import com.mbyy.algoritum.vo.Link.twos_link.Link;

//用链表实现的栈
public class Stack {
    private Link first;

    public Stack(){
        first=null;
    }

    public boolean isEmpty(){
        return first==null;
    }

    public void insertFirst(long dd){
        Link newLink=new Link(dd);
        newLink.next=first;
        first=newLink;
    }

    public long deleteFirst(){
        Link temp=first;
        first=first.next;
        return temp.dData;
    }

    public void displayList(){
        Link current=first;
        while (current!=null){
            current.displayLink();
            current=current.next;
        }
        System.out.println();
    }


}
