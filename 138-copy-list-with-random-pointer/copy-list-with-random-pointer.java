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
        while(current != null){
            Node newNode = new Node(current.val);
            newNode.next = current.next;
            current.next = newNode;
            current = current.next.next;
        }

        current = head;
        while(current != null){
            if(current.random != null)
                current.next.random = current.random.next;
            current = current.next.next;
        }

        current = head;
        Node copied = head.next;
        while(current != null){
            Node copiedNode = current.next;
            current.next = copiedNode.next;
            current = current.next;
            if(copiedNode.next != null)
                copiedNode.next = copiedNode.next.next;
        }

        return copied;
    }
}