package leib.demo.leecode2020.leetcode2009;

import java.util.*;

/**
 * @Author:Leib
 * @Date 2020/9/28 20:22
 */
public class T0929 {
 public class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }
    public static void main(String[] args) {
        T0911 t0911 = new T0911();
        int [] list = {-9,-5,0,5,9};
        TreeNode treeNode = t0911.sortedArrayToBST(list);

        T0929 t0929 = new T0929();
        //t0929.postorderTraversalIteration(treeNode);
        //t0929.preorderTraversal(treeNode);
        //t0929.inorderTraversal(treeNode);
        t0929.isUnique("faake");
    }
    ArrayList<Integer> tmp = new ArrayList<Integer>();
    public int[] reversePrint(ListNode head) {
        recur(head);
        int[] res = new int[tmp.size()];
        for(int i = 0; i < res.length; i++)
            res[i] = tmp.get(i);
        return res;
    }
    void recur(ListNode head) {
        if(head == null) return;
        recur(head.next);
        tmp.add(head.val);
    }
    public boolean isUnique(String astr) {
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < astr.length(); i++) {
            if(map.get(astr.charAt(i))==null){
                map.put(astr.charAt(i),1);
            }
            else return false;
        }
        return true;
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null)
            return null;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        while (!stack.isEmpty()){
            TreeNode node = stack.peek();
            if (node!=null){
                stack.pop();
                if (node.right != null)
                    stack.push(node.right);
                stack.push(node);
                stack.push(null);
                if (node.left != null)
                    stack.push(node.left);
            }else{
                stack.pop();
                node = stack.peek();
                stack.pop();
                res.add(node.val);
            }
        }
        return res;
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        preorder(root, res);
        return res;
    }

    private void preorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        preorder(root.left, res);
        preorder(root.right, res);
    }

    public List<Integer> postorderTraversalIteration(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null)
            return null;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            res.add(node.val);

            if (node.right != null)
                stack.push(node.right);
            if (node.left != null)
                stack.push(node.left);
        }
        return res;
    }


    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        postorder(root, res);
        return res;
    }

    public void postorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        postorder(root.left, res);
        postorder(root.right, res);
        res.add(root.val);
    }
}
