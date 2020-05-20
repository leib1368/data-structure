package leib.demo.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author:Leib
 * @Date 2020/5/20 9:52
 */
public class ProductConsumer {
    public static void main(String[] args) {
        Data data = new Data();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"A").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    data.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"B").start();
    }
}
class Data{
    private int num = 0;
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
    public  void increment() throws InterruptedException {
        lock.lock();
        try {
            while(num!=0){condition.await(); }
            System.out.println(Thread.currentThread().getName()+"=>"+num);
            num++;
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {lock.unlock(); }
    }
    public  void decrement() throws InterruptedException {
        lock.lock();
        try {
            while(num==0){condition.await(); }
            System.out.println(Thread.currentThread().getName()+"=>"+num);
            num--;
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {lock.unlock(); }
    }

    public void printC(){
        lock.lock();
        try {//业务判断-->执行-->通知
            while(num!=3){
                condition.await();
            }
            num=1;
            condition.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
