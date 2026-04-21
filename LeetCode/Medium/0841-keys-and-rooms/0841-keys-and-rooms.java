class Solution {
    int count;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        count=1;
        int n=rooms.size();
        boolean[] visited=new boolean[n];
        visited[0]=true;
        dfs(rooms, 0, visited);
        return count==n;

    }
    void dfs(List<List<Integer>> adj, int node, boolean[] visited){
        for(int v: adj.get(node)){
            if(!visited[v]){
                visited[v]=true;
                count++;
                dfs(adj, v, visited);
            }
        }
    }
}