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
    public int maxDepth(TreeNode root) {
        // Base case - Empty tree
        if (root == null) return 0;

        int leftSubTreeHeight = maxDepth(root.left);
        int rightSubTreeHeight = maxDepth(root.right);

        int maxHeight = 1 + Math.max(leftSubTreeHeight, rightSubTreeHeight);

        return maxHeight;
    }
}