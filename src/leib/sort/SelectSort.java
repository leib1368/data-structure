package leib.sort;

import java.util.Arrays;

/**
 * @Author:Leib
 * @Date 2020/4/14 18:06
 */
public class SelectSort {
    public static void main(String[] args) {
        int [] arr = new int []{3,2,1,5,61,4};
        System.out.println(Arrays.toString(arr));
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void selectSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i+1; j < arr.length; j++) {
                if(arr[minIndex]>arr[j]){
                    minIndex = j;
                }
            }
            if(i!=minIndex){
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }
}
