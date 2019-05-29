package mystack;

public interface MyStack<T> {
    /*
    * 判断栈是否为空
    * */
    boolean isEmpty();
    /*
    * 往栈里添加数据
    * */
    void push(T data);
    /*
    * 返回栈顶元素，不出栈
    * */
    T peek();
    /*
    * 返回栈顶元素，出栈
    * */
    T pop();
}
