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
    List<Integer> ls;
    int prefix[];
    HashMap<Integer, Integer> hm;
    public TreeNode bstToGst(TreeNode root) {
        ls=new ArrayList<>();
        dfs(root);
        prefix=new int[ls.size()];
        prefix[ls.size()-1]=ls.get(ls.size()-1);

        for(int i=ls.size()-2;i>=0;i--){
            prefix[i]=prefix[i+1]+ls.get(i);
        }
        hm=new HashMap<>();
        for(int i=0;i<ls.size();i++){
            hm.put(ls.get(i), prefix[i]);
        }
        TreeNode root1=new TreeNode(hm.get(root.val));
        dfs(root, root1);
        return root1;
    }
    
    void dfs(TreeNode root, TreeNode root1){
        if(root==null)return;

        if(root.left!=null){
            int x=hm.get(root.left.val);
            root1.left=new TreeNode(x);
            dfs(root.left, root1.left);
        }
        if(root.right!=null){
            int x=hm.get(root.right.val);
            root1.right=new TreeNode(x);
            dfs(root.right, root1.right);
        }
    }
    void dfs(TreeNode root){
        if(root==null)return;
        dfs(root.left);
        ls.add(root.val);
        dfs(root.right);
    }
}