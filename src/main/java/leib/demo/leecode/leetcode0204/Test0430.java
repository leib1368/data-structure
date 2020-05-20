package leib.demo.leecode.leetcode0204;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author:Leib
 * @Date 2020/4/30 9:27
 */
public class Test0430 {
    public static void main(String[] args) {
//        int test = 19;
//        System.out.println(isHappy(test));
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        maxDepth(node1);
    }
    public static int getNext(int n) {
        int sum = 0,cur = 0;
        while(n>0){
            cur = n%10;
            sum = sum+(cur*cur);
            n=n/10;
        }
        return sum;
    }
    public static boolean isHappy(int n){
        Set<Integer> set = new HashSet<>();
        while(n!=1&&!set.contains(n)){
            set.add(n);
            n=getNext(n);
        }
        if(set.add(n)){

        }
         return   n == 1;
    }

    public static int maxDepth(TreeNode root){
        //递归 自下而上
        if (root == null) {
            return 0;
        } else {
            int left_height = maxDepth(root.left);
            int right_height = maxDepth(root.right);

            return java.lang.Math.max(left_height, right_height) + 1;
        }
    }
    public static int getDepth(TreeNode node, int deep){
        return  0;
    }

}
