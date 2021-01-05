package leib.demo.leecode2020.leetcode2004;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author:Leib
 * @Date 2020/4/28 9:45
 */
public class Test0428 {
    public static void main(String[] args) {
        String a = "aabbcc";
        String b = "tebbem";
        canConstruct2(a,b);
        System.out.println(validPalindrome(b));
        int [] list =  {1,2,2,4,4,5};
        System.out.println(singleNumbers(list));
    }

    public static boolean canConstruct2(String ransomNote, String magazine) {
        Map<Character, Integer> rMap = new HashMap<>();
        Map<Character, Integer> mMap = new HashMap<>();
        for(char c : ransomNote.toCharArray()){
            rMap.put(c, rMap.getOrDefault(c, 0));
        }
        for(char c : magazine.toCharArray()){
            mMap.put(c, mMap.getOrDefault(c, 0) + 1);
        }
        for(char key : rMap.keySet()){
            // 要细心啊！可能第二个字符串中没有出现过第一个字符串中的字符，所以得用getOrDefault()
            if(rMap.get(key) > mMap.getOrDefault(key, 0))
                // 第二个字符串可以有剩余
            {
                return false;
            }
        }
        return true;
    }

    /*↓写错了哈哈哈*/

    public static boolean validPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)  +1);
            //讲字符串拆成字符并放入map中 每次放入都会叠加
        }//得到map后，查询字符的奇数个数即可 奇数如果大于2个以上123删掉也无法组成回文
        //奇数如果是2或1 还有戏
        int count = 0;

        for(char key : map.keySet()){
            if(map.get(key)%2==1){
                count =count+1;
            }
        }

        if(count >2){
            return false;
        }else{
            return  true;
        }

    }

    public static boolean validPalindrome2(String s){
        for(int i = 0, j = s.length()-1; i < j ; i++, j--){
            if(s.charAt(i) != s.charAt(j)){
                //分两种情况，一是右边减一，二是左边加一
                return isPalindrome(s,i,j-1) || isPalindrome(s, i+1, j);
            }
        }
        return true;
    }

    public static boolean isPalindrome(String s, int i, int j) {

        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }

    public static int[] singleNumbers(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        List<Integer> list = new ArrayList<>();

        for(int key : map.keySet()){
            if(map.get(key)%2==1){
                list.add(key);
            }
        }
       Integer[] ans =  list.toArray(new Integer[list.size()]);
        int result [] = new int[2];
        for (int i = 0; i < ans.length; i++) {
            result[i] = ans[i];
        }
        return result;
    }

}
