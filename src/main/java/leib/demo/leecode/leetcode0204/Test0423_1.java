package leib.demo.leecode.leetcode0204;

/**
 * @Author:Leib
 * @Date 2020/4/23 13:36
 */
public class Test0423_1 {
    public static void main(String[] args) {
        String s1,s2;
        s1 = "abcde";
        s2 = "deabc";
        isFlipedString(s1,s2);
        //双指针查询字符串是否旋转
    }
    public static boolean isFlipedString(String s1, String s2) {
        if(s1.length() != s2.length()) {
            return false;
        }

        int i = 0;
        int j = 0;
        int len = 0;
        while(i != s1.length() && j != s2.length()){
            if(s1.charAt(i) == s2.charAt(j)){
                i++;
                j++;
                len++;
            }else{
                j = 0;
                i++;
                len = 0;
            }
        }
        if(i == s1.length()){
            int k = 0;
            while(j != s2.length()){
                if(s2.charAt(j) == s1.charAt(k)){
                    k++;
                    j++;
                    len++;
                }else{
                    break;
                }
            }
            return len == s1.length();
        }
        return false;
    }
}
