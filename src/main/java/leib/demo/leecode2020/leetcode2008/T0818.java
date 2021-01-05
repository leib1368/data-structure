package leib.demo.leecode2020.leetcode2008;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author:Leib
 * @Date 2020/8/18 13:18
 */

public class T0818 {
    public static void main(String[] args) {
//        int [] s = {1,2,3,4};
//        rotate(s,3);

        //System.out.println(isHappy(111));
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        l1.next=l2;
        l2.next=l3;
        System.out.println(removeElements(l1,1));
    }


    public static ListNode removeElements(ListNode head, int val) {
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;

        ListNode prev = sentinel, curr = head;
        while (curr != null) {
            if (curr.val == val) prev.next = curr.next;
            else prev = curr;
            curr = curr.next;
        }
        return sentinel.next;


//        ListNode l1 = head;
//        if(head==null){
//            return null;
//        }
//        while(head.next==null){
//            if(head.val==val){
//                head.next=null;
//            }else{
//
//            }
//        }
//        return head;
    }

    public static boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int ans = 0;
        int temp = 0;
        while (true) {
            while (n > 0) {
                temp = n % 10;
                ans = ans + temp * temp;
                n = n / 10;
            }
            if (ans == 1) {
                return true;
            }
            if (set.contains(ans)) {
                return false;
            } else {
                set.add(ans);
                n = ans;
                ans = 0;
            }
        }
    }

    public static void rotate(int[] nums, int k) {

        int n = nums.length;
        k %= n;
        for (int i = 0; i < k; i++) {
            int temp = nums[n - 1];
            for (int j = n - 1; j > 0; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = temp;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
