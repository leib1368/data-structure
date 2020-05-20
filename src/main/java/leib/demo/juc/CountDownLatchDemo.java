package leib.demo.juc;

import java.util.concurrent.CountDownLatch;

/**
 * @Author:Leib
 * @Date 2020/5/20 13:53
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        //计数器
        CountDownLatch countDownLatch = new CountDownLatch(5);

        for (int i = 0; i < 5; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"go out");
                countDownLatch.countDown();
            },String.valueOf(i)).start();

        }
        //等待计数器归零 然后才向下执行
        countDownLatch.await();
        System.out.println("close door");
    }
}
