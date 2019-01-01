package com.mbyy.algoritum.vo.Array;

//不需要了解和使用下标的数组
public class HighArray {
    protected long[] a;
    protected int nElems;
    //定义数组
    public HighArray(int max){
        a=new long[max];
        nElems=0;
    }
    //交换两个值
    public void swap(int index,int index2){
        //交换方法
        long change=a[index];
        a[index]=a[index2];
        a[index2]=change;
    }
    //获取值
    public long get(int index){
        if (index>nElems){
            return -1;
        }
        return a[index];
    }
    //更新值
    public void update(int index,long value){
        a[index]=value;
    }
    //添加一个在最后
    public void insert(long value){
        a[nElems]=value;
        nElems++;
        //时间复杂度O(1)
    }
    //判断是否存在
    public boolean find(long searchKey){
        int j;
        for (j=0;j<nElems;j++){
            if (a[j]==searchKey)
                break;
        }
        if (j==nElems)
            return false;
        else
            return true;
    }
    //删除任意元素
    public boolean delete(long value){
        int j;
        for (j=0;j<nElems;j++){
            if (a[j]==value)
                break;
        }
        if (j==nElems)
            return false;
        else
            for (int k=j;j<nElems;k++){
                a[k]=a[k+1];
            }
            nElems--;
            return true;
    }
    //遍历元素
    public void display(){
        for (int j=0;j<nElems;j++){
            System.out.print(a[j]+",");
        }
        System.out.println();
    }
    //获取大小
    public int size(){
        return nElems;
    }
}
