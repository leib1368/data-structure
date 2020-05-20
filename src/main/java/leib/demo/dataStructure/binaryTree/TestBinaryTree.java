package leib.demo.dataStructure.binaryTree;

/**
 * @Author:Leib
 * @Date 2020/4/14 20:30
 */
public class TestBinaryTree {
    public static void main(String[] args) {
        //创建一棵树
        BinaryTree binaryTree = new BinaryTree();
        //创建根节点 value是1
        TreeNode root = new TreeNode(1);
        //节点绑点到树上
        binaryTree.setRoot(root);
        //创建左节点和右节点
        TreeNode leftNode = new TreeNode(2);
        TreeNode rightNode = new TreeNode(3);
        //绑定左节点和右节点到根节点上
        root.setLeftNode(leftNode);
        root.setRightNode(rightNode);
        //为左节点创建子节点
        leftNode.setLeftNode(new TreeNode(4));
        leftNode.setRightNode(new TreeNode(5));
        //为右节点创建子节点
        rightNode.setLeftNode(new TreeNode(6));
        rightNode.setRightNode(new TreeNode(7));

        //以下为新建节点并不是创造子节点
        /*TreeNode leftLeftNode = new TreeNode(4);
        TreeNode leftRightNode = new TreeNode(5);

        TreeNode rightLeftNode = new TreeNode(6);
        TreeNode rightRightNode = new TreeNode(7);*/

        //前序遍历
/*        binaryTree.frontShow();
        binaryTree.MidShow();
        binaryTree.AfterShow();
        TreeNode result = binaryTree.frontSearsh(5);
        System.out.println(result);*/

        binaryTree.frontShow();
        binaryTree.delete(5);
        binaryTree.frontShow();
    }

}
