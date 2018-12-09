package com.mbyy.algoritum.common.Array;

/*
 *
 * 二分查找和线性查找（对于列表）
 * */
public class applet {
    static int[] list = new int[20000];
    static int nElems = list.length;

    //本专题可以选择两种查找算法，线性查找和二分查找，后者查找有序数组更快，尤其是大数组情况下
    public static void main(String[] args) {
        for (int i = 0; i < list.length; i++) {
            list[i] = i + 1;
            System.out.print(i + ":" + list[i] + "\n");
        }
        long startTime = System.currentTimeMillis();
        System.out.println(find(28));
        long endTime = System.currentTimeMillis();
        System.out.println("二分查找消耗的时间是" + (endTime - startTime));
        //线性查找其实就是挨个遍历来查找，对于只拥有小数量元素的数组，线性查找
        //速度不会很慢，但随着元素增多线性查找会成倍增加时间，因为平均比较次数
        // 为n/2，n为列表元素的个数，而二分查找只需要2的指数函数的反函数次比较
        // 次数

    }

    //二分查找
    public static int find(int searchKey) {
        int lowerBound = 0;
        int upperBound = nElems - 1;
        int curIn;
        while (true) {
            curIn = (lowerBound + upperBound) / 2;
            if (list[curIn] == searchKey) {
                return curIn;
            } else if (lowerBound > upperBound) {
                return nElems;
            } else {
                if (list[curIn] < searchKey) {
                    lowerBound = curIn + 1;
                } else {
                    upperBound = curIn - 1;
                }
            }
        }
    }
}
