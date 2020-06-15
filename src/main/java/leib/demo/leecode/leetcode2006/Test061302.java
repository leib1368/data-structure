package leib.demo.leecode.leetcode2006;

/**
 * @Author:Leib
 * @Date 2020/6/13 14:17
 */
public class Test061302 {

    public class Generic<T> {
        private T key;

        public Generic(T key) {
            this.key = key;
        }
        public T getKey(){
            return key;
        }
    }
    public <T> T showKeyName(Generic<T> container){
        System.out.println("container key :" + container.getKey());
        //当然这个例子举的不太合适，只是为了说明泛型方法的特性。
        T test = container.getKey();
        return test;
    }

    public static <T> void printMsg( T... args){
        for(T t : args){
            System.out.println(("泛型测试 t is " + t));
        }
    }

    public static class StaticGenerator<T> {

        /**
         * 如果在类中定义使用泛型的静态方法，需要添加额外的泛型声明（将这个方法定义成泛型方法）
         * 即使静态方法要使用泛型类中已经声明过的泛型也不可以。
         * 如：public static void show(T t){..},此时编译器会提示错误信息：
         "StaticGenerator cannot be refrenced from static context"
         */

        public static <T> void show(T t){

        }
    }

    public static void main(String[] args) {
        printMsg("111",222,"aaaa","2323.4",55.55);
    }

}