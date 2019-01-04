package com.mbyy.algoritum.vo.Link.SortList;

import com.mbyy.algoritum.vo.Link.twos_link.Link;
import sun.plugin.javascript.navig.LinkArray;

public class App {
    public static void main(String[] args) {
//        SortedList theSortedList=new SortedList();
//        theSortedList.insert(20);
//        theSortedList.insert(40);
//
//        theSortedList.displayLink();
//        theSortedList.insert(10);
//        theSortedList.insert(30);
//        theSortedList.insert(50);
//        theSortedList.displayLink();
//        theSortedList.remove();
//        theSortedList.displayLink();

        int size=10;
        Link[] linkArray=new Link[size];

        for (int j=0;j<size;j++){
            int n=(int)(Math.random()*99);
            Link newLink=new Link(n);
            linkArray[j]=newLink;
        }
        System.out.println("Unsorted array: ");
        for (int j=0;j<size;j++){
            System.out.println(linkArray[j].dData+" ");
        }
        System.out.println("");

        SortedList theSortedList=new SortedList(linkArray);

        for (int j=0;j<size;j++){
            linkArray[j]=theSortedList.remove();
        }
        System.out.println("Sorted Array:  ");
        for (int j=0;j<size;j++){
            System.out.println(linkArray[j].dData+" ");
        }
        System.out.println(" ");
    }
}
