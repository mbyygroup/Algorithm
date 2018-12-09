package com.mbyy.algoritum.common.Simple_Sort;

/*
 * 排序算法 vs
 * */
public class AlgorithmVs {
    public static void main(String[] args) {
        time(new SelectionSort());
        time(new BubbleSort());
        time(new InsertSort());
    }

    static void time(father f) {
        int[] list = new int[10000];
        for (int i = 0; i < list.length; i++) {
            list[i] = (int) (Math.random() * 100000);
        }
        long start = System.currentTimeMillis();
        f.Sort(list);
        long end = System.currentTimeMillis();
        System.out.println(f.getName() + "耗费的时间:" + (end - start));
        f.display(list);
    }
}
