package leib.demo.juc;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author:Leib
 * @Date 2020/5/21 17:57
 */
public class JMMdemo02 {
    private volatile static AtomicInteger num = new AtomicInteger(0) ;

    public  static void add(){
        num.getAndIncrement();
    }
    public static void main(String[] args) {
        for (int i = 1; i <= 20; i++) {
            new Thread(()->{
                for (int j = 0; j < 1000; j++) {
                    add();
                }
            }).start();
        }
        while (Thread.activeCount()>2){
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName()+" "+num);
    }
}
