package leib.demo.leecode.leetcode2011;

import java.util.concurrent.TimeUnit;

/**
 * @Author:Leib
 * @Date 2020/11/6 8:29
 */
public class T1106 {

    final static int MAX = 5;

    //static int init_value = 0;
     static volatile int init_value = 0;

    public static void main(String[] args) {

        new Thread(() -> {
            int localValue = init_value;
            while (localValue < MAX) {
                if (init_value != localValue) {
                    System.out.printf("The init_value is update to [%d]\n", init_value);
                    localValue = init_value;
                }
            }
        }, "Reader").start();

        new Thread(() -> {
            int localValue = init_value;
            while (localValue < MAX) {
                System.out.printf("The init_value will be changed to [%d]\n", ++localValue);
                init_value = localValue;
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Updater").start();
    }


}
