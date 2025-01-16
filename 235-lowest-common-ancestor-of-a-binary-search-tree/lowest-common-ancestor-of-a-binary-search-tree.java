/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || p == null || q == null)
            return null;
        if(p.val > q.val){ //p always smaller
            TreeNode temp = p;
            p = q;
            q = temp;
        }

        if(p.val <= root.val && root.val <= q.val)
            return root;
        else if(p.val < root.val && q.val < root.val)
            return lowestCommonAncestor(root.left, p, q);
        else 
            return lowestCommonAncestor(root.right, p, q);
    }
}