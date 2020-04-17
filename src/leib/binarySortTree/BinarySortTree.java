package leib.binarySortTree;

/**
 * @Author:Leib
 * @Date 2020/4/17 13:21
 */
public class BinarySortTree {
    Node root;

    public  void add(Node node ){
        if(root ==null){
            root = node;
        }else{
            root.add(node);
        }
    }

    public  void midShow( ){
        if(root!=null){
            root.midShow(root);
        }
    }

    public  Node search(int value){
        if(root==null){return null;}
        else{
            return  root.search(value);
        }
    }

    public  Node searchParent(int value){
        if(root==null){return null;}
        else{
            return  root.searchParent(value);
        }
    }

    public  void delete(int value){
        if(root==null){return ;}
        else{
            //删除的目标节点
            Node target = search(value);
            if(target==null){
                return;
            }
            //确定父节点
            Node parent = searchParent(value);
            //删除的目标节点无左右节点 即叶子节点
            if(target.left==null&&target.right==null){
                //是删除的节点是父节点的左子节点
                if(parent.left.value==value){
                    parent.left= null;
                }
                //是删除的节点是父节点的右子节点
                else{
                    parent.right=null;
                }
            }
            //删除的目标节点有左右节点
            else if (target.left!=null&&target.right!=null){
                int min = deleteMin(target.right);
                //被删除节点的右子树的最小值  赋值给被删节点
                target.value=min;
            }
            //删除的目标节点有左节点或右节点
            else{
                //有左节点
                if(target.left!=null){
                    //目标是父节点的左节点
                    if(parent.left.value==value){
                        parent.left= target.left;
                    }
                    //目标是父节点的右节点
                    else{
                        parent.right=target.left;
                    }
                //有右节点
                }else{
                    if(parent.left.value==value){
                        parent.left= target.right;
                    }else{
                        parent.right=target.right;
                    }

                }
            }

        }
    }

    private int deleteMin(Node node) {
        Node target = node ;
        //找到最小的节点
        while(node.left!=null){
            target = target.left;
        }
        delete(target.value);
        return target.value;
    }

}

