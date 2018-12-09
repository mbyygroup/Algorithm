package com.mbyy.algoritum.common.List;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 带迭代器的链表
 * */
public class ListIterator {
    public static void main(String[] args) throws IOException {
        List theList = new List();
        iterator_1 iter1 = theList.getIterator();
        long value;

        iter1.insertAfter(20);
        iter1.insertAfter(40);
        iter1.insertAfter(80);
        iter1.insertBefore(60);

        while (true) {
            System.out.flush();
            char choice = getChar();
            switch (choice) {
                case 's':
                    if (!theList.isEmpty()) {
                        theList.displayList();
                    } else {
                        System.out.println("List is empty");
                    }
                    break;
                case 'r':
                    iter1.reset();
                    break;
                case 'n':
                    if (!theList.isEmpty() && iter1.atEnd())
                        iter1.nextLink();
                    else
                        System.out.println("Can't go to next link");
                    break;
                case 'g':
                    if (!theList.isEmpty()) {
                        value = iter1.getCurrent().dData;
                        System.out.println("Returnet " + value);
                    } else {
                        System.out.println("List is empty");
                    }
                case 'b':
                    System.out.println("Enter value to insert: ");
                    System.out.flush();
                    value = getInt();
                    iter1.insertBefore(value);
                    break;
                case 'a':
                    System.out.println("Enter value to insert:");
                    System.out.flush();
                    value = getInt();
                    iter1.insertAfter(value);
                    break;
                case 'd':
                    if (!theList.isEmpty()) {
                        value = iter1.deleteCurrent();
                        System.out.println("Deleted " + value);
                    } else {
                        System.out.println("Can't delete");
                    }
                    break;
                default:
                    System.out.println("Invalid entry");
            }

        }
    }

    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }

    public static char getChar() throws IOException {
        String s = getString();
        return s.charAt(0);
    }

    public static int getInt() throws IOException {
        String s = getString();
        return Integer.parseInt(s);
    }
}

class List {
    private flLink first;

    public List() {
        first = null;
    }

    public flLink getFirst() {
        return first;
    }

    public void setFirst(flLink f) {
        first = f;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public iterator_1 getIterator() {
        return new iterator_1(this);
    }

    public void displayList() {
        flLink current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
        System.out.println("");
    }

}

class iterator_1 {
    private flLink current;
    private flLink previous;
    private List ourList;

    public iterator_1(List list) {
        ourList = list;
        reset();
    }

    public void reset() {
        current = ourList.getFirst();
        previous = null;
    }

    public boolean atEnd() {
        return (current.next == null);
    }

    public void nextLink() {
        previous = current;
        current = current.next;
    }

    public flLink getCurrent() {
        return current;
    }

    public void insertAfter(long dd) {
        flLink newLink = new flLink(dd);
        if (ourList.isEmpty()) {
            ourList.setFirst(newLink);
            current = newLink;
        } else {
            newLink.next = current.next;
            current.next = newLink;
            nextLink();
        }
    }

    public void insertBefore(long dd) {
        flLink newLink = new flLink(dd);
        if (previous == null) {
            newLink.next = ourList.getFirst();
            ourList.setFirst(newLink);
            reset();
        } else {
            newLink.next = previous.next;
            previous.next = newLink;
            current = newLink;
        }
    }

    public long deleteCurrent() {
        long value = current.dData;
        if (previous == null) {
            ourList.setFirst(current.next);
            reset();
        } else {
            previous.next = current.next;
            if (atEnd())
                reset();
            else
                current = current.next;
        }
        return value;
    }


}
