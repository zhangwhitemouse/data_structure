package linkList;


/**
 * @author Linzhang
 * @Description TODO    单向链表基本功能的实现
 * @Date 9:33 2019/5/20
 * @Version 1.0
 */
public class LinkList<T> implements myLInkList<T>{
    Node head ;
    Node current ;
    int size;

    //构造方法初始化
    public LinkList() {
        head = new Node();
    }

    @Override
    public boolean isEmpty() {
        return head.next == null;
    }

    @Override
    public int length() {
        return size;
    }

    @Override
    public void addNode(T value) {
        Node newnode = new Node(value);
        current = head;
        while (current.next != null){
            current = current.next;
        }
        current.next = newnode;
        size++;
    }

    @Override
    public Node<T> getNode(int index) {
        int len = 1;
        current = head;
        if (index < 1||index > size){
            throw new IndexOutOfBoundsException("索引越界");
        }
        while (current.next != null){
            if (index == len++){
                return current;
            }
            current = current.next;
        }
        return current; //返回的是第index个节点的前一个节点
    }

    @Override
    public void addNode(int index, T value) {
        Node newnode = new Node(value);
        if (index < 1 ||index >size){
            throw new IndexOutOfBoundsException("索引越界");
        }
        current = getNode(index);
        newnode.next = current.next;
        current.next = newnode;
        size++;
    }

    @Override
    public void delNode(int index) {
        if (index < 1 ||index >size){
            throw new IndexOutOfBoundsException("索引越界");
        }
        current = getNode(index);
        current.next = current.next.next;
        size--;
    }

    @Override
    public void traverse() {
        Node current = head.next;
        while (current != null){
            System.out.println("节点数据为" + current.data);
            current = current.next;
        }
    }

    //下面都是一些拓展功能
    //1 判断是否是循环链表
    public boolean isCircular(){
        current = getNode(size);
        Node lastNode = current.next;
        return lastNode.next == head;
    }

    //2 单链表的反转（递归实现）
    public static Node reverse(Node temp){
        if (temp ==null || temp.next ==null){
            return temp;
        }

        Node firstHead = reverse(temp.next);
        temp.next = temp;
        temp.next = null;
        return firstHead;
    }

    //3 求单链表的中间节点（遍历1次）
    public Node midNode(){
        Node fast = head;
        Node slow = head;

        while (fast.next != null&&fast != null&&fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    //4 删除重复元素的节点
    public void removeNode(){
        Node firNode = head.next;
        Node secNode;

        while(firNode != null){
            secNode = firNode;

            while (secNode != null&&secNode.next != null){

                if (secNode.next.data == firNode.data){
                    //如果数值相同，则删除当前节点secNode.next
                    secNode.next = secNode.next.next;
                    secNode = secNode.next;
                }else{
                    secNode = secNode.next;
                }
            }
            firNode = firNode.next;
        }
    }
}
