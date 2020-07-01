package leib.demo.leecode.leetcode2006;

/**
 * @Author:Leib
 * @Date 2020/6/16 19:19
 */
public class Test0617 {
    public static void main(String[] args) {
        int [] intList = {1,2,3,4};
        int t = 3;
        //System.out.println(searchInsert(intList, t));

        String s = "str str sss" ;
        System.out.println(lengthOfLastWord(s));
    }

    public static int lengthOfLastWord(String s) {
        int res = 0, i = s.length() - 1;
        while (i >= 0) {
            if (s.charAt(i--) != ' ') res++; // 非空则计数
            else if (res > 0) return res; // 为空，但之前已经计过数了
        }
        return res;
   /*     if(s==null||s==""){return 0;}
        int t = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)==' '){
                t=i;
            }
        }

        return s.length()-t-1;*/
    }
    public static int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if(target==nums[i]){
                return i;
            }
        }
        return 0;
    }
}
