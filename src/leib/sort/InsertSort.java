package leib.sort;

import java.util.Arrays;

/**
 * @Author:Leib
 * @Date 2020/4/14 17:11
 */
public class InsertSort {
    public static void main(String[] args) {
        int [] arr = new int []{3,2,1,5,61,4};
        System.out.println(Arrays.toString(arr));
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void insertSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            if(arr[i]<arr[i-1]){
                int temp = arr[i];
                int j ;
                for (j=i-1;j>=0&&temp<arr[j]; j--) {
                    arr[j+1] = arr[j];
                }
                arr[j+1]= temp;
            }
        }
    }
}
