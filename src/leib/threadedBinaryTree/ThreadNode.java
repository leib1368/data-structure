package leib.threadedBinaryTree;


/**
 * @Author:Leib
 * @Date 2020/4/15 15:30
 */
public class ThreadNode {
    int value;
    ThreadNode leftNode ;
    ThreadNode rightNode ;
    //标识线索二叉树的节点指针类型
    int leftType ;
    int rightType ;

    public  ThreadNode(int value ){
        this.value= value;
    }

    public void setLeftNode(ThreadNode leftNode){
        this.leftNode = leftNode;
    }

    public void setRightNode(ThreadNode rightNode){
        this.rightNode = rightNode;
    }

    public void frontShow() {
        System.out.println(value);
        if (leftNode!=null){
            leftNode.frontShow();
        }
        if (rightNode!=null){
            rightNode.frontShow();
        }
    }

    public void midShow() {
        if (leftNode!=null){
            leftNode.midShow();
        }
        System.out.println(value);
        if (rightNode!=null){
            rightNode.midShow();
        }
    }

    public void afterShow() {
        if (leftNode!=null){
            leftNode.afterShow();
        }

        if (rightNode!=null){
            rightNode.afterShow();
        }

        System.out.println(value);
    }

    public ThreadNode frontSearch(int i ) {
        ThreadNode target = null ;
        if(this.value ==i){
            return this;
        }else{
            if(leftNode!=null){
                target = leftNode.frontSearch(i);
            }
            if(target != null){
                return target ;
            }
            if(rightNode !=null){
                target = rightNode.frontSearch(i);
            }

        }
        return target;
    }

    public void delete(int i) {
        ThreadNode parent = this ;
        if(parent.leftNode!=null &&parent.leftNode.value==i){
            parent.leftNode = null;
            return;
        }
        if(parent.rightNode!=null &&parent.rightNode.value==i){
            parent.rightNode =null;
            return;
        }
        parent = leftNode;
        if(parent!=null){
            parent.delete(i);
        }

        parent = rightNode;
        if(parent!=null){
            parent.delete(i);
        }
    }
}
