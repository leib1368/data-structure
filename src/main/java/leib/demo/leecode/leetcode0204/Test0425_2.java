package leib.demo.leecode.leetcode0204;

/**
 * @Author:Leib
 * @Date 2020/4/25 20:21
 */
public class Test0425_2 {
    public static void main(String[] args) {
        System.out.println(toHex(-18));

    }
    private final static String[] hex = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    public static String toHex(int num) {
        if (num >= 0 && num < 16) return hex[num];
        int tmp = 0xf;

        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            int low = num & tmp;
            num = num >>> 4;
            sb.insert(0, hex[low]);
        }
        return sb.toString();
    }

}
