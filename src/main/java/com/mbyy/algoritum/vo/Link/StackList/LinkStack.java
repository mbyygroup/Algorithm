package com.mbyy.algoritum.vo.Link.StackList;

public class LinkStack {
    private Stack stack;

    public LinkStack(){
        stack=new Stack();
    }

    public void push(long j){
        stack.insertFirst(j);
    }

    public long pop(){
        return stack.deleteFirst();
    }

    public boolean isEmpty(){
        return stack.isEmpty();
    }

    public void displayStack(){
        System.out.println("Stack (top-->bottom)");
        stack.displayList();
    }


}
