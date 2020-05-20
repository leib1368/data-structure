package leib.demo.thread.demo;

/**
 * @Author:Leib
 * @Date 2020/5/14 17:05
 */
public class TestJoin implements  Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("vip"+i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TestJoin testJoin = new TestJoin();
        Thread thread = new Thread(testJoin);
        thread.start();

        for (int i = 0; i < 100; i++) {
            if (i == 50) {
                thread.join();
            }
            System.out.println("main"+i);
        }
    }
}
