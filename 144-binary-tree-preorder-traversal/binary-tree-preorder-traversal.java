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
    // Morris Preorder Traversal
    // TC: O(N) and SC: O(1)
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        TreeNode curr = root;

        while (curr != null) {
            // Case 1 - When the current node does not have left node
            // Action - Add the element to list and move to right
            // Reason - Since the left is null, we cannot traverse to left
            if (curr.left == null) {
                list.add(curr.val);
                curr = curr.right;
            } 
            // Case 2 - When the current node have left node
            // Action - Create prev pointer and traverse till the right most
            // Reason - To establish connection from right most node to curr (parent)
            else {
                TreeNode prev = curr.left;
                while (prev.right != null && prev.right != curr) {
                    prev = prev.right;
                }

                // Case 2.1 - When the right most node is null
                // Action - Establish the connection from right most node to parent (prev.right = curr)
                // Reason - To perform traversal afterwards and now move curr to left
                if (prev.right == null) {
                    prev.right = curr;
                    list.add(curr.val);
                    curr = curr.left;
                } 
                // Case 2.2 - When the right most node is not null
                // Action - Cut the connection with the parent node and add the parent (curr) node
                // Reason - Since the left subtree has been already traversed
                else {
                    prev.right = null;
                    curr = curr.right;
                }
            }
        }

        return list;
    }
}