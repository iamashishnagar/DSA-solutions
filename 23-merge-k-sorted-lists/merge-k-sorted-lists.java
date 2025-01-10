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
        if(lists.length == 0) return null;

        Queue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);
        for(ListNode head : lists)
            if(head != null) minHeap.add(head);
        
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while(!minHeap.isEmpty()){
            ListNode smallest = minHeap.poll();
            current.next = smallest;
            current = current.next;

            if(smallest.next != null)
                minHeap.add(smallest.next);
        }

        return dummy.next;
    }
}