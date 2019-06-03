package myqueue;

/**
 * @author Linzhang
 * @Description TODO    链式结构实现队列
 * @Date 9:23 2019/6/3
 * @Version 1.0
 */
public class MyQueue2<T> implements MyQueue<T> {
    private Node head;
    private Node rear;
    private int size;

    public MyQueue2() {
        head = null;
        rear = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public T remove() {
        T temp;//临时变量
        if (isEmpty()){
            throw new NullPointerException("队列为空");
        }else{
            temp = (T) head.data;
            head = head.next;
            size--;
        }
        return temp;
    }

    @Override
    public T poll() {
        return null;
    }

    @Override
    public boolean add(T data) {
        Node newnode = new Node(data);
        if (isEmpty()){
            head = newnode;
        }else{
            rear.next = newnode;
        }
        rear = newnode;
        size++;
        return true;
    }

    @Override
    public boolean offer(T data) {
        return false;
    }

    @Override
    public void clearQueue() {//暂时还没想好怎么实现啊
    }
}
