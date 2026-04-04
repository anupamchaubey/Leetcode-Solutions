class Solution {
    class Pair{
        int city;
        int cost;
        Pair(int city, int cost){
            this.city=city;
            this.cost=cost;
        }
    }
    int MOD=1000000007;
    public int countPaths(int n, int[][] roads) {
        int[] dist=new int[n];
        int[] ways=new int[n];
        ways[0]=1;
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0]=0;
        List<List<Pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] r:roads){
            int u=r[0];
            int v=r[1];
            int c=r[2];
            adj.get(u).add(new Pair(v, c));
            adj.get(v).add(new Pair(u, c));
        }

        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)-> a[1]-b[1]); // node, price
        pq.offer(new int[]{0, 0});

        while(!pq.isEmpty()){
            int[] arr=pq.poll();
            int u=arr[0];
            int costTillNow=arr[1];
            if(costTillNow>dist[u])continue;
            for(Pair p: adj.get(u)){
                int v=p.city;
                int c=p.cost;
                if(costTillNow+c<dist[v]){
                    dist[v]=costTillNow+c;
                    ways[v] = ways[u];
                    pq.offer(new int[]{v, dist[v]});
                }else if(costTillNow+c==dist[v]){
                    ways[v]=(ways[u]+ways[v])%MOD;
                }
            }
        }
        return ways[n-1];
    }
}