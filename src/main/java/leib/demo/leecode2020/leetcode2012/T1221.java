package leib.demo.leecode2020.leetcode2012;


/**
 * @Author:Leib
 * @Date 2020/12/21 21:13
 */
public class T1221 {
    public static void main(String[] args) {

    }
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        if (n > 0){

        }
        return dp[n];
    }
}
