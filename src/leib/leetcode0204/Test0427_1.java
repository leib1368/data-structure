package leib.leetcode0204;

import java.util.*;

/**
 * @Author:Leib
 * @Date 2020/4/27 10:53
 */
public class Test0427_1 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(3);
        node1.next= node2 ;
        node2.next= node3 ;
        node3.next= node4 ;
        node4.next= node5 ;
        node5.next= node6 ;
        //System.out.println(removeDuplicateNodes(node1));
        //删除链表重复的值 非有序链表

        int [] arr = {4,5,6,7,0,1,2,3};
        int a =3;
        System.out.println(search(arr,a));

    }
    public static ListNode removeDuplicateNodes(ListNode head) {
        //双指针
        if (head == null || head.next == null){
            return head;
        }
        ListNode pre = head;
        ListNode later = null;
        Map<Integer, Integer> hashMap = new HashMap<>();
        while (pre != null){
            if (!hashMap.containsKey(pre.val)){
                hashMap.put(pre.val, 1);
                later = pre;
                pre = pre.next;
            } else {
                pre = pre.next;
                later.next = pre;
            }
        }
        return head;
    }

    public static int search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1, mid = 0;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) {
                return mid;
            }
        // 先根据 nums[mid] 与 nums[lo] 的关系判断 左端是否是增序
            if(nums[lo]<=nums[mid]){
                //判断target位于哪一段
                if(target>=nums[lo]&&target<nums[mid]){
                    hi = mid -1;
                }else{
                    lo = mid +1;
                }
            }//右端是增序
            else{
                if(target>nums[mid]&&target<=nums[hi]){
                    lo = mid +1;
                }else{
                    hi = mid -1;
                }
            }

        }

        return -1;
    }
}
