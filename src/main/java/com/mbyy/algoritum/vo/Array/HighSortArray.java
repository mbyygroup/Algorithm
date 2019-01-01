package com.mbyy.algoritum.vo.Array;

//有序数组
public class HighSortArray {
    private long[] a;
    private int nElems;
    public HighSortArray(int max){
        a=new long[max];
        nElems=0;
    }
    public void insert(long value){
        int j;
        for (j=0;j<nElems;j++){
            if (a[j]>value){
                break;
            }
            for (int k=nElems;k>j;k--){
                a[k+1]=a[k];
            }
        }
        a[j]=value;
        nElems++;
        //时间复杂度O(n)
    }
    public int find(long value){
        int lowerBound = 0;
        int upperBound = nElems - 1;
        int curIn;
        while (true) {
            curIn = (lowerBound + upperBound) / 2;
            if (a[curIn] == value)
                return curIn;
            else if (lowerBound > upperBound)
                return nElems;
            else
                if (a[curIn] < value) {
                    lowerBound = curIn + 1;
                } else {
                    upperBound = curIn - 1;
                }

        }
        //时间复杂度O(log2(n))
    }
    public boolean delete(long value){
        int j;
        for (j=0;j<nElems;j++)
            if (a[j]==value)
                break;

        if (j==nElems)
            return false;
        else
            for (int k=j;j<nElems;k++){
                a[k]=a[k+1];
            }
            nElems--;
            return true;
    }
    public void display(){
        for (int j=0;j<nElems;j++){
            System.out.println(a[j]+" ");
        }
    }
    public int size(){
        return nElems;
    }
}
