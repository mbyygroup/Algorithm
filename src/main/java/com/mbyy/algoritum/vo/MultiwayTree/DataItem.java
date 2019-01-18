package com.mbyy.algoritum.vo.MultiwayTree;

public class DataItem {
    public long dData;

    public DataItem(Long dd){
        dData=dd;
    }

    public void displayItem(){
        System.out.print("/"+dData);
    }
}
