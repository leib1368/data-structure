package leib.threadedBinaryTree;

import leib.binaryTree.TreeNode;

/**
 * @Author:Leib
 * @Date 2020/4/15 15:46
 */
public class TestBinaryTree {
    public static void main(String[] args) {
        ThreadedBinaryTree binTree = new ThreadedBinaryTree();
        //创建根节点 value是1
        ThreadNode root = new ThreadNode(1);
        //节点绑点到树上
        binTree.setRoot(root);
        //创建左节点和右节点
        ThreadNode leftNode = new ThreadNode(2);
        ThreadNode rightNode = new ThreadNode(3);
        //绑定左节点和右节点到根节点上
        root.setLeftNode(leftNode);
        root.setRightNode(rightNode);
        //为左节点创建子节点
        leftNode.setLeftNode(new ThreadNode(4));
        leftNode.setRightNode(new ThreadNode(5));
        //为右节点创建子节点
        rightNode.setLeftNode(new ThreadNode(6));
        rightNode.setRightNode(new ThreadNode(7));

        binTree.frontShow();
        System.out.println("-------");
        binTree.threadNode();
        binTree.threadIterate();
    }
}
