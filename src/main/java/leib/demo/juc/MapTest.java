package leib.demo.juc;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author:Leib
 * @Date 2020/5/20 13:00
 */
public class MapTest {
    public static void main(String[] args) {
        //容量与默认加载因子
        //Map<String,String> map = new HashMap<>(16,0.75);
        //Map<String,String> map = new HashMap<>();
        Map<String,String> map = new ConcurrentHashMap<>();

        for (int i = 1; i <= 20; i++) {
            new Thread(()->{
                map.put(Thread.currentThread().getName(),UUID.randomUUID().toString().substring(0,5));
                System.out.println(map);
            },String.valueOf(i)).start();
        }
    }
}
