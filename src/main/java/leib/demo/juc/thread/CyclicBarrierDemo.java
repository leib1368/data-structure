package leib.demo.juc.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Author:Leib
 * @Date 2020/5/20 14:42
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7,()->{
            System.out.println("有七颗龙珠、神龙何在！");
        });
        for (int i = 1; i <= 7; i++) {
            int temp = i;
            //小问题 lambda能调用for循环的i吗？
            new Thread(()->{
                System.out.println("已收集"+temp);
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }

    }
}
