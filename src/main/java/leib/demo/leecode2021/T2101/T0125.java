package leib.demo.leecode2021.T2101;

/**
 * @Author:Leib
 * @Date 2021/1/25 20:33
 */
public class T0125 {
    public static void main(String[] args) {

    }

    public int regionsBySlashes(String[] grid) {
        return 0;
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
