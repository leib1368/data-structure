package leib.demo.leecode2020.leetcode2006;

import java.util.Stack;

/**
 * @Author:Leib
 * @Date 2020/6/5 9:00
 */
class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> min_stack;
    public MinStack() {
        stack = new Stack<>();
        min_stack = new Stack<>();
    }
    public void push(int x) {
        stack.push(x);
        if(min_stack.isEmpty() || x <= min_stack.peek())
            min_stack.push(x);
    }
    public void pop() {
        if(stack.pop().equals(min_stack.peek()))
            min_stack.pop();
    }
    public int top() {
        return stack.peek();
    }
    public int getMin() {
        return min_stack.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        //Stack<Integer> stack1 = minStack.stack;
        minStack.getMin();
    }
}

