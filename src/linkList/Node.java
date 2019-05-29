package linkList;

/**
 * @author Linzhang
 * @Description TODO    定义一个节点类
 * @Date 9:25 2019/5/20
 * @Version 1.0
 */
public class Node<T> {
    public T data;          //数据域
    public Node<T> next;    //指向下一个节点引用

    public Node() {
    }

    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }

    public Node(Node<T> next) {
        this.next = next;
    }

    public Node(T data) {
        this.data = data;
    }
}


