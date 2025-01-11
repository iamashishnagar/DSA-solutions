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
        if(head == null || k == 1) return head;
        //dummy
        ListNode dummy = new ListNode(0, head);
        ListNode lastGroupEnd = dummy;

        while(true){
            //check kth node
            ListNode kthNode = getKthNode(lastGroupEnd, k);
            if(kthNode == null) break;

            //reverse
            ListNode groupStart = lastGroupEnd.next;
            ListNode nextGroupStart = kthNode.next;
            reverseGroup(groupStart, kthNode);

            //reconnect
            lastGroupEnd.next = kthNode;
            groupStart.next = nextGroupStart;

            lastGroupEnd = groupStart;
        }

        //return
        return dummy.next;
        
    }

    private void reverseGroup(ListNode start, ListNode end){
        ListNode prev = null;
        while(prev != end){
            ListNode next = start.next;
            start.next = prev;
            prev = start;
            start = next;
        }
    }

    private ListNode getKthNode(ListNode start, int k){
        while(start != null && k > 0){
            start = start.next;
            k--;
        }
        return start;
    }
}