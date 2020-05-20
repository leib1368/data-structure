package leib.demo.juc;

import java.util.function.Function;

/**
 * @Author:Leib
 * @Date 2020/5/20 20:54
 */
public class FunctionDemo {
    public static void main(String[] args) {
/*        Function function = new Function<String,String>() {
            @Override
            public String apply(String o) {
                return o;
            }
        };*/
        Function function =(str)->{return str;};
        System.out.println(function.apply("qqq"));
    }
}
