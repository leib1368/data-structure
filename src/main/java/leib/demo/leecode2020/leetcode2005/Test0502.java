package leib.demo.leecode2020.leetcode2005;

import java.util.HashMap;

/**
 * @Author:Leib
 * @Date 2020/5/2 15:03
 */
public class Test0502 {
    public static void main(String[] args) {
        String s = "abcd" ;
       /*
       使用快慢指针去查询最长不重复字段
       很显然这样子并不能判断之后的字符是否重复
       转用map去判断
       */

        lengthOfLongestSubstring(s);
    }
    public static int lengthOfLongestSubstring(String s) {
        if (s.length()==0) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int left = 0;
        for(int i = 0; i < s.length(); i ++) {
            if (map.containsKey(s.charAt(i))) {
                //如果有重复字符
                left = Math.max(left, map.get(s.charAt(i)) + 1);
                //取得前面重复的字符并+1向后移动
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-left+1);
        }

        return max;
    }
}
