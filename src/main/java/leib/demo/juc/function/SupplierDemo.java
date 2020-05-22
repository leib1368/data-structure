package leib.demo.juc.function;

import java.util.function.Supplier;

/**
 * @Author:Leib
 * @Date 2020/5/20 21:11
 */
public class SupplierDemo {
    public static void main(String[] args) {
/*        Supplier supplier = new Supplier() {
            @Override
            public Integer get() {
                System.out.println("get()");
                return 1024 ;
            }
        };*/
        Supplier supplier =()->{
            //lambda只能写一行
            //System.out.println("get()");
            return 1024 ;
        };
        System.out.println(supplier.get());
    }
}
