package leib.demo.leecode.leetcode2006;

/**
 * @Author:Leib
 * @Date 2020/6/4 22:47
 */
public class Test0604 {
    public static void main(String[] args) {
        int [] list = {2,3,4,5,1};
        System.out.println(findUnsortedSubarray(list));
    }
    public static int findUnsortedSubarray(int[] nums) {
        int len = nums.length;
        int leftBorder = nums[0];
        int rightBorder = nums[len-1];
        // 如果array是已经sorted的话，begin和end还是初始值，确保返回的数值是0。
        int l = 0, r = -1;
        for(int i=0;i<len;i++){
            if(leftBorder>nums[i]){
                r = i;
            }else{
                leftBorder = nums[i];
            }
            if(rightBorder<nums[len-i-1]){
                l = len-i-1;
            }else{
                rightBorder = nums[len-i-1];
            }
        }
        return r-l+1;
    }
}
