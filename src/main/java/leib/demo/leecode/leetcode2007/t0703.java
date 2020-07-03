package leib.demo.leecode.leetcode2007;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:Leib
 * @Date 2020/7/3 20:34
 */
public class t0703 {
    public static void main(String[] args) {
        generate(5);
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
}
