package leib.demo.leecode.leetcode0205;

/**
 * @Author:Leib
 * @Date 2020/5/11 15:22
 */
public class Test0511 {

    //二叉树递归求最深 之前好像写过，看来需要系统学习一下dfs了
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int left_height = maxDepth(root.left);
            int right_height = maxDepth(root.right);
            return java.lang.Math.max(left_height, right_height) + 1;
        }
    }
}
