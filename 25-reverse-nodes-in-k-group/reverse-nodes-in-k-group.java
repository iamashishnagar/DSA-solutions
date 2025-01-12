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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head);
        ListNode lastGroupEnd = dummy;

        while(true){
            ListNode kthNode = getKthNode(lastGroupEnd, k);
            if(kthNode == null) break;
            
            ListNode groupStart = lastGroupEnd.next;
            ListNode nextGroupStart = kthNode.next;

            reverse(groupStart, kthNode);

            lastGroupEnd.next = kthNode;
            groupStart.next = nextGroupStart; 

            lastGroupEnd = groupStart;           
        }

        return dummy.next;
    }

    private ListNode getKthNode(ListNode start, int k){
        while(k > 0){
            if(start != null) start = start.next;
            k--;
        }            
        return start;
    }

    private void reverse(ListNode start, ListNode end){
        ListNode prev = null;
        while(prev != end){
            ListNode next = start.next;
            start.next = prev;
            prev = start;
            start = next;
        }
    }
}