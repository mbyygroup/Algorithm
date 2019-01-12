package com.mbyy.algoritum.vo.BinaryTree;

import java.util.Stack;

public class Tree {
    private Node root;  //根节点
    public Tree(){
        root=null;
    }
    public Node find(int key){
        Node current=root;
        while (current.iData!=key){
            if (key<current.iData){
                current=current.leftChild;
            }else {
                current=current.rightChild;
            }
            if (current==null){
                return null;
            }
        }
        return current;
    }

    public void insert(int id,double dd){
        Node newNode=new Node();
        newNode.iData=id;
        newNode.dData=dd;
        if (root==null){
            root=newNode;
        }else {
            Node current=root;
            Node parent;
            while (true){
                parent=current;
                if (id<current.iData){
                    current=current.leftChild;
                    if (current==null){
                        parent.leftChild=newNode;
                        return;
                    }
                }else {
                    current=current.rightChild;
                    if (current==null){
                        parent.rightChild=newNode;
                        return;
                    }
                }
            }
        }
    }

    //删除节点
    public boolean delete(int key){
        Node current=root;
        Node parent=root;
        boolean isLeftChild=true;
        while (current.iData!=key){
            parent=current;
            if (key<current.iData){
                isLeftChild=true;
                current=current.leftChild;
            }else {
                isLeftChild=false;
                current=current.rightChild;
            }

            if (current==null){
                return false;
            }
        }
        //情况一：删除没有子节点的节点
        //找到节点后判断是否有子节点，如果没有子节点再检查是不是根
        //如果是根的话，把它变为null，这样就清空了整棵树，否则就把
        //父节点的leftChild或者rightChild变为null，断开父节点和那个要删除节点的连接
        if (current.leftChild==null&&current.rightChild==null){
            if (current==root){
                root=null;
            }else if (isLeftChild){
                parent.leftChild=null;
            }else {
                parent.rightChild = null;
            }
        }else if(current.rightChild==null){
            //情况二：删除有一个子节点的节点
            //只需要断开连向子树的旧的引用，建立新的引用即可。虽然子树中可能有很多节点
            // ，但不需要担心一个个的移动他们。程序只是修改了子树的根的引用
            if (current==root){
                root=current.leftChild;
            }else if (isLeftChild){
                parent.leftChild=current.leftChild;
            }else {
                parent.rightChild=current.leftChild;
            }
        }else if(current.leftChild==null){
            if (current==root){
                root=current.rightChild;
            }else if (isLeftChild){
                parent.leftChild=current.rightChild;
            }else {
                parent.rightChild=current.rightChild;
            }
        }else {
            //第三种情况：删除有两个子节点的节点
            //解决方案：先找到后继节点，然后指向新的引用，
            Node successor=getSuccessor(current);
            if (current==root){
                root=successor;
            }else if (isLeftChild){
                parent.leftChild=successor;
            }else {
                parent.rightChild=successor;
            }
            successor.leftChild=current.leftChild;
        }
        return true;

    }

    //找到后继节点
    private Node getSuccessor(Node delNode){
        Node successorParent=delNode;
        Node successor=delNode;
        Node current=delNode.rightChild;
        while (current!=null){
            successorParent=successor;
            successor=current;
            current=current.leftChild;
        }
        if (successor!=delNode.rightChild){
            successorParent.leftChild=successor.rightChild;
            successor.rightChild=delNode.rightChild;
        }
        return successor;
    }

    //返回最小关键字
    public int minimum(){
        Node node=root;
        while (node.leftChild!=null){
            node=node.leftChild;
        }
        return node.iData;
    }

    //返回最大关键字
    public int maxmum(){
        Node node=root;
        while (node.rightChild!=null){
            node=node.rightChild;
        }
        return node.iData;
    }

    //中序遍历    只会遍历当前和子元素
    public void inOrder(Node localRoot){
        if (localRoot!=null){
            inOrder(localRoot.leftChild);
            System.out.print(localRoot.iData+" ");
            inOrder(localRoot.rightChild);
        }
    }


}
