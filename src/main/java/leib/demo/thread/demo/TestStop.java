package leib.demo.thread.demo;

/**
 * @Author:Leib
 * @Date 2020/5/14 16:40
 */
public class TestStop implements Runnable {
    private boolean flag = true;
    @Override
    public void run() {
        int j = 0;
        while (flag){
            System.out.println("run thread" + j++);
        }
    }
    public void stop(){
        this.flag = false;
    }

    public static void main(String[] args) {
        TestStop t = new TestStop() ;
        new Thread(t).start();

        for (int i = 0; i < 999; i++) {
            System.out.println("main---"+i);
            if(i==900){
                t.stop();
                System.out.println("------stop-------");
            }
        }
    }
}
