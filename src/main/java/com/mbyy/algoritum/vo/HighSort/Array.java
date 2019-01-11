package com.mbyy.algoritum.vo.HighSort;

public abstract class Array {
    protected long[] theArray;
    protected int nElems;

    public Array(int max){
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


}
