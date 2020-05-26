package leib.demo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author:Leib
 * @Date 2020/5/26 9:52
 */
//自定义注解
public class Test {
    @MyAnnotation1("value" )
    public void test1(){}
}
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation1 {
    //注解的参数:参数类型+参数名| 和方法不同
    String name () default "s";
    // 默认值为-1时 代表不存在
    int id() default -1 ;
    String [] schools() default {"bj","qh"};
    //如果参数是value上方可以省略参数=
    String value();
}

