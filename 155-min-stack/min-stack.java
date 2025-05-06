import java.util.*;
class MinStack {
    private Deque<Integer> stack;
    private Deque<Integer> minStack;

    public MinStack() {
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if(minStack.isEmpty() || val <= minStack.peek())
            minStack.push(val);
    }
    
    public void pop() {
        if(!stack.isEmpty()){
            int removed = stack.pop();
            if(!minStack.isEmpty() && removed <= minStack.peek())
                minStack.pop();
        }
    }
    
    public int top() {
        if(!stack.isEmpty()) return stack.peek();
        throw new NoSuchElementException("Stack is empty.");
    }
    
    public int getMin() {
        if(!minStack.isEmpty()) return minStack.peek();
        throw new NoSuchElementException("Stack is empty.");
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