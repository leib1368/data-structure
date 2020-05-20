package leib.demo.thread.demo;

/**
 * @Author:Leib
 * @Date 2020/5/14 13:38
 */
public class TestThread03 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            System.out.println("执行run方法");
        }
    }

    public static void main(String[] args) {
        TestThread03 testThread03 = new TestThread03();
        //创建线程对象，通过线程对象来开启我们的线程代理
        new Thread(testThread03).start();
        for (int i = 0; i < 1000; i++) {
            System.out.println("---执行main方法");
        }
    }
}
