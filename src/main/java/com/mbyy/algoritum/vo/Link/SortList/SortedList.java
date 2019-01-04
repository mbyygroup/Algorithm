package com.mbyy.algoritum.vo.Link.SortList;

import com.mbyy.algoritum.vo.Link.twos_link.Link;

//有序链表
public class SortedList {
    private Link first;

    public SortedList(){
        first=null;
    }

    //有序链表改进实现
    public SortedList(Link[] linkArr){
        first=null;
        for (int j=0;j<linkArr.length;j++){
            insert(linkArr[j]);
        }
    }

    public boolean isEmpty(){
        return first==null;
    }

//    public void insert(long key){
//        Link newLink=new Link(key);
//        Link previous=null;
//        Link current=first;
//
//        while (current!=null && key>current.dData){
//            previous=current;
//            current=current.next;
//        }
//        if (previous==null)
//            first=newLink;
//        else
//            previous.next=newLink;
//        newLink.next=current;
//    }

    public void insert(Link k){
        //改进写法
        //创建一个无序数组，把他们插入到有序链表中（使用构造函数），然后再从链表中删除，放回原数组
        Link previous=null;
        Link current=first;

        while (current!=null && k.dData>current.dData){
            previous=current;
            current=current.next;
        }

        if (previous==null){
            first=k;
        }else {
            previous.next=k;
        }
        k.next=current;
    }

    public Link remove(){
        Link temp=first;
        first=first.next;
        return temp;
    }

    public void displayLink(){
        System.out.println("List (first-->last):");
        Link current=first;
        while (current !=null){
            current.displayLink();
            current=current.next;
        }
        System.out.println(" ");
    }
}
