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
        //append copied list with val and next along side original list
        Node current = head;
        while(current != null){
            Node newNode = new Node(current.val);
            newNode.next = current.next;
            current.next = newNode;
            current = current.next.next;
        }
        //iterate through the new combined list to fill random number
        current = head;
        while(current != null){
            if(current.random != null)
                current.next.random = current.random.next;
            current = current.next.next;
        }
        //split the list into original and copied
        current = head;
        Node copied = head.next;
        while(current != null){
            Node copiedNext = current.next;
            current.next = copiedNext.next;
            current = current.next;
            if(copiedNext.next != null){
                copiedNext.next = copiedNext.next.next;
            }
        }
        //return copied head  
        return copied;
    }
}