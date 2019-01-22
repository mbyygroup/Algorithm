package com.mbyy.algoritum.vo.Map;

//广度优先搜索
public class BFSApp {
    public static void main(String[] args) {
        Graph theGraph=new Graph();
        theGraph.addVertex('A');
        theGraph.addVertex('B');
        theGraph.addVertex('C');
        theGraph.addVertex('D');
        theGraph.addVertex('E');
        theGraph.addEdge(0,1);
        theGraph.addEdge(1,2);
        theGraph.addEdge(0,3);
        theGraph.addEdge(3,4);
        System.out.println("Visits:");
        theGraph.bfs();
        System.out.println();
    }
}
