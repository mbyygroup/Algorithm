package com.mbyy.algoritum.common.recursion;

/*
 *
 * 汉诺塔问题：有三个塔座a,b,c。有很多直径不同的盘子，刚开始所有的盘子都在a座上，
 * 这个难题的目标是将所有的盘子都从塔座a移动到塔座c上，每次只能移动一个盘子，并且
 * 任何一个盘子都不能放在比自己小的盘子之上
 *
 * */
public class towers {
    static int nDisks = 5;       //假设有五个盘子

    public static void main(String[] args) {
        doTowers(nDisks, 'a', 'b', 'c');
    }

    public static void doTowers(int topN, char from, char inter, char to) {
        if (topN == 1) {
            System.out.println("Disk 1 from " + from + " to " + to);
        } else {
            doTowers(topN - 1, from, to, inter);
            System.out.println("Disk " + topN + " from " + from + " to " + to);
            doTowers(topN - 1, inter, from, to);
        }
    }
}
