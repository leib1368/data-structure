package leib.demo.leecode.leetcode2006;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:Leib
 * @Date 2020/6/13 13:51
 */
class test0613 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        List<String> stringArrayList = new ArrayList<String>();
        List<Integer> integerArrayList = new ArrayList<Integer>();

        Class classStringArrayList = stringArrayList.getClass();
        Class classIntegerArrayList = integerArrayList.getClass();

        System.out.println(classStringArrayList);
        System.out.println(classIntegerArrayList);

        Object obj = genericMethod(Class.forName("leib.demo.leecode.leetcode2006.test0613"));
        System.out.println(obj);
    }


    Generic<Integer> genericInteger = new Generic<Integer>(123456);
    //传入的实参类型需与泛型的类型参数类型相同，即为String.
    Generic<String> genericString = new Generic<String>("key_vlaue");


    public static <T> T genericMethod(Class<T> tClass)throws InstantiationException ,IllegalAccessException{
        T instance = tClass.newInstance();
        return instance;
    }

}
class Generic<T>{
    //key这个成员变量的类型为T,T的类型由外部指定
    private T key;

    public Generic(T key) { //泛型构造方法形参key的类型也为T，T的类型由外部指定
        this.key = key;
    }

    public T getKey(){ //泛型方法getKey的返回值类型为T，T的类型由外部指定
        return key;
    }
}
