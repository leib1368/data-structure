package leib.demo.leecode.leetcode2009;



import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author:Leib
 * 留着明天写2333
 * @Date 2020/9/11 20:55
 */
public class T0911 {
    public static void main(String[] args) {
        T0911 t0911 = new T0911();
        int [] list = {-10,-3,0,5,9};
        TreeNode treeNode = t0911.sortedArrayToBST(list);

        t0911.binaryTreePaths(treeNode);
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new LinkedList<>();
        if (root == null)
            return res;
        //到达叶子节点，把路径加入到集合中
        if (root.left == null && root.right == null) {
            res.add(root.val + "");
            return res;
        }
        //遍历左子节点的路径
        for (String path : binaryTreePaths(root.left)) {
            res.add(root.val + "->" + path);
        }
        //遍历右子节点的路径
        for (String path : binaryTreePaths(root.right)) {
            res.add(root.val + "->" + path);
        }
        return res;
    }

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> averages = new ArrayList<Double>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            double sum = 0;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                TreeNode left = node.left, right = node.right;
                if (left != null) {
                    queue.offer(left);
                }
                if (right != null) {
                    queue.offer(right);
                }
            }
            averages.add(sum / size);
        }
        return averages;
    }


    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
        }
    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(height(root.left), height(root.right)) + 1;
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    public TreeNode helper(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        // 总是选择中间位置左边的数字作为根节点
        int mid = (left + right) / 2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, left, mid - 1);
        root.right = helper(nums, mid + 1, right);
        return root;
    }

}
