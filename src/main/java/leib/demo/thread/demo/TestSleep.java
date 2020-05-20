package leib.demo.thread.demo;

/**
 * @Author:Leib
 * @Date 2020/5/14 16:51
 */
public class TestSleep {
    public static void main(String[] args) throws InterruptedException {
        fiveDown();
    }
    public static void fiveDown() throws InterruptedException {
        int num =5 ;
        while (num>0){
            Thread.sleep(1000);
            System.out.println(num--);
        }
    }
}
