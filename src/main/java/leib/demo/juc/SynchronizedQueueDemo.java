package leib.demo.juc;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * @Author:Leib
 * @Date 2020/5/20 17:31
 */
public class SynchronizedQueueDemo {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new SynchronousQueue<>();

        new Thread(()->{
            try {
                blockingQueue.put("1");
                System.out.println(Thread.currentThread().getName()+"put 1");
                blockingQueue.put("2");
                System.out.println(Thread.currentThread().getName()+"put 2");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t1").start();

        new Thread(()->{
            try {
                blockingQueue.take();
                System.out.println(Thread.currentThread().getName()+"take 1");
                blockingQueue.take();
                System.out.println(Thread.currentThread().getName()+"take 2");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t2").start();
    }
}
