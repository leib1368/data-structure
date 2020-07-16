package leib.demo.leecode.leetcode2007;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * @Author:Leib
 * @Date 2020/7/16 20:11
 */
public class T0716 {
    public static void main(String[] args) {
        int [] i1 = {1,2,2};
        int [] i2 = {1,2,3,4,4};

       //intersection(i1,i2);
        merge(i1,3,i2,5);
    }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }


    public static int[] set_intersection(HashSet<Integer> set1, HashSet<Integer> set2) {
        int [] output = new int[set1.size()];
        int idx = 0;
        for (Integer s : set1)
            if (set2.contains(s)) output[idx++] = s;

        int[] ints = Arrays.copyOf(output, idx);
        return ints;
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<Integer>();
        for (Integer n : nums1) set1.add(n);
        HashSet<Integer> set2 = new HashSet<Integer>();
        for (Integer n : nums2) set2.add(n);

        if (set1.size() < set2.size()) return set_intersection(set1, set2);
        else return set_intersection(set2, set1);
    }


}
