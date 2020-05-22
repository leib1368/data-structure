package leib.demo.juc.function;

import java.util.function.Consumer;

/**
 * @Author:Leib
 * @Date 2020/5/20 21:08
 */
public class ConsumerDemo {
    public static void main(String[] args) {
/*        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };*/
        Consumer<String> consumer =(s)->{
            System.out.println(s);
        };
        consumer.accept("asd");
    }
}
