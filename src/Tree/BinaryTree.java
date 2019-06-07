package Tree;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Linzhang
 * @Description TODO   常规二叉树的实现(插入节点和遍历节点)
 * @Date 9:52 2019/6/6
 * @Version 1.0
 */
public class BinaryTree {
    private BinaryTree leftnode;
    private BinaryTree rightnode;
    private String data;
    //构造方法
    public BinaryTree() {
    }

    public BinaryTree(BinaryTree leftnode, BinaryTree rightnode, String data) {
        this.leftnode = leftnode;
        this.rightnode = rightnode;
        this.data = data;
    }

    public BinaryTree(String data) {
        this.data = data;
    }

    //插入节点
    //插入左节点
    public void insertleft(BinaryTree node,String value){
        if (node != null){
            //当前节点不存在左节点
            if (node.leftnode == null){
                node.leftnode = new BinaryTree(value);
            }else {
                //当前节点有左节点
                BinaryTree newnode = new BinaryTree(value);
                newnode.leftnode = node.leftnode;
                node.leftnode = newnode;
            }
        }

    }
    //插入右节点
    public void insertright(BinaryTree node,String value){
        if (node != null){
            //当前节点不存在右节点
            if (node.rightnode == null){
                node.rightnode = new BinaryTree(value);
            }else {
                //当前节点有右节点
                BinaryTree newnode = new BinaryTree(value);
                newnode.rightnode = node.rightnode;
                node.rightnode = newnode;
            }
        }

    }

    //树的遍历
    //1 深度优先DFS
        //前序遍历
    public void PreOrder(BinaryTree node){
         if (node != null){
             System.out.println(node.data);

             if (node.leftnode != null){
                 node.leftnode.PreOrder(node.leftnode);
             }

             if (node.rightnode != null){
                 node.rightnode.PreOrder(node.rightnode);
             }
         }
    }
        //中序遍历
    public void InOrder(BinaryTree node){
        if (node != null){
            if (node.leftnode != null){
                node.leftnode.InOrder(node.leftnode);
            }

            System.out.println(node.data);

            if (node.rightnode != null){
                node.rightnode.InOrder(node.rightnode);
            }
        }
    }
        //后序遍历
    public void PostOrder(BinaryTree node){
        if (node != null){
            if (node.leftnode != null){
                node.leftnode.PostOrder(node.leftnode);
            }

            if (node.rightnode != null){
                node.rightnode.PostOrder(node.rightnode);
            }

            System.out.println(node.data);
        }
    }
    //2 广度优先BFS
    public void BreTraverse(BinaryTree node){
        if (node != null){
            Queue<BinaryTree> queue = new ArrayDeque<>();
            queue.add(node);

            while (!queue.isEmpty()){
                BinaryTree cur_node = queue.poll();
                System.out.println(cur_node.data);

                if (cur_node.leftnode != null){
                    queue.add(cur_node.leftnode);
                }

                if (cur_node.rightnode !=null){
                    queue.add(cur_node.rightnode);
                }
            }
        }
    }


    //测试树
    public static void main(String[] args) {
        BinaryTree node = new BinaryTree("1");

        node.insertleft(node,"2");
        node.insertright(node,"5");

        BinaryTree node2 = node.leftnode;
        node2.insertright(node2,"4");
        node2.insertleft(node2,"3");

        BinaryTree node5 = node.rightnode;
        node5.insertleft(node5,"6");
        node5.insertright(node5,"7");

/*        node.PreOrder(node);
        node.InOrder(node);
        node.PostOrder(node);*/

        node.BreTraverse(node);

    }
}
