package leib.demo.leecode.leetcode2009;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author:Leib
 * @Date 2020/9/28 11:33
 */
public class T0928 {
    public static void main(String[] args) {
        //FileInputStream fileInputStream = new FileInputStream();
        T0911 t0911 = new T0911();
        T0928 t0928 = new T0928();
        int [] list = {10,-3,0,5,9};
        TreeNode treeNode = t0911.sortedArrayToBST(list);
        t0928.levelOrder(treeNode);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<Integer>();
            int currentLevelSize = queue.size();
            for (int i = 1; i <= currentLevelSize; ++i) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ans.add(level);
        }
        return ans;
    }
}
enum season {
    red,blue;
}