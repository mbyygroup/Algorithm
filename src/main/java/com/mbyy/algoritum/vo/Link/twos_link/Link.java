package com.mbyy.algoritum.vo.Link.twos_link;

//只有next和一条数据的链表
public class Link {
    public long dData;
    public Link next;

    public Link(long d){
        dData=d;
    }

    public void displayLink(){
        System.out.println(dData+" ");
    }

}

