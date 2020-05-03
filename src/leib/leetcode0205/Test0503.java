package leib.leetcode0205;

/**
 * @Author:Leib
 * @Date 2020/5/3 10:26
 */
public class Test0503 {
    public static void main(String[] args) {
        int [] arr = {1, -2, 3, 4};
        maxSubArray(arr);
    }
    public static int maxSubArray(int[] nums) {
/*        int maximum = Integer.MIN_VALUE;
        int sum=0;
        int n = nums.length;
        for(int i = 0; i < n; i++)
        {
            for(int j = i; j < n; j++)
            {
                for(int k = i; k <= j; k++)
                    {
                        sum += nums[k];
                    }
                if(sum > maximum) {
                    maximum = sum;
                }

                sum=0;
                //这里要记得清零，否则的话sum最终存放的是所有子数组的和。
            }
        }
        return maximum ;*/


        int i,j;
        int MaxSum =  Integer.MIN_VALUE;
        int len = nums.length;
        //每次开始累加的起始位置的循环
        for(i=0;i<len;i++)
        {
            int CurSum = 0;
            //向后累加的循环
            for(j=i;j<len;j++)
            {
                CurSum += nums[j];
                if(CurSum > MaxSum)
                    MaxSum = CurSum;
            }
        }
        return MaxSum;

    }
}
