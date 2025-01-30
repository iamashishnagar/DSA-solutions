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
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        postorder(root);
        return maxSum;
    }

    private int postorder(TreeNode node){
        if(node == null) return 0;

        int leftMax = Math.max(postorder(node.left), 0);
        int rightMax = Math.max(postorder(node.right), 0);

        int totalSum = node.val + leftMax + rightMax;
        maxSum = Math.max(maxSum, totalSum);

        return node.val + Math.max(leftMax, rightMax);
    }
}