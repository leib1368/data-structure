package leib.demo.leecode.leetcode0204;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author:Leib
 * @Date 2020/4/29 20:25
 */
public class Test0429Map {
    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<Integer,String>();
        for(int i=0; i<6; i++){
            map.put(i,"val_"+i);
        }
        map.put(10,null);
        map.forEach((key,value) -> System.out.println(key+":"+value));
        System.out.println("---");
        System.out.println(map.putIfAbsent(3,"val_66"));//val_3
        System.out.println(map.putIfAbsent(10,"val_66"));//null
        System.out.println(map.putIfAbsent(11,"val_66"));//null
        System.out.println(map.get(3)+"--"+map.get(10)+"--"+map.get(11));//val_3--val_66--val_66
        System.out.println("---");
        map.forEach((key,value) -> System.out.println(key+":"+value));
    }
}
