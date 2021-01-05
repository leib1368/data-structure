package leib.demo.leecode2020.leetcode2007;

import java.util.Arrays;

/**
 * @Author:Leib
 * @Date 2020/7/9 20:56
 */
public class T0709 {
    public static void main(String[] args) {
        titleToNumber("AAA");
        System.out.println(countPrimes1(15));
    }
    public static int titleToNumber(String s) {
        int ans = 0 ;
        for (int i = 0; i < s.length(); i++) {
            int num = s.charAt(i) - 'A' + 1;
            ans = ans * 26 + num;
        }
        return ans ;
    }
//    public static int countPrimes(int n) {
//        int count = 0;
//        for (int i = 2; i < n; i++)
//            if (isPrime(i)) count++;
//        return count;
//    }
//    // 判断整数 n 是否是素数
//    public static boolean isPrime(int n) {
//        for (int i = 2; i < n; i++)
//            if (n % i == 0)
//                // 有其他整除因子
//                return false;
//        return true;
//    }

    public static int countPrimes1(int n) {
        boolean[] isPrim = new boolean[n];
        Arrays.fill(isPrim, true);
        for (int i = 2; i * i < n; i++)
            if (isPrim[i])
                for (int j = i * i; j < n; j += i)
                    isPrim[j] = false;

        int count = 0;
        for (int i = 2; i < n; i++)
            if (isPrim[i]) count++;

        return count;
    }
}
