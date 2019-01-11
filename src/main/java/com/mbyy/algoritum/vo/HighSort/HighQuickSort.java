package com.mbyy.algoritum.vo.HighSort;

public class HighQuickSort extends Array {
    public HighQuickSort(int max) {
        super(max);
    }
    //在快速排序中使用插入排序被证实是最快的一种方法，但是它快速排序中对三个或者更少的数据项的
    // 子数组手动排序快。这个写法并不比快排明显节省时间，但能把快速排序的性能发挥到极致
    public void Sort(){
        recQuickSort(0,nElems-1);
    }
    public void recQuickSort(int left,int right){
        int size=right-left+1;
        if (size<10)
            insertionSort(left,right);
        else {
            long median=medianOf3(left,right);
            int partition=partitionIt(left,right,median);
            recQuickSort(left,partition-1);
            recQuickSort(partition+1,right);
        }
    }

    public long medianOf3(int left,int right){
        int center=(left+right)/2;
        if (theArray[left]>theArray[center])
            swap(left,center);
        if (theArray[left]>theArray[right])
            swap(left,right);
        if (theArray[center]>theArray[right])
            swap(center,right);
        swap(center,right-1);
        return theArray[right-1];
    }

    public int partitionIt(int left,int right,long pivot){
        int leftPtr=left;
        int rightPtr=right-1;
        while (true){
            while (theArray[++leftPtr]<pivot);
            while (theArray[--rightPtr]>pivot);
            if (leftPtr>=rightPtr)
                break;
            else
                swap(leftPtr,rightPtr);
        }
        swap(leftPtr,right-1);
        return leftPtr;    //和上面的相比处理过程是一样的，但是位置是不一样的
    }

    public void insertionSort(int left,int right){
        int in,out;
        for (out=left+1;out<=right;out++) {
            long temp=theArray[out];
            in=out;

            while (in>left && theArray[in-1] >=temp){
                theArray[in]=theArray[in-1];
                --in;
            }
            theArray[in]=temp;
        }
    }

    public void swap(int dex1,int dex2){
        long temp=theArray[dex1];
        theArray[dex1]=theArray[dex2];
        theArray[dex2]=temp;
    }
}
