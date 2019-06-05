package Interview_question;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Linzhang
 * @Description TODO 两个队列实现栈
 * @Date 8:36 2019/6/5
 * @Version 1.0
 */
public class TwoQueueStack<T> {
    private Queue<T> queue1;
    private Queue<T> queue2;

    public TwoQueueStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }
    //向栈中压入元素
    public T push(T t){
        if (queue1.size() !=0){
            queue1.add(t);
        }else if (queue2.size() !=0){
            queue2.add(t);
        }else{
            queue1.add(t);
        }
        return t;
    }

    //弹出栈中的元素
    public T pop(){
        T res = null;
        if (queue1.size() ==0 && queue2.size() ==0){
            return null;
        }

        if (queue1.size() != 0){
            while (queue1.size() !=0){
                res = queue1.poll();
                if (queue1.size() != 0){
                    queue2.add(res);
                }
            }
        }else{
            while (queue2.size() != 0){
                res = queue2.poll();
                if (queue2.size() != 0){
                    queue1.add(res);
                }
            }
        }
        return res;
    }
    //测试功能
    public static void main(String[] args) {
        TwoQueueStack twoQueueStack = new TwoQueueStack();

        twoQueueStack.push("123");
        twoQueueStack.push("456");
        twoQueueStack.push("789");

        System.out.println(twoQueueStack.pop());
        System.out.println(twoQueueStack.pop());

        twoQueueStack.push("888");
        System.out.println(twoQueueStack.pop());
        System.out.println(twoQueueStack.pop());
    }
}
