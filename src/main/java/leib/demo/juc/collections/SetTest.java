package leib.demo.juc.collections;

import java.util.*;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @Author:Leib
 * @Date 2020/5/20 12:52
 */
public class SetTest {
    public static void main(String[] args) {
        //ConcurrentModificationException
        //Set<String> set = new HashSet<>();
        //Set<String> set = Collections.synchronizedSet(new HashSet<>()) ;
        Set<String> set = new CopyOnWriteArraySet<>();

        for (int i = 1; i <= 30; i++) {
            new Thread(()->{
                set.add(UUID.randomUUID().toString().substring(0,5));
                System.out.println(set);
            },String.valueOf(i)).start();
        }
    }
}
