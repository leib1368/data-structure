package leib.demo.leecode2020.leetcode2009;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:Leib
 * @Date 2020/9/26 10:33
 */
public class T0926 {
    public static void main(String[] args) {
        T0911 t0911 = new T0911();
        int[] list = {-9, -5, 0, 5, 9, 11, 77};
        TreeNode treeNode = t0911.sortedArrayToBST(list);

        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        n1.left= n2;
        n1.right= n3;
        n2.left= n4;

        T0926 t0926 = new T0926();
        //t0926.pathSum(n1,7);
        t0926.invertTree(n1);
        //System.out.println(Arrays.toString(t0926.masterMind("RRGG", "GGXG")));

    }
    public TreeNode invertTree(TreeNode root) {
        if (root==null){return null;}
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
    public int[] masterMind(String solution, String guess) {
        int hit = 0, udohit = 0; //猜中，伪猜中
        char[] sc = solution.toCharArray();
        char[] gc = guess.toCharArray();
        int[] dict = new int[128];
        for (int i = 0; i < gc.length; i++) {
            if (gc[i] == sc[i]) {
                gc[i] = '/'; //表示已经猜过了
                hit++;
            } else {
                System.out.println(sc[i]);
                System.out.println(dict[sc[i]]);
                dict[sc[i]]++;//剩余未猜中的建字典，类似set,用来做伪猜中.
                System.out.println(dict[sc[i]]);
                System.out.println("---");
            }
        }
        for (int i = 0; i < gc.length; i++) {
            if (dict[gc[i]] > 0) {
                dict[gc[i]]--; //伪猜中后，应猜字符数减少
                udohit++;
            }
        }
        return new int[]{hit, udohit};
//        int [] list= new int [2];
//        List<Integer> bingoList = new ArrayList();
//
//        int bingo = 0;
//        int fakeBingo = 0;
//
//        for (int i = 0; i < solution.length(); i++) {
//            if (solution.charAt(i)==guess.charAt(i)){
//                bingo++;
//                bingoList.add(i);
//            }
//        }
//        list[0] =bingo;
//        list[1] =fakeBingo;
//        return list;
    }
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, sum, new ArrayList<>(), result);
        return result;
    }

    public void dfs(TreeNode root, int sum, List<Integer> list,
                    List<List<Integer>> result) {
        if (root==null){return;}

        List sub = new ArrayList(list);
        sub.add(new Integer(root.val));

        if (root.left==null&&root.right==null){

            if (root.val==sum){
                result.add(sub);
            }
            return;
        }

        dfs(root.left,sum-root.val,sub,result);
        dfs(root.right,sum-root.val,sub,result);
    }
}
