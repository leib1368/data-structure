package leib.demo.dataStructure.threadedBinaryTree;


/**
 * @Author:Leib
 * @Date 2020/4/15 15:30
 */
public class ThreadedBinaryTree {
    ThreadNode root ;
    ThreadNode pre = null;

    public void   setRoot (ThreadNode root){
        this.root = root;
    }

    public ThreadNode getRoot() {
        return root;
    }

    //中序(左根右)查询 初始化
    public void threadNode(){
        threadNode(root);
    }
    public void threadNode(ThreadNode node ){
        if(node==null){
            return;
        }
        //先处理左子树
        threadNode(node.leftNode);
        if(node.leftNode==null){
            node.leftNode = pre;
            node.leftType =1;
        }
        if(pre!=null&&pre.rightNode==null){
            pre.rightNode=node ;
            pre.rightType=1;
        }
        pre  = node ;
        //再处理右子树
        threadNode(node.rightNode);
    }

    public void threadIterate(){
        ThreadNode node = root ;
        while (node!=null){
            while (node.leftType==0){
                node=node.leftNode;
            }
            System.out.println(node.value);
            while (node.rightType==1){
                node= node.rightNode;
                System.out.println(node.value);
            }
            node= node.rightNode;
        }

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

    public ThreadNode frontSearsh(int i) {
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
