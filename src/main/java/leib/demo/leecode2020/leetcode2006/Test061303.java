package leib.demo.leecode2020.leetcode2006;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:Leib
 * @Date 2020/6/13 14:39
 */
public class Test061303 {

    static int countLegs (List<? extends Animal > animals ) {
        int retVal = 0;
        for ( Animal animal : animals )
        {
           // retVal += animal.countLegs();
        }
        return retVal;
    }

    static int countLegs1 (List< Animal > animals ){
        int retVal = 0;
        for ( Animal animal : animals )
        {
           // retVal += animal.countLegs();
        }
        return retVal;
    }

    public static void main(String[] args) {
        List<Dog> dogs = new ArrayList<>();
        // 不会报错
        countLegs( dogs );
        // 报错
        //countLegs1(dogs);
    }


}
class Dog extends Animal{

}
class Animal {
    void countLegs(){

    }
}