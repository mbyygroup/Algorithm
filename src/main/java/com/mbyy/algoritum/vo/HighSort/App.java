package com.mbyy.algoritum.vo.HighSort;

public class App {
    public static void main(String[] args) {
        int maxSize=10;
//        ShellSort shell=new ShellSort(maxSize);
//        QuickSort shell=new QuickSort(maxSize);
//        HighQuickSort shell=new HighQuickSort(maxSize);
//        RadixSort shell=new RadixSort(maxSize);
        MergeSort shell=new MergeSort(maxSize);
        for (int j=0;j<maxSize;j++){
            long n=(int)(Math.random()*999);
            shell.insert(n);
        }
        shell.display();
        shell.Sort();
        shell.display();
    }
}
