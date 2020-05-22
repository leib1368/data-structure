package leib.demo.juc.thread;

import java.util.concurrent.*;

/**
 * @Author:Leib
 * @Date 2020/5/20 20:03
 */
public class PoolDemo {
    //Executors三大方法
    public static void main(String[] args) {
        ExecutorService threadPool = new ThreadPoolExecutor(2,5,
                3, TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardOldestPolicy());
        try {
            //最大承载：deque+max=8
            for (int i = 1; i <= 9; i++) {
            threadPool.execute(()->{
                System.out.println(Thread.currentThread().getName()+"ok");
            });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }
}
