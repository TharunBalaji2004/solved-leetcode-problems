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
    public int findBottomLeftValue(TreeNode root) {
        int[] res = new int[]{0,0}; // {level, value}
        
        int currLevel = 1;
        preorder(root, currLevel, res);

        return res[1];
    }

    private void preorder(TreeNode root, int currLevel, int[] res) {
        if (root == null) return;

        if (currLevel > res[0]) {
            // Update new level
            res[0] = currLevel;
            res[1] = root.val;
        }

        preorder(root.left, currLevel+1, res);
        preorder(root.right, currLevel+1, res);
    }
}