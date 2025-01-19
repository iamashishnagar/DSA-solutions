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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> values = new ArrayList<>();
            while(size > 0){
                TreeNode current = queue.poll();
                values.add(current.val);

                if(current.left != null) queue.add(current.left);
                if(current.right != null) queue.add(current.right);

                size--;
            }
            result.add(values);
        }
        return result;
    }
}