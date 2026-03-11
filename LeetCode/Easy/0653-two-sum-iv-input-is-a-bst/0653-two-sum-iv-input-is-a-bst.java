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
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> ls= new ArrayList<>();
        inorder(root, ls);
        
        HashSet<Integer> hs= new HashSet<>();
        for(int i: ls){
            if(hs.contains(k-i))return true;
            hs.add(root.val);
        }
        return false;
    }
    void inorder(TreeNode root, List<Integer> ls){
        if(root==null)return ;
        inorder(root.left, ls);
        ls.add(root.val);
        inorder(root.right, ls);
    }
}