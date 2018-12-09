package com.mbyy.algoritum.common.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test_2_delimiterStack {

    public static void main(String[] args) throws IOException {
        String input;
        while (true) {
            System.out.println("Enter string containing delimiters: ");
            System.out.flush();
            input = getString();
            if (input.equals(" ")) {
                break;
            }
            BracktChecker bracktChecker = new BracktChecker(input);
            bracktChecker.check();
        }
    }

    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }
}

class delimiterStackX {
    private int maxSize;
    private char[] stackArray;
    private int top;

    public delimiterStackX(int s) {
        maxSize = s;
        stackArray = new char[maxSize];
        top = -1;
    }

    public void push(char j) {
        stackArray[++top] = j;
    }

    public char pop() {
        return stackArray[top--];
    }

    public long peek() {
        return stackArray[top];
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == maxSize - 1);
    }
}

class BracktChecker {
    private String input;

    public BracktChecker(String in) {
        input = in;
    }

    public void check() {
        int stackSize = input.length();
        delimiterStackX theStack = new delimiterStackX(stackSize);

        for (int j = 0; j < input.length(); j++) {
            char ch = input.charAt(j);
            switch (ch) {
                case '{':
                case '[':
                case '(':
                    theStack.push(ch);
                    break;
                case '}':
                case ']':
                case ')':
                    if (!theStack.isEmpty()) {
                        char chx = theStack.pop();
                        if ((ch == '}' && chx != '{') ||
                                (ch == ']' && chx != '[') ||
                                (ch == ')' && chx != '(')) {
                            System.out.println("Error:" + ch + " at " + j);
                        } else {
                            System.out.println("Error: " + ch + " at " + j);
                            break;
                        }
                    }
                default:
                    break;
            }
        }
        if (!theStack.isEmpty()) {
            System.out.println("Error: missing right delimiter");
        }
    }
}
