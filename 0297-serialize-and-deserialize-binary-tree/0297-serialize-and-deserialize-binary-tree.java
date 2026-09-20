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
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) {
                sb.append("null>");
            } else {
                sb.append(node.val).append(">");
                if (node.left != null) {
                    q.offer(node.left);
                } else
                    q.offer(null);
                if (node.right != null) {
                    q.offer(node.right);
                } else
                    q.offer(null);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(">");
        if (arr[0].equals("null"))
            return null;
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int idx = 1;

        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (arr[idx].equals("null")) {
                node.left = null;
            } else {
                node.left = new TreeNode(Integer.parseInt(arr[idx]));
                q.offer(node.left);
            }
            if (arr[idx + 1].equals("null")) {
                node.right = null;
            } else {
                node.right = new TreeNode(Integer.parseInt(arr[idx + 1]));
                q.offer(node.right);
            }
            idx += 2;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));