package leib.demo.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @Author:Leib
 * @Date 2020/5/26 13:59
 */
public class Test04 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {
        Class<?> c1 = Class.forName("leib.demo.reflection.User");

        User user = new User();
        c1 = user.getClass();

        //获得类名和包名
        System.out.println(c1.getName());
        System.out.println(c1.getSimpleName());

        //只能找到public属性
        Field[] fields = c1.getFields();
        //获得全部属性
        fields = c1.getDeclaredFields();
        for (Field field:fields) {
            System.out.println(field);
        }

        //获得指定属性的值（私有的也
        Field name = c1.getDeclaredField("name");
        System.out.println(name);

        //获得类以及父类的public方法
        Method[] methods = c1.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
        //获得类的所有方法
        methods = c1.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method);
        }

        Method getName = c1.getMethod("getName");
        Method setName = c1.getMethod("setName", String.class);

        Constructor<?>[] constructors = c1.getConstructors();
        Constructor<?>[] declaredConstructors = c1.getDeclaredConstructors();
        Constructor<?> declaredConstructor = c1.getDeclaredConstructor(String.class);
    }
}
