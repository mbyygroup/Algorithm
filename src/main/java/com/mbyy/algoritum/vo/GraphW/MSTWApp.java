package com.mbyy.algoritum.vo.GraphW;

public class MSTWApp {
    public static void main(String[] args) {
        Graph theGraph=new Graph();
        theGraph.addVertex('A');
        theGraph.addVertex('B');
        theGraph.addVertex('C');
        theGraph.addVertex('D');
        theGraph.addVertex('E');
//        theGraph.addVertex('F');
//        theGraph.addEdge(0,1,6);
//        theGraph.addEdge(0,3,4);
//        theGraph.addEdge(1,2,10);
//        theGraph.addEdge(1,3,7);
//        theGraph.addEdge(1,4,7);
//        theGraph.addEdge(2,3,8);
//        theGraph.addEdge(2,4,5);
//        theGraph.addEdge(2,5,6);
//        theGraph.addEdge(3,4,12);
//        theGraph.addEdge(4,5,7);
        //最小生成树
//        System.out.print("Minimum spanning tree: ");
//        theGraph.mstw();

        theGraph.addEdge(0,1,50);
        theGraph.addEdge(0,3,80);
        theGraph.addEdge(1,2,60);
        theGraph.addEdge(1,3,90);
        theGraph.addEdge(2,4,40);
        theGraph.addEdge(3,2,20);
        theGraph.addEdge(3,4,70);
        theGraph.addEdge(4,1,50);
        //最短路径问题,也可用来解决最小花费问题
        System.out.println("Shortest paths");
        theGraph.path();
        System.out.println();
    }
}
