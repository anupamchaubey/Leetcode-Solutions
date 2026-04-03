class Solution {
    List<List<Integer>> adj;
    public boolean canFinish(int n, int[][] courses) {
        adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        int[] indegree= new int[n];

        for(int[] c: courses){
            adj.get(c[0]).add(c[1]);
            indegree[c[1]]++;
        }
        // boolean[] visited=new boolean[n];
        // boolean[] pathvisited=new boolean[n];
        // for(int i=0;i<n;i++){
        //     if(!visited[i]){
        //         visited[i]=true;
        //         pathvisited[i]=true;
        //         if(dfs(i, visited, pathvisited))return false;
        //         pathvisited[i]=false;
        //     }
        // }
        // return true;
        int nodes=0;
        Queue<Integer> q= new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                nodes++;
                q.offer(i);
            }
        }
        while(!q.isEmpty()){
            int u=q.poll();
            for(int v: adj.get(u)){
                indegree[v]--;
                if(indegree[v]==0)nodes++;
                q.offer(v);
            }
        }
        return nodes==n;

    }
    boolean dfs(int node, boolean[] visited, boolean[] pathvisited){

        for(int v: adj.get(node)){
            if(!visited[v]){
                visited[v]=true;
                pathvisited[v]=true;
                if(dfs(v, visited, pathvisited))return true;//cycle detected
                pathvisited[v]=false;
            }else if(pathvisited[v])return true;//cycle detected
        }
        return false;//no cycle
    }
}