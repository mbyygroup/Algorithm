package com.mbyy.algoritum.common.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 *
 * 阶乘
 * */
public class Factorial {
    static int theNumber;

    static int factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return (n * factorial(n - 1));
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Enter a number: ");
        theNumber = getInt();
        int theAnswer = factorial(theNumber);
        System.out.println("Factorial=" + theAnswer);
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
