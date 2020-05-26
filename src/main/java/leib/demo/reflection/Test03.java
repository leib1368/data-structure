package leib.demo.reflection;

/**
 * @Author:Leib
 * @Date 2020/5/26 11:59
 */
public class Test03 {
    public static void main(String[] args) {
        A a = new A();
        System.out.println(A.m);
        /*
        * 1.加载到内存,会产生一个类对应的class对象
        * 2.链接,链接结束后m=0
        * 3.初始化
        *       <clinit>(){
                    System.out.println("A静态方法快");
                    m = 300;
                    m = 100;
        *       }
        *       因此m=100
        */
    }
}
class A{
    static {
        System.out.println("A静态方法快");
        m = 300;
    }
    static int m = 100;
    public A(){
        System.out.println("A的无参构造方法");
    }
}
