package com.mbyy.algoritum.common.High_Sort;

public class App {
    public static void main(String[] args) {
        int maxSize=10;
        ShellSort shell=new ShellSort(maxSize);
        for (int j=0;j<maxSize;j++){
            long n=(int)(Math.random()*99);
            shell.insert(n);
        }
        shell.display();
        shell.Sort();
        shell.display();
    }
}
