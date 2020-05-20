package leib.demo.juc;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Author:Leib
 * @Date 2020/5/20 12:27
 */
public class ListTest {
    public static void main(String[] args) {
        //并发下 Arraylist不安全
        //java.util.ConcurrentModificationException
        //List<String> list = new ArrayList<>();
        //解决方案
        //1:List<String> list = new Vector<>();
        //2:List<String> list = Collections.synchronizedList(new ArrayList<>());
        //3:JUC下的包
        // List<String> list = new CopyOnWriteArrayList<>();

        //写入时复制
        List<String> list = new CopyOnWriteArrayList<>();

        for (int i = 1; i <= 10; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,5));
                System.out.println(list);
            },String.valueOf(i)).start();
        }
    }
}
