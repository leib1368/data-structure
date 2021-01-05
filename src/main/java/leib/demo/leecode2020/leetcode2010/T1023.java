package leib.demo.leecode2020.leetcode2010;

/**
 * @Author:Leib
 * @Date 2020/10/23 13:11
 */
public class T1023 {
    public static void main(String[] args) {
        int list [] = {2,2,0,1};
        T1023 t1023 = new T1023();
        t1023.fib(3);
    }
    public int fib(int N) {
        int [] dp = new int [N+1];
        dp[0]=0;
        dp[1]=1;
        if(N==0) return dp[0] ;
        if(N==1) return dp[1] ;
        for(int i=2;i<=N;i++){
            dp[i] = dp[i-1] + dp[i-2];
            dp[i] %= 1000000007;
        }
        return dp[N];
    }
    public ListNode reverseList(ListNode head) {
/*        ListNode cur = null ,pre = head;
        while (pre!=null){
            ListNode t  = pre.next;
            pre.next = cur;
            cur = pre ;
            pre  = t;
        }
        return cur;*/
/*        if ( head==null|| head.next==null) return head;
        ListNode res = reverseList(head.next);
        head.next.next = head;
        head.next=null;
        return res;*/
        if (head==null) return null;
        ListNode cur = head ;
        while (head.next !=null){
            ListNode t = head.next.next;
            head.next.next=cur;
            cur = head.next;
            head.next = t;
        }
        return cur;
    }
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for(int i : A){
            sum += i;
        }
        if(sum%3 != 0){
            // 总和不是3的倍数，直接返回false
            return false;
        }

        // 使用双指针,从数组两头开始一起找，节约时间
        int left = 0;
        int leftSum = A[left];
        int right = A.length - 1;
        int rightSum = A[right];
        // 使用left + 1 < right 的原因，防止只能将数组分成两个部分
        // 例如：[1,-1,1,-1]，使用left < right作为判断条件就会出错
        while(left + 1 < right){
            if(leftSum == sum/3 && rightSum == sum/3){
                // 左右两边都等于 sum/3 ，中间也一定等于
                return true;
            }
            if(leftSum != sum/3){
                // left = 0赋予了初值，应该先left++，在leftSum += A[left];
                leftSum += A[++left];
            }
            if(rightSum != sum/3){
                // right = A.length - 1 赋予了初值，应该先right--，在rightSum += A[right];
                rightSum += A[--right];
            }
        }
        return false;
    }

    public int minArray(int[] numbers) {
        int i = 0, j = numbers.length - 1;
        while (i<j){
            int m = (i+j)/2;
            if (numbers[j]<numbers[m]) i = m+1;
            else if (numbers[j]>numbers[m]) j = m;
            else j--;
        }
        return numbers[i];
    }
}
