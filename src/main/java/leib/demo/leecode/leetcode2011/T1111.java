package leib.demo.leecode.leetcode2011;

import java.util.ArrayList;

/**
 * @Author:Leib
 * @Date 2020/11/11 15:01
 */
public class T1111 {
    public static void main(String[] args) {
        T1111 t1111 = new T1111();
        int[] num = {1, 2, 2, 3, 4, 5, 6, 7, 8, 9};
        int sum = 7;
        t1111.checkSubarraySum(num, sum);
    }

    public ArrayList<ArrayList<Integer>> checkSubarraySum(int[] nums, int k) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for (int start = 0; start < nums.length - 1; start++) {
            for (int end = start + 1; end < nums.length; end++) {
                int sum = 0;
                ArrayList<Integer> l = new ArrayList<>();
                for (int i = start; i <= end; i++) {

                    sum += nums[i];
                    l.add(nums[i]);

                    if (sum == k || (k != 0 && sum % k == 0)) {
                        ans.add(l);
                        l.clear();
                    }
                }
                l.clear();
            }
        }
        return ans;
    }
}