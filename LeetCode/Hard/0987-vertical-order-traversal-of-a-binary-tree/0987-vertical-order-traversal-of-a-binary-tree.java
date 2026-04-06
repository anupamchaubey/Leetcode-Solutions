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
        int r, c;
        Pair(TreeNode node, int r, int c){
            this.node=node;
            this.r=r;
            this.c=c;
        }
    }
    TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> tm;//sort by col, row, value
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        tm=new TreeMap<>();

        Queue<Pair> q= new LinkedList<>();
        q.offer(new Pair(root, 0, 0));

        while(!q.isEmpty()){
            Pair p=q.poll();
            TreeNode node=p.node;
            int r=p.r;
            int c=p.c;
            tm.putIfAbsent(c, new TreeMap<>());
            tm.get(c).putIfAbsent(r, new PriorityQueue<>());
            tm.get(c).get(r).offer(node.val);
            if(node.left!=null){
                q.offer(new Pair(node.left, r+1, c-1));
            }
            if(node.right!=null){
                q.offer(new Pair(node.right, r+1, c+1));
            }
        }
        List<List<Integer>> ans=new ArrayList<>();

        for(TreeMap<Integer, PriorityQueue<Integer>> v: tm.values()){
            List<Integer> ls =  new ArrayList<>();
            for(PriorityQueue<Integer> pq: v.values()){
                while(!pq.isEmpty()){
                    ls.add(pq.poll());
                }
            }
            ans.add(ls);
        }
        return ans;
    }
}