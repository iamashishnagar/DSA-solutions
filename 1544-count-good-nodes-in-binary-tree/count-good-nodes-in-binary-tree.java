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
    public int goodNodes(TreeNode root) {
        return countGoodNodes(root, root.val);
    }

    private int countGoodNodes(TreeNode node, int maxSoFar){
        int count = 0;
        if(node == null) return count;

        if(node.val >= maxSoFar){
            count++;
            maxSoFar = Math.max(maxSoFar, node.val);
        }

        count += (node.left != null) ? countGoodNodes(node.left, maxSoFar) : 0;
        count += (node.right != null) ? countGoodNodes(node.right, maxSoFar) : 0;

        return count;
    }
}