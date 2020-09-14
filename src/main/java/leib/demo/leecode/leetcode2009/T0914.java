package leib.demo.leecode.leetcode2009;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author:Leib
 * @Date 2020/9/14 19:05
 */
public class T0914 {
    public static void main(String[] args) {
        T0914 t0914 = new  T0914();
        T0911 t0911 = new T0911();
        int [] list = {10,-3,0,5,9};
        TreeNode treeNode = t0911.sortedArrayToBST(list);
        t0914.inorderTraversal(treeNode);

        t0914.trailingZeroes(13);

    }
    public int trailingZeroes(int n) {
//        int ans = 1;
//        while (n>0){
//            ans *= n ;
//            n--;
//        }
//        Integer i = ans;
//        String s = i.toString();
//        int count = 0;
//        for (int j = s.length()-1; j < s.length(); j--) {
//            if(s.charAt(j)=='0'){
//                count ++;
//            }else{
//                break;
//            }
//        }
//        return count;

//        // Calculate n!
//        BigInteger nFactorial = BigInteger.ONE;
//        for (int i = 2; i <= n; i++) {
//            nFactorial = nFactorial.multiply(BigInteger.valueOf(i));
//        }
//
//        // Count how many 0's are on the end.
//        int zeroCount = 0;
//
//        while (nFactorial.mod(BigInteger.TEN).equals(BigInteger.ZERO)) {
//            nFactorial = nFactorial.divide(BigInteger.TEN);
//            zeroCount++;
//        }
//
//        return zeroCount;


        int zeroCount = 0;
        for (int i = 5; i <= n; i += 5) {
            int powerOf5 = 5;
            while (i % powerOf5 == 0) {
                zeroCount += 1;
                powerOf5 *= 5;
            }
        }
        return zeroCount;

    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        midShow(root,list);
        return  list;
    }
    public void midShow(TreeNode root,List<Integer> res) {
        if (root==null){
            return ;
        }

        midShow(root.left,res);
        res.add(root.val);
        midShow(root.right,res);
    }
}
