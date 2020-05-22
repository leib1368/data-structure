package leib.demo.thread.demo;

/**
 * @Author:Leib
 * @Date 2020/5/14 17:02
 */
public class TestYield {
    public static void main(String[] args) {
        MyYield myYield = new MyYield();
        new Thread(myYield,"a").start();
        new Thread(myYield,"b").start();
    }
}
class MyYield implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"开始");
        //Thread.yield();
        System.out.println(Thread.currentThread().getName()+"结束");
    }
}
