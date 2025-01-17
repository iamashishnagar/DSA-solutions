/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode slow = dummy, fast = dummy;
        //find middle
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //split second half from first half
        ListNode second = slow.next;
        slow.next = null;
        ListNode prev = null;
        //reverse second half
        while(second != null){
            ListNode next = second.next;
            second.next = prev;
            prev = second;
            second = next;
        }
        //merge both half
        ListNode first = head;
        second = prev;
        while(second != null){ 
            ListNode firstNext = first.next;
            ListNode secondNext = second.next;

            first.next = second;
            second.next = firstNext;

            first = firstNext;
            second = secondNext;
        }
    }
}