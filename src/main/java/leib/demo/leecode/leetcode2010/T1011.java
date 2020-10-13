package leib.demo.leecode.leetcode2010;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author:Leib
 * @Date 2020/10/11 15:04
 */
public class T1011 {
    public static void main(String[] args) {
        T1011 t1011 = new T1011();
        int[] list = {1,2,5};
       // System.out.println(t1011.coinChange(list, 11));
        ListNode l1= new ListNode(1);
        ListNode l2= new ListNode(2);
        ListNode l3= new ListNode(3);
        ListNode l4= new ListNode(4);
        ListNode l5= new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        t1011.swapPairs1(l1);
    }
    public ListNode swapPairs1(ListNode head) {
        if (head ==null || head.next==null) return  head;
        ListNode p1 = head;
        ListNode p2 = head.next;
        ListNode newHead = p2;
        while (true){
            p1.next = p2.next;
            p2.next = p1;
            if (p1.next==null || p1.next.next==null) break;
            ListNode temp = p1.next ;
            p1.next = p1.next.next;
            p1 = temp ;
            p2 = temp.next;
        }
        return newHead;
    }
    public ListNode swapPairs(ListNode head) {
        // 最多就 1 个节点，无需交换
        if (head == null || head.next == null) {
            return head;
        }
        // 至少两个结点
        ListNode p1 = head, p2 = head.next;
        ListNode newhead = p2;  // 交换后，它就是最终链表的第一个元素
        while (true) {
            // 两两交换
            p1.next = p2.next;
            p2.next = p1;
            // 如果后面没有两个以上的节点，停止交换
            if (p1.next == null || p1.next.next == null) {
                break;
            }
            // 否则还要继续交换
            ListNode temp = p1.next;    //  记录一下，否则执行“串起来”后无法让p1,p2指向两个新的待交换节点
            p1.next = p1.next.next;     // “串起来”
            p1 = temp;                  //  分别指向两个
            p2 = temp.next;             //  新的待交换节点
        }
        return newhead;
    }

    public int coinChange(int[] coins, int amount) {
        if (amount < 0) return -1;
        if (amount == 0) return 0;

        int[] dp = new int[amount+1];
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = amount+1;
            for (int c: coins) {
                if (i-c<0) continue;
                dp[i] = Math.min(dp[i],dp[i-c]+1);
            }
        }

        return (dp[amount] == amount+1) ? -1 :dp[amount];
    }

    public boolean canPartition(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // 特判：如果是奇数，就不符合要求
        if ((sum & 1) == 1) {
            return false;
        }

        int target = sum / 2;
        return dfs(nums, 0, 0, sum / 2);
    }

    Map<String, Boolean> ms = new HashMap<>();

    private boolean dfs(int[] nums, int i, int curSum, int target) {
        String key = curSum + "&" + i;
        if (ms.containsKey(key)) return ms.get(key);
        if (i > nums.length - 1 || curSum > target) return false;
        if (curSum == target) return true;
        //res 分两种 一种加入当前i 一种不加入i
        boolean res = dfs(nums, i + 1, curSum + nums[i], target) || dfs(nums, i + 1, curSum, target);
        ms.put(key, res);
        return res;
    }

    public boolean canPartition1(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        // 特判：如果是奇数，就不符合要求
        if ((sum & 1) == 1) {
            return false;
        }

        int target = sum / 2;
        // 创建二维状态数组，行：物品索引，列：容量（包括 0）
        boolean[][] dp = new boolean[len][target + 1];

        // 先填表格第 0 行，第 1 个数只能让容积为它自己的背包恰好装满
        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }
        // 再填表格后面几行
        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= target; j++) {
                // 直接从上一行先把结果抄下来，然后再修正
                dp[i][j] = dp[i - 1][j];

                if (nums[i] == j) {
                    dp[i][j] = true;
                    continue;
                }
                if (nums[i] < j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
            }
        }
        return dp[len - 1][target];
    }

    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        // 背包容量为整数，sum+S为奇数的话不满足要求
        if ((sum + S) % 2 == 1) {
            return 0;
        }
        // 目标和不可能大于总和
        if (S > sum) {
            return 0;
        }
        int len = (sum + S) / 2;
        int[] dp = new int[len + 1];
        dp[0] = 1;

        for (int num : nums) {
            for (int i = len; i >= num; --i) {
                dp[i] += dp[i - num];
            }
        }

        return dp[len];
    }
}
