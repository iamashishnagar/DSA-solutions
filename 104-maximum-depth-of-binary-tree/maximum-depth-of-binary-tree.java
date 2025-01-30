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
    int maxDepth = 0;
    public int maxDepth(TreeNode root) {
        calculateDepth(root);
        return maxDepth;
    }

    private int calculateDepth(TreeNode node){
        if(node == null) return 0;

        int leftDepth = calculateDepth(node.left);
        int rightDepth = calculateDepth(node.right);

        maxDepth = Math.max(maxDepth, 1 + Math.max(leftDepth, rightDepth));
        return 1 + Math.max(leftDepth, rightDepth);
    }
}