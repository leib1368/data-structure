package leib.demo.leecode.leetcode2007;

/**
 * @Author:Leib
 * @Date 2020/7/6 22:31
 */
public class T0706 {
    public static void main(String[] args) {
        convertToTitle(30);
        int s [] = {1,2,3,4,5};
        twoSum(s,4);
    }
    public static int[] twoSum(int[] numbers, int target) {
        if (numbers == null) return null;
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                return new int[]{i + 1, j + 1};
            } else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }
        return null;
    }

    public static String convertToTitle(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        while (n != 0) {
            n --;//这里稍作处理，因为它是从1开始
            char c = (char) (n % 26 + 'A');
            stringBuilder.append(c);
            n /= 26;
        }
        return stringBuilder.reverse().toString();
    }
}
