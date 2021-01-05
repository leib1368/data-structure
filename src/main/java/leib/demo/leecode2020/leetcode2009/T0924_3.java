package leib.demo.leecode2020.leetcode2009;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:Leib
 * @Date 2020/9/24 19:34
 */
public class T0924_3 {
    public static void main(String[] args) {
        int [] l1 = {1,2,3,4};
        int [] l2 = new int [4];
        l2 = l1;
        l2[0] =4 ;
        //System.out.println(l2);

        List list = new ArrayList<>();
        list.add(1);

        List list2 = new ArrayList<>(list);
        for (Object i : list2) {
            System.out.println(i);
        }
    }
    public TreeNode convertBiNode(TreeNode root) {
        return null;
    }
}
