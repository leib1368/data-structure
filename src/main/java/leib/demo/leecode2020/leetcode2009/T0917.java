package leib.demo.leecode2020.leetcode2009;


/**
 * @Author:Leib
 * @Date 2020/9/17 9:34
 */
public class T0917 {
    public int massage(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return nums[0];
        }

        // dp[i][0]：区间 [0, i] 里接受预约请求，并且下标为 i 的这一天不接受预约的最大时长
        // dp[i][1]：区间 [0, i] 里接受预约请求，并且下标为 i 的这一天接受预约的最大时长
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];

        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + nums[i];
        }
        return Math.max(dp[len - 1][0], dp[len - 1][1]);
    }

    public static void main(String[] args) {
        T0917 t0917 = new T0917();
        // int[] nums = {1, 2, 3, 1};
        // int[] nums = {2, 7, 9, 3, 1};
        int[] nums = {2, 1, 4, -5, 3, 1, 1, 3};
        int res = t0917.maxSubArray(nums);
        System.out.println(res);
    }

    public int maxSubArray(int[] nums) {
        int len = nums.length;
        if(len == 0) return 0;
        if(len == 1) return nums[0];
        int[] dp = new int[len];
        int max =  nums[0];
        dp[0] = nums[0];
        for(int i = 1;i < len;i ++){
            dp[i] = Math.max(dp[i - 1] + nums[i],nums[i]); //判断是跟着前面的数据继续干还是自己单干！
            max   = Math.max(max , dp[i]); //更新最后的结果
        }
        return max;
    }


    public TreeNode convertBiNode(TreeNode root) {
        return new TreeNode(1)  ;
    }

//    public static void main(String[] args) {
//        T0917 t0917 = new T0917();
//
//        t0917.hammingWeight(8);
//    }
    public int hammingWeight(int n) {
        int bits = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                bits++;
            }
            mask <<= 1;
        }
        return bits;
    }
}
