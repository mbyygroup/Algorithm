package com.mbyy.algoritum.common.List;

//双端链表
public class FirstLastList {

    public static void main(String[] args) {
        FirstLastList theList = new FirstLastList();
        theList.insertFirst(22);
        theList.insertFirst(44);
        theList.insertFirst(66);
        theList.insertLast(11);
        theList.insertLast(33);
        theList.insertLast(55);
        theList.displayList();
        theList.deleteFirst();
        theList.deleteFirst();
        theList.displayList();
    }

    private flLink first;
    private flLink last;

    public FirstLastList() {
        first = null;
        last = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insertFirst(long dd) {
        flLink newLink = new flLink(dd);
        if (isEmpty()) {
            last = newLink;
            newLink.next = first;
            first = newLink;
        }
    }

    public void insertLast(long dd) {
        flLink newLink = new flLink(dd);
        if (isEmpty()) {
            first = newLink;
        } else {
            last.next = newLink;
            last = newLink;
        }
    }

    public long deleteFirst() {
        long temp = first.dData;
        if (first.next == null) {
            last = null;
        }
        first = first.next;
        return temp;
    }

    public void displayList() {
        System.out.println("List(first-->last);");
        flLink current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
        System.out.println("");
    }

}

class flLink {
    public long dData;
    public flLink next;

    public flLink(long d) {
        dData = d;
    }

    public void displayLink() {
        System.out.println(dData + " ");
    }
}

