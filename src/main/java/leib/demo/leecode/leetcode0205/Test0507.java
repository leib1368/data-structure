package leib.demo.leecode.leetcode0205;

/**
 * @Author:Leib
 * @Date 2020/5/7 21:16
 */
public class Test0507 {
    public static void main(String[] args) {
        System.out.println(fib(3));
    }

    public static int fib(int N) {
        if(N==0)
            return 0;
        //leetcode里一定要做非零的判断 晕

        int[] dp = new int[N + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[N];
    }
    //爬楼梯 动态规范 dp问题
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
