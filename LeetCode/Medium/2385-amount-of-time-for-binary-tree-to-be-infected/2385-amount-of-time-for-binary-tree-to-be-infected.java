
class Solution {
    int cnt=0;
    HashMap<TreeNode, TreeNode> map=new HashMap<>();
    TreeNode starty;
    public int amountOfTime(TreeNode root, int start) {
        count(root, new HashSet<TreeNode>());
        buildParent(root, null, start);
        
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(starty);
        int time=0;
        Set<TreeNode> set= new HashSet<>();
        set.add(starty);
        while(!q.isEmpty()){
            if(set.size()==cnt)return time;
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode x=q.poll();

                if(x.left!=null && !set.contains(x.left)){
                    set.add(x.left);
                    q.offer(x.left);
                }
                if(x.right!=null && !set.contains(x.right)){
                    set.add(x.right);
                    q.offer(x.right);
                }
                TreeNode par=map.get(x);
                if(par!=null && !set.contains(par)){
                    set.add(par);
                    q.offer(par);
                }
            }
            time++;
        }
        return time;
    }
    
    void buildParent(TreeNode node, TreeNode parent, int start) {
        if (node == null)
            return;
        if(node.val==start)starty=node;
        map.put(node, parent);
        buildParent(node.left, node, start);
        buildParent(node.right, node, start);
    }
    void count(TreeNode r1, Set<TreeNode> visited){
        if(r1==null)return;
        if(!visited.contains(r1)){
            cnt++;
        }
        visited.add(r1);
        count(r1.left, visited);
        count(r1.right, visited);
    }
}