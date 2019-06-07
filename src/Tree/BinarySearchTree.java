package Tree;

/**
 * @author Linzhang
 * @Description TODO 二叉搜索树的实现（查找、插入、删除）
 * @Date 10:13 2019/6/7
 * @Version 1.0
 */
public class BinarySearchTree {
    private BinarySearchTree leftnode;
    private BinarySearchTree rightnode;
    private String data;
    //构造方法
    public BinarySearchTree() {
    }

    public BinarySearchTree(BinarySearchTree leftnode, BinarySearchTree rightnode, String data) {
        this.leftnode = leftnode;
        this.rightnode = rightnode;
        this.data = data;
    }

    public BinarySearchTree(String data) {
        this.data = data;
    }

    //查找节点是否存在
    public boolean FindNode(BinarySearchTree node,Integer val){
        if (node != null){
            if (val < Integer.valueOf(node.data) && node.leftnode != null){
                return node.leftnode.FindNode(node.leftnode,val);
            }

            if (val > Integer.valueOf(node.data) && node.rightnode != null){
                return node.rightnode.FindNode(node.rightnode,val);
            }

            return val == Integer.valueOf(node.data);
        }
        return false;
    }

    //插入节点
    public void InsertNode(BinarySearchTree node,String value){

    }
}
