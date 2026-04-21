class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        ans=new ArrayList<>();
        dfs(graph, 0, new ArrayList<>(), graph.length-1);
        return ans;
    }
    void dfs(int[][] graph, int node, List<Integer> ls,int dest){
        if(node==dest){
            ls.add(node);
            ans.add(new ArrayList<>(ls));
            ls.remove(ls.size()-1);
            return;
        }
        ls.add(node);
        for(int v: graph[node]){
            
            dfs(graph, v, ls, dest);
            
        }
        ls.remove(ls.size()-1);
    }
}