package leib.demo.leecode2020.leetcode2005;

/**
 * @Author:Leib
 * @Date 2020/5/12 19:15
 */
public class Test0512 {
    public static void main(String[] args) {
        int [] coin = {2,5,7};
        int count = 27 ;
        System.out.println(minCoin(coin,count));
        int m = 2 ;
        int n = 2 ;
        System.out.println(uniquePaths(m,n));
        int [] path1 = {3,2,1,0,4};
        int [] path2 = {2,3,1,4,1};
        System.out.println(maxSubArray(path2));

        System.out.println(divisorGame(5));

        int i = 9;
        for (int j = 0; j < 5; j++) {
            i=i+1;
        }
        System.out.println(i);

    }
    /*
    *   322. 零钱兑换
    */

    public static int minCoin(int [] coins ,int amount ){
        // dp(0) ---dp(n) 需要n+1个数
        int [] f = new int [amount+1];
        // n为硬币数
        int n = coins.length;
        // 初始条件
        f[0] =  0;
        //f1、f2 ... f(count)
        for (int i = 1; i <= amount; i++) {
            //开始时先附上最大值 ps后续要防止最大值+1 报错
            f[i] = Integer.MAX_VALUE;
            //动态规划处理
            for (int j = 0; j < n; j++) {
                //防止下标为负数以及最大值溢出
                if(i-coins[j] >= 0 && f[i - coins[j] ]!=Integer.MAX_VALUE){
                    //取最小值
                    f[i]=Math.min(f[i - coins[j] ] +1 ,f[i]);
                }
            }
        }
        if(f[amount] == Integer.MAX_VALUE ){
            return -1;
        }
        return f[amount];
    }

    /*
    *   62. 不同路径
    */

    public static int uniquePaths(int m, int n) {
        int [][] f = new int [m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                f[0][0]=0;
                if (i==0||j==0){
                    f[i][j] = 1;
                }else{
                    f[i][j] =  f[i-1][j]+ f[i][j-1];
                }
            }
        }
        return  f[m-1][n-1];
    }

    /*
    *   53. 最大子序和
    * 1) 确定状态
    * 2）确定子问题
    * 3）转移方程    f[j] = OR(0<=i<j) (f[i] and i + a[i] >= j )
    * 4) 计算顺序
    */

    public static boolean maxSubArray(int[] nums) {
        int n = nums.length;
        boolean [] f =new boolean [n] ;
        f[0]=true;

        for (int j = 1; j < n; j++) {
            f[j] = false ;
            for (int i = 0; i < j; i++) {
                if(f[i]&& i+nums[i]>=j){
                    f[j] = true;
                    break;
                }
            }
        }

        return f[n-1];
    }

    public static boolean divisorGame(int N) {

        if(N == 1) return false;
        if(N == 2) return true;

        boolean[] dp = new boolean[N+1];
        dp[1] = false;
        dp[2] = true;

        for(int i = 3; i<=N; i++){
            dp[i] = false;
            for(int j = 1; j<i; j++){
                if(i % j == 0 && !dp[i - j]){
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[N];
    }

}
