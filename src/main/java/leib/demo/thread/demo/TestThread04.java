package leib.demo.thread.demo;

/**
 * @Author:Leib
 * @Date 2020/5/14 14:00
 */
public class TestThread04 implements Runnable {
    private int ticket = 10;
    @Override
    public void run() {
        while (true){
            if(ticket<0) break;
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"拿到了第"+ticket--+"票");
        }
    }
    //线程并发，线程不安全
    public static void main(String[] args) {
        TestThread04 ticket = new TestThread04();
        new Thread(ticket,"a").start();
        new Thread(ticket,"b").start();
        new Thread(ticket,"c").start();
    }
}
