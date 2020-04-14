package leib.binaryTree;

/**
 * @Author:Leib
 * @Date 2020/4/14 20:21
 */
public class BinaryTree {
    TreeNode root ;

    public void   setRoot (TreeNode root){
        this.root = root;
    }

    public TreeNode getRoot() {
        return root;
    }

    public void frontShow(){
        root.frontShow();
    }

    public void MidShow() {
        root.midShow();
    }


    public void AfterShow() {
        root.afterShow();
    }

    public TreeNode frontSearsh(int i) {
        return root.frontSearch(i);
    }

    public void delete(int i) {
        if(root.value==i){
            root =null;
        }else{
            root.delete(i);
        }

    }
}
