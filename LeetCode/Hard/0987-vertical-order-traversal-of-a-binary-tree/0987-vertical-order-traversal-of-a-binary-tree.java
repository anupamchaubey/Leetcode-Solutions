//most expected and efficient approach
class Pair {
    TreeNode node;
    int r;
    int c;

    public Pair(TreeNode node, int r, int c) {
        this.node = node;
        this.r = r;
        this.c = c;
    }
}

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<int[]> nodes= new ArrayList<>();
        Queue<Pair> q= new LinkedList<>();
        q.offer(new Pair(root, 0, 0));
        while(!q.isEmpty()){
            Pair p = q.poll();
            TreeNode node = p.node;
            int r = p.r;
            int c = p.c;
            nodes.add(new int[]{c, r, node.val});
            
            if(node.left!=null){
                q.offer(new Pair(node.left, r+1, c-1));
            }
            if(node.right!=null){
                q.offer(new Pair(node.right, r+1, c+1));
            }
        }
        Collections.sort(nodes, (a, b)-> {
            if(a[0]!=b[0])return a[0]-b[0];
            else if( a[1]!=b[1])return a[1]-b[1];
            else return a[2]-b[2];
        });

        List<List<Integer>> ans = new ArrayList<>();

        int prevCol = Integer.MIN_VALUE;

        for(int[] node : nodes){

            int col = node[0];
            int val = node[2];

            if(col != prevCol){
                ans.add(new ArrayList<>());
                prevCol = col;
            }

            ans.get(ans.size()-1).add(val);
        }

        return ans;

    }
}