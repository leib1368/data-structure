package leib.demo.leecode.leetcode2004;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author:Leib
 * @Date 2020/4/16 11:51
 */
public class LeetcodeTest01 {
    public static void main(String[] args) {
        //System.out.println(compressString("aabcccccaaa"));
        System.out.println(compressStringMap("aabcccccaaa"));
    }

    public static String compressString(String S) {
        int len = S.length();
        int i = 0;
        StringBuffer sb = new StringBuffer();
        while(i<len){
            int j = i;
            while(j<len&&S.charAt(i)==S.charAt(j)){
                j=j+1;
            }
            sb.append(S.charAt(i));
            sb.append(j-i);
            i=j;
        }
        String res = sb.toString();
        if (res.length() < S.length()) {
            return res;
        } else {
            return S;
        }


    }
    public static String compressStringMap(String S){
        Map<Character, Integer> map = new HashMap<>();
        char [] chars =  S.toCharArray();
        for(char c : chars){
            Integer count = map.get(c);
            if(count==null){
                map.put(c,1);
            }else{
                map.put(c,count+1);
            }
        }
        StringBuffer sb = new StringBuffer();
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            sb.append(entry.getKey());
            sb.append(entry.getValue());
        }
        System.out.println(sb);
        String ans = sb.toString() ;
        return ans;
    }
}