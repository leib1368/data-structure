package leib.demo.leecode.leetcode2011;


/**
 * @Author:Leib
 * @Date 2020/11/8 8:15
 */
public class T1108 {
    public static void main(String[] args) {
        T1108 t1108 = new T1108();
        int [] l1 = {1,2,3,4};

        System.out.println(t1108.smallerNumbersThanCurrent(l1));
    }

    public int maxProfit2(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;               // 表示第 i 天交易完后手里没有股票的最大利润
        dp[0][1] = -prices[0];      //  表示第  i 天交易完后手里持有一支股票的最大利润（i 从 0 开始）。
        for (int i = 1; i < n; ++i) {
            //如果这一天交易完后手里没有股票，那么可能的转移状态为前一天已经没有股票， 即  dp[i−1][0]
            // 或者前一天结束的时候手里持有一支股票，即  dp[i−1][1]，这时候我们要将其卖出，并获得 prices[i] 的收益。
            //
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0];
    }
    //买卖股票 dp算法
    public int maxProfit(int[] prices) {
        if(prices==null || prices.length==0) {
            return 0;
        }
        int n = prices.length;
        //创建两个数组，一个记录每次卖出的最大收益，一个记录每次买入最大收益
        int[] sell = new int[n];
        int[] buy = new int[n];
        //初始化第一天收益
        sell[0] = 0;
        buy[0] = -prices[0];
        for(int i=1;i<n;++i) {
            //第i天卖出收益 = max(第i-1天卖出收益，第i-1天买入收益+当天股价)
            sell[i] = Math.max(sell[i-1],buy[i-1]+prices[i]);
            //第i天买入收益 = max(第i-1天买入收益，-当天股价)
            buy[i] = Math.max(buy[i-1],-prices[i]);
        }
        return Math.max(sell[n-1],buy[n-1]);
    }

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int [] ans = new int [nums.length];
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (j==i) {
                    continue;
                }
                if (nums[i] > nums[j] ) {
                     count++;
                }
            }
            ans [i] = count;
        }

        return ans ;
    }
}
