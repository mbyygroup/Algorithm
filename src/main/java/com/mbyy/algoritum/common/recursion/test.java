package com.mbyy.algoritum.common.recursion;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

//测试案例
public class test {
    public static void main(String[] args) {
//        求成方
        int number = middle_module(2, 10);
        System.out.println(number);

    }

    //求一个数的乘方
    static int power(int x, int y, int z) {
        if (y % 2 == 0 && y / 2 != 0) {
            return power(x * x, y / 2, z);
        } else if (y % 2 == 1 && y / 2 == 0) {
            return x * z;
        } else if (y % 2 == 1 && y / 2 != 0) {
            return power(x * x, (y - 1) / 2, x * z);
        } else {
            return -1;
        }
    }

    static int middle_module(int x, int y) {
        return power(x, y, 1);
    }

}
