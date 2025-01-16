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
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offerLast(root);

        while(!queue.isEmpty()){
            TreeNode current = queue.pollFirst();
            TreeNode right = current.right;
            current.right = current.left;
            current.left = right;

            if(current.left != null) queue.offerLast(current.left);
            if(current.right != null) queue.offerLast(current.right);
        }

        return root;
    }
}