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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        for(int i = 1; i < left; i++){
            prev = prev.next;
        }

        prev.next = reverseSublist(prev.next, right - left);

        return dummy.next;
    }

    private ListNode reverseSublist(ListNode head, int count){
        ListNode prev = null;
        ListNode current = head;
        ListNode tail = head;

        for(int i = 0; i <= count; i++){
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        tail.next = current;
        return prev;
    }
}