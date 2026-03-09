class Solution {
    int[] nodesBelow;//countNodesFromHere
    int[] res;//distance sum inside substree
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
        nodesBelow=new int[n];
        res=new int[n];
        
        dfs1(0, -1);
        dfs2(0, -1, n);
        return res;
    }
    void dfs1(int node, int parent){
        nodesBelow[node]=1;
        for(int child: adj.get(node)){
            if(child==parent)continue;
            dfs1(child, node);
            nodesBelow[node]+=nodesBelow[child];
            res[node]+=res[child]+nodesBelow[child];
        }
    }
    void dfs2(int node, int parent, int n){
        for(int child: adj.get(node)){
            if(child==parent)continue;
            res[child]=res[node]-nodesBelow[child]+(n-nodesBelow[child]);
            dfs2(child, node, n);
        }
    }


}