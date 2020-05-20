package leib.demo.juc;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @Author:Leib
 * @Date 2020/5/20 14:55
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);

        for (int i = 1; i <= 6; i++) {
            new Thread(()->{
                //acquire 得到
                try {
                    System.out.println("获得车位");
                    semaphore.acquire();
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println("离开车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                }
                //release 释放
            }).start();
        }
    }
}
