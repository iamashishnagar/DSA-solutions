import java.util.*;
class MinStack {
    class Node{
        int value;
        Node next;

        Node(int value){
            this.value = value;
        }
    }

    private Node head;
    private Node minHead;

    public MinStack() {
        head = null;
        minHead = null;
    }
    
    public void push(int val) {
        Node node = new Node(val);

        if(head == null){
            head = node;
            minHead = new Node(val);
        }
        else{
            node.next = head;
            head = node;

            if(val <= minHead.value){
                Node minNode = new Node(val);
                minNode.next = minHead;
                minHead = minNode;
            }
        }
    }
    
    public void pop() {
        if(head == null) return;
        int value = head.value;
        head = head.next;

        if(minHead != null && value <= minHead.value)
            minHead = minHead.next;
    }
    
    public int top() {
        if(head != null) return head.value;
        throw new NoSuchElementException("empty.");
    }
    
    public int getMin() {
        if(minHead != null) return minHead.value;
        throw new NoSuchElementException("empty.");
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