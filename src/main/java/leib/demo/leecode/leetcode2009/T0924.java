package leib.demo.leecode.leetcode2009;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:Leib
 * @Date 2020/9/24 14:05
 */
public class T0924 {
    public static void main(String[] args) {
        T0911 t0911 = new T0911();
        int [] list = {-9,-5,0,5,9,11,77};
        TreeNode treeNode = t0911.sortedArrayToBST(list);

        T0924 t0924 = new T0924();
        t0924.findMode(treeNode);
    }

    List<Integer> mList = new ArrayList<>();
    int curent = 0;//表示当前节点的值
    int count = 0;//表示当前节点的数量
    int maxCount = 0;//最大的重复数量

    public int[] findMode(TreeNode root) {
        inOrderTraversal(root);
        int[] res = new int[mList.size()];
        //把集合list转化为数组
        for (int i = 0; i < mList.size(); i++) {
            res[i] = mList.get(i);
        }
        return res;
    }

    //递归方式
    public void inOrderTraversal(TreeNode node) {
        //终止条件判断
        if (node == null)
            return;
        //遍历左子树
        inOrderTraversal(node.left);

        //下面是对当前节点的一些逻辑操作
        int nodeValue = node.val;
        if (nodeValue == curent) {
            //如果节点值等于curent，count就加1
            count++;
        } else {
            //否则，就表示遇到了一个新的值，curent和count都要
            //重新赋值
            curent = nodeValue;
            count = 1;
        }
        if (count == maxCount) {
            //如果count == maxCount，就把当前节点加入到集合中
            mList.add(nodeValue);
        } else if (count > maxCount) {
            //否则，当前节点的值重复量是最多的，直接把list清空，然后
            //把当前节点的值加入到集合中
            mList.clear();
            mList.add(nodeValue);
            maxCount = count;
        }

        //遍历右子树
        inOrderTraversal(node.right);
    }

}
