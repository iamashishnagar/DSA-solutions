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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null) return true;
        if(root == null || subRoot == null) return false;

        return isSameSubtree(root, subRoot) || 
            isSubtree(root.left, subRoot) || 
            isSubtree(root.right, subRoot);
    }

    private boolean isSameSubtree(TreeNode root, TreeNode subRoot){
        if(root == null && subRoot == null) return true;
        if(root == null || subRoot == null || root.val != subRoot.val)
            return false;
        
        return isSameSubtree(root.left, subRoot.left) &&
            isSameSubtree(root.right, subRoot.right);
    }
}