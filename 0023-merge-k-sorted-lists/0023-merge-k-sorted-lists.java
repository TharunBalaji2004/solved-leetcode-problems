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
        if (lists.length == 0) return null;
        return helper(lists, 0, lists.length-1);
    }

    private ListNode helper(ListNode[] lists, int start, int end) {
        // Base case
        if (start == end) return lists[start];

        int mid = start + (end - start)/2;
        ListNode leftList = helper(lists, start, mid);
        ListNode rightList = helper(lists, mid+1, end);

        return mergeTwoLists(leftList, rightList);
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Edge cases
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }
}