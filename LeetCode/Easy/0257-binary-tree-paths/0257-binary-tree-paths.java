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
    List<String> ls= new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root, "");
        return ls;
    }
    void dfs(TreeNode root, String s){
        if(root==null){
            return;
        }
        if(root.left==null && root.right==null){
            s+=root.val;
            ls.add(s);
            return;
        }
        s+=root.val+"->";
        dfs(root.left, s);
        dfs(root.right, s);
    }
}