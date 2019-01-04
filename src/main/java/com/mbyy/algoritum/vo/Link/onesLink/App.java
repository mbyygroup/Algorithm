package com.mbyy.algoritum.vo.Link.onesLink;

public class App {
    public static void main(String[] args) {
        LinkedList list=new LinkedList();
        list.insertFirst(22,3.89);
        list.insertFirst(23,5.13);
        list.insertFirst(66,34.5);
        list.displayList();
        Link f=list.find(44);
        if (f!=null){
            System.out.println("Fount"+f.iData);
        }else {
            System.out.println("Not found link");
        }
        Link d=list.delete(66);
//        while (!list.isEmpty()) {
//            Link aLink = list.deleteFirst();
//            System.out.println("Deleted ");
//            aLink.displayLink();
//        }
        if (d!=null){
            System.out.println("已删除"+d.iData);
        }else {
            System.out.println("Can't delete link");
        }
        list.displayList();
    }
}
