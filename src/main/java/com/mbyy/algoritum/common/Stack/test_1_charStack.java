package com.mbyy.algoritum.common.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test_1_charStack {
    public static void main(String[] args) throws IOException {
        String input, output;
        while (true) {
            System.out.println("Enter a string: ");
            System.out.flush();
            input = getString();
            if (input.equals(""))
                break;
            CharReverser charReverser = new CharReverser(input);
            output = charReverser.doRev();
            System.out.println("Reversed: " + output);
        }
    }

    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }
}

class CharStackX {
    private int maxSize;
    private char[] stackArray;
    private int top;

    public CharStackX(int s) {
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

class CharReverser {
    private String input;
    private String output;

    public CharReverser(String in) {
        input = in;
    }

    public String doRev() {
        int stackSize = input.length();
        CharStackX charStackX = new CharStackX(stackSize);

        for (int j = 0; j < input.length(); j++) {
            char ch = input.charAt(j);
            charStackX.push(ch);
        }
        output = " ";
        while (!charStackX.isEmpty()) {
            char ch = charStackX.pop();
            output = output + ch;
        }
        return output;
    }
}