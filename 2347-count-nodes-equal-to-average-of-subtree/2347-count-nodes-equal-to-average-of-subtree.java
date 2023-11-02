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
    // Define custom Pair Class
    public class Pair<T, U> {
        private final T first;
        private final U second;

        public Pair(T first, U second) {
            this.first = first;
            this.second = second;
        }

        public T getFirst() {
            return first;
        }

        public U getSecond() {
            return second;
        }
    }

    public int averageOfSubtree(TreeNode root) {
        // Passing count as reference
        int[] count = new int[1];
        helper(root, count);
        return count[0];
    }

    public Pair<Integer,Integer> helper(TreeNode root, int[] count) {
        if (root == null) return new Pair<>(0,0);

        // Find pair(totalsum, elementcount) at each root node
        Pair<Integer, Integer> left = helper(root.left, count);
        Pair<Integer, Integer> right = helper(root.right, count);

        int total = left.getFirst() + right.getFirst() + root.val;
        int countEle = left.getSecond() + right.getSecond() + 1;
        
        // Avg of totalsum and elementcount, then update count if equals root value
        if (total / countEle == root.val) count[0]++;

        return new Pair<>(total, countEle);
    }
}