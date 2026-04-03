class Solution {
    public int longestCycle(int[] edges) {
        int n=edges.length;
        int[] indegree=new int[n];
        for(int i=0;i<n;i++){
            if(edges[i]==-1)continue;
            indegree[edges[i]]++;
        }
        int max=Integer.MIN_VALUE;
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                q.offer(new int[]{i, -1, 1});//node, parent, cycle length
            }
        }
        int nodes=0;
        while(!q.isEmpty()){
            int[] arr=q.poll();
            nodes++;
            int u=arr[0];
            int parent=arr[1];
            int len=arr[2];
            int v=edges[u];
            if(v!=-1){
                indegree[v]--;
                if(indegree[v]==0){
                    q.offer(new int[]{v, u, len+1});
                }
            }
        }
        if(nodes==n)return -1;
        return n-nodes;
    }
}