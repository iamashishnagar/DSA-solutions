/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        
        Node current = head;
        //interweave
        while(current != null){
            Node next = current.next;
            Node newNode = new Node(current.val);
            current.next = newNode;
            newNode.next = next;
            current = next;
        }
        //insert random
        current = head;
        while(current != null){
            if(current.random != null){
                current.next.random = current.random.next;
            }
            current = current.next.next;
        }
        //split
        current = head;
        Node copiedHead = current.next;
        while(current != null){
            Node copiedNode = current.next;
            Node originalNext = copiedNode.next;
            current.next = originalNext;
            current = originalNext;
            if(originalNext != null)
                copiedNode.next = originalNext.next;
        }
        //return
        return copiedHead;
        
    }
}