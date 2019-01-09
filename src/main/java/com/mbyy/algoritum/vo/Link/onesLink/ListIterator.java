package com.mbyy.algoritum.vo.Link.onesLink;


//迭代器
public class ListIterator {
    private Link current;    //表示对当前链节点的引用
    private Link previous;
    private LinkedList outList;

    public ListIterator(LinkedList list){
        outList=list;
        reset();
    }

    public void reset(){    //把迭代器放在表头
        current=outList.getFirst();
        previous=null;
    }

    public boolean atEnd(){     //判断迭代器是否迭代完
        return (current.next==null);
    }

    public void nextLink(){     //把迭代器移动到下一个链接点
        previous=current;
        current=current.next;
    }

    public Link getCurrent(){
        return current;
    }

    public void insertAfter(int id,double dd){
        Link newLink=new Link(id,dd);
        if (outList.isEmpty()){
            outList.setFirst(newLink);
            current=newLink;
        }else {
            newLink.next=current.next;
            current.next=newLink;
            nextLink();
        }
    }


    public void insertBefore(int id,double dd){
        Link newLink=new Link(id,dd);
        if (previous==null){
           newLink.next=outList.getFirst();
           outList.setFirst(newLink);
           reset();
        }else {
            newLink.next=previous.next;
            previous.next=newLink;
            current=newLink;
        }
    }

    public long deleteCurrent(){
        int value=current.iData;
        if (previous==null){
            outList.setFirst(current.next);
            reset();
        }else {
            previous.next=current.next;
            if (atEnd())
                reset();
            else
                current=current.next;
        }
        return value;
    }

}
