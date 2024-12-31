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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private boolean preorder(ListNode head, TreeNode root) {
        // BASE CASE
        if (head == null) return true;
        if (root == null) return false;

        if (head.val != root.val) return false;

        return preorder(head.next, root.left) || preorder(head.next, root.right);
    }

    public boolean isSubPath(ListNode head, TreeNode root) {
        // BASE CASE
        if (head == null) return true;
        if (root == null) return false;

        return preorder(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }
}