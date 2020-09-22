package leib.demo.leecode.leetcode2009;

import java.util.Arrays;

/**
 * @Author:Leib
 * @Date 2020/9/22 17:13
 */
public class T0922 {
    //Instance;


//    public static void main(String[] args) {
//        for (int i = 0; i < 100; i++) {
//            new Thread(()->{
//                System.out.println(T0922.Instance.hashCode());
//            }).start();
//        }
//    }
    public static void main(String[] args) {
        int[] array = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
        // 只需要修改成对应的方法名就可以了
        //bubbleSort(array);

        //selectionSort(array);

        System.out.println(Arrays.toString(array));
    }

    private static void selectionSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }

        int length = array.length;

        for (int i = 0; i < length-1; i++) {
            int min = i;
            for (int j = i+1; j < length; j++) {
                if(array[min]<array[j]){
                    //swap(array,i,j);
                    min = j;
                }
            }
            if (    i!= min )swap(array,i,min);
        }
    }
    private static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    private static void bubbleSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }

        int length = array.length;

        for (int i = 0; i < length-1; i++) {
            for (int j = 0; j < length - 1 - i; j++) {
                // 前面的数大于后面的数就进行交换
                if (array[j] > array[j + 1]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }
}
