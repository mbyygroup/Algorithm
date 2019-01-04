package com.mbyy.algoritum.vo.Link.DoublyLinkedList;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

public class DoublyLinkedList {
    private Link first;
    private Link last;

    public DoublyLinkedList(){
        first=null;
        last=null;
    }

    public boolean isEmpty(){
        return first==null;
    }

    //原理：创建新元素与原链表的左边，first为原先链表的最左边
    //first的previous指向这个新元素，然后新元素的next指向first
    //first指向新元素为标示链表最左端
    public void insertFirst(long dd){
        Link thelink=new Link(dd);
        if (isEmpty()){
            last=thelink;
        }else {
            first.previous=thelink;
        }
        thelink.next=first;
        first=thelink;
    }

    public void insertLast(long dd){
        Link theLink=new Link(dd);
        if (isEmpty()){
            first=theLink;
        }else {
            last.next=theLink;
        }
        theLink.previous=last;
        last=theLink;
    }

    //原理：令first为它自身的next(右边)，然后它自身next的previous（左边）为null
    public Link deleteFirst(){
        Link temp=first;
        if (first.next==null){
            last=null;
        }else {
            first=first.next;
            first.previous=null;
        }
        return temp;
    }

    public Link deleteLast(){
        Link link=last;
        if (link.previous==null){
            first=null;
        }else {
            last=last.previous;
            last.next=null;
        }
        return link;
    }

    public boolean insertAfter(long key,long dd){
        Link current=first;
        while (current.dData!=key){
            current=current.next;
            if (current==null){
                return false;
            }
        }
        Link newLink=new Link(dd);

        if (current==last){
            newLink.next=null;
            last=newLink;
        }else {
            newLink.next=current.next;
            current.next.previous=newLink;
        }
        newLink.previous=current;
        current.next=newLink;
        return true;
    }

    public Link deleteKey(long key) {
        Link current=first;
        while (current.dData!=key){
            current=current.next;
            if (current==null){
                return null;
            }
        }
        if (current==first){
            first=current.next;
        }else {
            current.previous.next=current.next;
        }

        if (current==last){
            last=current.previous;
        }else {
            current.next.previous=current.previous;
        }
        return current;
    }

    public void displayForward(){
        System.out.println("List (first-->last)");
        Link current=first;
        while (current!=null){
            current.displayLink();
            current=current.next;
        }
        System.out.println(" ");
    }

    public void displayBackward(){
        System.out.println("List (last-->first):");
        Link current=last;
        while (current!=null){
            current.displayLink();
            current=current.previous;
        }
        System.out.println("");
    }
}
