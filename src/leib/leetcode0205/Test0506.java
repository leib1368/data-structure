package leib.leetcode0205;

import java.util.*;

/**
 * @Author:Leib
 * @Date 2020/5/6 20:16
 */
public class Test0506 {
    public static void main(String[] args) {
       int [] nums = { 2, 7, 11, 15};
       int target = 9;
       String s = "{}{}[][]";
       //System.out.println(twoSum(nums,target));
       System.out.println(isValid(s));
    }
    public static int[] twoSum(int[] nums, int target) {
/*        int [] ans = new int [2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length; j++) {
                if(nums[i]==(target-nums[j])){
                    ans[0]=i;
                    ans[1]=j;
                }
            }
        }
        return ans;*/
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i <nums.length; i++) {
            int t = target-nums[i];
            if(map.containsKey(t)){
                return new int []{i,map.get(t)};
            }
            map.put(nums[i],i);
        }
        return  null;
    }

    public static boolean isValid(String s) {
/*        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
        }
        return set.size()%2==0 ?  true :  false;*/

        char[] chars = s.toCharArray();
        if (chars.length%2!=0){//基数肯定不是
            return false;
        }
        if (s.isEmpty()) return true;
        for (int i=0;i<chars.length/2;i++){
            s = s.replaceAll("\\(\\)","")
                    .replaceAll("\\[\\]","")
                    .replaceAll("\\{\\}","");
            if (s.isEmpty()) return true;
        }
        return false;


    }
}
