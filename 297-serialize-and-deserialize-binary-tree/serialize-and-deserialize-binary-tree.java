/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder encoded = new StringBuilder();
        preorderTraversal(root, encoded);
        return encoded.toString();        
    }

    private void preorderTraversal(TreeNode node, StringBuilder encoded){
        if(node == null){
            encoded.append("#,");
            return;
        }

        encoded.append(node.val).append(",");

        preorderTraversal(node.left, encoded);
        preorderTraversal(node.right, encoded);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] values = data.split(",");
        Queue<String> queue = new ArrayDeque<>(Arrays.asList(values));
        return buildTree(queue);
    }

    private TreeNode buildTree(Queue<String> queue){
        if(queue.isEmpty()) return null;
        
        String value = queue.poll();
        if(value.equals("#")) return null;

        TreeNode node = new TreeNode(Integer.parseInt(value));
        node.left = buildTree(queue);
        node.right = buildTree(queue);

        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));