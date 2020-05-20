package leib.demo.leecode.leetcode0205;

/**
 * @Author:Leib
 * @Date 2020/5/4 22:24
 */
public class Test0504 {
    public static void main(String[] args) {

        int [] arr = {2,1,0,2};

        System.out.println(canJump(arr));
    }
    public static boolean canJump(int[] nums) {
/*        int n = nums.length;
        int rightmost = 0;
        for (int i = 0; i < n; ++i) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }
        return false;*/

        int k = 0;
        for (int i = 0; i < nums.length; i++)
        {
            if (i > k) return false;
            k = Math.max(k, i + nums[i]);
        }
        return true;

    }

}
