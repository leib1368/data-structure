package leib.demo.leecode.leetcode2009;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author:Leib
 * @Date 2020/9/7 16:33
 */
public class T0907 {
    public static void main(String[] args) {
        T0907 t0907 = new T0907();
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode1.left=treeNode2;
        treeNode1.right=treeNode3;

        t0907.levelOrderBottom(treeNode1);

    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root==null) {
            return new ArrayList<List<Integer>>();
        }
        //改用链表实现，每次都插入到第一位
        LinkedList<List<Integer>> res = new LinkedList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            List<Integer> oneLevel = new ArrayList<>();
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                TreeNode node = queue.poll();
                oneLevel.add(node.val);
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            // 每次都往队头塞
            res.addFirst(oneLevel);
        }
        return res;
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return head;
        ListNode pre = head;//指向第一个不重复的节点
        ListNode cur = head.next;//当前节点
        while (cur != null) {
            if (cur.val != pre.val) {//找到了一个新的不重复节点，则把pre指向cur，更新pre
                pre.next = cur;
                pre = cur;
            }
            cur = cur.next;//更新cur
        }
        pre.next = null;//切断pre与剩余重复元素的联系
        return head;
    }

}
