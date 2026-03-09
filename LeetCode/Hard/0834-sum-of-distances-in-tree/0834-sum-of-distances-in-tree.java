class Solution {
    int[] subtree;//number of nodes in subtree of x
    int[] res;//sum of distances from x to all nodes in its subtree
    List<List<Integer>> adj;
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] e: edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        subtree=new int[n];
        res=new int[n];
        
        dfs1(0, -1);
        dfs2(0, -1, n);
        return res;
    }
    void dfs1(int node, int parent){
        subtree[node]=1;
        for(int child: adj.get(node)){
            if(child==parent)continue;
            dfs1(child, node);
            subtree[node]+=subtree[child];
            res[node]+=res[child]+subtree[child];
        }
    }
    void dfs2(int node, int parent, int n){
        for(int child: adj.get(node)){
            if(child==parent)continue;
            res[child]=res[node]-subtree[child]+(n-subtree[child]);
            dfs2(child, node, n);
        }
    }
    
}