class Solution {
    List<List<Integer>> adj;
    int[] count;
    int[] res;
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        res = new int[n];
        count = new int[n];

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int[] arr = new int[n];
        dfs(0, -1);
        dfs1(0, -1, n);
        return res;
    }
    void dfs1(int node, int parent, int n){
        for(int i: adj.get(node)){
            if(i==parent) continue;
            res[i]=res[node]-count[i]+(n-count[i]);
            dfs1(i, node, n);
        }
    }
    void dfs(int node, int parent){
        count[node]=1;
        for(int i: adj.get(node)){
            if(i==parent)continue;
            dfs(i, node);
            count[node]+=count[i];
            res[node]+=res[i]+count[i];
            
        }
    }

}