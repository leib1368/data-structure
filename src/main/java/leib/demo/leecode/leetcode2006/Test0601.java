package leib.demo.leecode.leetcode2006;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @Author:Leib
 * @Date 2020/6/1 9:50
 */
public class Test0601 {
    public static void main(String[] args) {
        int [] list = {3,3,4,4,2};
        int ec= 2 ;
        //System.out.println(kidsWithCandies(list, ec));
        //System.out.println(maxProfit1(list));
        System.out.println(singleNumber2(list));
    }

    public static int singleNumber1(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer count = map.get(nums[i]);
            if (count == null) {
                map.put(nums[i],1);
            }else{
                map.put(nums[i],count+1);
            }
        }
        Integer only = 1;
        final Integer[] ans = {null};
        map.forEach((k,v)-> {
            System.out.println("Item : " + k + " Count : " + v);
            if(only.equals(v)){
                System.out.println("Hello E");
                ans[0] = k ;
            }
        })    ;
        return ans[0] ;
    }

    public static int singleNumber2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer i : nums) {
            Integer count = map.get(i);
            count = count == null ? 1 : ++count;
            map.put(i, count);
        }
        for (Integer i : map.keySet()) {
            Integer count = map.get(i);
            if (count == 1) {
                return i;
            }
        }
        return -1;
        // can't find it.
    }

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int n=candies.length;
        Integer[] iarr=new Integer[n];
        for(int i=0;i<n;i++){
            iarr[i]=new Integer(candies[i]);
        }

        List<Boolean> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int max = (int) Collections.max(Arrays.asList(iarr));
            int temp = iarr[i];

            Boolean tempAns = temp + extraCandies >= max;
            ans.add(tempAns);
        }

        return ans;
    }

    //买卖股票 暴力循环
    public static int maxProfit1(int prices[]) {
        int maxprofit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                if (profit > maxprofit)
                    maxprofit = profit;
            }
        }
        return maxprofit;
    }

    public static int maxProfit2(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;
    }
}
