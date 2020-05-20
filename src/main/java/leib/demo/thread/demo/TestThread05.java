package leib.demo.thread.demo;

/**
 * @Author:Leib
 * @Date 2020/5/14 14:13
 */
public class TestThread05 implements Runnable {
    private static String  winner ;
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            boolean flag = gameover(i);
            System.out.println(Thread.currentThread().getName()+"跑了"+i+"步");
            if(flag) break;
        }
    }

    private boolean gameover(int steps) {
        if(winner!=null){
            return true;
        }
        if(steps>=100){
            winner = Thread.currentThread().getName();
            System.out.println("winner is"+winner);
            return true ;
        }
        return false ;
    }

    public static void main(String[] args) {
        TestThread05 race = new TestThread05();
        new Thread(race,"兔子").start();
        new Thread(race,"乌龟").start();
        new Thread(new TestThread05(),"1").start();
    }
}
