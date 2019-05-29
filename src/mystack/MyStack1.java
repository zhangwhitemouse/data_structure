package mystack;

import java.io.Serializable;
import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * @author Linzhang
 * @Description TODO    栈的具体实现
 * @Date 10:22 2019/5/19
 * @Version 1.0
 *
 * 为了保证不同Java编译器实现之间的一致的serialVersionUID值，
 * 一个可序列化的类必须声明一个显式的serialVersionUID值。
 * 还强烈建议，显式的serialVersionUID声明在可能的情况下使用private修饰符，
 * 因为这种声明仅适用于立即声明的类 - serialVersionUID字段作为继承成员无效。
 *
 * 序列化的作用就是为了不同JVM之间共享实例对象的一种解决方案
 * 什么时候需要序列化：
 *  内存中对象写入硬盘中（需要将对象的状态信息进行持久化）
 *  Socket网络传输的时候
 */
public class MyStack1<T> implements MyStack<T>, Serializable {

    private static final long serialVersionUID = -5413303117698554397L;
    //定义栈顶指针
    private int top = -1;
    //定义默认容量
    private int capacity = 16;
    //定义存放元素的数组
    private T[] array ;
    //定义数组长度的变量
    private int size;

    //定义构造方法
    public MyStack1() {
        array = (T[]) new Object[this.capacity];
    }

    public MyStack1(int capacity) {
        array = (T[]) new Object[capacity];
    }

    //定义一个获取数组长度的方法
    public int getSize(){
        return size;
    }

    @Override
    public String toString() {
        return "MyStack1{" +
                "top=" + top +
                ", capacity=" + capacity +
                ", array=" + Arrays.toString(array) +
                ", size=" + size +
                '}';
    }

    @Override
    public boolean isEmpty() {
        return this.top == -1;
    }

    @Override
    public void push(T data) {
        //先判断容量是否够用
        if (array.length == size){
            addCapacity(capacity*2 + 1);
        }
        //添加元素
        array[++top] = data;
        size++;
    }

    @Override
    public T peek() {
        //先要判断一下，栈是否为空
        if (isEmpty()){
            new EmptyStackException();
        }
        //返回栈顶元素
        return array[top];
    }

    @Override
    public T pop() {
        if (isEmpty()){
            new EmptyStackException();
        }
        size--;
        return array[top --];
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

        for (int i = 0;i<size;i++){
            array[i] = old[i];
        }
    }
}
