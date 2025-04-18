import java.util.*;

class MinStack {
    Deque<Integer> stack;
    Deque<Integer> minStack;

    public MinStack() {
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if(minStack.isEmpty() || minStack.peek() >= val)
            minStack.push(val);
    }
    
    public void pop() {
        if(!stack.isEmpty()){
            int removed = stack.pop();
            if(!minStack.isEmpty() && minStack.peek() == removed)
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