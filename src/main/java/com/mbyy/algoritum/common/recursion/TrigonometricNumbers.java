package com.mbyy.algoritum.common.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 三角数字
 * 1，3，6，10，15，21数字序列
 * 这个数列第n项是由第 n-1 项+ n 得到的
 * 这样的序列称为三角函数
 *
 * */
public class TrigonometricNumbers {
    static int theNumber;

    static int triangle(int n) {
        int total = 0;
        while (n > 0) {
            total = total + n;
            --n;
        }
        return total;
    }

    //trangle的递归写法
    //递归其实就是程序设计中的数学归纳法
    static int triangle_2(int n) {
        if (n == 1) {
            return 1;
        }
        return (n + triangle_2(n - 1));
    }


    public static void main(String[] args) throws IOException {
        System.out.println("Enter a number: ");
        theNumber = getInt();
        int theAnswer = triangle_2(theNumber);
        System.out.println("Triangle=" + theAnswer);
    }

    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }

    public static int getInt() throws IOException {
        String s = getString();
        return Integer.parseInt(s);
    }
}
