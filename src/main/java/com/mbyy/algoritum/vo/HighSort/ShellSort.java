package com.mbyy.algoritum.vo.HighSort;

//希尔排序不比插入排序的代码复杂多少
//只是在插入排序的开始部分在合适的位置把h赋值为1
public class ShellSort extends Array {
    public ShellSort(int max) {
        super(max);
    }

    //原理：加入插入排序中元素之间的间隔，并在这些有间隔的元素中进行插入排序，从而使数据项能大跨度地移动
    //当这些数据项排过一趟序后，希尔排序算法减少数据项的间隔在进行排序，一般间隔从h=3*h+1来产生，初始值
    // 为1，当间隔大于数组时过程停止
    //效率：除非特殊情况，还没有人能够从理论上分析希尔排序的效率。
    //有各种基于实验的评估，估计它的时间级从O(N3/2)到O(N7/6)
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
