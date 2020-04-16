package leib.leedcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author:Leib
 * @Date 2020/4/16 18:56
 */
public class Test02 {
    public static void main(String[] args) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(1,1);
        map.put(1,2);
        map.put(1,3);
        map.put(2,1);
        System.out.println(map);
    }
}
