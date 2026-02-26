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
    List<List<Integer>> ans= new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        if(root==null)return ans;
        dfs(root, 0, new ArrayList<>(), target);
        
        return ans;
    }
    void dfs(TreeNode root, int sum, List<Integer> ls, int target){
        if(root==null)return ;
        ls.add(root.val);
        sum+=root.val;
        if(sum==target && root.left==null && root.right==null){
            ans.add(new ArrayList<>(ls));
        }
        
        
        
        dfs(root.left, sum, ls, target);
        dfs(root.right, sum, ls, target);
        ls.remove(ls.size()-1);
    }
}