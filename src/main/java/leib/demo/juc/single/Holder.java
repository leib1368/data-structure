package leib.demo.juc.single;

/**
 * @Author:Leib
 * @Date 2020/5/22 13:55
 */
public class Holder {
    private Holder(){
    }
    public static Holder getInstance(){
        return InnerClass.holder;
    }
    public static class InnerClass{
        private static final Holder holder = new Holder();
    }
}
