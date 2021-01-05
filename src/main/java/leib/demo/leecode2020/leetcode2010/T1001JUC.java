package leib.demo.leecode2020.leetcode2010;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * @Author:Leib
 * @Date 2020/10/1 15:25
 */
public class T1001JUC {
    public static void main(String[] args) {
        String ran1 = UUID.randomUUID().toString().substring(0,5);
        String ran2 = UUID.randomUUID().toString().substring(0,5);
        String ran3 = UUID.randomUUID().toString().substring(0,5);
        System.out.println(ran1);
        System.out.println(ran2);
        System.out.println(ran3);
        Set<String> set = new HashSet<>();
        set.add(ran1);
        set.add(ran2);
        set.add(ran3);
        System.out.println(set);

        for (int i = 0; i < 5; i++) {
            new Thread(()->{
                set.add(UUID.randomUUID().toString().substring(0,5));
                System.out.println(set+"->"+Thread.currentThread().getName());
            },String.valueOf(i)).start();
        }
    }
}
