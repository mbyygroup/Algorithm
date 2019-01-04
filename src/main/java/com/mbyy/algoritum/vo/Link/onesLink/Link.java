package com.mbyy.algoritum.vo.Link.onesLink;

//链表的简易实现  一般来说有next和数据两个属性即可
public class Link {
    public int iData;
    public double dData;
    public Link next;

    public Link(int id,double dd){
        iData=id;
        dData=dd;
        //链表底部是不需要next的
        //     first=null
        //     第一个数据  next=first=0
        //     第二条数据  next=第一条数据
    }

    public void displayLink(){
        System.out.println("{"+iData+","+dData+"}");
    }

}
