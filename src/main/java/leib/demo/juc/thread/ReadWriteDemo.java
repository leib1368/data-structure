package leib.demo.juc.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author:Leib
 * @Date 2020/5/20 15:14
 */
public class ReadWriteDemo {
    public static void main(String[] args) {
        MyCahe myCahe = new MyCahe() ;
        for (int i = 0; i < 5; i++) {
            final int temp = i;
            new Thread(()->{
            myCahe.put(temp+"",temp+"");
            },String.valueOf(i)).start();
        }
        for (int i = 0; i < 5; i++) {
            final int temp = i;
            new Thread(()->{
                myCahe.get(temp+"");
            },String.valueOf(i)).start();
        }
    }
}

class MyCahe{
    private volatile Map<String,Object> map = new HashMap<>();
    private ReadWriteLock lock = new ReentrantReadWriteLock();
    public void put (String key , Object value){
        lock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"write"+key);
            map.put(key,value);
            System.out.println(Thread.currentThread().getName()+"write ok" );
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.writeLock().unlock();
        }
    }
    public void get (String key){
        lock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"read"+key);
            Object o = map.get(key);
            System.out.println(Thread.currentThread().getName()+"read ok" );
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.readLock().unlock();
        }
    }
}