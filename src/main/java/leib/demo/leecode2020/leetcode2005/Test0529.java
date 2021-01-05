package leib.demo.leecode2020.leetcode2005;

/**
 * @Author:Leib
 * @Date 2020/5/29 10:58
 */
public class Test0529 {
    public static void main(String[] args) {
        int [] list = {3,2,1,4,5};
        System.out.println(rob(list));
    }
    public static int rob(int[] nums) {
        int len = nums.length;
        if(len == 0)
            return 0;
        int[] dp = new int[len + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for(int i = 2; i <= len; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i-1]);
        }
        return dp[len];
    }

}
