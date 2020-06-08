package leib.demo.leecode.leetcode2004;

/**
 * @Author:Leib
 * @Date 2020/4/27 12:53
 */
public class Test0427_2 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next= node2 ;
        node2.next= node3 ;
        node3.next= node4 ;
        //reverseListDigui(node1);
        //reverseListDiedai(node1);
        reverseBetween(node1,2,3);
    }
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            //记录当前节点的下一个节点
            ListNode nextTemp = curr.next;
            //然后将当前节点指向pre
            curr.next = prev;

            //pre和cur节点都前进一位
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
    public static ListNode reverseListDigui(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseListDigui(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
    public static ListNode reverseListDiedai(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            //记录当前节点的下一个节点
            ListNode nextTemp = curr.next;
            //然后将当前节点指向pre
            curr.next = prev;

            //pre和cur节点都前进一位
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

}
