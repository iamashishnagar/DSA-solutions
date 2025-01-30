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
        encodeTree(root, encoded);
        return encoded.toString();
    }

    private void encodeTree(TreeNode node, StringBuilder encoded){
        if(node == null){
            encoded.append("#,");
            return;
        }
        encoded.append(node.val).append(",");
        encodeTree(node.left, encoded);
        encodeTree(node.right, encoded);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] values = data.split(",");
        Queue<String> queue = new ArrayDeque<>(Arrays.asList(values));
        return decodeTree(queue);
    }

    private TreeNode decodeTree(Queue<String> queue){
        if(queue.isEmpty()) return null;

        String current = queue.poll();
        if(current.equals("#")) return null;

        TreeNode node = new TreeNode(Integer.parseInt(current));
        node.left = decodeTree(queue);
        node.right = decodeTree(queue);

        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));