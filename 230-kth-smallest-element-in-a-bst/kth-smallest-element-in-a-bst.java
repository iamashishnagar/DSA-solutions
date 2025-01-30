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
    int k;
    int result = -1;

    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        inorder(root);
        return result; 
    }

    private void inorder(TreeNode node){
        if(node == null) return;

        inorder(node.left);

        k--;
        if(k == 0) {
            result = node.val;
            return;
        }

        inorder(node.right);
    }
}