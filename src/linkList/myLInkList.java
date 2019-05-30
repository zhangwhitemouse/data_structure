/*
* 实现单链表的接口，包含着基本功能
*   判断是否为空链表
*   获取链表长度
*   根据索引找到指定位置的节点
*   往链表指定位置添加元素
*   删除链表指定位置的元素
*   遍历链表
* */

package linkList;

public interface myLInkList<T> {

    boolean isEmpty();

    int length();

    Node<T> getNode(int index);

    void addNode(T value);

    void addNode(int index,T value);

    void delNode(int index);

    void traverse();

}
