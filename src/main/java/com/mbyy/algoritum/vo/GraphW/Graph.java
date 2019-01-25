package com.mbyy.algoritum.vo.GraphW;


public class Graph {
    private final int MAX_VERTS=20;
    private final int INFINITY=1000000;
    private Vertex[] vertexList;
    private int adjMat[][];
    private int nVerts;
    private int nTree;
    private int currentVert;
    //最小生成树算法使用的对象
//    private PriorityQ thePQ;

    //最短路径算法需要用到的对象和变量
    private DistPar sPath[];
    private int startToCurrent;

    public Graph(){
        vertexList=new Vertex[MAX_VERTS];

        adjMat=new int[MAX_VERTS][MAX_VERTS];
        nVerts=0;
        nTree=0;
        for (int j=0;j<MAX_VERTS;j++)
            for (int k=0;k<MAX_VERTS;k++)
                adjMat[j][k]=INFINITY;
        sPath=new DistPar[MAX_VERTS];
//        thePQ=new PriorityQ();
    }

    public void addVertex(char lab){
        vertexList[nVerts++]=new Vertex(lab);
    }

    public void addEdge(int start,int end,int weight){
        adjMat[start][end]=weight;
        //最小生成树需要用到来回两个路线,而最短路径算法则不一定
//        adjMat[end][start]=weight;
    }

    public void path(){
        int startTree=0;
        vertexList[startTree].isInTree=true;
        nTree=1;
        for (int j = 0; j < nVerts; j++) {
            int tempDist=adjMat[startTree][j];
            sPath[j]=new DistPar(startTree,tempDist);
        }

        while (nTree<nVerts){
            int indexMin=getMin();
            int minDist=sPath[indexMin].distance;
            if (minDist==INFINITY){
                System.out.println("There are unreachable vertices");
                break;
            }else {
                currentVert=indexMin;
                startToCurrent=sPath[indexMin].distance;
            }

            vertexList[currentVert].isInTree=true;
            nTree++;
            adjust_sPat();
        }
        displayPaths();
    }

    public int getMin(){
        int minDist=INFINITY;
        int indexMin=0;
        for (int j = 1; j < nVerts; j++) {
            if (!vertexList[j].isInTree&&sPath[j].distance<minDist){
                minDist=sPath[j].distance;
                indexMin=j;
            }
        }
        return indexMin;
    }

    public void adjust_sPat(){
        int column=1;
        while (column<nVerts){
            if (vertexList[column].isInTree){
                column++;
                continue;
            }
            int currentToFringe=adjMat[currentVert][column];
            int startToFringe=startToCurrent+currentToFringe;
            int sPathDist=sPath[column].distance;
            if (startToFringe<sPathDist){
                sPath[column].paremntVert=currentVert;
                sPath[column].distance=startToFringe;
            }
            column++;
        }
    }

    public void displayVertex(int v){
        System.out.println(vertexList[v].label);
    }

    public void displayPaths(){
        for (int j = 0; j < nVerts; j++) {
            System.out.print(vertexList[j].label+"=");
            if (sPath[j].distance==INFINITY)
                System.out.println("inf");
            else
                System.out.print(sPath[j].distance);
            char parent=vertexList[sPath[j].paremntVert].label;
            System.out.print("("+parent+") ");
        }
        System.out.println("");
    }

//    public void mstw(){
//        currentVert=0;
//        while (nTree<nVerts-1){
//            vertexList[currentVert].isInTree=true;
//            nTree++;
//
//            for (int j = 0; j < nVerts; j++) {
//                if (j==currentVert)
//                    continue;
//                if (vertexList[j].isInTree)
//                    continue;
//                int distance=adjMat[currentVert][j];
//                if (distance==INFINITY)
//                    continue;
//                putInPQ(j,distance);
//            }
//            if (thePQ.size()==0){
//                System.out.println(" GRAPH NOT CONNECTED");
//                return;
//            }
//            Edge theEdge=thePQ.removeMin();
//            int sourceVert =theEdge.srcVert;
//            currentVert=theEdge.destVert;
//
//            System.out.print(vertexList[sourceVert].label);
//            System.out.print(vertexList[currentVert].label);
//            System.out.print(" ");
//        }
//        for (int j = 0; j < nVerts; j++)
//            vertexList[j].isInTree=false;
//
//    }
//
//    public void putInPQ(int newVert,int newDist){
//        int queueIndex=thePQ.find(newVert);
//        if (queueIndex!=-1){
//            Edge tempEdge=thePQ.peekN(queueIndex);
//            int oldDist=tempEdge.distance;
//            if (oldDist>newDist){
//                thePQ.removeN(queueIndex);
//                Edge theEdge=new Edge(currentVert,newVert,newDist);
//                thePQ.insert(theEdge);
//            }
//        }else {
//            Edge theEdge=new Edge(currentVert,newVert,newDist);
//            thePQ.insert(theEdge);
//        }
//    }

}
