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
        ListNode curr = head;

        while (curr != null) {
            while (!stack.isEmpty() && curr.val > stack.peek().val) {
                stack.pop();
            }
            stack.add(curr);
            curr = curr.next;
        }

        ListNode newHead = null;

        while (!stack.isEmpty()) {
            ListNode temp = stack.pop();
            temp.next = newHead;
            newHead = temp;
        }

        return newHead;
    }
}