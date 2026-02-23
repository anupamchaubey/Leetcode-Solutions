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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null)return ans;
        Queue<TreeNode> q= new LinkedList<>();
        q.offer(root);
        boolean left=true;
        while(!q.isEmpty()){
            int size=q.size();
            List<Integer> ls= new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode x=q.poll();
                
                if(x.left!=null){
                    q.offer(x.left);
                }
                if(x.right!=null){
                    q.offer(x.right);
                }
                ls.add(x.val);
            }
            if(left)ans.add(new ArrayList<>(ls));
            else{
                Collections.reverse(ls);
                ans.add(new ArrayList<>(ls));
            }
            left=!left;
        }
        return ans;
    }
}