class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> ls= new ArrayList<>();
        int V=graph.length;
        boolean[] visited=new boolean[V];
        boolean[] pathVisited=new boolean[V];
        for(int i=0;i<V;i++){
            if(!dfs(graph, i, visited, pathVisited))ls.add(i);
        }
        return ls;

    }
    boolean dfs(int[][] graph, int node, boolean[] visited, boolean[] pathVisited){
        visited[node]=true;
        pathVisited[node]=true;
        for(int i: graph[node]){
            if(!visited[i]){
                if(dfs(graph, i, visited, pathVisited))return true;
            }else{
                if(pathVisited[i])return true;
            }
        }
        pathVisited[node]=false;
        return false;
    }
}