package com.mbyy.algoritum.common.List;

//单链表
public class LinkList {

    public static void main(String[] args) {
        LinkList theList = new LinkList();
        theList.insertFirst(22, 2.99);
        theList.insertFirst(44, 4.99);
        theList.insertFirst(66, 6.99);
        theList.insertFirst(88, 8.99);

        theList.displayList();

        while (!theList.isEmpty()) {
            Link link = theList.deleteFirst();
            System.out.println("Deleted ");
            link.displayLink();
            System.out.println("");
        }
        theList.displayList();
    }

    private Link first;

    public void LinkList() {
        first = null;      //构造方法不写也可以，因为引用类型创建时值就是null
    }

    public boolean isEmpty() {
        return (first == null);
    }

    public void insertFirst(int id, double dd) {
        Link newLink = new Link(id, dd);
        newLink.next = first;
        first = newLink;
    }

    public Link deleteFirst() {
        Link temp = first;
        first = first.next;
        return temp;
    }

    public void displayList() {
        System.out.println("List (first --> last):");
        Link current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
        System.out.println(" ");
    }
}

class Link {
    public int iData;
    public double dData;
    public Link next;

    public Link(int id, double dd) {
        iData = id;
        dData = dd;
    }

    public void displayLink() {
        System.out.println("{" + iData + ", " + dData + "} ");
    }
}
