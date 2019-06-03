package myqueue;

import java.util.NoSuchElementException;

/**
 * @author Linzhang
 * @Description TODO 队列的具体实现（顺序循环结构）
 * @Date 15:38 2019/5/19
 * @Version 1.0
 */
public class MyQueue1<T> implements MyQueue<T> {
    //定义成员变量
    private int front,rear;
    private int size;//默认为0
    private T array[];

    public static final int DEFAULT_SIZE = 16;

    //定义构造方法

    public MyQueue1() {
        array = (T[]) new Object[DEFAULT_SIZE];
        front=rear=0;
    }

    public MyQueue1(int capacity) {
        array = (T[]) new Object[capacity];
        front = rear = 0;
    }

    @Override
    public int size() {
        return size;
    }
    //当队头与队尾指针相同时，队列为空
    @Override
    public boolean isEmpty() {
        return front == rear;
    }

    @Override
    public T remove() {
        if (isEmpty()){
            throw new NoSuchElementException("The array is empty");
        }
        return poll();
    }
    //删除操作，队头处理
    @Override
    public T poll() {
        T temp = this.array[this.front];
        //移动队头指针
        this.front = (this.front+1)%this.array.length;
        size--;
        return temp;
    }

    @Override
    public boolean add(T data) {
        //先判断队列是否满了
        if (this.front ==(this.rear+1)%array.length){
            addCapacity(DEFAULT_SIZE*2+1);
        }
        //往队列里面添加数据
        array[this.rear] = data;
        this.rear = (this.rear + 1)%array.length;//rear指向下一个空的位置
        size++;
        return true;
    }

    @Override
    public boolean offer(T data) {
        if (data == null){
            throw new NullPointerException("The data can not be null");
        }
        if (this.front == (this.rear+1)%array.length){
            throw new IllegalArgumentException("The capacity is not use");
        }

        //往队列里面添加数据
        array[this.rear] = data;
        this.rear = (this.rear + 1)%array.length;//只要rear不超过length
        size++;
        return true;
    }

    @Override
    public void clearQueue() {
        //将每一个元素都变成null
        for (int i = this.front;i!= this.rear;i = (i+1)%array.length){
            array[i] = null;
        }

        this.front = this.rear = 0;
        size = 0;
    }

    //定义一个扩容的方法
    public void addCapacity(int capacity){
        //如果需要扩容的容量比现在的还要小，就不需要扩容了
        if (capacity<size){
            return;
        }

        //将原来栈中的元素，存放到新的栈中
        T[] old = array;
        array = (T[]) new Object[capacity];
        int j = 0;
        //复制元素
        for (int i = this.front;i!= this.rear;i = (i+1)%old.length){
            array[j++] = old[i];
        }
        this.front = 0;
        this.rear = 0;
    }
}
