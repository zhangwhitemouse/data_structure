package mystack;

/**
 * @author Linzhang
 * @Description TODO  栈的功能测试
 * @Date 9:18 2019/6/2
 * @Version 1.0
 */
public class myStack_test {
    public static void main(String[] args) {
        MyStack1 stack1 = new MyStack1();
        System.out.println(stack1.isEmpty());

        stack1.push("1");
        stack1.push("2");
        stack1.push("3");
        stack1.push("4");

        System.out.println(stack1);

        System.out.println(stack1.peek());

        System.out.println(stack1.pop());
        System.out.println(stack1.pop());

    }
}
