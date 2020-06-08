package leib.demo.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * @Author:Leib
 * @Date 2020/5/26 20:50
 */
//标注这是切面的类

@Aspect
public class PointCut {
    //aspect的execution表达式
    @Before("execution(* leib.demo.aop.*(..))")
    public void before(){
        System.out.println("before");
    }
}
