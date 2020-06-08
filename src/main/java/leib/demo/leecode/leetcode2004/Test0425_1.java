package leib.demo.leecode.leetcode2004;

/**
 * @Author:Leib
 * @Date 2020/4/25 12:37
 */
public class Test0425_1 {
    public static void main(String[] args) {
        int a = 12;
        int b = 23;
        Test0425_1 aa = new Test0425_1();
        aa.add(a,b);
    }
    public void add(int a,int b){
        System.out.println("计算的结果是："+(a+b));
    }
    //链表相交 双指针查询
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        ListNode pA = headA, pB = headB;
        while(pA!=pB){
            pA= pA == null?headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}
