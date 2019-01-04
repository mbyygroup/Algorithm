package com.mbyy.algoritum.vo.Link.DoublyLinkedList;

//双向链表实现
//双向链表可以任意方向遍历，即反向遍历
public class Link {
    //相比于单项链表不同之处在于多一个previous属性来指引反向的链接点
    public long dData;
    public Link next;
    public Link previous;

    public Link(long d){
        dData=d;
    }

    public void displayLink(){
        System.out.println(dData+" ");
    }
}
