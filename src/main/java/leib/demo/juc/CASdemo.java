package leib.demo.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @Author:Leib
 * @Date 2020/5/22 14:29
 */
public class CASdemo {
    public static void main(String[] args) {
        AtomicStampedReference<Integer> atomicInteger = new AtomicStampedReference<>(1,1);

        new Thread(()->{
            //可以理解为sql里乐观锁的版本号
            int stamp = atomicInteger.getStamp();
            System.out.println("a1->"+stamp);

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(atomicInteger.compareAndSet(1, 3,
                    atomicInteger.getStamp(), atomicInteger.getStamp() + 1)+"---a");
            System.out.println("a2->"+atomicInteger.getStamp());

            System.out.println(atomicInteger.compareAndSet(3, 1,
                    atomicInteger.getStamp(), atomicInteger.getStamp() + 1)+"---a");
            System.out.println("a3->"+atomicInteger.getStamp());
        },"a").start();

        new Thread(()->{
            //可以理解为sql里乐观锁的版本号
            int stamp = atomicInteger.getStamp();
            System.out.println("b1->"+stamp);

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(atomicInteger.compareAndSet(1, 66,
                    stamp, stamp + 1));
            System.out.println("b2->"+atomicInteger.getStamp());

        },"b").start();

    }
}
