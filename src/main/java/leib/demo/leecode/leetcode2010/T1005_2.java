package leib.demo.leecode.leetcode2010;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:Leib
 * @Date 2020/10/5 13:46
 */
//class ListNode {
//     int val;
//     ListNode next;
//     ListNode(int x) { val = x; }
// }
public class T1005_2 {
    public static void main(String[] args) {
        //第二种方法设计翻转链表与双指针 因此记录一下
    }
    public boolean isPalindrome2(ListNode head) {
        if(head==null||head.next==null){
            return true;
        }
        //利用快慢指针找到链表的中间位置
        ListNode fast=head;
        ListNode slow=head;
        while(fast.next!=null&&fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        if(fast.next!=null)slow=slow.next;//偶数节点,让slow指向下一节点
        ListNode newHead=reverseList(slow);
        //System.out.println(slow.val);
        //System.out.println(newHead.val);
        slow.next=null;//把链表从中间切开
        //比较两个链表是否相等
        while(newHead!=null){
            if(newHead.val!=head.val)return false;
            head=head.next;
            newHead=newHead.next;
        }
        return true;
    }
    //翻转链表
    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode next=head.next;
        ListNode newHead=reverseList(next);
        next.next=head;
        head.next=null;
        return newHead;
    }

    public boolean isPalindrome1(ListNode head) {
        List<Integer> vals = new ArrayList<>();

        // Convert LinkedList into ArrayList.
        ListNode currentNode = head;
        while (currentNode != null) {
            vals.add(currentNode.val);
            currentNode = currentNode.next;
        }

        // Use two-pointer technique to check for palindrome.
        int front = 0;
        int back = vals.size() - 1;
        while (front < back) {
            // Note that we must use ! .equals instead of !=
            // because we are comparing Integer, not int.
            if (!vals.get(front).equals(vals.get(back))) {
                return false;
            }
            front++;
            back--;
        }
        return true;
    }
}
