package com.mbyy.algoritum.vo.Map;

public class Graph {
    private final int MAX_VERTS=20;
    private Vertex vertexList[];
    private int adjMat[][];
    private int nVerts;
    private StackX theStack;
    private Queue theQueue;
    private char sortedArray[];

    public Graph(){
        vertexList=new Vertex[MAX_VERTS];
        adjMat=new int[MAX_VERTS][MAX_VERTS];
        nVerts=0;
        for (int j = 0; j < MAX_VERTS; j++)
            for (int k = 0; k < MAX_VERTS; k++)
                adjMat[j][k]=0;
        theStack=new StackX();
        theQueue=new Queue();
        sortedArray=new char[MAX_VERTS];
    }

    public void addVertex(char lab){
        vertexList[nVerts++]=new Vertex(lab);
    }

    public void addEdge(int start,int end){
        adjMat[start][end]=1;           //只添加一个矩阵节点值的是有向图,添加两个为无向图
//        adjMat[end][start]=1;
    }

    public void displayVertex(int v){
        System.out.print(vertexList[v].label);
    }

    //深度优先搜索
    public void dfs(){
        vertexList[0].wasVisited=true;
        displayVertex(0);
        theStack.push(0);
        while (!theStack.isEmpty()){
            int v=getAdjUnvisitedVertex(theStack.peek());
            if (v==-1){
                theStack.pop();
            }else {
                vertexList[v].wasVisited=true;
                displayVertex(v);
                theStack.push(v);
            }
        }

        for (int j = 0; j < nVerts; j++) {
            vertexList[j].wasVisited=false;
        }
    }

    public int getAdjUnvisitedVertex(int v){
        for (int j = 0; j < nVerts; j++) {
            if (adjMat[v][j]==1&&vertexList[j].wasVisited==false)
                return j;
        }
        return -1;
    }

    //广度优先搜索
    public void bfs(){
        vertexList[0].wasVisited=true;
        displayVertex(0);
        theQueue.insert(0);
        int v2;
        while (!theQueue.isEmpty()){
            int v1=theQueue.remove();
            while ((v2=getAdjUnvisitedVertex(v1))!=-1) {
                vertexList[v2].wasVisited = true;
                displayVertex(v2);
                theQueue.insert(v2);
            }
        }

        for (int j = 0; j < nVerts; j++) {
            vertexList[j].wasVisited=false;
        }
    }

    //最小生成树
    public void mst(){
        vertexList[0].wasVisited=true;
        theStack.push(0);
        while (!theStack.isEmpty()){
            int currentVertex=theStack.peek();
            int v=getAdjUnvisitedVertex(currentVertex);
            if (v==-1){
                theStack.pop();
            }else{
                vertexList[v].wasVisited=true;
                theStack.push(v);
                displayVertex(currentVertex);
                displayVertex(v);
                System.out.print(" ");
            }
        }
        for (int j = 0; j < nVerts; j++) {
            vertexList[j].wasVisited=false;
        }
    }

    //拓扑算法
    public void topo(){
        int orig_nVerts=nVerts;
        while (nVerts>0){
            int currentVertex=noSuccessors();
            if (currentVertex==-1){
                System.out.println("Error:Graph has cycles");
                return;
            }
            sortedArray[nVerts-1]=vertexList[currentVertex].label;
            deleteVertex(currentVertex);
        }

        System.out.print("Topologically sorted order: ");
        for (int j = 0; j < orig_nVerts; j++)
            System.out.print(sortedArray[j]);
        System.out.println("");
    }

    public int noSuccessors(){
        boolean isEdge;
        for (int row=0;row<nVerts;row++){
            isEdge=false;
            for (int col = 0; col < nVerts; col++) {
                if (adjMat[row][col]>0){
                    isEdge=true;
                    break;
                }
            }
            if (!isEdge)
                return row;
        }
        return -1;
    }

    public void deleteVertex(int delVert){
        if (delVert!=nVerts-1){
            for (int j = delVert; j < nVerts - 1; j++)
                vertexList[j]=vertexList[j+1];
            for (int row = delVert; row <nVerts-1 ; row++)
                moveRowUp(row,nVerts);
            for (int col=delVert;col<nVerts-1;col++)
                moveColLeft(col,nVerts-1);
        }
        nVerts--;
    }

    private void moveRowUp(int row,int length){
        for (int col = 0; col < length; col++)
            adjMat[row][col]=adjMat[row++][col];
    }

    private void moveColLeft(int col,int length){
        for(int row=0;row<length;row++)
            adjMat[row][col]=adjMat[row][col+1];
    }
}
