package leib.demo.juc.single;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * @Author:Leib
 * @Date 2020/5/22 12:23
 */
public class LazyMan {
    private static boolean signal = false ;
    private LazyMan(){
        synchronized (LazyMan.class){
            if(signal==false){
                signal = true ;
            }else{
                throw  new RuntimeException("不要试图用反射修改");
            }
        }
        System.out.println(Thread.currentThread().getName()+"ok");
    }
    //需要加volatile
    private volatile static  LazyMan lazyMan;
    //双重检测锁模式的DCL懒汉式
    public static LazyMan getInstance(){
        if(lazyMan==null){
            synchronized (LazyMan.class){
                if(lazyMan==null) {
                    lazyMan = new LazyMan();
                    /*非原子性操作
                    * 1 分配内存空间
                    * 2 执行构造空间 初始化
                    * 3 把对象指向这个空间
                    *   并发下 可能发生指令重排
                    * */
                }
            }
        }
        return lazyMan;
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        //LazyMan instance = LazyMan.getInstance();
        Field signal = LazyMan.class.getDeclaredField("signal");
        signal.setAccessible(true);

        Constructor<LazyMan> declaredConstructor = LazyMan.class.getDeclaredConstructor(null);
        declaredConstructor.setAccessible(true);

        LazyMan lazyMan1 = declaredConstructor.newInstance();
        signal.set(lazyMan1,false);

        LazyMan lazyMan2 = declaredConstructor.newInstance();
        System.out.println(lazyMan1);
        System.out.println(lazyMan2);
    }
}
