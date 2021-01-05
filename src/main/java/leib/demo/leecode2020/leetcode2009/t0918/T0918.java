package leib.demo.leecode2020.leetcode2009.t0918;

import javax.servlet.http.Cookie;
import java.lang.reflect.Executable;
import java.util.Properties;

/**
 * @Author:Leib
 * @Date 2020/9/18 11:50
 */
public class T0918 {
    Cookie cookie = new Cookie("","");
    Properties info = new Properties();

    public static void main(String[] args) {

        CalculatorImpl calculatorImpl = new CalculatorImpl();
        //把目标对象通过构造器塞入代理对象
        Calculator calculator = new CalculatorProxy(calculatorImpl);
        //代理对象调用目标对象方法完成计算，并在前后打印日志
        calculator.add(1, 2);
        calculator.subtract(2, 1);
    }

    public void A(Executable[] a){

    }
}
