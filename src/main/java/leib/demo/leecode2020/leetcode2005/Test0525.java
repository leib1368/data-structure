package leib.demo.leecode2020.leetcode2005;

import java.util.*;

/**
 * @Author:Leib
 * @Date 2020/5/25 9:12
 */
public class Test0525 {
    public static void main(String[] args) {
        int [] nums = {1,2,2,3,3,5};
        System.out.println(findDisappearedNumbers(nums));
    }
    public static List<Integer> findDisappearedNumbers(int[] nums) {
/*        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer count = map.get(nums[i]);
            if(map.get(nums[i])==null){
                map.put(nums[i],1);
            }else{
                map.put(nums[i],count+1);
            }
        }*/
        Map<Integer,Boolean> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],true);
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= nums.length; i++) {
            if(!map.containsKey(i)){
                list.add(i);
            }
        }

        List<String> list1 = Arrays.asList("a","b","c");
        list1.forEach((a)-> System.out.println(a));

        map.forEach((k,v)-> System.out.println(k+" ans="+v));

        return list ;
    }
}
