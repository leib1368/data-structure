package leib.demo.juc.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Author:Leib
 * @Date 2020/5/20 15:53
 */
public class BlockingQueue {
    public static void main(String[] args) throws InterruptedException {
        test4();
    }
    public static void test1(){
        ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue(3);
        System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));
        //IllegalStateException: Queue full
        //System.out.println(blockingQueue.add("d"));

        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        //NoSuchElementException
        //System.out.println(blockingQueue.remove());
    }

    public static void test2(){
        ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue(1);
        blockingQueue.offer("1");
        blockingQueue.offer("2");
        blockingQueue.poll();
        blockingQueue.poll();
    }

    public static void test3() throws InterruptedException {
        ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue(1);
        blockingQueue.put("1");
        //blockingQueue.put("2");
        blockingQueue.take();
        //blockingQueue.take();
    }

    public static void test4() throws InterruptedException {
        ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue(1);
        blockingQueue.offer("1");
        blockingQueue.offer("2",2, TimeUnit.SECONDS);//超过两秒就退出
        blockingQueue.poll();
        blockingQueue.poll(2,TimeUnit.SECONDS);//超过两秒就退出
    }
}
