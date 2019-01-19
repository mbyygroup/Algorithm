package com.mbyy.algoritum.vo.HashTable;

public class HashTable {
    private DataItem[] hashArray;
    private int arraySize;
    private DataItem nonItem;

    public HashTable(int size) {
        arraySize=size;
        hashArray=new DataItem[size];
        nonItem= new DataItem(-1);
    }

    public void displayTable(){
        System.out.print("Table: ");
        for (int j = 0; j <arraySize ; j++) {
            if (hashArray[j]!=null){
                System.out.print(hashArray[j].getKey()+" ");
            }else {
                System.out.print("** ");
            }
        }
        System.out.println("");
    }

    //初次哈希
    public int hashFunc1(int key){
        return key%arraySize;
    }

    //二次哈希
    public int hashFunc2(int key){
        return 5-key%5;
    }

    public void insert(int key,DataItem item){
        int hashVal=hashFunc1(key);
        int stepSize=hashFunc2(key);
        while (hashArray[hashVal]!=null&&hashArray[hashVal].getKey()!=-1){
            hashVal+=stepSize;
            hashVal%=arraySize;
        }
        hashArray[hashVal]=item;
    }

    public DataItem delete(int key){
        int hashVal=hashFunc1(key);
        int stepSize=hashFunc2(key);
        while (hashArray[hashVal]!=null){
            if (hashArray[hashVal].getKey()==key){
                DataItem temp=hashArray[hashVal];
                hashArray[hashVal]=nonItem;
                return temp;
            }
            hashVal+=stepSize;
            hashVal %=arraySize;
        }
        return null;
    }

    public DataItem find(int key){
        int hashVal=hashFunc1(key);
        int stepSize=hashFunc2(key);
        while (hashArray[hashVal]!=null){
            if (hashArray[hashVal].getKey()==key)
                return hashArray[hashVal];
            hashVal+=stepSize;
            hashVal %= arraySize;
        }
        return null;
    }
}
