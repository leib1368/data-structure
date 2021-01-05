package leib.demo.leecode2020.leetcode2005;

/**
 * @Author:Leib
 * @Date 2020/4/30 12:52
 */
public class Test0501 {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node4.right = node5;

        //System.out.println(minDepthLeetcode(node1));

        ListNode listNode1 = new  ListNode(1);
        ListNode listNode2 = new  ListNode(3);
        ListNode listNode3 = new  ListNode(2);
        ListNode listNode4 = new  ListNode(4);
        listNode1.next = listNode2;
        listNode3.next = listNode4;
        System.out.println(mergeTwoLists(listNode1,listNode3));
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        l2.next = mergeTwoLists(l1, l2.next);
        return l2;
    }

    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

/*      int depthL = minDepth(root.left);
        int depthR = minDepth(root.right);

        return Math.max(depthL,depthR)+1;
        ↑为求最大深度
*/
        if (root.left == null && root.right != null) {
            return minDepth(root.right) + 1;
        }

        if (root.right == null && root.left != null) {
            return minDepth(root.left) + 1;
        }


        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }

    public static int minDepthLeetcode(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if ((root.left == null) && (root.right == null)) {
            return 1;
        }

        int min_depth = Integer.MAX_VALUE;
        if (root.left != null) {
            min_depth = Math.min(minDepthLeetcode(root.left), min_depth);
        }
        if (root.right != null) {
            min_depth = Math.min(minDepthLeetcode(root.right), min_depth);
        }

        return min_depth + 1;
    }



}
