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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null && list2 == null) return null;
        if(list1 == null) return list2;
        if(list2 == null) return list1;

        ListNode dummy = new ListNode(0);
        ListNode merge = dummy;

        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                merge.next = list1;
                list1 = list1.next;
            }
            else{
                merge.next = list2;
                list2 = list2.next;
            }
            merge = merge.next;
        }
        if(list1 != null) merge.next = list1;
        else if(list2 != null) merge.next = list2;

        return dummy.next;
    }
}