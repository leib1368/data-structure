package leib.demo.juc;

import java.util.concurrent.TimeUnit;

/**
 * @Author:Leib
 * @Date 2020/5/21 17:14
 */
public class JMMdemo {
    private volatile  static  int num = 0 ;
    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            while (num==0){

            }
        }).start();

        TimeUnit.SECONDS.sleep(1);
        num=1;
        System.out.println(num);
    }
}
