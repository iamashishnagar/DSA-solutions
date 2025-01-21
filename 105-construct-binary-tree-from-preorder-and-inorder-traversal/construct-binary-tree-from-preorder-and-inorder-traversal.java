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
    Map<Integer, Integer> inorderMap = new HashMap<>();
    int preIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0; i < inorder.length; i++)
            inorderMap.put(inorder[i], i);
        
        return buildTreeHelper(preorder, 0, preorder.length - 1);
    }

    private TreeNode buildTreeHelper(int[] preorder, int left, int right){
        if(left > right) return null;
        
        int rootValue = preorder[preIndex++];
        TreeNode root = new TreeNode(rootValue);
        
        int mid = inorderMap.get(rootValue);

        root.left = buildTreeHelper(preorder, left, mid - 1);
        root.right = buildTreeHelper(preorder, mid + 1, right);

        return root;
    }
}