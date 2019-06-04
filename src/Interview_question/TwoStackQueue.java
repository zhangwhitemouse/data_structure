package Interview_question;

import java.util.Stack;

/**
 * @author Linzhang
 * @Description TODO    两个栈实现一个队列
 * @Date 10:54 2019/6/4
 * @Version 1.0
 */
public class TwoStackQueue<T> {
    private Stack<T> stack1;
    private Stack<T> stack2;

    public TwoStackQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    //往栈中压入元素
    public Boolean add(T t){
        stack1.push(t);
        return true;
    }

    //返回队列头部的值，但是不删除
    public T peek(){
        if (stack1.isEmpty() && stack2.isEmpty()){
            return null;
        }

        if (stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.add(stack1.pop());
            }
        }
        return stack2.peek();
    }

    //返回队列头部的值，并去除该元素
    public T poll(){
        if (stack1.isEmpty() && stack2.isEmpty()){
            return null;
        }
        if (stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.add(stack1.pop());
            }
        }
        return stack2.pop();
    }

    //测试一下队列的功能
    public static void main(String[] args) {
        TwoStackQueue twoStackQueue = new TwoStackQueue();

        twoStackQueue.add("1");
        twoStackQueue.add("2");
        twoStackQueue.add("3");
        twoStackQueue.add("4");

        System.out.println(twoStackQueue.poll());
        System.out.println(twoStackQueue.poll());
    }
}
