package com.mbyy.algoritum.vo.Link.StackList;

public class LinkQueue {
    private FirstLastQueue theList;

    public LinkQueue(){
        theList=new FirstLastQueue();
    }

    public boolean isEmpty(){
        return theList.isEmpty();
    }

    public void insert(long j){
        theList.insertLast(j);
    }

    public long remove(){
        return theList.deleteFirst();
    }

    public void displayQueue(){
        System.out.println("Queue (front-->rear):");
        theList.displayList();
    }
}
