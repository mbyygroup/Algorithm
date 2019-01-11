package com.mbyy.algoritum.vo.HighSort;

import java.util.HashMap;
import java.util.Map;

//基数排序
public class RadixSort extends Array{
    //原理：：将所有待比较数值（正整数）统一为同样的数位长度，数位较短的数前面补零。然后，从最
    // 低位开始，依次进行一次排序。这样从最低位排序一直到最高位排序完成以后, 数列就变成一个有
    // 序序列
    public RadixSort(int max) {
        super(max);
    }

    public void Sort(int d){//d表示最大有多少位
        int k=0;
        int n=1;   //表示除以个位，十位或者百位
        int m=1;   //控制键值排序依据在哪一位
        long[][] temp=new long[10][theArray.length];
        long[] order=new long[10];
        while (m<=d){
            for (int i=0;i<theArray.length;i++){
                int lsd=((int)(theArray[i]/n)%10);
                temp[lsd][(int)order[lsd]]=theArray[i];
                order[lsd]++;
            }
            for (int i=0;i<10;i++){
                if (order[i]!=0){
                    for (int j=0;j<order[i];j++){
                        theArray[k]=temp[i][j];
                        k++;
                    }
                }
                order[i]=0;
            }
            n *=10;
            k=0;
            m++;

        }
    }


}
