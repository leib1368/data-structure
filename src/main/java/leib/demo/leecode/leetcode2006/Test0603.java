package leib.demo.leecode.leetcode2006;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author:Leib
 * @Date 2020/6/3 16:36
 */
public class Test0603 {
    public static void main(String[] args) {
        int [] list = {3,0,4,4,2,4};
        moveZeroes(list);
        System.out.println();
    }

    public static void moveZeroes(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }
        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public static int majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer count = map.get(nums[i]);
            if (count == null) {
                map.put(nums[i],1);
            }else{
                map.put(nums[i],count+1);
            }
        }
        Collection<Integer> c = map.values();
        Object[] obj = c.toArray();
        Arrays.sort(obj);

        map.forEach((k,v)-> {
            System.out.println("Item : " + k + " Count : " + v);
        });

        int max=0;
        int ans = 0;
        for (Integer key : map.keySet()) {
           // System.out.println("key= "+ key + " and value= " + map.get(key));
            if(map.get(key)>max){
                max = map.get(key);
                ans = key ;
            }
        }

        return ans ;
    }
}
