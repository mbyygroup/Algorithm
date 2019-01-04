package com.mbyy.algoritum.vo.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class StackApp {
    public static void main(String[] args) throws IOException {
//        StackX stackX=new StackX(20);
//        for (int i=0;i<5;i++){
//            stackX.push((long) (Math.random()*100));
//        }
//        while (!stackX.isEmpty())
//            System.out.println(stackX.pop());
        String input;
        while (true){
            System.out.println("Enter string containing delimiters");
            System.out.flush();
            input=getString();
            if (input.equals("")){
                break;
            }
            BracketChecker theChecker = new BracketChecker(input);
            theChecker.check();

        }
    }
    public static String getString() throws IOException{
        InputStreamReader isr=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(isr);
        String s=br.readLine();
        return s;
    }
}
