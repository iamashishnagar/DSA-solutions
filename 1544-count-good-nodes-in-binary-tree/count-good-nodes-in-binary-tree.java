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
    int goodCount = 0;
    public int goodNodes(TreeNode root) {
        preorder(root, root.val);
        return goodCount;
    }

    private void preorder(TreeNode node, int maxSoFar){
        if(node == null) return;
        if(node.val >= maxSoFar)
            goodCount++;
        
        maxSoFar = Math.max(maxSoFar, node.val);
        preorder(node.left, maxSoFar);
        preorder(node.right, maxSoFar);
    }
}