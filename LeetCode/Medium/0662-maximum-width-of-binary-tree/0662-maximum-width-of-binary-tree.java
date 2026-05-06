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
        int idx;// index of the node in the array
        Pair(TreeNode node, int idx){
            this.node=node;
            this.idx=idx;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        // tree array me represent krne vali property use hui h
        Queue<Pair> q=new LinkedList<>();
        int maxwidth=0;
        q.offer(new Pair(root, 0));
        while(!q.isEmpty()){
            int size=q.size();
            int st=-1, en=-1;
            for(int i=0;i<size;i++){
                Pair p=q.poll();
                TreeNode node=p.node;
                if(st==-1)st=p.idx;
                if(node.left!=null){
                    q.offer(new Pair(node.left, 2*p.idx+1));
                }
                if(node.right!=null){
                    q.offer(new Pair(node.right, 2*p.idx+2));
                }
                en=p.idx;
            }
            maxwidth=Math.max(maxwidth, en-st+1);
        }
        return maxwidth;
    }
}