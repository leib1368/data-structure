package leib.demo.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author:Leib
 * @Date 2020/5/26 14:22
 */
public class Test05 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Class<?> c1 = Class.forName("leib.demo.reflection.User");
/*        User user = (User) c1.newInstance();
        //本质调用无参构造器
        System.out.println(user);*/

/*        Constructor<?> constructor = c1.getDeclaredConstructor(String.class, int.class, int.class);
        User leib = (User) constructor.newInstance("leib", 001, 24);
        System.out.println(leib);*/

        //通过反射调用普通方法
        User u = (User) c1.newInstance();
        //通过反射获取方法
        Method setName = c1.getDeclaredMethod("setName", String.class);

        //invoke 激活 （对象,“方法值”
        setName.invoke(u,"leibniz");
        System.out.println(u.getName());


        User u1 = (User) c1.newInstance();
        Field name = c1.getDeclaredField("name");

        //不能直接操作私有属性,需要关闭程序的安全检测
        name.setAccessible(true);
        name.set(u1,"leibniz");

        System.out.println(u1.getName());
    }
}
