package leib.loopNode;

/**
 * @Author:Leib
 * @Date 2020/4/14 16:01
 */
public class TestDoubleNode {
    public static void main(String[] args) {
        DoubleNode n1 = new DoubleNode(1);
        DoubleNode n2 = new DoubleNode(2);
        DoubleNode n3 = new DoubleNode(3);
        DoubleNode n4 = new DoubleNode(4);

        System.out.println(n1.data);
        System.out.println(n1.pre.data);
        System.out.println(n1.next.data);

        n1.after(n2);
        System.out.println(n1.data);
        System.out.println(n1.pre.data);
        System.out.println(n1.next.data);

        n2.after(n3);
        System.out.println(n1.data);
        System.out.println(n1.pre.data);
        System.out.println(n1.next.data);
    }
}
