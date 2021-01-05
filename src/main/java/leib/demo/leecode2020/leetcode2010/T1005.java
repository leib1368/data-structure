package leib.demo.leecode2020.leetcode2010;

import java.util.*;

/**
 * @Author:Leib
 * @Date 2020/10/5 9:25
 */
public class T1005 {
    public static void main(String[] args) {
        T1005 t1005 = new T1005();
        int [] ls= new int [] {1,-2,-5,-4,-3,3,3,5};
        int [] ls2= new int [] {-4,-3,1};
        //List<List<Integer>> list1 = t1005.fourSumByThreeSum(ls, -11);
        List<List<Integer>> list2 = t1005.threeSum(ls2, -6);
        //System.out.println(list1);
        System.out.println(list2);

    }
    public List<List<Integer>> fourSum(int[] nums,int target) {
        /*定义一个返回值*/
        List<List<Integer>> result=new ArrayList<>();
        /*当数组为null或元素小于4个时，直接返回*/
        if(nums==null||nums.length<4){
            return result;
        }
        /*对数组进行从小到大排序*/
        Arrays.sort(nums);
        /*数组长度*/
        int length=nums.length;

        for (int k = 0; k < length-3; k++) {
            /*当k的值与前面的值相等时忽略*/
            if(k>0&&nums[k]==nums[k-1]){
                continue;
            }
            /*获取当前最小值(最前三个值)，如果最小值比目标值大，说明后面越来越大的值根本没戏*/
            int min1=nums[k]+nums[k+1]+nums[k+2]+nums[k+3];
            if(min1>target){
                break;
            }
            /*获取当前最大值(最后三个值)，如果最大值比目标值小，说明后面越来越小的值根本没戏，忽略*/
            int max1=nums[k]+nums[length-1]+nums[length-2]+nums[length-3];
            if(max1<target){
                continue;
            }

            for (int i = k+1; i < length-2; i++) {
                /*当i的值与前面的值相等时忽略*/
                if(i>k+1&&nums[i]==nums[i-1]){
                    continue;
                }
                /*定义指针j指向i+1*/
                int j=i+1;
                /*定义指针h指向数组末尾*/
                int h=length-1;
                /*获取当前最小值，如果最小值比目标值大，说明后面越来越大的值根本没戏*/
                int min=nums[k]+nums[i]+nums[j]+nums[j+1];
                if(min>target){
                    break;
                }
                /*获取当前最大值，如果最大值比目标值小，说明后面越来越小的值根本没戏，忽略*/
                int max=nums[k]+nums[i]+nums[h]+nums[h-1];
                if(max<target){
                    continue;
                }
                /*开始j指针和h指针的表演，计算当前和，如果等于目标值，j++并去重，h--并去重，当当前和大于目标值时h--，当当前和小于目标值时j++*/
                while (j<h){
                    int curr=nums[k]+nums[i]+nums[j]+nums[h];
                    if(curr==target){
                        result.add(Arrays.asList(nums[k],nums[i],nums[j],nums[h]));
                        j++;
                        while(j<h&&nums[j]==nums[j-1]){
                            j++;
                        }
                        h--;
                        while(j<h&&i<h&&nums[h]==nums[h+1]){
                            h--;
                        }
                    }else if(curr>target){
                        h--;
                    }else {
                        j++;
                    }
                }
            }

        }

        return result;
    }

    public List<List<Integer>> fourSumByThreeSum(int[] nums,int target) {
        Arrays.sort(nums); // 排序
        List<List<Integer>> ans = new ArrayList<>(); //返回结果
        List<List<Integer>> source; //保存三数之和

        for (int i = 0; i < nums.length; i++) {
            if(i > 0 && nums[i] == nums[i-1]) continue; // 去重

            int temp = target; //三数之和的目标值
            temp = target- nums[i];

            int [] num = new int [nums.length-(i+1)] ; //三数数组
            for (int j = 0, k = i; j < nums.length-(i+1); j++,k++) {
                num[j] = nums[k+1];
            }

            source = threeSum(num, temp);
            if (source.size()>0){
                for(List<Integer> list : source ){
                    List<Integer> tempAns = new ArrayList<>();
                    tempAns.add(nums[i]);
                    tempAns.addAll(list);
                    if (tempAns.size()>0){
                        ans.add(tempAns);//添加到ans中
                    }
                }
            }
        }

        return ans;
    }
    public List<List<Integer>> threeSum(int[] nums,int target) {
        List<List<Integer>> ans = new ArrayList();
        int len = nums.length;
        if(nums == null || len < 3) return ans;
        Arrays.sort(nums); // 排序

        for (int i = 0; i < len; i++) {
            //if(nums[i] > target) break; // 如果当前数字大于0，则三数之和一定大于0，所以结束循环
            if(i > 0 && nums[i] == nums[i-1]) continue; // 去重

            int l = i+1;
            int r = len-1;
            while(l<r){
                int sum = nums[i] + nums[l] + nums[r] ;
                if (sum==target){
                    ans.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    while(l<r && nums[l]==nums[l+1]) l++;
                    while(l<r && nums[r]==nums[r-1]) r--;

                    l++;
                    r--;
                }
                else if(sum>target) r--;
                else if(sum<target) l++;
            }
        }
        return ans;
    }
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target-nums[i])){
                return new int [] {map.get(target-nums[i]),i};
            }else{
                map.put(nums[i],i);
            }
        }

        return new int [0] ;
    }
}
