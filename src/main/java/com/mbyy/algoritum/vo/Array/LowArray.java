package com.mbyy.algoritum.vo.Array;

//需要下标的数组
public class LowArray {
    private long[] a;

    public LowArray(int size){
        a=new long[size];
    }

    public Long getElem(int index) {
        return a[index];
    }

    public void setElem(int index,long value) {
        a[index]=value;
    }


}
