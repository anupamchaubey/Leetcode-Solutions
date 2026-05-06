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
    class Pair{
        TreeNode node;
        int idx;
        Pair(TreeNode node, int idx){
            this.node=node;
            this.idx=idx;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        int max=0;
        Queue<Pair> q= new LinkedList<>();
        q.offer(new Pair(root, 0));
        while(!q.isEmpty()){
            int st=-1, en=-1;
            int size=q.size();
            for(int i=0;i<size;i++){
                Pair p=q.poll();
                TreeNode node=p.node;
                int idx=p.idx;
                if(st==-1){
                    st=idx;
                }
                en=idx;
                if(node.left!=null){
                    q.offer(new Pair(node.left, 2*idx+1));
                }
                if(node.right!=null){
                    q.offer(new Pair(node.right, 2*idx+2));
                }
            }
            max=Math.max(max,en-st+1);
        }
        return max;
    }
}