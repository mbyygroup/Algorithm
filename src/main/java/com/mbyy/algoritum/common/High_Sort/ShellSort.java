package com.mbyy.algoritum.common.High_Sort;

//希尔排序不比插入排序的代码复杂多少
//只是在插入排序的开始部分在合适的位置把h赋值为1
public class ShellSort {
    private long[] theArray;
    private int nElems;

    public ShellSort(int max){
        theArray=new long[max];
        nElems=0;
    }

    public void insert(long value){
        theArray[nElems]=value;
        nElems++;
    }

    public void display(){
        System.out.print("A=");
        for (int j=0;j<nElems;j++){
            System.out.print(theArray[j]+" ");
        }
        System.out.println("");
    }

    public void Sort(){
        int h=0;
        while (h<nElems/3)
            h=h*3+1;
        while (h>0){
            for (int outer=h;outer<nElems;outer++){
                long temp=theArray[outer];
                int inner;

                for (inner=outer-h;inner>=0&&theArray[inner]>temp;inner=inner-h){
                    theArray[inner+h]=theArray[inner];
                }
                theArray[inner+h]=temp;
            }
            h=(h-1)/3;
        }
    }
}
