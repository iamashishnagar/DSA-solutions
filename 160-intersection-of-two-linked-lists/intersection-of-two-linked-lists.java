/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        int m = getLength(headA);
        int n = getLength(headB);

        while(m > n){
            headA = headA.next;
            m--;
        }

        while(n > m){
            headB = headB.next;
            n--;
        }

        while(headA != null || headB != null){
            if(headA == headB) return headA;
            headA = headA.next;
            headB = headB.next;
        }

        return null;
    }

    private int getLength(ListNode head){
        int length = 0;
        
        while(head != null){
            length++;
            head = head.next;
        }

        return length;
    }
}