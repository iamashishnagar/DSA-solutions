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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            TreeNode rightMost = null;
            while(size > 0){
                TreeNode current = queue.poll();
                rightMost = current;
                if(current.left != null) queue.add(current.left);
                if(current.right != null) queue.add(current.right);

                size--;
            }
            result.add(rightMost.val);
        }
        return result;
    }
}