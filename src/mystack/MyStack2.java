package mystack;


import java.util.LinkedList;

/**
 * @author Linzhang
 * @Description TODO  栈的链表实现(通过Java.util包下的LinkedList双向链表实现)
 * @Date 9:41 2019/6/2
 * @Version 1.0
 */
public class MyStack2<T> implements MyStack<T>{
    LinkedList<T> list;

    public MyStack2() {
        list = new LinkedList<T>();
    }

    @Override
    public boolean isEmpty() {
        return list.size() == 0;
    }

    @Override
    public void push(T data) {
        list.addFirst(data);
    }

    @Override
    public T peek() {
        return list.getFirst();
    }

    @Override
    public T pop() {
        return list.removeFirst();
    }
}
