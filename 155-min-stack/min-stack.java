import java.util.*;
class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if(minStack.isEmpty() || val <= minStack.peek())
            minStack.push(val);
        else minStack.push(minStack.peek());
    }
    
    public void pop() {
        if(!stack.isEmpty()) stack.pop();
        if(!minStack.isEmpty()) minStack.pop();
    }
    
    public int top() {
        if(!stack.isEmpty()) return stack.peek();
        throw new NoSuchElementException("Stack is empty"); 
    }
    
    public int getMin() {
        if(!minStack.isEmpty()) return minStack.peek();
        throw new NoSuchElementException("Stack is empty"); 
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */