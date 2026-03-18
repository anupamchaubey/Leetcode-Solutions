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
        StringBuilder sb=new StringBuilder();
        preorder(root, sb);
        return sb.toString();
    }
    void preorder(TreeNode root, StringBuilder sb){
        if(root==null){
            sb.append("null,");
            return;
        }
        
        sb.append(root.val).append(",");
        preorder(root.left, sb);
        preorder(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes=data.split(",");
        return build(nodes);
    }
    int idx=0;
    TreeNode build(String[] nodes){
        if(nodes[idx].equals("null")){
            idx++;
            return null;
        }
        TreeNode root=new TreeNode(Integer.parseInt(nodes[idx++]));
        root.left=build(nodes);
        root.right=build(nodes);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));