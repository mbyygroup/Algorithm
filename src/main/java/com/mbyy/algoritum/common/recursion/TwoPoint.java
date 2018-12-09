package com.mbyy.algoritum.common.recursion;

/*
 *
 * 二分查找
 * */
public class TwoPoint {

    public static void main(String[] args) {
        int maxSize = 100;
        TwoPoint tp;
        tp = new TwoPoint(maxSize);

        tp.insert(72);
        tp.insert(90);
        tp.insert(45);
        tp.insert(126);
        tp.insert(54);
        tp.insert(99);
        tp.insert(144);
        tp.insert(27);
        tp.insert(135);
        tp.insert(81);
        tp.display();

        int searchKey = 27;
        if (tp.find(searchKey) != tp.size()) {
            System.out.println("Found " + searchKey);
        } else {
            System.out.println("Can't find " + searchKey);
        }

    }

    private long[] a;
    private int nElems;

    public TwoPoint(int max) {
        a = new long[max];
        nElems = max;
    }

    public int size() {
        return nElems;
    }

    public int find(long searchKey) {
        return recFind(searchKey, 0, nElems - 1);
    }

    private int recFind(long searchKey, int lowerBound, int upperBound) {
        int curIn;
        curIn = (lowerBound + upperBound) / 2;
        if (a[curIn] == searchKey) {
            return curIn;
        } else if (lowerBound > upperBound) {
            return nElems;
        } else {
            if (a[curIn] < searchKey) {
                return recFind(searchKey, curIn + 1, upperBound);
            } else {
                return recFind(searchKey, lowerBound, curIn - 1);
            }
        }
    }

    public void insert(long value) {
        if (a[0] >= value) {
            return;
        }
        for (int i = 1; i < nElems; i++) {
            if (a[i] < value) {
                a[i - 1] = a[i];
                if (i == nElems - 1) {
                    a[nElems - 1] = value;
                }
            } else {
                a[i - 1] = value;
                break;
            }
        }
    }

    public void display() {
        for (int j = 0; j < nElems; j++) {
            System.out.print(a[j] + " ");
        }
        System.out.println("");
    }

}

