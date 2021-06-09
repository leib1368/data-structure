package leib.demo.leecode2021.T2106;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author:Leib
 * @Date 2021/6/9 22:57
 */
public class T0609 {
    public static void main(String[] args) {
        List<Map<String,String>> listA = new ArrayList<>();
        List<Map<String,String>> listB = new ArrayList<>();

        HashMap<String,String> mapA = new HashMap<>();
        HashMap<String,String> mapB = new HashMap<>();

        mapA.put("A","001");
        listA.add(mapA);
        listB.addAll(listA);

        String a = "string-a";
        mapA.put("B",a);

        for (Map<String,String> map : listB ) {
            //此时创建临时变量 即使跳出循环 依旧存在
            map.put("A","***");
        }

        System.out.println(listA);
        System.out.println(listB);
    }
}
