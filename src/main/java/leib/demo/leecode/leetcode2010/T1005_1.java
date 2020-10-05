package leib.demo.leecode.leetcode2010;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:Leib
 * @Date 2020/10/5 12:43
 */
public class T1005_1 {
    public static void main(String[] args) {
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        ans.add(list);
        list.add(1);
        list.add(2);
        ans.add(list);
        System.out.println(ans);
    }
}
