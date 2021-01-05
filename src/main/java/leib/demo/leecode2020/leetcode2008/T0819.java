package leib.demo.leecode2020.leetcode2008;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author:Leib
 * @Date 2020/8/19 12:12
 */
public class T0819 {
    static int num = 0;

    public static void main(String[] args) {
//        String s = "abcba";
//        System.out.println(countSubstrings(s));

//        int[] a = {1,2,3,0,0,0,0};
//        int[] b = {6,7,8,9};
//
//        merge(a,3,b,4);

//        int[][] arr = findContinuousSequence1(9);
//        for(int a=0;a<arr.length;a++){//控制每个一维数组
//            for(int i=0;i<arr[a].length;i++){//控制每个一维数组中的元素
//                System.out.print(arr[a][i]+" ");//输出每个元素的值
//            }
//            System.out.println();//每执行完一个一维数组换行
//        }

        int[] a = {1, 2, 5, 4};


        System.out.println(getLeastNumbers(a, 2).toString());
    }

    public static int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = arr[i];
        }
        return ans;
    }

    public static int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return nums[i];
                }
            }
        }
        return 0;
    }

    public static int[][] findContinuousSequence1(int target) {

        List<int[]> result = new ArrayList<>();
        int i = 1;

        while (target > 0) {
            target -= i++;
            if (target > 0 && target % i == 0) {
                int[] array = new int[i];
                for (int k = target / i, j = 0; k < target / i + i; k++, j++) {
                    array[j] = k;
                }
                result.add(array);
            }
        }
        Collections.reverse(result);
        int[][] ints = result.toArray(new int[0][]);
        return ints;
    }

    public static int[][] findContinuousSequence(int target) {
        int ans = target;

        List<Object[]> res = new ArrayList<>();

        int t = 0;

        for (int i = 1; i <= target / 2 + 1; i++) {
            int count = 0;
            ArrayList list = new ArrayList();
            while (count != ans) {
                count = count + i;
                list.add(i);
                i++;
            }
            Object[] array = list.toArray();
            res.add(array);
            t++;
        }
        int[][] ints = res.toArray(new int[0][]);
        return ints;
    }

    public static void merge(int[] A, int m, int[] B, int n) {
        for (int i = 0; i < n; i++) {
            A[i + m] = B[i];
        }
        Arrays.sort(A);
    }

    public static int countSubstrings(String s) {
        for (int i = 0; i < s.length(); i++) {
            count(s, i, i);
            //回文串长度为奇数
            count(s, i, i + 1);
            //回文串长度为偶数
        }
        return num;
    }

    public static void count(String s, int start, int end) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            num++;
            System.out.println(num);
            start--;
            end++;
        }
    }
}
