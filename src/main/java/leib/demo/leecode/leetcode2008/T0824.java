package leib.demo.leecode.leetcode2008;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author:Leib
 * @Date 2020/8/24 13:14
 */
public class T0824 {
    public static void main(String[] args) {
        /*
        String str1 = "tutorials point", str2 = "http://";

        CharSequence cs1 = "int";

        // string contains the specified sequence of char values
        boolean retval = str1.contains(cs1);
        System.out.println("Method returns : " + retval);

        // string does not contain the specified sequence of char value
        retval = str2.contains("_");
        System.out.println("Methods returns: " + retval);
         */

        System.out.println(compressString("aaaaaaabc"));
        distributeCandies(14,3);
    }

    public static int[] distributeCandies(int candies, int num_people) {
        int[] ans = new int[num_people];
        int i = 0;
        while (candies != 0) {
            ans[i % num_people] += Math.min(candies, i + 1);
            candies -= Math.min(candies, i + 1);
            i += 1;
        }
        return ans;
    }

    public boolean repeatedSubstringPattern(String s) {
        return (s+s).substring(1, 2 * s.length() - 1).contains(s);
    }

    public static String compressString(String S) {
      /*  Map<Character,Integer> map = new HashMap<>();

        for (int i = 0; i < S.length(); i++) {
            Integer count = map.get(S.charAt(i));
            if(map.get(S.charAt(i))==null){
                map.put(S.charAt(i),0);
            }else{
                map.put(S.charAt(i),count+1);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {

            sb.append(entry.getKey());
            sb.append(entry.getValue()+1);
        }
        String ans = sb.toString();
        if(S.length()<=ans.length()) return S;
        else return  ans ;*/

        int N = S.length();
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (i < N) {
            int j = i;
            while (j < N && S.charAt(j) == S.charAt(i)) {
                j++;
            }
            sb.append(S.charAt(i));
            sb.append(j - i);
            i = j;
        }

        String res = sb.toString();
        if (res.length() < S.length()) {
            return res;
        } else {
            return S;
        }

    }

    public ListNode middleNode(ListNode head) {
        ListNode p = head, q = head;
        while (q != null && q.next != null) {
            q = q.next.next;
            p = p.next;
        }
        return p;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
