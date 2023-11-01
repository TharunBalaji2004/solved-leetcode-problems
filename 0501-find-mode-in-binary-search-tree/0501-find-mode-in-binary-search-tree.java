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
    Integer prev = null;
    int count = 1;
    int max = 0;

    public int[] findMode(TreeNode root) {
        List<Integer> modes = new ArrayList<>();

        helper(root, modes);

        int[] res = new int[modes.size()];
        for (int i=0;i<modes.size();i++){
            res[i] = modes.get(i);
        }

        return res;
    }

    // Performing Recursive Inorder traversal
    public void helper(TreeNode node, List<Integer> modes) {
        if (node == null) return;

        helper(node.left, modes);

        if (prev != null) {
            if (prev == node.val){
                count++;
            } else {
                count = 1;
            }
        }

        if (count > max) {
            max = count;
            modes.clear();
            modes.add(node.val);
        } else if (count == max) {
            modes.add(node.val);
        }

        prev = node.val;

        helper(node.right, modes);
    }
}