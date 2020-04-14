package leib.sort;

import java.util.Arrays;

/**
 * @Author:Leib
 * @Date 2020/4/14 16:17
 */
public class BubbleSort {
    public static void main(String[] args) {
        int [] arr = new int []{3,2,1,5,61,4};
        System.out.println(Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public   static  void bubbleSort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j <arr.length - 1 - i; j++) {
                if(arr[j]>arr[j+1]){
                    int temp= arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }

}
