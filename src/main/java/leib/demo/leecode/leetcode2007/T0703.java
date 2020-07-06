package leib.demo.leecode.leetcode2007;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:Leib
 * @Date 2020/7/3 20:34
 */
public class T0703 {
    public static void main(String[] args) {
        //System.out.println(getRow(3));
        isPalindrome("A man, a plan, a canal: Panama");
    }

    public static boolean isPalindrome(String s) {
        if (s.isEmpty())
            return true;
        int left = 0, right = s.length() - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left)))
                left++;
            while (left < right && !Character.isLetterOrDigit(s.charAt(right)))
                right--;
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right)))
                return false;
            left++;
            right--;
        }
        return true;

    }
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        if (numRows == 0) {
            return triangle;
        }
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);;

        for (int rowNum = 1; rowNum < numRows; rowNum++) {

            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow = triangle.get(rowNum-1);

            row.add(1);

            for (int i = 1; i < rowNum; i++) {
                row.add(prevRow.get(i-1)+prevRow.get(i));
            }

            row.add(1);
            triangle.add(row);
        }

        return triangle;
    }

    public static  List<Integer> getRow(int rowIndex) {
        rowIndex = rowIndex +1 ;
        List<Integer>  triangle = new ArrayList<>();
        if (rowIndex == 0) {
            return triangle;
        }
        triangle.add(1);;

        for (int rowNum = 1; rowNum < rowIndex; rowNum++) {

            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow = triangle;

            row.add(1);

            for (int i = 1; i < rowNum; i++) {
                row.add(prevRow.get(i-1)+prevRow.get(i));
            }

            row.add(1);
            triangle = row ;
        }

        return triangle;
    }
}
