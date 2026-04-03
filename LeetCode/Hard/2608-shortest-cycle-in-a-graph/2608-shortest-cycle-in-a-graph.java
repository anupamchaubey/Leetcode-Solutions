class Solution {
    int min=Integer.MAX_VALUE;
    List<List<Integer>> adj;
    int v;
    public int findShortestCycle(int n, int[][] edges) {
        adj=new ArrayList<>();
        v=n;
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] e: edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        
        for(int i=0;i<n;i++){
            int[] dist=new int[n];
            Arrays.fill(dist, -1);
            bfs(i, dist);
        }
        return min==Integer.MAX_VALUE? -1: min;
    }
    boolean bfs(int node, int[] dist){
        
        Queue<int[]> q= new LinkedList<>();
        dist[node]=0;
        q.offer(new int[] {node, -1});

        while(!q.isEmpty()){
            int[] arr=q.poll();
            int u=arr[0];
            int parent=arr[1];

            for(int v: adj.get(u)){
                if(dist[v]==-1){
                    dist[v]=dist[u]+1;
                    q.offer(new int[]{v, u});
                }else if(v!=parent){
                    min=Math.min(min, dist[u]+dist[v]+1);
                }
            }
        }
        return true;
    }
}