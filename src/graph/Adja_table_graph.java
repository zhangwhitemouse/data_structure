package graph;

import java.util.Scanner;

/**
 * @author Linzhang
 * @Description TODO    以邻接表的形式实现图  数组+链表
 * @Date 8:59 2019/6/17
 * @Version 1.0
 */

//图的实现类
public class Adja_table_graph {
    //无向图
    private int verNum;         //有多少个顶点
    private int edgeNum;        //有多少条边
    private Vertex[] vertexarr;    //存放顶点的数组

    //构造函数
    public Adja_table_graph(int verNum,int edgeNum) {
        vertexarr = new Vertex[verNum];
        Scanner sc = new Scanner(System.in);
        for (int i=0;i<verNum;i++){
            System.out.println("请输入第"+(i+1)+"个节点名");
            Vertex vertex = new Vertex();
            vertex.verName = sc.nextLine();//节点名给每个节点
            vertex.firstvex = null;
            vertexarr[i] = vertex;
        }

        System.out.println("请按 头节点 权值 指向节点 的形式输入边的信息");
        for (int i=0;i<edgeNum;i++){
            String preName = sc.next();
            int weight1 = sc.nextInt();
            String lastName = sc.next();

            Vertex prev = getVertex(preName);
            Vertex last = getVertex(lastName);

            if (prev ==null||last == null){
                System.out.println("输入错误，不存在该顶点");
                i--;
                continue;
            }

            //给边上的属性赋值
            Edge edge = new Edge();
            edge.tailName = lastName;
            edge.weight = weight1;
            //将顶点与边的节点相连接
            edge.nextEdge = prev.firstvex;
            prev.firstvex = edge;
        }
    }

    //根据节点名称获取节点
    public Vertex getVertex(String vername){
        for (int i=0;i<verNum;i++){
            if (vertexarr[i].verName.equals(vername)){
                return vertexarr[i];
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Adja_table_graph graph = new Adja_table_graph(3,3);
    }
}

//边类
class Edge{
    String tailName;     //被边连接起来的另一个节点的名字
    int weight;     //边的权重
    Edge nextEdge;  //下一条边的位置
}

//节点类
class Vertex{
    String verName; //节点的名字
    Edge firstvex;  //边链表的头指针
}

