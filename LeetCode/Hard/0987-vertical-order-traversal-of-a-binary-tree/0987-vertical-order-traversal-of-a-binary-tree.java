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
        int r, c;
        TreeNode node;
        Pair(TreeNode node, int r, int c){
            this.node=node;
            this.r=r;
            this.c=c;
        }
    }
    TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> tm;

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        tm=new TreeMap<>();
        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(root, 0, 0));

        while(!q.isEmpty()){
            Pair p=q.poll();
            
            tm.putIfAbsent(p.c, new TreeMap<>());
            tm.get(p.c).putIfAbsent(p.r, new PriorityQueue<>());
            tm.get(p.c).get(p.r).add(p.node.val);

            if(p.node.left!=null){
                q.offer(new Pair(p.node.left, p.r+1, p.c-1));
            }
            if(p.node.right!=null){
                q.offer(new Pair(p.node.right, p.r+1, p.c+1));
            }
        }
        List<List<Integer>> ans= new ArrayList<>();

        for(TreeMap<Integer, PriorityQueue<Integer>> t: tm.values()){
            List<Integer> ls=new ArrayList<>();
            for(PriorityQueue<Integer> pq: t.values()){
                while(!pq.isEmpty()){
                    ls.add(pq.poll());
                }
            }
            ans.add(ls);
        }
        return ans;
    }
}