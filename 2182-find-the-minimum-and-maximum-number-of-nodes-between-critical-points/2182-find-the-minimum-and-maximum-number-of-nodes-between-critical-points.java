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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if (head == null || head.next == null) return new int[]{-1,-1};

        int mini = Integer.MAX_VALUE;
        int prev = head.val, firstCpoint = -1, lastCpoint = -1, position = 1;
        ListNode curr = head.next;
        
        while (curr != null && curr.next != null) {
            if (((prev < curr.val)&&(curr.val > curr.next.val)) || ((prev > curr.val)&&(curr.val < curr.next.val))) {
                if (firstCpoint == -1) {
                    firstCpoint = position;
                } else {             
                    mini = Math.min(mini, position - lastCpoint);
                }

                lastCpoint = position;
            }

            prev = curr.val;
            curr = curr.next;
            position++;
        }

        if (firstCpoint == -1 || firstCpoint == lastCpoint) {
            return new int[]{-1, -1};
        }

        return new int[]{mini, lastCpoint - firstCpoint};
    }
}