package leib.leetcode0204;

/**
 * @Author:Leib
 * @Date 2020/4/24 11:26
 * 反转链表
 */
public class Test0424_1 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(4);
        node1.next= node2 ;
        node2.next= node3 ;
        System.out.println(isPalindrome(node1));
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */

    public static boolean isPalindrome(ListNode head) {

        ListNode mid = findMidNode(head);
        ListNode behindList = reverseLinked(mid.next);

        ListNode curr1 = head;
        ListNode curr2 = behindList;

        boolean flag = true;
        while(flag && curr2 != null){
            if(curr1.val != curr2.val) {
                flag = false;
            }
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        return flag;
    }

    /* 反转链表 */
    private static ListNode reverseLinked(ListNode head){
        ListNode cur = head;
        ListNode prev = null;
        while(cur != null){
            ListNode nextTemp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nextTemp;
        }
        return prev;
    }

    /*
    快慢指针寻找中间节点
    */

    private static ListNode findMidNode(ListNode head){
        ListNode fast = head;
        ListNode low = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            low = low.next;
        }
        return low;
    }



}
