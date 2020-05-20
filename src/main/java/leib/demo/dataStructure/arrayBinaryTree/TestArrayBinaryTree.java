package leib.demo.dataStructure.arrayBinaryTree;

/**
 * @Author:Leib
 * @Date 2020/4/15 13:15
 */
public class TestArrayBinaryTree {
    public static void main(String[] args) {
        int [] list = new int []{1,2,3,4,5,6,7};
        ArrayBinaryTree arrayBinaryTree = new ArrayBinaryTree(list);
        arrayBinaryTree.frontShow();
    }
}
