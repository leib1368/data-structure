package leib.demo.leecode2020.leetcode2010;

/**
 * @Author:Leib
 * @Date 2020/10/13 12:56
 */

public class T1013 {
    public static void main(String[] args) {
        ListNode l3 = new ListNode(3);
        ListNode l2 = new ListNode(4,l3);
        ListNode l1 = new ListNode(2,l2);

        ListNode r3 = new ListNode(4);
        ListNode r2 = new ListNode(6,r3);
        ListNode r1 = new ListNode(5,r2);

        T1013 t1013 = new T1013();
        t1013.addTwoNumbers(l1,r1);
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int carry = 0 ;
        while(l1 !=null || l2 !=null){
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 +n2 +carry;
           if (head==null){
               head = tail=  new ListNode((sum)%10);
           } else {
               tail.next =new ListNode((sum)%10);
               tail =tail.next;
           }
           carry = sum /10;

            if (l1 != null) l1 = l1.next;

            if (l2 != null) l2 = l2.next;

        }
        if (carry > 0) tail.next = new ListNode(carry);
        return head;
    }

}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
