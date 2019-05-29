package mystack;

/**
 * @author Linzhang
 * @Description TODO  栈的功能测试
 * @Date 9:18 2019/5/27
 * @Version 1.0
 */
public class myStack_test {
    public static void main(String[] args) {
        MyStack1 stack1 = new MyStack1();
        System.out.println(stack1.isEmpty());

        stack1.push("123456");
        stack1.push("123");
        stack1.push("1");

        System.out.println(stack1);
        System.out.println(stack1.getSize());

        System.out.println(stack1.peek());
        System.out.println(stack1.pop());
    }
}
