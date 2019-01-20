package com.mbyy.algoritum.vo.Heap;

import org.omg.CORBA.NO_IMPLEMENT;

public class Heap {
    private Node[] heapArray;
    private int maxSize;
    private int currentSize;

    public Heap(int mx){
        maxSize=mx;
        currentSize=0;
        heapArray=new Node[maxSize];
    }

    public boolean isEmpty(){
        return currentSize==0;
    }

    public boolean insert(int key){
        if (currentSize==maxSize){      //检测堆有没有满
            return false;
        }
        Node newNode=new Node(key);        //创建这个节点
        heapArray[currentSize]=newNode;        //在数组里添加这个节点
        trickleUp(currentSize++);        //
        return true;
    }

    public void trickleUp(int index){
        int parent=(index-1)/2;        //找到父节点下标
        Node bottom=heapArray[index];        //找到新添加入的节点元素
        while (index>0&&heapArray[parent].getKey()<bottom.getKey()){       //比对元素
            heapArray[index]=heapArray[parent];
            index=parent;
            parent=(parent-1)/2;
        }
        heapArray[index]=bottom;
    }

    public Node remove(){
        Node root=heapArray[0];
        heapArray[0]=heapArray[--currentSize];
        trickleDown(0);
        return root;
    }

    public void trickleDown(int index){
        int largerChild;
        Node top=heapArray[index];
        while (index<currentSize/2){
            int leftChild=2*index+1;
            int rightChild=leftChild+1;
            if (rightChild<currentSize&&heapArray[leftChild].getKey()<heapArray[rightChild].getKey()){
                largerChild=rightChild;
            }else {
                largerChild=leftChild;
            }
            if (top.getKey()>=heapArray[largerChild].getKey()){
                break;
            }
            heapArray[index]=heapArray[largerChild];
            index=largerChild;
        }
        heapArray[index]=top;
    }

    public boolean change(int index,int newValue){
        if (index<0||index>=currentSize){
            return false;
        }
        int oldValue=heapArray[index].getKey();
        heapArray[index].setKey(newValue);
        if (oldValue<newValue){
            trickleUp(index);
        }else {
            trickleDown(index);
        }
        return true;
    }

    public void displayHeap(){
        System.out.print("heapArray: ");
        for (int m = 0; m <currentSize ; m++) {
            if (heapArray[m]!=null)
                System.out.print(heapArray[m].getKey()+" ");
            else
                System.out.print("-----");

        }
        System.out.println();
        int nBlanks=32;
        int itemsPerRow=1;
        int column=0;
        int j=0;
        String dots=".......................";
        System.out.println(dots+dots);

        while (currentSize>0){
            if (column==0)
                for (int k = 0; k < nBlanks; k++)
                    System.out.print(' ');
                System.out.print(heapArray[j].getKey());
                if (++j==currentSize)
                    break;

                if (++column==itemsPerRow){
                    nBlanks/=2;
                    itemsPerRow *=2;
                    column=0;
                    System.out.println();
                }else
                    for (int k = 0; k < nBlanks * 2 - 2; k++)
                        System.out.print(' ');
        }
        System.out.println("\n"+dots+dots);
    }
}
