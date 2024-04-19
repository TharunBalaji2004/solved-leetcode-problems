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
    public TreeNode helper(TreeNode root, int val, int depth, int currDepth) {
        if (root == null) return null;

        if (currDepth == depth - 1) {
            TreeNode oldLeft = root.left;
            TreeNode oldRight = root.right;

            root.left = new TreeNode(val);
            root.right = new TreeNode(val);
            root.left.left = oldLeft;
            root.right.right = oldRight;

            return root; 
        }

        root.left = helper(root.left, val, depth, currDepth+1);
        root.right = helper(root.right, val, depth, currDepth+1);

        return root;
    }

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        // If the depth == 1
        if (depth == 1) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root; // Assign the old root to left
            return newRoot;
        }

        return helper(root, val, depth, 1);
    }
}