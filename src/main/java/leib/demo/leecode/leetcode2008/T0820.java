package leib.demo.leecode.leetcode2008;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author:Leib
 * @Date 2020/8/20 9:30
 */
public class T0820 {
    public static void main(String[] args) {

        String s1 = "a";

        System.out.println(longestPalindrome(s1));

    }

    public static int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Integer count = map.get(s.charAt(i));
            if (map.get(s.charAt(i)) == null) {
                map.put(s.charAt(i), 1);
            } else {
                map.put(s.charAt(i), count + 1);
            }
        }

        int ans = 0;
        int qi = 0;
        int ou = 0;

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                if(entry.getValue()>2){
                    ans+=entry.getValue()-1;
                }
                qi++;
            }
            if (entry.getValue() % 2 == 0) {
                ou++;
                ans += entry.getValue();
            }
        }

        if (qi == 0) return ans;
        else return ans + 1;
    }

    public static boolean isSubsequence(String s, String t) {
        int count = 0;
        int temp = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = temp; j < t.length(); j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    count++;
                    temp = j + 1;
                    break;
                }
            }
        }

        if (count == s.length()) {
            return true;
        } else {
            return false;
        }
    }
}
