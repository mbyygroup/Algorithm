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
        trickleUp(currentSize++);        //从底加入这个节点,并通过上浮来安排到正确的位置上
        return true;
    }

    public void trickleUp(int index){
        int parent=(index-1)/2;        //找到父节点下标
        Node bottom=heapArray[index];        //找到新添加入的节点元素
        while (index>0&&heapArray[parent].getKey()<bottom.getKey()){       //比对元素
            heapArray[index]=heapArray[parent];     //如果父节点的值小于新加入的节点,那么就要进行交换.这里不
            index=parent;                           //是直接采用的交换,而是把子节点的值更换父节点的值,一直向
            parent=(parent-1)/2;                    //上遍历直到条件不满足,当前节点值更换为新加入的节点的值
        }
        heapArray[index]=bottom;    //在当前下标处直接加入
    }

    public Node remove(){
        Node root=heapArray[0];                   //得到优先级最高的节点
        heapArray[0]=heapArray[--currentSize];         //把优先级最高的节点替换为最后一个节点
        trickleDown(0);                //从当前节点下沉,并使得合适的节点上浮以形成新的堆头
        return root;
    }

    public void trickleDown(int index){
        int largerChild;
        Node top=heapArray[index];               //创建一个节点,值为当前节点
        while (index<currentSize/2){              //如果不是底
            int leftChild=2*index+1;
            int rightChild=leftChild+1;            //找到左孩子和右孩子
            if (rightChild<currentSize&&heapArray[leftChild].getKey()<heapArray[rightChild].getKey()){
                largerChild=rightChild;          //如果右孩子不是最后一个元素并且左孩子小于右孩子.那么右孩子就是更大的节点
            }else {
                largerChild=leftChild;           //否则左孩子就是更大的节点
            }
            if (top.getKey()>=heapArray[largerChild].getKey()){
                break;                      //如果当前节点的值比两个孩子都大则退出
            }
            heapArray[index]=heapArray[largerChild];        //否则交换当前节点和更大节点的值
            index=largerChild;
        }
        heapArray[index]=top;          //当前值不改变
    }

    public boolean change(int index,int newValue){
        if (index<0||index>=currentSize){    //先辨别下表是否合法
            return false;
        }
        int oldValue=heapArray[index].getKey();      //得到老值
        heapArray[index].setKey(newValue);          //赋值新值
        if (oldValue<newValue){                      //比对两个值
            trickleUp(index);                       //上调新值
        }else {
            trickleDown(index);                     //下调新值
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

        //这里已经经过排序,所以下标0的位置就是优先级最高的
        while (currentSize>0){
            if (column==0)
                for (int k = 0; k < nBlanks; k++)
                    System.out.print(' ');          //开头打印空格
                System.out.print(heapArray[j].getKey());
                if (++j==currentSize)
                    break;

                if (++column==itemsPerRow){
                    nBlanks/=2;           //缩小间隔
                    itemsPerRow *=2;       //当前行最大个数×2
                    column=0;               //让下一行从第一个数字位置开始
                    System.out.println();
                }else
                    for (int k = 0; k < nBlanks * 2 - 2; k++)
                        System.out.print(' ');        //结尾打印空格来模拟树的形状
        }
        System.out.println("\n"+dots+dots);
    }

    public void displayArray(){
        for (int j = 0; j < maxSize; j++) {
            System.out.print(heapArray[j].getKey()+" ");
        }
        System.out.println("");
    }

    public void insertAt(int index,Node newNode){
        heapArray[index]=newNode;
    }

    public void incrementSize(){
        currentSize++;
    }
}
