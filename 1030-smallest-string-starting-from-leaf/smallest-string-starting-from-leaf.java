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
    String smallest = null;

    public void helper(TreeNode root, StringBuilder path) {
        // Base case
        if (root == null) return;

        path.insert(0, (char)('a' + root.val));

        // If the current node is leaf node
        if (root.left == null && root.right == null) {
            String curr = path.toString();
            // Compare if the current string is lexographically smaller than smallest string
            if (smallest == null || curr.compareTo(smallest) < 0) {
                smallest = curr;
            }
        }
        // Otherwise, apply DFS to all other nodes in tree
        else {
            helper(root.left, path);
            helper(root.right, path);
        }

        path.deleteCharAt(0);
    }

    public String smallestFromLeaf(TreeNode root) {
        helper(root, new StringBuilder());
        return smallest;
    }
}