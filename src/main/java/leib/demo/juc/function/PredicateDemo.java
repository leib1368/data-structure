package leib.demo.juc.function;

import java.util.function.Predicate;

/**
 * @Author:Leib
 * @Date 2020/5/20 21:00
 */
public class PredicateDemo {
    public static void main(String[] args) {
/*        Predicate<String> predicate = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.isEmpty();
            }
        };*/
        Predicate<String> predicate=(s)->{
            return s.isEmpty();
        };
        System.out.println(predicate.test(""));
    }
}
