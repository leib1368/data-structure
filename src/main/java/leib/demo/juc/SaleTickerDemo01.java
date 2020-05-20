package leib.demo.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author:Leib
 * @Date 2020/5/19 21:35
 */
public class SaleTickerDemo01 {
    public static void main(String[] args) {
        //获取cpu的核数
        //cpu 密集型 io 密集型
        //System.out.println(Runtime.getRuntime().availableProcessors());
        Ticket ticket = new Ticket();

        new Thread(()->{
            for (int i = 0; i < 50; i++) {
               ticket.sale();
            }
        },"c").start();

        new Thread(()->{
            for (int i = 0; i < 50; i++) {
                ticket.sale();
            }
        },"b").start();

        new Thread(()->{
            for (int i = 0; i < 50; i++) {
                ticket.sale();
            }
        },"a").start();
    }
}
class Ticket{
    private int ticket =30;
    Lock lock = new ReentrantLock();
    public void sale(){
        try {
            lock.lock();
            if(ticket>0){
                System.out.println("剩余"+ticket--);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }
}