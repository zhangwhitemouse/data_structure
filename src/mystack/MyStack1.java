package mystack;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * @author Linzhang
 * @Description TODO    栈的具体实现（数组实现）
 * @Date 10:22 2019/6/2
 * @Version 1.0
 */
public class MyStack1<T> implements MyStack<T> {

    private int top = 0;//定义栈顶指针

    private int capacity = 16;//定义默认容量

    private T[] array ;//定义存放元素的数组


    //定义构造方法
    public MyStack1() {
        array = (T[]) new Object[this.capacity];
    }

    public MyStack1(int capacity) {
        array = (T[]) new Object[capacity];
    }

    @Override
    public String toString() {
        return "MyStack1{" +
                "top=" + top +
                ", capacity=" + capacity +
                ", array=" + Arrays.toString(array) +
                '}';
    }

    @Override
    public boolean isEmpty() {
        return this.top == 0;
    }

    @Override
    public void push(T data) {
        //先判断容量是否够用
        if (array.length == capacity){
            addCapacity(capacity*2 + 1);
        }
        //添加元素
        array[top++] = data;
    }

    @Override
    public T peek() {
        if (isEmpty()){
            throw new EmptyStackException();
        }
        return array[--top];
    }

    @Override
    public T pop() {
        if (isEmpty()){
            new EmptyStackException();
        }
        return array[top--];
    }

    //定义一个扩容的方法
    public void addCapacity(int size){
        //如果需要扩容的容量比现在的还要小，就不需要扩容了
        if (size<capacity){
            return;
        }

        //将原来栈中的元素，存放到新的栈中
        T[] old = array;
        array = (T[]) new Object[size];

        for (int i = 0;i<capacity;i++){
            array[i] = old[i];
        }
    }
}
