package leib.demo.thread.proxy;

/**
 * @Author:Leib
 * @Date 2020/5/26 17:24
 */
public class Host implements Rent {
    @Override
    public void rent() {
        System.out.println("房东租房子");
    }

    @Override
    public void sale() {
        System.out.println("收钱");
    }
}
