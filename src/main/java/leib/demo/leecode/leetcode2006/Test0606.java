package leib.demo.leecode.leetcode2006;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author:Leib
 * @Date 2020/6/6 14:10
 */
public class Test0606 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;

        System.out.println(hasCycle(l1));
    }
    public static boolean hasCycle(ListNode head) {
        Set<ListNode> nodesSeen = new HashSet<>();

        while (head != null) {
            if (nodesSeen.contains(head)) {
                return true;
            } else {
                nodesSeen.add(head);
            }
            head = head.next;
        }
        return false;
    }
}
 class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
 }