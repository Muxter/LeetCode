/**
 *	Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 *	push(x) -- Push element x onto stack.
 *	pop() -- Removes the element on top of the stack.
 *	top() -- Get the top element.
 *	getMin() -- Retrieve the minimum element in the stack.
 *
 *	Author: matao
 */

import java.util.Stack;

public class MinStack {

	private static Stack<Integer> dataStack = new Stack<Integer>();
    private static Stack<Integer> minStack = new Stack<Integer>();
     
    public static void push(int node) {
        dataStack.push(node);
        if(minStack.isEmpty() || minStack.peek() > node) {
            minStack.push(node);
        } else {
            minStack.push(minStack.peek());
        }
    }
     
    public static void pop() {
        dataStack.pop();
        minStack.pop();
    }
     
    public static int top() {
        return dataStack.peek();
    }
     
    public static int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
		MinStack mStack = new MinStack();
		mStack.push(2);
		mStack.push(3);
		mStack.push(4);
		System.out.println(mStack.getMin());
	}
}