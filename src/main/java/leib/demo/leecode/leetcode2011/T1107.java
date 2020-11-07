package leib.demo.leecode.leetcode2011;

import leib.demo.leecode.leetcode2004.ListNode;

import java.util.List;
import java.util.Stack;

/**
 * @Author:Leib
 * @Date 2020/11/7 15:20
 */
public class T1107 {
    public static void main(String[] args) {

    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast =  head;
        //ListNode fast = head;
        ListNode slow = head;
        //fast移n步，
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        if (fast==null) return head.next;

        while (fast.next!=null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }
    int maxDepth = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return maxDepth  ;
    }

    private int depth(TreeNode root) {
        if (root==null) return 0;
        int l = depth(root.left);
        int r = depth(root.right);
        maxDepth = Math.max(l+r,maxDepth);
        return  Math.max(l,r)+1;
    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        TreeNode merged = new TreeNode(t1.val + t2.val);
        merged.left = mergeTrees(t1.left, t2.left);
        merged.right = mergeTrees(t1.right, t2.right);
        return merged;

    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
