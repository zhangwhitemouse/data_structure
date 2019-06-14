package graph;

import java.util.ArrayList;

/**
 * @author Linzhang
 * @Description TODO  以邻接矩阵的形式实现图的基本功能
 * @Date 9:24 2019/6/14
 * @Version 1.0
 */
public class Matrix_graph {
    //定义一个数组来存储顶点
    private ArrayList vertexList;
    //定义一个二维数组来存储边
    private int [][] edges;
    //定义边的数目
    private int numOfEdge;


    //构造方法初始化
    public Matrix_graph(int n) {    //n代表这个图有多少个顶点
        edges =new int[n][n];
        vertexList = new ArrayList(n);
        numOfEdge = 0;
    }

    //计算整个图的顶点数目
    public int getNumOfVertex(){
        return vertexList.size();
    }

    //计算整个图边的数目
    public int getNumOfEdge(){
        return numOfEdge;
    }

    //返回顶点i的数据
    public Object getValueByIndex(int i){
        return vertexList.get(i);
    }

    //返回两个顶点之间的边
    public int getWeight(int v1,int v2){
        return edges[v1][v2];
    }

    //插入顶点
    public void insertVertex(Object vertex){
        vertexList.add(vertexList.size(),vertex);
    }

    //插入边
    public void insertEdge(int v1,int v2,int weight){
        edges[v1][v2]= weight;
        numOfEdge++;
    }

    //删除边
    public void delEdge(int v1,int v2){
        edges[v1][v2] = 0;
        numOfEdge--;
    }

    //根据某个顶点，找到它的第一个邻接顶点下标
    public int getFirstNeighbor(int index){
        for (int j = 0;j<vertexList.size();j++){
            if (edges[index][j]>0){
                return j;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Matrix_graph graph = new Matrix_graph(4);

        //给这个图插入顶点
        String[] labels = {"v1","v2","v3","v4"};
        for (int i = 0;i<labels.length;i++){
            graph.insertVertex(labels[i]);
        }

        //插入4条边
        graph.insertEdge(0,1,2);
        graph.insertEdge(0,2,5);
        graph.insertEdge(2,3,8);
        graph.insertEdge(3,0,7);

        System.out.println("边数为"+graph.getNumOfEdge());
        System.out.println("顶点数为"+graph.getNumOfVertex());

        graph.delEdge(0,1);
        System.out.println("边数为"+graph.getNumOfEdge());

    }
}
