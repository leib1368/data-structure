package leib.demo.leecode2021.T2101;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author:Leib
 * @Date 2021/1/5 20:08
 */
public class T0105 {
    public static void main(String[] args) {
        T0105 t0105 = new T0105() ;
        t0105.largeGroupPositions("aaaaqqqccc");
    }
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        int n = s.length();
        int num = 1;
        for (int i = 0; i < n; i++) {
            if (i == n - 1 || s.charAt(i) != s.charAt(i + 1)) {
                if (num >= 3) {
                    ret.add(Arrays.asList(i - num + 1, i));
                }
                num = 1;
            } else {
                num++;
            }
        }
        return ret;
    }
}
