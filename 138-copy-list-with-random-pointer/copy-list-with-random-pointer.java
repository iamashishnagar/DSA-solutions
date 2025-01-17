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
        //interweave new copy with val and next
        Node current = head;
        while(current != null){
            Node newNode = new Node(current.val);
            Node oldNextNode = current.next;
            current.next = newNode;
            newNode.next = oldNextNode;
            current = oldNextNode;
        }
        //insert random
        current = head;
        while(current != null){
            if(current.random != null)
                current.next.random = current.random.next;
            current = current.next.next;
        }
        //split
        current = head;
        Node copiedHead = head.next;
        while(current != null){
            Node copied = current.next;
            Node oldNext = copied.next;

            current.next = oldNext;
            current = oldNext;

            if(oldNext != null)
                copied.next = oldNext.next;
        }
        //return copied head
        return copiedHead;
    }
}