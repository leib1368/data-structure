package leib.demo.leecode.leetcode2010;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TransferQueue;

/**
 * @Author:Leib
 * @Date 2020/10/2 11:37
 */
public class T1002 {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
    }
}
class Fruit {
    static int x = 10;
    static BigWaterMelon bigWaterMelon_1 = new BigWaterMelon(x);
    int y = 20;
    BigWaterMelon bigWaterMelon_2 = new BigWaterMelon(y);
    public static void main(String[] args) {
        final Fruit fruit = new Fruit();
        int z = 30;
        BigWaterMelon bigWaterMelon_3 = new BigWaterMelon(z);
        new Thread() {
            @Override
            public void run() {
                int k = 100;
               setWeight(k);
                bigWaterMelon_3.weight=k;
            }
            void setWeight(int waterMelonWeight) {
                fruit.bigWaterMelon_2.weight = waterMelonWeight;
            }
        }.start();
    }
}
class BigWaterMelon {
    public BigWaterMelon(int weight) {
        this.weight = weight;
    }
    public int weight;
}
