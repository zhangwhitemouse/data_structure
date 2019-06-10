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
    public void InsertNode(BinarySearchTree node,Integer value){
        if (node != null){
            if (value <= Integer.valueOf(node.data) && node.leftnode !=null){
                node.leftnode.InsertNode(node.leftnode,value);
            }else if (value <= Integer.valueOf(node.data)){
                node.leftnode = new BinarySearchTree(String.valueOf(value));
            }else if (value > Integer.valueOf(node.data) &&node.rightnode != null){
                node.rightnode.InsertNode(node.rightnode,value);
            }else{
                node.rightnode = new BinarySearchTree(String.valueOf(value));
            }
        }
    }

    //删除节点
    //1 当前节点没有子节点
    //2 当前节点有一个子节点
    //3 当前节点有两个子节点
    public boolean removeNode(BinarySearchTree node, Integer value, BinarySearchTree parent) {
        if (node != null) {
            if (value < Integer.valueOf(node.data) && node.leftnode != null) {
                return node.leftnode.removeNode(node.leftnode, value, node);
            } else if (value < Integer.valueOf(node.data)) {
                return false;
            } else if (value > Integer.valueOf(node.data) && node.rightnode != null) {
                return node.rightnode.removeNode(node.rightnode, value, node);
            } else if (value > Integer.valueOf(node.data)) {
                return false;
            } else {
                if (node.leftnode == null && node.rightnode == null && node == parent.leftnode) {
                    parent.leftnode = null;
                    node.clearNode(node);
                } else if (node.leftnode == null && node.rightnode == null && node == parent.rightnode) {
                    parent.rightnode = null;
                    node.clearNode(node);
                } else if (node.leftnode != null && node.rightnode == null && node == parent.leftnode) {
                    parent.leftnode = node.leftnode;
                    node.clearNode(node);
                } else if (node.leftnode != null && node.rightnode == null && node == parent.rightnode) {
                    parent.rightnode = node.leftnode;
                    node.clearNode(node);
                } else if (node.rightnode != null && node.leftnode == null && node == parent.leftnode) {
                    parent.leftnode = node.rightnode;
                    node.clearNode(node);
                } else if (node.rightnode != null && node.leftnode == null && node == parent.rightnode) {
                    parent.rightnode = node.rightnode;
                    node.clearNode(node);
                } else {
                    node.data=String.valueOf(node.rightnode.findMinValue(node.rightnode));
                    node.rightnode.removeNode(node.rightnode,Integer.valueOf(node.rightnode.data),node);
                }
                return true;
            }
        }
        return false;
    }

    //清除节点
    public void clearNode(BinarySearchTree node) {
        node.data = null;
        node.leftnode = null;
        node.rightnode = null;
    }
    //找到最小的节点值
    public Integer findMinValue(BinarySearchTree node) {
        if (node != null) {
            if (node.leftnode != null) {
                return node.leftnode.findMinValue(node.leftnode);
            } else {
                return Integer.valueOf(node.data);
            }
        }
        return null;
    }
}
