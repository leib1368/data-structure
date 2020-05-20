package leib.demo.thread.demo;

/**
 * @Author:Leib
 * @Date 2020/5/14 18:15
 */
public class TestDaemon {
    public static void main(String[] args) {
        God god = new God();
        You you = new You();
        Thread thread = new Thread(god);
        thread.setDaemon(true);
        thread.start();
        new Thread(you).start();
    }
}
class God implements Runnable{
    @Override
    public void run() {
        while (true){
            System.out.println("god with you");
        }
    }
}
class You implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 365; i++) {
            System.out.println("hello world ");
        }
        System.out.println("goodbye world ");
    }
}
