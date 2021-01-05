package leib.demo.leecode2020.leetcode2008;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:Leib
 * @Date 2020/8/25 12:54
 */
public class T0825 {
    public static void main(String[] args) {
        //int [] list = {5,7,6};
        //findSubsequences(list);

        char [] charList = {'a','b','c'};
        reverseString(charList);
    }


    public static void reverseString(char[] s) {
        int len = s.length;

        char temp ;
        for (int i = 0; i < (len / 2); i++) {
            temp=s[i];
            s[i]=s[len-i-1];
            s[len-i-1]=temp;
        }

    }

    private static List<List<Integer>> res = new ArrayList<List<Integer>>();
    private static List<Integer> temp = new ArrayList<>();

    public static List<List<Integer>> findSubsequences(int[] nums) {
        if (nums == null) {
            return null;
        }
        dfs(0, Integer.MIN_VALUE, nums);
        return res;
    }

    private static void dfs(int curIndex, int preValue, int[] nums) {
        if (curIndex >= nums.length) {
            // 遍历结束
            if (temp.size() >= 2) {
                res.add(new ArrayList<>(temp));
            }
            return;
        }

        if (nums[curIndex] >= preValue) {
            // 将当前元素加入，并向后遍历
            temp.add(nums[curIndex]);
            dfs(curIndex + 1, nums[curIndex], nums);
            temp.remove(temp.size() - 1);
        }
        if (nums[curIndex] != preValue) {   // 不遍历 重复元素
            dfs(curIndex + 1, preValue, nums);  // 将下一个元素加入，并向后遍历
        }
    }
}
