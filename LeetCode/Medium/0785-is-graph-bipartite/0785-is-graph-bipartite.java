class Solution {
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        boolean[] visited=new boolean[n];
        int color[]=new int[n];
        
        for(int l=0;l<n;l++){
            if(!visited[l]){
                color[l]=5;
                Queue<Integer> q=new LinkedList<>();
                q.offer(l);
                while(!q.isEmpty()){
                    int x=q.poll();
                    int c=color[x];
                    visited[x]=true;
                    for(int i: graph[x]){
                        if(color[i]==c)return false;
                        if(!visited[i]){
                            color[i]=c+1;
                            q.offer(i);
                        }
                    }
                }
            }
        }
        return true;
        
    }
}