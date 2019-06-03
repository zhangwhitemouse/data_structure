package myqueue;

public interface MyQueue<T> {

    int size();//判断队列长度

    boolean isEmpty();//判断队列是否为空

    T remove();//执行删除操作,若队列为空,抛出异常:NoSuchElementException
    T poll();   //出队,执行删除操作,返回队头元素,若队列为空,返回null

    boolean add(T data);    //添加成功返回true，可扩容
    boolean offer(T data);  //offer 方法可插入一个元素,这与add 方法不同，
                            //该方法只能通过抛出未经检查的异常使添加元素失败
                            //而不是出现异常的情况
    //清空队列
    void clearQueue();

}
