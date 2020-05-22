package leib.demo.juc.single;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @Author:Leib
 * @Date 2020/5/22 14:22
 */
public enum  EnumSingle {
    INSTANCE;
    public EnumSingle getInstance(){
        return INSTANCE;
    }
}
class Test{
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        EnumSingle instance = EnumSingle.INSTANCE;
        Constructor<EnumSingle> declaredConstructor =EnumSingle.class.getDeclaredConstructor(String.class,int.class);
        declaredConstructor.setAccessible(true);
        EnumSingle instance2 =declaredConstructor.newInstance();

        System.out.println(instance);
        System.out.println(instance2);
    }
}
