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
    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        checkDiameter(root);
        return diameter;
    }

    private int checkDiameter(TreeNode node){
        if(node == null) return 0;

        int leftDia = checkDiameter(node.left);
        int rightDia = checkDiameter(node.right);

        diameter = Math.max(diameter, leftDia + rightDia);
        return 1 + Math.max(leftDia, rightDia);
    }
}