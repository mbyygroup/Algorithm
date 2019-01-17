package com.mbyy.algoritum.vo.RBTree;

public class RBNode<T extends Comparable<T>> {

    public static final boolean RED=false;
    public static final boolean BLACK=true;

    boolean color; //颜色
    T key;          //关键值
    RBNode<T> left;   //左孩子
    RBNode<T> right;   //右孩子
    RBNode<T> parent;    //父节点

    public RBNode(T key,boolean color,RBNode<T> parent,RBNode<T> left,RBNode<T> right){
        this.key=key;
        this.color=color;
        this.parent=parent;
        this.left=left;
        this.right=right;
    }

    public T getKey(){
        return key;
    }

    public String toString(){
        return ""+key+(this.color==RED?"(R)":"B");
    }

}
