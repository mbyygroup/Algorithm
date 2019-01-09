package com.mbyy.algoritum.vo.Link.onesLink;

//单链表实现
public class LinkedList {
    private Link first;
    public LinkedList(){
        first=null;
    }

    public boolean isEmpty(){
        return first==null;
    }

    public void insertFirst(int id,double dd){
        Link newLink=new Link(id,dd);
        newLink.next=first;
        first=newLink;
    }

    public Link find(int key){
        Link current=first;
        while (current.iData!=key){
            if (current.next==null){
                return null;
            }
            else {
                current=current.next;
            }
        }
        return current;
    }

    public Link deleteFirst(){
        Link temp=first;
        first=first.next;
        return temp;
    }

    public void displayList(){
        System.out.println("List (first-->last): ");
        Link current=first;
        while (current !=null) {
            current.displayLink();
            current=current.next;
        }
    }

    public Link delete(int key){
        Link current=first;
        Link previous=first;
        while (current.iData !=key){
            if (current.next==null){
                return null;
            }else {
                previous=current;
                current=current.next;
            }

        }
        if (current==first){
            first=first.next;
        }else {
            previous.next=current.next;
        }
        return current;
    }


    //对迭代器优化适配
    public Link getFirst(){
        return first;
    }

    public void setFirst(Link f){
        first=f;
    }

    public ListIterator getIterator(){
        return new ListIterator(this);
    }
}
