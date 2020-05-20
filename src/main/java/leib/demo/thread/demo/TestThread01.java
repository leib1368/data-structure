package leib.demo.thread.demo;

/**
 * @Author:Leib
 * @Date 2020/5/14 13:05
 */
public class TestThread01 extends Thread{
    @Override
    public void run(){
        for (int i = 0; i < 50; i++) {
            System.out.println("执行run方法");
        }
    }
    public static void main(String[] args) {
        TestThread01 testThread01 = new TestThread01();
        testThread01.start();
        for (int i = 0; i < 100; i++) {
            System.out.println("---执行main方法");
        }
    }
}
