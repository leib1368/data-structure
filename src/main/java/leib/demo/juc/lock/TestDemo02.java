package leib.demo.juc.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author:Leib
 * @Date 2020/5/22 15:31
 */
public class TestDemo02 {
    public static void main(String[] args) throws InterruptedException {
        Demo02 lock = new Demo02();

        new Thread(()->{
            lock.myLock();
            lock.myUnLock();
        },"T1").start();

        TimeUnit.SECONDS.sleep(2);

        new Thread(()->{
            lock.myLock();
            lock.myUnLock();
        },"T2").start();
    }
}
