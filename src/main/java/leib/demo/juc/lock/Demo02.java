package leib.demo.juc.lock;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @Author:Leib
 * @Date 2020/5/22 15:13
 */
public class Demo02 {
    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    public void myLock() {
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName() + "-->mylock");
        while (!atomicReference.compareAndSet(null, thread)) {

        }
    }

    public void myUnLock() {
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName() + "-->myunlock");
        atomicReference.compareAndSet(thread, null);
    }
}
