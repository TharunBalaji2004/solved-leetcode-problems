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
    public ListNode removeNodes(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head;

        while (temp != null) {
            // Greater element
            while (!stack.isEmpty() && temp.val > stack.peek().val) {
                stack.pop();
            }

            stack.push(temp);
            temp = temp.next;
        }

        ListNode newHead = null;

        while (!stack.isEmpty()) {
            ListNode curr = stack.pop();
            curr.next = newHead;
            newHead = curr;
        }

        return newHead;
    }
}