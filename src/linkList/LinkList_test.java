package linkList;

/**
 * @author Linzhang
 * @Description TODO 测试链表的功能
 * @Date 9:23 2019/5/23
 * @Version 1.0
 */
public class LinkList_test {
    public static void main(String[] args) {
        LinkList linkList = new LinkList();

        System.out.println(linkList.isEmpty());
        System.out.println(linkList.length());

        linkList.addNode(1);
        linkList.addNode(2);
        linkList.addNode(3);
        linkList.addNode(4);
        System.out.println(linkList.length());
        linkList.traverse();

        System.out.println("-------------");

        linkList.addNode(2,777);
        linkList.traverse();
        System.out.println(linkList.length());

        System.out.println("-------------");

        linkList.delNode(2);
        linkList.traverse();
        System.out.println(linkList.length());

    }
}
