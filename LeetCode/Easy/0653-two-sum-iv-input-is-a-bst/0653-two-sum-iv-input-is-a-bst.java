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
        int i=0, j=ls.size()-1;
        while(i<j){
            int sum=ls.get(i)+ls.get(j);
            if(sum==k)return true;
            else if(sum<k)i++;
            else j--;
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