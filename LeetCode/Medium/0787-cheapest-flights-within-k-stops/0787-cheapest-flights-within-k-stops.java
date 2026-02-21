class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // use bellman-ford algo
        long[] dist=new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[src]=0;
        for(int i=0;i<=k;i++){
            long[] temp=dist.clone();
            for(int[] f: flights){
                int u=f[0], v=f[1], w=f[2];
                if(dist[u]!=Long.MAX_VALUE && dist[u]+w<temp[v]){
                    temp[v]=dist[u]+w;
                }
            }
            dist=temp;
        }
        return dist[dst]==Long.MAX_VALUE? -1: (int)dist[dst];
    }
}