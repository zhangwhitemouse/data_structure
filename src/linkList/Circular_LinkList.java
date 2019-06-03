package linkList;

/**
 * @author Linzhang
 * @Description TODO 循环链表的实现，也就是和单链表的判断条件不一样
 * @Date 10:17 2019/5/24
 * @Version 1.0
 */
public class Circular_LinkList<T> implements myLInkList<T>{
    Node head;
    Node current;
    int size;

    public Circular_LinkList() {
        head = new Node();
        head.next = head;//头节点指向自己
    }

    @Override
    public boolean isEmpty() {
        return head.next == head;
    }

    @Override
    public int length() {
        return size;
    }
    //尾节点增加节点
    @Override
    public void addNode(T value) {
        Node newnode = new Node(value);
        current = head;
        while (current.next != head){
            current = current.next;
        }
        newnode.next = current.next;
        current.next = newnode;
        size++;
    }

    @Override
    public Node<T> getNode(int index) {
        current = head;
        int len = 1;
        if (index< 1||index > size){
            throw new IndexOutOfBoundsException("索引越界");
        }

        while (current.next != head){
            if (index == len ++){
                return current;
            }
            current = current.next;
        }
        return current;//拿的是index前一个节点
    }

    @Override
    public void addNode(int index, T value) {
        if (index < 1||index > size){
            throw new IndexOutOfBoundsException("索引越界");
        }
        Node newnode = new Node(value);
        current = getNode(index);
        newnode.next = current.next;
        current.next = newnode;
        size++;
    }

    @Override
    public void delNode(int index) {
        if (index <1||index>size){
            throw new IndexOutOfBoundsException("索引越界");
        }
        current = getNode(index);
        current.next = current.next.next;
        size--;
    }

    @Override
    public void traverse() {
        current = head.next;
        while (current != head){
            System.out.println("数据为"+ current.data);
            current = current.next;
        }
    }
}
