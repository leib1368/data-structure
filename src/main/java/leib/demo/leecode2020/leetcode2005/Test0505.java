package leib.demo.leecode2020.leetcode2005;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author:Leib
 * @Date 2020/5/5 21:28
 */
public class Test0505 {
    public static void main(String[] args) {
        List<String> l1 = new ArrayList<>();
        l1.add("London");
        l1.add("New York");

        List<String> l2 = new ArrayList<>();
        l2.add("New York");
        l2.add("Lima");

        List<String> l3 = new ArrayList<>();
        l3.add("Lima");
        l3.add("LA");

        List<List<String>> list = new ArrayList<>();
        list.add(l1);
        list.add(l2);
        list.add(l3);

        System.out.println(destCity(list));;
    }
    public  static String destCity(List<List<String>> paths) {
        Map<String, String> map = new HashMap<>();

         for(List<String> path : paths){
             map.put(path.get(0), path.get(1));
         }
       // paths.forEach(path->map.put(path.get(0),path.get(1)));

        String from = paths.get(0).get(0);
        while(true){
            if(!map.containsKey(from))
                return from;
            from = map.get(from);
        }

    }



}
