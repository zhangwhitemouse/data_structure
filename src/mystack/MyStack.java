package mystack;
/*
* 基本功能
* 1 判断是否为空
* 2 往栈中压入元素
* 3 查看栈顶的元素，
* 4 删除栈顶的元素
* */

public interface MyStack<T> {

    boolean isEmpty();

    void push(T data);

    T peek();

    T pop();
}
