package com.mbyy.algoritum.vo.HighSort;

//归并排序
public class MergeSort extends Array {
    //原理：续将两个子部分进行递归的归并排序；然后将已经有序的两个子部分进行合并，最终完成排序
    public MergeSort(int max) {
        super(max);
    }

    public void Sort(){
        mergeSort(new long[theArray.length],0,theArray.length-1);
    }

    public void mergeSort(long[] tempList,int head,int rear){
        if (head<rear){
            //取分隔位置
            int middle=(head+rear)/2;
            //递归划分列表的左序列
            mergeSort(tempList,head,middle);
            //递归划分列表的右序列
            mergeSort(tempList, middle+1, rear);
            //列表的合并操作
            merge(theArray,tempList,head,middle+1,rear);
        }
    }

    //合并操作
    public static void merge(long[] list ,long[] tempList,int head,int middle,int rear){
        //左指针尾
        int headEnd=middle-1;
        //右指针尾
        int rearStart=middle;
        //临时的下标
        int tempIndex=head;
        //列表合并后的长度
        int tempLength=rear-head+1;

        //先循环两个区间段都没有结束的情况
        while ((headEnd>=head)&&(rearStart<=rear)){
            //如果发现右序列大，则将次数放入临时列表
            if (list[head]<list[rearStart]){
                tempList[tempIndex++]=list[head++];
            }else {
                tempList[tempIndex++]=list[rearStart++];
            }
        }

        //判断左序列是否结束
        while (head<=headEnd){
            tempList[tempIndex++]=list[head++];
        }

        //判断右序列是否结束
        while (rearStart<=rear){
            tempList[tempIndex++]=list[rearStart++];
        }

        //交换数据
        for (int i=0;i<tempLength;i++){
            list[rear]=tempList[rear];
            rear--;
        }
    }
}
