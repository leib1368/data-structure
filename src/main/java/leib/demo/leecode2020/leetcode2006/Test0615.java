package leib.demo.leecode2020.leetcode2006;

import java.util.regex.Pattern;

/**
 * @Author:Leib
 * @Date 2020/6/15 15:07
 */
public class Test0615 {
    String chunkIPv4 = "([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])";
    Pattern pattenIPv4 =
            Pattern.compile("^(" + chunkIPv4 + "\\.){3}" + chunkIPv4 + "$");

    String chunkIPv6 = "([0-9a-fA-F]{1,4})";
    Pattern pattenIPv6 =
            Pattern.compile("^(" + chunkIPv6 + "\\:){7}" + chunkIPv6 + "$");

    public String validIPAddress(String IP) {
        if (IP.contains(".")) {
            return (pattenIPv4.matcher(IP).matches()) ? "IPv4" : "Neither";
        }
        else if (IP.contains(":")) {
            return (pattenIPv6.matcher(IP).matches()) ? "IPv6" : "Neither";
        }
        return "Neither";
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int data = 0;
        int tmp = x;
        while (tmp > 0) {
            data = data * 10 + tmp % 10;
            tmp = tmp / 10;
        }
        return data == x;
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0,j = 1;
        for (; j < nums.length; j++) {

            if(nums[j]!=nums[i]){
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }


    public static int removeDuplicates2(int[] nums) {

/*        int j = 1, count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                 count++;
            } else {
                count = 1;
            }
            if (count <= 2) {
                nums[j++] = nums[i];
            }
        }
        return j;*/

        int i = 0;
        for (int n : nums) {
            if (i < 2 || n > nums[i-2]) {
                nums[i++] = n;
            }
        }
        return i;





    }
    


    public static void main(String[] args) {
        String [] strList = {"str","s","strList","strNull"};
        longestCommonPrefix2(strList);
        isPalindrome(12321);
        int [] intList = {1,2,2,3,3,3,5};

        removeDuplicates2(intList);

    }

    public static String longestCommonPrefix1(String[] strs) {
        if (strs.length == 0)
            return "";
        String ans = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            for (; j < ans.length() && j < strs[i].length(); j++) {
                if (ans.charAt(j) != strs[i].charAt(j))
                    break;
            }
            ans = ans.substring(0, j);
            if (ans.equals(""))
                return ans;
        }
        return ans;
    }

    public static String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int length = strs[0].length();
        int count = strs.length;

        //i是横向字符遍历
        //j是纵向遍历目标数组
        for (int i = 0; i < length; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < count; j++) {
                //防止数组越界
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }

        return strs[0];
    }

}
