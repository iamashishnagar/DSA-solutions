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
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        if(n == 0) return null;
        Queue<ListNode> minHeap = new PriorityQueue<>(
            (a, b) -> a.val - b.val
        );
        
        for(ListNode head : lists){
            if(head != null) minHeap.add(head);
        }

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        while(!minHeap.isEmpty()){
            ListNode removed = minHeap.poll();
            current.next = removed;
            current = current.next;

            if(removed.next != null)
                minHeap.add(removed.next);
        }
        return dummy.next;
    }
}