package leib.leetcode0204;

import java.util.*;

/**
 * @Author:Leib
 * @Date 2020/4/23 14:48
 */
public class Test0423_2 {
    public static void main(String[] args) {
        String s = "aaaccceee";
        System.out.println(longestPalindrome(s));
        //最长回文数


    }
    public static int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Integer count = map.get(s.charAt(i));

            if(count==null){
                map.put(s.charAt(i),1);
                //第一个字符，先存放到map<char,1>
            }else{
                map.put(s.charAt(i),count+1);
            }
        }//拿到了map 即所有字符
        int ans = 0;
        int qishu=0;
        List<Integer> list = new ArrayList<>();

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {

                ans += entry.getValue()-(entry.getValue() & 1);

        }

        return ans  < s.length() ? ans + 1 : ans;
    }
}
