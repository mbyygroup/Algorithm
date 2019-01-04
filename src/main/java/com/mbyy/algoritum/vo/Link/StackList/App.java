package com.mbyy.algoritum.vo.Link.StackList;

public class App {
    public static void main(String[] args) {
        LinkQueue theQueue=new LinkQueue();
        theQueue.insert(20);
        theQueue.insert(40);
        theQueue.displayQueue();

        theQueue.insert(60);
        theQueue.insert(80);
        theQueue.displayQueue();

        theQueue.remove();
        theQueue.remove();
        theQueue.displayQueue();
//        LinkStack linkStack=new LinkStack();
//        linkStack.push(20);
//        linkStack.push(40);
//        linkStack.displayStack();
//        linkStack.push(60);
//        linkStack.push(80);
//        linkStack.displayStack();
//        linkStack.pop();
//        linkStack.pop();
//        linkStack.displayStack();
    }
}
