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
    public void inorder(TreeNode root, List<Integer> elements) {
        // Base case
        if (root == null) return;

        // Inorder - L root R
        inorder(root.left, elements);
        elements.add(root.val);
        inorder(root.right, elements);
    }

    public boolean isValidBST(TreeNode root) {
        List<Integer> elements = new ArrayList<>();
        inorder(root, elements);

        // Check if the elements are in sorted order (since inorder of BST gives sorted array)
        for (int i=1;i<elements.size();i++) {
            if (elements.get(i) <= elements.get(i-1)) return false;
        }

        return true;
    }
}