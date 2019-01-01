package com.mbyy.algoritum.vo.SimpleSort;

import com.mbyy.algoritum.vo.Array.HighArray;

//冒泡排序因为太过简单这里不写
//排序
public class ChooseSort {

    static HighArray highArray=new HighArray(20);   //这里操作自己实现的数组
    static int nElems;
    public static void main(String[] args) {
        highArray.insert(3);
        highArray.insert(233);
        highArray.insert(354);
        highArray.insert(32);
        highArray.insert(34);
        highArray.insert(64);
        highArray.insert(3);
        highArray.insert(1);
        highArray.insert(8);
        highArray.display();
//        selectionSort();
        insertionSort();
        highArray.display();
        System.out.println();
    }

    //选择排序
    //原理：用数组的第一个数字指代最小值（或最大值）,然后循环遍历，如果有一个数字小于最小值或者对于最大值，那么记录这个值
    // 一轮结束后把这个最小值（或最大值）和数组第一位进行替换，下一轮遍历时从下一位开始。
    public static void selectionSort(){
        int out,in,min,nElems=highArray.size();
        for (out=0;out<nElems-1;out++){
            min=out;
            for (in=out+1;in<nElems;in++){
                if (highArray.get(in)<highArray.get(min)){
                    min=in;
                }
            }
            highArray.swap(out,min);
        }
        //选择排序和插入排序，冒泡排序的效率都是O(n2)，总速度相比冒泡最慢，选择排序略快，插入排序最快
        //不过这都是比较简单的排序算法，效率都不高
    }

    //插入排序
    //原理：从第二位开始遍历，然后和第一位比较，后者比前面小就交换，循环到第三位时和前面两位已经排序好了
    //从后到前做比较，如果小于前面一个数，那么前面的数后移，直到这个值大于前面的数字时，更新这个下
    // 标的值为新值，后续也是这样进行操作
    public static void insertionSort(){
        int in,out,nElems=highArray.size();
        for (out=1;out<nElems;out++){
            long temp=highArray.get(out);
            in=out;
            while (in>0&&highArray.get(in-1)>=temp){
                highArray.update(in,highArray.get(in-1));
                --in;
            }
            highArray.update(in,temp);
        }
    }


    //对象排序：因为现实任务很多不只是比较数字，还有字母，字符串等。
    //可以使用compareTo（）方法根据两个string的字典顺序（字母序）返回给调用者不同的整数值
}
