package leib.demo.reflection;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * @Author:Leib
 * @Date 2020/5/26 14:50
 */
public class Test06 {
    public void test01(Map<String,User> map , List<User> list){
        System.out.println("test01");
    }
    public Map<String,User>  test02(){
        System.out.println("test02");
        return null;
    }
    public static void main(String[] args) throws NoSuchMethodException {
        Method test01 = Test06.class.getMethod("test01", Map.class, List.class);
        Type[] parameterTypes = test01.getGenericParameterTypes();
        for (Type parameterType : parameterTypes) {
            System.out.println(parameterType);
            if(parameterType instanceof ParameterizedType){
                Type[] types = ((ParameterizedType) parameterType).getActualTypeArguments();
                for (Type type : types) {
                    System.out.println("真实参数："+type);
                }
            }
        }

        Method test02 = Test06.class.getMethod("test02");
        Type genericReturnType = test02.getGenericReturnType();

        if(genericReturnType instanceof ParameterizedType){
            Type[] types = ((ParameterizedType) genericReturnType).getActualTypeArguments();
            for (Type type : types) {
                System.out.println("真实返回参数："+type);
            }
        }

    }
}
