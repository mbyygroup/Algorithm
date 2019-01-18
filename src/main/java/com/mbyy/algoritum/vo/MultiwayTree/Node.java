package com.mbyy.algoritum.vo.MultiwayTree;

public class Node {
    private static final int ORDER=4;
    private int numItems;      //节点中实际存储的数据项数目,其值一定不大于三
    private Node parent;
    private Node childArray[] = new Node[ORDER];          //子节点数组
    private DataItem itemArray[] = new DataItem[ORDER-1];     //存储数据项数组

    //把参数中的节点作为子节点,与当前节点进行连接
    public void connectChild(int childNum,Node child){
        childArray[childNum] = child;
        if (child!=null){
            child.parent=this;
        }
    }

    //断开参数确定的节点与当前节点的连接,这个节点一定是当前节点的子节点.
    public Node disconnectChild(int childNum){
        Node tempNode=childArray[childNum];
        childArray[childNum]=null;
        return tempNode;
    }

    public int insertItem(DataItem newItem){     //节点为满时插入
        numItems++;
        long newKey=newItem.dData;     //获得关键字

        for (int j = ORDER-2; j >=0 ; j--) {    //因为节点未满.所以从倒数第二项向前查找
            if (itemArray[j]==null)
                continue;
            else {
                long itsKey = itemArray[j].dData;       //获得关键字
                if (newKey < itsKey)                //插入位置在其前面
                    itemArray[j+1]=itemArray[j];        //当前数据向后移
                else {
                    itemArray[j + 1] = newItem;         //在其后位置插入
                    return j + 1;              //返回插入的位置下标
                }
            }
        }
        itemArray[0]=newItem;
        return 0;
    }

    //移除数据项,从后向前移除
    public DataItem removeItem(){
        DataItem temp=itemArray[numItems-1];
        itemArray[numItems-1]=null;
        numItems--;
        return temp;
    }

    public void displayNode(){
        for (int j = 0; j <numItems ; j++) {
            itemArray[j].displayItem();
        }
        System.out.println("/");
    }

    //获取相应的子节点
    public Node getChild(int childNum){
        return childArray[childNum];
    }

    //查找
    public int findItem(long key){
        for (int j = 0; j <ORDER-1 ; j++) {
            if (itemArray[j]==null)
                break;
            else if (itemArray[j].dData==key)
                return j;
        }
        return -1;
    }

    //获取具体的数据项
    public DataItem getItem(int index){
        return itemArray[index];
    }

    //判断该节点是否已满
    public boolean isFull(){
        return (numItems==ORDER-1)?true:false;
    }

    public int getNumItems(){
        return numItems;
    }

    //获取父节点
    public Node getParent(){
        return parent;
    }

    //判断是否是叶节点
    public boolean isLeaf(){
        return (childArray[0]==null)?true:false;
    }
}
