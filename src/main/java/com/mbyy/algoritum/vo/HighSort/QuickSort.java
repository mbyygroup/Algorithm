package com.mbyy.algoritum.vo.HighSort;

public class QuickSort extends Array {
    //快速排序是最流行的排序算法，大多数情况下快速排序都是最快的，执行时间为O(N*logN)级
    //原理：把一个数组划分为两个子数组，然后递归调用自身为每一个子数组进行快速排序
    public QuickSort(int maxSize){
        super(maxSize);

    }

    public void Sort(){
        recQuickSort(0,nElems-1);
    }
    //这样划分性能会被降低到O(N2)级别，而且当数据量过大时会因为递归调用次数过多引发栈溢出，使系统瘫痪
    //上述问题出现的原因在于枢纽的选取出了问题，通常情况下会使用三数据项取中的方法来解决速度问题和数据
    // 已经排序好却仍然选择最大或者最小数据项作为枢纽的机会。

//    public void recQuickSort(int left,int right){
//        if (right-left<=0){
//            return;
//        }else {
//            long pivot=theArray[right];
//            int partition=partitionIt(left,right,pivot);
//            recQuickSort(left,partition-1);
//            recQuickSort(partition+1,right);
//        }
//    }
//
//    public int partitionIt(int left,int right,long pivot){
//        int leftPtr=left-1;
//        int rightPtr=right;
//        while (true){
//            while (theArray[++leftPtr]<pivot);
//            while (rightPtr>0&&theArray[--rightPtr]>pivot);
//            if (leftPtr>=rightPtr)
//                break;
//            else
//                swap(leftPtr,rightPtr);
//        }
//        swap(leftPtr,right);
//        return leftPtr;
//    }

    //三数据项取中的办法
    public void recQuickSort(int left,int right){
        int size=right-left+1;
        if (size<=3)
            manualSort(left,right);
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

    public void manualSort(int left,int right){
        int size=right-left+1;
        if (size<=1)
            return;
        if (size==2) {
            if (theArray[left] > theArray[right])
                swap(left, right);
            return;
        }else {
            if (theArray[left]>theArray[right-1])
                swap(left,right-1);
            if (theArray[left]>theArray[right])
                swap(left,right);
            if (theArray[right-1]>theArray[right])
                swap(right-1,right);
        }
    }

    public void swap(int dex1,int dex2){
        long temp=theArray[dex1];
        theArray[dex1]=theArray[dex2];
        theArray[dex2]=temp;
    }

}
