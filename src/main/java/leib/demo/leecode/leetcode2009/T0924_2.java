package leib.demo.leecode.leetcode2009;

import java.util.*;

/**
 * @Author:Leib
 * @Date 2020/9/24 17:32
 */
public class T0924_2 {
    public static void main(String[] args) {
        T0911 t0911 = new T0911();
        int[] list = {-9, -5, 0, 5, 9, 11, 77};
        TreeNode treeNode = t0911.sortedArrayToBST(list);

        T0924_2 t0924 = new T0924_2();
        //System.out.println(Arrays.toString(t0924.findMode(treeNode)));
//        t0924.listInOrderTraversal(list);
//        Arrays.toString(list);

        t0924.isBalanced(treeNode);
    }
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        //拿到节点的左子树和右子树的深度
        int deptLeft = getDept(root.left, 0);
        int deptRight = getDept(root.right, 0);
        //如果相差大于1，那么不是一颗平衡树
        if (Math.abs(deptLeft - deptRight) > 1)
            return false;
        //递归检查这个节点的左子节点和右子节点
        return isBalanced(root.left) && isBalanced(root.right);
    }
    //获取从某个节点开始的深度
    private int getDept(TreeNode root, int dept) {
        if (root == null)
            return dept;
        System.out.println("当前节点:"+root.val+"当前深度:"+dept);
        int deptLeft = getDept(root.left, dept + 1);
        int deptRight = getDept(root.right, dept + 1);

        return Math.max(deptLeft, deptRight);
    }

    public TreeNode convertBiNode(TreeNode root) {
        change(root);
        return head.right;
    }

    TreeNode prev = null;
    TreeNode head = new TreeNode(-1);

    private void change(TreeNode node) {
        if (node == null)
            return;
        change(node.left);

        if (prev == null) {
            prev = node;
            head.right = node;
        } else {
            prev.right = node;
            prev = node;
        }
        node.left = null;
        change(node.right);
    }

    public void listInOrderTraversal(int[] list) {
        for (int i = 0; i < list.length; i++) {
            if (list[i] == curent) {
                count++;
            } else {
                curent = list[i];
                count = 1;
            }

            if (count == maxCount) {
                mList.add(list[i]);
            } else if (count > maxCount) {
                mList.clear();
                mList.add(list[i]);
                maxCount = count;
            }
        }
        for (int i : mList) {
            System.out.println(i);
        }

    }

    /*
    *   我们都知道二叉搜索树的中序遍历是有序的，有一种方式就是把二叉搜索树中序遍历的结果存放到一个数组中，
        因为这个数组是升序的（虽然有重复的），我们可以遍历这个数组，这里使用几个变量
        使用变量curent表示当前的值，count表示当前值的数量，maxCount表示重复数字最大的数量。list集合存放结果
            1，如果节点值等于curent，count就加1，
            2，如果节点不等于current，说明遇到了下一个新的值，更新current为新的值，然后让count=1；
        接着比较count和maxCount的大小，
        如果count==maxCount，就把当前节点的值加入到集合list中。
        如果count>maxCount，先把list集合清空，然后再把当前节点的值加入到集合list中，最后在更新maxCount的值。
    * */

    public int[] findMode(TreeNode root) {
        inOrderTraversal(root);
        int ans[] = new int[mList.size()];
        for (int i = 0; i < mList.size(); i++) {
            ans[i] = mList.get(i);
        }
        return ans;
    }

    List<Integer> mList = new ArrayList<>();
    int curent = 0;//表示当前节点的值
    int count = 0;//表示当前节点的数量
    int maxCount = 0;//最大的重复数量

    public void inOrderTraversal(TreeNode node) {
        if (node == null)
            return;
        inOrderTraversal(node.left);

        if (node.val == curent) {
            count++;
        } else {
            curent = node.val;
            count = 1;
        }

        if (count == maxCount) {
            mList.add(node.val);
        } else if (count > maxCount) {
            mList.clear();
            mList.add(node.val);
            maxCount = count;
        }

        inOrderTraversal(node.right);
    }

}
