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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ls= new ArrayList<>();
        if(root==null)return ls;
        Queue<TreeNode> q= new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode x=q.poll();
                if(x.left!=null){
                    q.offer(x.left);
                }
                if(x.right!=null){
                    q.offer(x.right);
                }
                if(i==size-1)ls.add(x.val);
            }
        }
        return ls;
    }
}